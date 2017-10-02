package com.cachexic.cloud.security.core.authtication.mobile;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.SecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.DefaultSecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

/**
 * @author tangmin
 * @Description: 短信认证的config,可被其他config通过apply加入
 * @date 2017-09-28 14:56:02
 */
@Configuration
public class SmsCodeAuthenticationSecurityConfig extends SecurityConfigurerAdapter<DefaultSecurityFilterChain,HttpSecurity> {

  private static final Logger log = LoggerFactory.getLogger(SmsCodeAuthenticationSecurityConfig.class);

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

  @Autowired
  private AuthenticationFailureHandler myAuthenticationFailureHandler;

  @Override
  public void configure(HttpSecurity http) throws Exception {

    SmsCodeAuthenticationFilter smsCodeAuthenticationFilter = new SmsCodeAuthenticationFilter();
    smsCodeAuthenticationFilter.setAuthenticationManager(http.getSharedObject(AuthenticationManager.class));

    smsCodeAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
    smsCodeAuthenticationFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);

    SmsCodeAuthenticationProvider smsCodeAuthenticationProvider = new SmsCodeAuthenticationProvider();
    smsCodeAuthenticationProvider.setUserDetailsService(userDetailsService);

    http.authenticationProvider(smsCodeAuthenticationProvider)
        .addFilterAfter(smsCodeAuthenticationFilter, UsernamePasswordAuthenticationFilter.class)
        .formLogin();

    super.configure(http);
  }
}
