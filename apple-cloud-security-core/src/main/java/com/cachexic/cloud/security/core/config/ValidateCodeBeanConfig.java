package com.cachexic.cloud.security.core.config;

import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.image.DefaultImageCodeGenerator;
import com.cachexic.cloud.security.core.validate.code.sms.DefaultSmsCodeSender;
import com.cachexic.cloud.security.core.validate.code.sms.SmsCodeSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Description: 配置默认的实现bean
 * @author tangmin
 * @date 2017-09-30 09:42:07
 */
@Configuration
public class ValidateCodeBeanConfig {

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * ConditionalOnMissingBean的作用是当上下文没有ValidateCodeGenerator的实现的时候,启用这个Bean
   * @return
   */
  @Bean
  @ConditionalOnMissingBean(name = "imageCodeGenerator")
  public ValidateCodeGenerator imageCodeGenerator() {
    DefaultImageCodeGenerator codeGenerator = new DefaultImageCodeGenerator();
    codeGenerator.setSecurityProperties(securityProperties);
    return codeGenerator;
  }

  /**
   * 配置短信发送接口的默认实现
   * @return
   */
  @Bean
  @ConditionalOnMissingBean(SmsCodeSender.class)
  public SmsCodeSender smsCodeSender() {
    return new DefaultSmsCodeSender();
  }
}
