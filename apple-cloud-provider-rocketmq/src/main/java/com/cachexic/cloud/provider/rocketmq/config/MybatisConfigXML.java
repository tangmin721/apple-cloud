package com.cachexic.cloud.provider.rocketmq.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * @author tangmin
 * @version V1.0
 * @Title: com.cachexic.cloud.config.mybatis.annotation.MybatisConfig.java
 * @Package com.cachexic.sjdbc.common.config.mybatis
 * @Description:
 * @date 2017-08-20 15:56:00
 */
@Configuration
@ImportResource(locations={"classpath:orm/mybatis.xml"})
@Order(4)
public class MybatisConfigXML {

}
