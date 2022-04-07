package tech.pdai.springboot.shardingjdbc.jpa.tenant.db.config;

import java.util.Collection;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

/**
 * This class is for MyPreciseShardingDBAlgorithm.
 *
 * @author pdai
 */
public class MyPreciseShardingDBAlgorithm implements PreciseShardingAlgorithm<String> {

    private static final String DATABASE_TENANT_PREFIX = "tenant-";

    /**
     * @param availableTargetNames tenant-a, tenant-b
     * @param shardingValue        sharding value
     * @return targetDb
     */
    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<String> shardingValue) {
        String targetDb = DATABASE_TENANT_PREFIX + shardingValue.getValue();
        if (availableTargetNames.contains(targetDb)) {
            return targetDb;
        }

        throw new UnsupportedOperationException("UnsupportedOperationException: " + shardingValue.getValue());
    }
}
