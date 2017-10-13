package com.cachexic.cloud.provider.order.security;

import com.cachexic.cloud.security.core.authorize.AuthorizeConfigProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @Description: Order模块自定义的config
 * @author tangmin
 * @date 2017-10-13 15:07:07
 */
@Component
public class OrderAuthorizeConfigProvider implements AuthorizeConfigProvider {

  @Override
  public boolean config(ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {
    config.antMatchers("/demo.html").hasRole("ADMIN");

    return false;
  }
}
