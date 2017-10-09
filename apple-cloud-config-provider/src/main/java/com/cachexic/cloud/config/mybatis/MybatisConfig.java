package com.cachexic.cloud.config.mybatis;

import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import java.io.IOException;
import javax.sql.DataSource;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
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

/**
 * @Description: mybatis配置文件
 * @author tangmin
 * @date 2017-10-09 21:26:53
 */
@Configuration
@EnableTransactionManagement
@MapperScan(value = "com.cachexic.cloud", annotationClass = MybatisDao.class)
@Order(4)
public class MybatisConfig implements TransactionManagementConfigurer {

  /**
   * 如果是shardingJdbc,需要把bean的名字定义为dataSource
   * 如果是单库，ds也需要定义为dataSource
   */
  @Autowired
  @Qualifier("dataSource")
  private DataSource dataSource;

  @Bean
  public SqlSessionFactoryBean sqlSessionFactoryBean() throws IOException {
    SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
    sqlSessionFactoryBean.setDataSource(dataSource);

    //mapper文件路径
    ResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
    Resource[] resources = resolver.getResources("classpath*:mybatis/**/*Dao.xml");
    sqlSessionFactoryBean.setMapperLocations(resources);

    //多个用,隔开
    //sqlSessionFactoryBean.setTypeAliasesPackage("com.gasq.cloud.provider.customer.entity");

    return sqlSessionFactoryBean;
  }

  @Bean
  @Override
  public PlatformTransactionManager annotationDrivenTransactionManager() {
    return new DataSourceTransactionManager(dataSource);
  }
}
