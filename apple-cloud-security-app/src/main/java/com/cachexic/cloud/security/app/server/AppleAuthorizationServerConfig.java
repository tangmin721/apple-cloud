package com.cachexic.cloud.security.app.server;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;

/**
 * @Description: 认证服务器配置
 * http://localhost:8002/oauth/authorize?response_type=code&client_id=9f420a0f-b419-4e26-9e51-4b4837f7bedc&redirect_uri=http://example.com&scope=all
 * @author tangmin
 * @date 2017-10-10 22:41:14
 */
@Configuration
@EnableAuthorizationServer
public class AppleAuthorizationServerConfig {

}
