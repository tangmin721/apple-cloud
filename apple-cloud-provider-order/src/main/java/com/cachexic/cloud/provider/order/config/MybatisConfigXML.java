package com.cachexic.cloud.provider.order.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.core.annotation.Order;

/**
 * @author tangmin
 * @Description:
 * @date 2017-08-20 15:56:00
 */
@Configuration
@ImportResource(locations={"classpath:orm/mybatis.xml"})
@Order(4)
public class MybatisConfigXML{

}
