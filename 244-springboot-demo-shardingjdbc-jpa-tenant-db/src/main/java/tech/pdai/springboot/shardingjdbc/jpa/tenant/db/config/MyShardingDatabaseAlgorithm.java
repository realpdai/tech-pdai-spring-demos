package tech.pdai.springboot.shardingjdbc.jpa.tenant.db.config;

import org.apache.shardingsphere.api.sharding.standard.PreciseShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.standard.PreciseShardingValue;

import java.util.Collection;

/**
 * This class is for MyShardingDatabaseAlgorithm.
 *
 * @author pdai
 */
public class MyShardingDatabaseAlgorithm implements PreciseShardingAlgorithm<String> {

    @Override
    public String doSharding(final Collection<String> availableTargetNames, final PreciseShardingValue<String> shardingValue) {
        String targetTable = shardingValue.getValue();
        if (availableTargetNames.contains(targetTable)){
            return targetTable;
        }

        throw new UnsupportedOperationException("UnsupportedOperationException: " + shardingValue.getValue());
    }
}
