package com.sdkbackendpr.config;

import com.google.common.base.Strings;
import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 等值查询使用的分片算法，包括in
 */
public class TblUserInfoShardAlgo implements PreciseShardingAlgorithm<Long> {

    @Override
    public String doSharding(Collection<String> availableTargetNames, PreciseShardingValue<Long> shardingColumn) {

        String param = Strings.padStart((shardingColumn.getValue() % (6*64)) + 1 + "",4,'0');
        String tableName = shardingColumn.getLogicTableName() + "_" +param;

        return tableName;

    }
}