package com.sdkbackendpr.config;

import io.shardingjdbc.core.api.algorithm.sharding.PreciseShardingValue;
import io.shardingjdbc.core.api.algorithm.sharding.standard.PreciseShardingAlgorithm;

import java.util.Collection;

/**
 * 数据库分库的策略，根据分片键，返回数据库名称
 */
public class DBUserInfoShardAlgo implements PreciseShardingAlgorithm<Long> {

    private static final String DATABASE_PREFIX = "sharding_appinfo0";


    @Override
    public String doSharding(Collection<String> collection, PreciseShardingValue<Long> preciseShardingValue) {

        for (String each : collection) {
            if (match(each,preciseShardingValue.getValue())) {
                return each;
            }
        }
        System.out.println(" ******** ");
        throw new IllegalArgumentException();

    }

    protected boolean match(String dbName,Long shardingVal){
        String result = DATABASE_PREFIX + (((int)(shardingVal % (6*64))/64) + 1) + "";
        return dbName.equals(result);
    }

}