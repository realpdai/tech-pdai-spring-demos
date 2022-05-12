package tech.pdai.springboot.redis.jedis.lock.annotation;

import java.lang.annotation.*;

/**
 * @author pdai
 */
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@Inherited
public @interface RedisLock {

    /**
     * redis lock key as value.
     *
     * @return lock key
     */
    String value() default "";

    /**
     * how long we hold the lock.
     *
     * @return mills
     */
    long expireMills() default 30000;

    /**
     * if lock failed, do we need to retry, default retry 0 means NO retry.
     *
     * @return retry times
     */
    int retryTimes() default 0;

    /**
     * when we retry to get lock, what's the duration for next retry.
     *
     * @return mills
     */
    long retryDurationMills() default 200;

}
