package com.cachexic.cloud.security.core.authorize;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.ExpressionUrlAuthorizationConfigurer;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 核心模块的授权配置提供器，安全模块涉及的url的授权配置在这里。优先加载
 * @date 2017-10-13 14:42:20
 */
@Component
@Order(Integer.MIN_VALUE)
public class AppleAuthorizeConfigProvider implements AuthorizeConfigProvider {

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * 通用对外暴露的接口
   */
  @Override
  public boolean config(
      ExpressionUrlAuthorizationConfigurer<HttpSecurity>.ExpressionInterceptUrlRegistry config) {

    //对请求做授权
    config.antMatchers(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
        SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_MOBILE,
        SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID,
        SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
        securityProperties.getBrowser().getSignInPage(),
        securityProperties.getBrowser().getSignUpUrl(),
        securityProperties.getBrowser().getSession().getSessionInvalidUrl())
        .permitAll();

    //退出接口特殊处理
    if (StringUtils.isNotBlank(securityProperties.getBrowser().getSignOutUrl())) {
      config.antMatchers(securityProperties.getBrowser().getSignOutUrl()).permitAll();
    }
    return false;
  }

}
