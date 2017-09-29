package com.cachexic.cloud.config.sjdbc;

import com.alibaba.druid.pool.DruidDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

/**
 * 公共属性配置
 */
@Component
@Configuration
@Order(1)
public class DruidDatasourceBase {

  private Logger logger = LoggerFactory.getLogger(getClass());

  /**
   * 获取数据源
   */
  public DruidDataSource getDruidDataSource(String url, String username, String password,
      String publickey,
      String filters) {
    DruidDataSource datasource = new DruidDataSource();
    datasource.setUrl(url);
    datasource.setUsername(username);
    datasource.setPassword(password);
    setCommonProperties(datasource, publickey);
    try {
      datasource.setFilters(filters);
    } catch (SQLException e) {
      logger.error("druid configuration initialization filter", e);
    }
    return datasource;
  }

  /**
   * 设置数据公共属性
   */
  private void setCommonProperties(DruidDataSource datasource, String publickey) {
    datasource.setDriverClassName(driverClassName);
    datasource.setInitialSize(initialSize);
    datasource.setMinIdle(minIdle);
    datasource.setMaxActive(maxActive);
    datasource.setMaxWait(maxWait);
    datasource.setTimeBetweenEvictionRunsMillis(timeBetweenEvictionRunsMillis);
    datasource.setMinEvictableIdleTimeMillis(minEvictableIdleTimeMillis);
    datasource.setValidationQuery(validationQuery);
    datasource.setTestWhileIdle(testWhileIdle);
    datasource.setTestOnBorrow(testOnBorrow);
    datasource.setTestOnReturn(testOnReturn);
    datasource.setPoolPreparedStatements(poolPreparedStatements);
    datasource.setRemoveAbandoned(removeAbandoned);
    datasource.setRemoveAbandonedTimeout(removeAbandonedTimeout);
    datasource.setLogAbandoned(logAbandoned);
    //配置数据库加密，慢查询
    datasource.setConnectionProperties("config.decrypt=true;config.decrypt.key=" + publickey
        + ";druid.stat.slowSqlMillis=" + slowSqlMillis
    );
  }

  /**
   * 公共属性
   */
  @Value("${spring.datasource.driver-class-name}")
  private String driverClassName;

  @Value("${spring.datasource.initialSize}")
  private int initialSize;

  @Value("${spring.datasource.minIdle}")
  private int minIdle;

  @Value("${spring.datasource.maxActive}")
  private int maxActive;

  @Value("${spring.datasource.maxWait}")
  private int maxWait;

  @Value("${spring.datasource.timeBetweenEvictionRunsMillis}")
  private int timeBetweenEvictionRunsMillis;

  @Value("${spring.datasource.minEvictableIdleTimeMillis}")
  private int minEvictableIdleTimeMillis;

  @Value("${spring.datasource.validationQuery}")
  private String validationQuery;

  @Value("${spring.datasource.testWhileIdle}")
  private boolean testWhileIdle;

  @Value("${spring.datasource.testOnBorrow}")
  private boolean testOnBorrow;

  @Value("${spring.datasource.testOnReturn}")
  private boolean testOnReturn;

  @Value("${spring.datasource.poolPreparedStatements}")
  private boolean poolPreparedStatements;

  @Value("${spring.datasource.removeAbandoned}")
  private boolean removeAbandoned;

  @Value("${spring.datasource.removeAbandonedTimeout}")
  private int removeAbandonedTimeout;

  @Value("${spring.datasource.logAbandoned}")
  private boolean logAbandoned;

  @Value("${spring.datasource.slowSqlMillis}")
  private String slowSqlMillis;
}