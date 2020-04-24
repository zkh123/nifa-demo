package com.sdkbackendpr.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 等值查询使用的分片算法，包括in
 */
public class TblOrderPreShardAlgo implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingColumn) {
        return "t_order_1";

//        throw new IllegalArgumentException();
    }




}