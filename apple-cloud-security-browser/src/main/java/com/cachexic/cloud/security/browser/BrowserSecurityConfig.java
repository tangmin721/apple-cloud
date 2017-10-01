package com.cachexic.cloud.security.browser;

import com.cachexic.cloud.security.core.authtication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.validate.web.SmsCodeFilter;
import com.cachexic.cloud.security.core.validate.web.ValidateCodeFilter;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;

/**
 * @author tangmin
 * @Description: PC浏览器的项目
 * @date 2017-09-28 14:56:02
 */
@Configuration
public class BrowserSecurityConfig extends WebSecurityConfigurerAdapter {

  private static final Logger log = LoggerFactory.getLogger(BrowserSecurityConfig.class);

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

  @Autowired
  private AuthenticationFailureHandler myAuthenticationFailureHandler;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

  /**
   * 配置密码加密规则.也可以自己实现这个接口,用自己的加密规则
   */
  @Bean
  public PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }


  /**
   * 记住我功能
   * @return
   */
  @Bean
  public PersistentTokenRepository persistentTokenRepository(){
    JdbcTokenRepositoryImpl tokenRepository = new JdbcTokenRepositoryImpl();
    tokenRepository.setDataSource(dataSource);
    //tokenRepository.setCreateTableOnStartup(true);
    return tokenRepository;
  }

  /**
   * 重载默认的HttpSecurity
   */
  @Override
  protected void configure(HttpSecurity http) throws Exception {
    log.info("====>>override WebSecurityConfigurerAdapter...");

    //图形验证码过滤器
    ValidateCodeFilter validateCodeFilter = new ValidateCodeFilter();
    validateCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
    validateCodeFilter.setSecurityProperties(securityProperties);
    validateCodeFilter.afterPropertiesSet();

    //短信验证码过滤器
    SmsCodeFilter smsCodeFilter = new SmsCodeFilter();
    smsCodeFilter.setAuthenticationFailureHandler(myAuthenticationFailureHandler);
    smsCodeFilter.setSecurityProperties(securityProperties);
    smsCodeFilter.afterPropertiesSet();


    //http.httpBasic()// 弹框默认的方式登录
    http.addFilterBefore(smsCodeFilter, UsernamePasswordAuthenticationFilter.class)
        .addFilterBefore(validateCodeFilter, UsernamePasswordAuthenticationFilter.class)
        .formLogin()  //表单登录
          .loginPage("/authentication/require") //当请求需要身份认证时，默认跳转的url
          .loginProcessingUrl("/authentication/form") //默认的用户名密码登录请求处理url

          .successHandler(myAuthenticationSuccessHandler) //配置自定义的登录成功返回结果信息
          .failureHandler(myAuthenticationFailureHandler) //配置自定义的登录失败返回结果信息
          .and()
        .rememberMe() //配置记住我功能
          .tokenRepository(persistentTokenRepository())
          .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
          .userDetailsService(userDetailsService )

          .and()
        .authorizeRequests() //对请求做授权
        .antMatchers(
            SecurityConstants.DEFAULT_UNAUTHENTICATION_URL,
            securityProperties.getBrowser().getLoginPage(),
            "/code/*",
            SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_FORM,
            SecurityConstants.DEFAULT_LOGIN_PROCESSING_URL_MOBILE
        ).permitAll() //排除页的身份验证
        .anyRequest()  //对所有请求
        .authenticated() //都是要身份认证

        .and()
        .csrf().disable() //暂时禁用掉跨站伪造防护

        .apply(smsCodeAuthenticationSecurityConfig);//把短信验证码的配置通过apply直接可以加入到这
    ;
  }
}
