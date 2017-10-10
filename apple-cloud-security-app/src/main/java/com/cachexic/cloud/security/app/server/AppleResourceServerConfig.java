package com.cachexic.cloud.security.app.server;

import com.cachexic.cloud.security.core.authtication.FormAuthenticationConfig;
import com.cachexic.cloud.security.core.authtication.ValidateCodeSecurityConfig;
import com.cachexic.cloud.security.core.authtication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
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

  @Override
  public void configure(HttpSecurity http) throws Exception {
    log.info("====>>override WebSecurityConfigurerAdapter...");

    formAuthenticationConfig.configure(http);

    //http.httpBasic()// 弹框默认的方式登录
    http
//        .apply(validateCodeSecurityConfig) //验证码的配置通过apply直接可以加入到这
//        .and()
        .apply(smsCodeAuthenticationSecurityConfig)
        .and()
        .apply(mySocialSecurityConfig)
        .and()
        .authorizeRequests() //对请求做授权

        .antMatchers(//排除的url
            SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
            securityProperties.getBrowser().getSignInPage(),
            SecurityConstants.DEFAULT_VALIDATE_CODE_URL_PREFIX + "/*",
            securityProperties.getBrowser().getSignUpUrl(),
            securityProperties.getBrowser().getSession().getSessionInvalidUrl()
            // securityProperties.getBrowser().getSignOutUrl()
        ).permitAll() //排除页的身份验证
        .anyRequest()  //对所有请求
        .authenticated() //都是要身份认证

        .and()
        .csrf().disable() //暂时禁用掉跨站伪造防护

        .apply(smsCodeAuthenticationSecurityConfig);

  }


}
