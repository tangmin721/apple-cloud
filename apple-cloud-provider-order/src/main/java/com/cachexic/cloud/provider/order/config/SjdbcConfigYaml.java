package com.cachexic.cloud.provider.order.config;

import com.dangdang.ddframe.rdb.sharding.config.yaml.api.YamlShardingDataSource;
import com.google.common.collect.Maps;
import java.io.File;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Map;
import javax.sql.DataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 引入sjdbc配置
 * @date 2017-10-09 21:51:51
 */
@Component
@Configuration
@Order(3)
public class SjdbcConfigYaml {

  @Autowired
  @Qualifier("ds_0")
  private DataSource ds_0;

  @Autowired
  @Qualifier("ds_1")
  private DataSource ds_1;

  @Bean(name = "dataSource")
  public DataSource dataSource() throws IOException, SQLException {

    Map<String, DataSource> dataSourceMaps = Maps.newHashMap();
    dataSourceMaps.put("ds_0", ds_0);
    dataSourceMaps.put("ds_1", ds_1);

    YamlShardingDataSource dataSource = new YamlShardingDataSource(dataSourceMaps,
        new File(SjdbcConfigYaml.class.getResource("/config/sjdbc.yaml").getFile()));
    return dataSource;
  }

}
