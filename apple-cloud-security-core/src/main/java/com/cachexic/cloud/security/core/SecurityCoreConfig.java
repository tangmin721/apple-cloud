package com.cachexic.cloud.security.core;

import com.cachexic.cloud.security.core.properties.SecurityProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * @author tangmin
 * @Description: 让SecurityProperties读取配置生效
 * @date 2017-09-28 17:39:07
 */
@Configuration
@EnableConfigurationProperties(SecurityProperties.class)
public class SecurityCoreConfig {

}
