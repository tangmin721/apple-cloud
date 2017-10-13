package com.cachexic.cloud.security.app.server;

import com.cachexic.cloud.security.core.authentication.FormAuthenticationConfig;
import com.cachexic.cloud.security.core.authentication.ValidateCodeSecurityConfig;
import com.cachexic.cloud.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.cachexic.cloud.security.core.authorize.AuthorizeConfigManager;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author tangmin
 * @Description: 资源服务器配置  安全配置
 * @date 2017-10-10 23:52:51
 */
@Configuration
@EnableResourceServer
public class AppleResourceServerConfig extends ResourceServerConfigurerAdapter {

  private static final Logger log = LoggerFactory.getLogger(AppleResourceServerConfig.class);

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private ValidateCodeSecurityConfig validateCodeSecurityConfig;

  @Autowired
  private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

  @Autowired
  private SpringSocialConfigurer mySocialSecurityConfig;

  @Autowired
  private FormAuthenticationConfig formAuthenticationConfig;

  @Autowired
  private AuthorizeConfigManager authorizeConfigManager;

  @Override
  public void configure(HttpSecurity http) throws Exception {
    log.info("====>>override WebSecurityConfigurerAdapter...");

    formAuthenticationConfig.configure(http);

    //http.httpBasic()// 弹框默认的方式登录
    http
        .apply(validateCodeSecurityConfig) //验证码的配置通过apply直接可以加入到这
        .and()
        .apply(smsCodeAuthenticationSecurityConfig)
        .and()
        .apply(mySocialSecurityConfig)
        .and()
        .csrf().disable(); //暂时禁用掉跨站伪造防护

    //把自定义配置设置到通用的config里
    authorizeConfigManager.config(http.authorizeRequests());

  }


}
