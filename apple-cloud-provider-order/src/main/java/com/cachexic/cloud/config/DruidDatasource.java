package com.cachexic.cloud.config;

import com.cachexic.cloud.config.sjdbc.DruidDatasourceBase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;

/**
 * 每个工程配置自己的数据源
 */
@Component
@Configuration
@Order(2)
public class DruidDatasource {
    @Autowired
    private DruidDatasourceBase druidDatasourceBase;

    @Bean(name = "ds_0")
    @Primary
    public DataSource ds_0(
            @Value("${sharding.jdbc.datasource.ds_0.url}") String url,
            @Value("${sharding.jdbc.datasource.ds_0.username}") String username,
            @Value("${sharding.jdbc.datasource.ds_0.password}") String password,
            @Value("${sharding.jdbc.datasource.ds_0.publickey}") String publickey,
            @Value("${sharding.jdbc.datasource.ds_0.filters}") String filters) {
        return druidDatasourceBase.getDruidDataSource(url, username, password, publickey, filters);
    }

    @Bean(name = "ds_1")
    public DataSource ds_1(
            @Value("${sharding.jdbc.datasource.ds_1.url}") String url,
            @Value("${sharding.jdbc.datasource.ds_1.username}") String username,
            @Value("${sharding.jdbc.datasource.ds_1.password}") String password,
            @Value("${sharding.jdbc.datasource.ds_1.publickey}") String publickey,
            @Value("${sharding.jdbc.datasource.ds_1.filters}") String filters) {
        return druidDatasourceBase.getDruidDataSource(url, username, password, publickey, filters);
    }


}