package com.cachexic.cloud.security.app.authentication.social;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.social.support.AppleSpringSocialConfigurer;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;

/**
 * @Description: app环境 注册
 * @author tangmin
 * @date 2017-10-17 12:28:32
 */
@Component
public class SpringSocialConfigurerPostProcessor implements BeanPostProcessor {

  /* (non-Javadoc)
   * @see org.springframework.beans.factory.config.BeanPostProcessor#postProcessBeforeInitialization(java.lang.Object, java.lang.String)
   */
  @Override
  public Object postProcessBeforeInitialization(Object bean, String beanName)
      throws BeansException {
    return bean;
  }

  @Override
  public Object postProcessAfterInitialization(Object bean, String beanName) throws BeansException {
    if (StringUtils.equals(beanName, "appleSocialSecurityConfig")) {
      AppleSpringSocialConfigurer config = (AppleSpringSocialConfigurer) bean;
      config.signupUrl(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL);
      return config;
    }
    return bean;
  }

}
