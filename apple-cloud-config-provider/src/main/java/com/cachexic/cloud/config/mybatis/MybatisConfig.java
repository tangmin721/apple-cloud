package com.cachexic.cloud.config.mybatis;

import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.dangdang.ddframe.rdb.sharding.jdbc.core.datasource.ShardingDataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.core.io.Resource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.core.io.support.ResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.annotation.TransactionManagementConfigurer;

import java.io.IOException;

/**
 * @author tangmin
 * @version V1.0
 * @Title: com.cachexic.cloud.config.mybatis.annotation.MybatisConfig.java
 * @Package com.cachexic.sjdbc.common.config.mybatis
 * @Description: 
 * @date 2017-08-20 15:56:00
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.cachexic.sjdbc", annotationClass = MybatisDao.class)
@Order(3)
public class MybatisConfig implements TransactionManagementConfigurer {
    /**
     * 注入shardingDataSource
     */
    @Autowired
    private ShardingDataSource shardingDataSource;

    @Bean
    public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        sqlSessionFactoryBean.setDataSource(shardingDataSource);

        //mapper文件路径
        ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        Resource[] resources = resolver.getResources("classpath*:mybatis/**/*Dao.xml");
        sqlSessionFactoryBean.setMapperLocations(resources);

        //多个用,隔开
        //sqlSessionFactoryBean.setTypeAliasesPackage("com.gasq.cloud.provider.customer.entity");

        return sqlSessionFactoryBean;
    }

    /**
     * 开启事务注解
     * @return
     */
    @Bean
    @Override
    public PlatformTransactionManager annotationDrivenTransactionManager() {
        return new DataSourceTransactionManager(shardingDataSource);
    }
}
