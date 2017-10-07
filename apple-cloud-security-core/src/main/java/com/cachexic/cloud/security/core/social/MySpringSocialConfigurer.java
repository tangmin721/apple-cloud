package com.cachexic.cloud.security.core.social;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author tangmin
 * @Description: 覆盖默认的实现，自定义第三方登录成功后的回调url
 * @date 2017-10-04 17:13:00
 */
public class MySpringSocialConfigurer extends SpringSocialConfigurer {

  /**
   * 可配置的处理调用成功的请求url
   */
  private String filterProcessesUrl;

  /**
   * 在构造函数里设置url
   */
  public MySpringSocialConfigurer(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  @Override
  protected <T> T postProcess(T object) {
    SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
    filter.setFilterProcessesUrl(filterProcessesUrl);
    return (T) filter;
  }
}
