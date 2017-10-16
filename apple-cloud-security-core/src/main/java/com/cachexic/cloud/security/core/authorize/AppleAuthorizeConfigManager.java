package com.cachexic.cloud.security.core.authorize;

import java.util.List;
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
  private List<AuthorizeConfigProvider> authorizeConfigProviders;

  /**
   * 配置授权路径,请求method
   */
  @Override
  public void config(
      ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

    boolean existAnyRequestConfig = false;
    String existAnyRequestConfigName = null;

    for (AuthorizeConfigProvider authorizeConfigProvider : authorizeConfigProviders) {
      //按照order顺序加载AppleAuthorizeConfigProvider里配置的一些通用配置 和 各项目自定义的配置
      boolean currentIsAnyRequestConfig = authorizeConfigProvider.config(config);
      if (existAnyRequestConfig && currentIsAnyRequestConfig) {
        throw new RuntimeException("重复的anyRequest配置:" + existAnyRequestConfigName + ","
            + authorizeConfigProvider.getClass().getSimpleName());
      } else if (currentIsAnyRequestConfig) {
        existAnyRequestConfig = true;
        existAnyRequestConfigName = authorizeConfigProvider.getClass().getSimpleName();
      }
    }

    if(!existAnyRequestConfig){
      //所有请求都需要身份认证才能访问
      config.anyRequest().authenticated();
    }
  }

}
