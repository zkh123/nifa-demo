package com.sdkbackendpr.config;

import io.shardingjdbc.core.api.config.ShardingRuleConfiguration;
import io.shardingjdbc.core.api.config.TableRuleConfiguration;
import io.shardingjdbc.core.api.config.strategy.StandardShardingStrategyConfiguration;
import io.shardingjdbc.core.jdbc.core.datasource.ShardingDataSource;
import org.apache.commons.dbcp.BasicDataSource;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 分片数据源配置，返回 ShardingDataSource
 */
@Configuration
@MapperScan(basePackages = "com.sdkbackendpr.mapper", sqlSessionFactoryRef = "sqlSessionFactory")
public class DataSourceConfig {

    private static final String[] APPINFO_DATABASES = {"sharding_appinfo01", "sharding_appinfo02",
            "sharding_appinfo03", "sharding_appinfo04","sharding_appinfo05",
            "sharding_appinfo06"};

    private static final String[] ORDER_DATABASES = {"sharding_other01", "sharding_other02"
            ,"sharding_other03", "sharding_other04"};


    @Bean
    @Primary
    public DataSource shardingDataSource() throws SQLException {
        ShardingRuleConfiguration src = new ShardingRuleConfiguration();
         List<TableRuleConfiguration> list = new ArrayList<>();
         TableRuleConfiguration tableRuleConfiguration1 = getOrderTableRuleConfiguration();
         TableRuleConfiguration tableRuleConfiguration2 = getUserTableRuleConfiguration();
         TableRuleConfiguration tableRuleConfiguration3 = getConfigTableRuleConfiguration();
         list.add(tableRuleConfiguration1);list.add(tableRuleConfiguration2);list.add(tableRuleConfiguration3);
         src.setTableRuleConfigs(list);
        // 数据源名和数据源的映射表
        return new ShardingDataSource(src.build(createDataSourceMap()));
    }

    // 配置数据源
    private Map<String, DataSource> createDataSourceMap() {
        Map<String, DataSource> result = new HashMap<>();
        result.put("sharding_appinfo01", createDataSource("jdbc:mysql://localhost:3306/sharding_appinfo01?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_appinfo02", createDataSource("jdbc:mysql://localhost:3306/sharding_appinfo02?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_appinfo03", createDataSource("jdbc:mysql://localhost:3306/sharding_appinfo03?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_appinfo04", createDataSource("jdbc:mysql://localhost:3306/sharding_appinfo04?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_appinfo05", createDataSource("jdbc:mysql://localhost:3306/sharding_appinfo05?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_appinfo06", createDataSource("jdbc:mysql://localhost:3306/sharding_appinfo06?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_other01", createDataSource("jdbc:mysql://localhost:3306/sharding_other01?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_other02", createDataSource("jdbc:mysql://localhost:3306/sharding_other02?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_other03", createDataSource("jdbc:mysql://localhost:3306/sharding_other03?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_other04", createDataSource("jdbc:mysql://localhost:3306/sharding_other04?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        result.put("sharding_default", createDataSource("jdbc:mysql://localhost:3306/sharding_default?characterEncoding=utf8&useSSL=false&serverTimezone=UTC"));
        return result;
    }

    // 根据数据源地址创建 DataSource
    private DataSource createDataSource(final String dataSourceName) {
        BasicDataSource result = new BasicDataSource();
        result.setDriverClassName("com.mysql.jdbc.Driver");
        result.setUrl(dataSourceName);
        result.setUsername("root");
        result.setPassword("root");
        return result;
    }

    // 事务管理器
    @Bean
    public DataSourceTransactionManager transactitonManager(DataSource shardingDataSource) {
        return new DataSourceTransactionManager(shardingDataSource);
    }

    public TableRuleConfiguration getUserTableRuleConfiguration() {
        TableRuleConfiguration userTableRuleConfig=new TableRuleConfiguration();
        userTableRuleConfig.setLogicTable("user_info");
        userTableRuleConfig.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id", DBUserInfoShardAlgo.class.getName()));
        userTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("user_id",TblUserInfoShardAlgo.class.getName()));
        return userTableRuleConfig;
    }

    public TableRuleConfiguration getOrderTableRuleConfiguration() {
        TableRuleConfiguration userTableRuleConfig=new TableRuleConfiguration();
        userTableRuleConfig.setLogicTable("t_order");
        userTableRuleConfig.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id", DBOrderShardAlgo.class.getName()));
        userTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("order_id", TblOrderPreShardAlgo.class.getName()));
        return userTableRuleConfig;
    }


    public TableRuleConfiguration getConfigTableRuleConfiguration() {
        TableRuleConfiguration userTableRuleConfig=new TableRuleConfiguration();
        userTableRuleConfig.setLogicTable("t_config");
        userTableRuleConfig.setDatabaseShardingStrategyConfig(new StandardShardingStrategyConfiguration("config_id", DBConfigShardAlgo.class.getName()));
        userTableRuleConfig.setTableShardingStrategyConfig(new StandardShardingStrategyConfiguration("config_id",TblConfigShardAlgo.class.getName()));
        return userTableRuleConfig;
    }
}
