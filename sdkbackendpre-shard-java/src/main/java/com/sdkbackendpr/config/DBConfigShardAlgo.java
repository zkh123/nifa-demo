package com.sdkbackendpr.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 数据库分库的策略，根据分片键，返回数据库名称
 */
public class DBConfigShardAlgo implements PreciseShardingAlgorithm<Long> {
    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        return "sharding_default";
//        throw new IllegalArgumentException();
    }

}
