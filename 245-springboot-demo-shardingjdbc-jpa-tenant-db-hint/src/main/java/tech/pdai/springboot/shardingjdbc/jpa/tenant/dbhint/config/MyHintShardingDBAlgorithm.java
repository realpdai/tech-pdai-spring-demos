package tech.pdai.springboot.shardingjdbc.jpa.tenant.dbhint.config;

import java.util.Collection;
import java.util.stream.Collectors;

import org.apache.shardingsphere.api.sharding.hint.HintShardingAlgorithm;
import org.apache.shardingsphere.api.sharding.hint.HintShardingValue;

/**
 * @author pdai
 */
public class MyHintShardingDBAlgorithm implements HintShardingAlgorithm<String> {

    /**
     * Sharding.
     *
     * <p>sharding value injected by hint, not in SQL.</p>
     *
     * @param availableTargetNames available data sources or tables's names
     * @param shardingValue        sharding value
     * @return sharding result for data sources or tables's names
     */
    @Override
    public Collection<String> doSharding(Collection<String> availableTargetNames, HintShardingValue<String> shardingValue) {
        return shardingValue.getValues().stream().filter(availableTargetNames::contains).collect(Collectors.toList());
    }
}
