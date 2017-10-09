package com.cachexic.cloud.security.browser;

import com.cachexic.cloud.security.browser.session.AppleExpiredSessionStrategy;
import com.cachexic.cloud.security.browser.session.AppleInvalidSessionStrategy;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.web.session.InvalidSessionStrategy;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @author tangmin
 * @Description: 浏览器环境下扩展点配置，配置在这里的bean，业务系统都可以通过声明同类型或同名的bean来覆盖安全 模块默认的配置。
 * @date 2017-10-09 16:06:42
 */
@Configuration
public class BrowserSecurityBeanConfig {

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * session失效时的处理策略配置
   */
  @Bean
  @ConditionalOnMissingBean(InvalidSessionStrategy.class)
  public InvalidSessionStrategy invalidSessionStrategy() {
    return new AppleInvalidSessionStrategy(securityProperties);
  }

  /**
   * 并发登录导致前一个session失效时的处理策略配置
   */
  @Bean
  @ConditionalOnMissingBean(SessionInformationExpiredStrategy.class)
  public SessionInformationExpiredStrategy sessionInformationExpiredStrategy() {
    return new AppleExpiredSessionStrategy(securityProperties);
  }


}
