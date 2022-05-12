package tech.pdai.springboot.redis.jedis.lock.lock;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.data.redis.core.RedisCallback;
import org.springframework.data.redis.core.StringRedisTemplate;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.jedis.commands.JedisCommands;
import redis.clients.jedis.params.SetParams;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author pdai
 */
@Slf4j
public class RedisDistributedLock {

    /**
     * lua script for unlock.
     */
    private static final String UNLOCK_LUA;

    static {
        StringBuilder sb = new StringBuilder();
        sb.append("if redis.call(\"get\",KEYS[1]) == ARGV[1] ");
        sb.append("then ");
        sb.append("    return redis.call(\"del\",KEYS[1]) ");
        sb.append("else ");
        sb.append("    return 0 ");
        sb.append("end ");
        UNLOCK_LUA = sb.toString();
    }

    /**
     * unique lock flag based on thread local.
     */
    private final ThreadLocal<String> lockFlag = new ThreadLocal<>();

    private final StringRedisTemplate redisTemplate;

    public RedisDistributedLock(StringRedisTemplate redisTemplate) {
        this.redisTemplate = redisTemplate;
    }

    public boolean lock(String key, long expire, int retryTimes, long retryDuration) {
        // use JedisCommands instead of setIfAbsense
        boolean result = setRedis(key, expire);

        // retry if needed
        while ((!result) && retryTimes-- > 0) {
            try {
                log.debug("lock failed, retrying..." + retryTimes);
                Thread.sleep(retryDuration);
            } catch (Exception e) {
                return false;
            }

            // use JedisCommands instead of setIfAbsense
            result = setRedis(key, expire);
        }
        return result;
    }

    private boolean setRedis(String key, long expire) {
        try {
            RedisCallback<String> redisCallback = connection -> {
                JedisCommands commands = (JedisCommands) connection.getNativeConnection();
                String uuid = UUID.randomUUID().toString(); // change to distribute UUID generation.
                lockFlag.set(uuid);
                return commands.set(key, uuid, SetParams.setParams().nx().px(expire));
            };
            String result = redisTemplate.execute(redisCallback);
            return !StringUtils.isEmpty(result);
        } catch (Exception e) {
            log.error("set redis occurred an exception", e);
        }
        return false;
    }

    public boolean unlock(String key) {
        boolean success = false;
        try {
            List<String> keys = new ArrayList<>();
            keys.add(key);
            List<String> args = new ArrayList<>();
            args.add(lockFlag.get());

            // use lua script
            RedisCallback<Long> redisCallback = connection -> {
                Object nativeConnection = connection.getNativeConnection();

                if (nativeConnection instanceof JedisCluster) { // cluster mode
                    return (Long) ((JedisCluster) nativeConnection).eval(UNLOCK_LUA, keys, args);
                } else if (nativeConnection instanceof Jedis) { // single mode
                    return (Long) ((Jedis) nativeConnection).eval(UNLOCK_LUA, keys, args);
                }
                return 0L;
            };
            Long result = redisTemplate.execute(redisCallback);
            success = result != null && result > 0;
        } catch (Exception e) {
            log.error("release lock occurred an exception", e);
        } finally {
            if (success) {
                lockFlag.remove();
            }
        }
        return success;
    }

}

