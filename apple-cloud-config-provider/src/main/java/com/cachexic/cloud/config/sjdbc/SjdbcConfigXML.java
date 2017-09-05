package com.cachexic.cloud.config.sjdbc;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * 引入xml的配置文件
 */
@Configuration
@ImportResource(locations={"classpath:sjdbc/shardingContext.xml"})
@Order(2)
public class SjdbcConfigXML {
}
