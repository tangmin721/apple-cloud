package com.cachexic.cloud.security.core.authentication;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

/**
 * @author tangmin
 * @Description: 抽象通用的一些配置出来
 * @date 2017-10-01 22:36:24
 */
public class AbstractChannelSecurityConfig extends WebSecurityConfigurerAdapter {

  @Autowired
  protected AuthenticationSuccessHandler myAuthenticationSuccessHandler;

  @Autowired
  protected AuthenticationFailureHandler myAuthenticationFailureHandler;

  protected void applyPasswordAuthenticationConfig(HttpSecurity http) throws Exception {
    http.formLogin()
        //当请求需要身份认证时，默认跳转的url
        .loginPage(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
        //默认的用户名密码登录请求处理url
        .loginProcessingUrl(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_FORM)
        //配置自定义的登录成功返回结果信息
        .successHandler(myAuthenticationSuccessHandler)
        //配置自定义的登录失败返回结果信息
        .failureHandler(myAuthenticationFailureHandler);
  }

}
