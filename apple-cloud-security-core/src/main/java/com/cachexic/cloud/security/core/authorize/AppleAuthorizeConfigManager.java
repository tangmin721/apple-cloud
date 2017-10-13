package com.cachexic.cloud.security.core.authorize;

import java.util.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 默认的授权配置管理器
 * @date 2017-10-13 14:39:17
 */
@Component
public class AppleAuthorizeConfigManager implements AuthorizeConfigManager {

  @Autowired
  private Set<AuthorizeConfigProvider> authorizeConfigProviders;

  /**
   * 配置授权路径,请求method
   */
  @Override
  public void config(
      ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

    for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
      authorizeConfigProvider.config(config);

    }
    //所有请求都需要身份认证才能访问
    config
        .anyRequest() //对所有请求
        .authenticated();//都是要身份认证
  }

}
