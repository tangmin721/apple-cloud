package com.cachexic.cloud.security.browser;

import com.cachexic.cloud.security.core.authentication.AbstractChannelSecurityConfig;
import com.cachexic.cloud.security.core.authentication.ValidateCodeSecurityConfig;
import com.cachexic.cloud.security.core.authentication.mobile.SmsCodeAuthenticationSecurityConfig;
import com.cachexic.cloud.security.core.authorize.AuthorizeConfigManager;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import javax.sql.DataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;
import org.springframework.security.web.authentication.rememberme.JdbcTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author tangmin
 * @Description: PC浏览器的项目
 * @date 2017-09-28 14:56:02
 */
@Configuration
public class BrowserSecurityConfig extends AbstractChannelSecurityConfig {

  private static final Logger log = LoggerFactory.getLogger(BrowserSecurityConfig.class);

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private DataSource dataSource;

  @Autowired
  private UserDetailsService userDetailsService;

  @Autowired
  private ValidateCodeSecurityConfig validateCodeSecurityConfig;

  @Autowired
  private SmsCodeAuthenticationSecurityConfig smsCodeAuthenticationSecurityConfig;

  @Autowired
  private SpringSocialConfigurer appleSocialSecurityConfig;

  @Autowired
  private SessionInformationExpiredStrategy sessionInformationExpiredStrategy;

  @Autowired
  private InvalidSessionStrategy invalidSessionStrategy;

  @Autowired
  private LogoutSuccessHandler logoutSuccessHandler;

  @Autowired
  private AuthorizeConfigManager authorizeConfigManager;
  /**
   * 记住我功能
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

    super.applyPasswordAuthenticationConfig(http);

    //http.httpBasic()// 弹框默认的方式登录
    http.apply(validateCodeSecurityConfig) //验证码的配置通过apply直接可以加入到这
          .and()
        .apply(smsCodeAuthenticationSecurityConfig)
          .and()
        .apply(appleSocialSecurityConfig)
          .and()
        .rememberMe() //配置记住我功能(浏览器)
          .tokenRepository(persistentTokenRepository())
          .tokenValiditySeconds(securityProperties.getBrowser().getRememberMeSeconds())
          .userDetailsService(userDetailsService )
          .and()

        .sessionManagement()//配置session过期跳转到的url
          .invalidSessionStrategy(invalidSessionStrategy)
          .invalidSessionUrl(SecurityConstants.DEFAULT_SESSION_INVALID_URL)
          .maximumSessions(securityProperties.getBrowser().getSession().getMaximumSessions()) //如果配置最大session数量为1,则后面登录的会把之前登录的踢掉
          .maxSessionsPreventsLogin(securityProperties.getBrowser().getSession().isMaxSessionsPreventsLogin()) //在达到最大登录数量后,阻止其他设备登录(另一种策略)
          .expiredSessionStrategy(sessionInformationExpiredStrategy) //并发登录导致session超时的策略
          .and()
          .and()
        .logout()
          .logoutUrl("/signOut")  //替换默认的/logout为/signOut
          .logoutSuccessHandler(logoutSuccessHandler) // 自定义退出成功后的处理操作
          .deleteCookies("JSESSIONID") //清除cook
          .and()
        .csrf().disable(); //暂时禁用掉跨站伪造防护

        //把自定义配置设置到通用的config里
        authorizeConfigManager.config(http.authorizeRequests());

  }
}
