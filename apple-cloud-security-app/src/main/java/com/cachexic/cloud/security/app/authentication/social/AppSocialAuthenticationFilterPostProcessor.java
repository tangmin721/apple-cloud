package com.cachexic.cloud.security.app.authentication.social;

import com.cachexic.cloud.security.core.social.support.SocialAuthenticationFilterPostProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.stereotype.Component;

/**
 * @Description: 第三方登录成功后的处理器
 * @author tangmin
 * @date 2017-10-17 12:32:49
 */
@Component
public class AppSocialAuthenticationFilterPostProcessor implements
    SocialAuthenticationFilterPostProcessor {

  @Autowired
  private AuthenticationSuccessHandler myAuthenticationSuccessHandler;

  @Override
  public void process(SocialAuthenticationFilter socialAuthenticationFilter) {
    socialAuthenticationFilter.setAuthenticationSuccessHandler(myAuthenticationSuccessHandler);
  }
}
