/**
 *
 */
package com.cachexic.cloud.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;
import org.springframework.social.security.SpringSocialConfigurer;

/**
 * @author tangmin
 * @Description: 继承默认的社交登录配置，加入自定义的后处理逻辑
 * @date 2017-10-15 17:19:53
 */
public class AppleSpringSocialConfigurer extends SpringSocialConfigurer {

  private String filterProcessesUrl;

  private SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor;

  public AppleSpringSocialConfigurer(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  @SuppressWarnings("unchecked")
  @Override
  protected <T> T postProcess(T object) {
    SocialAuthenticationFilter filter = (SocialAuthenticationFilter) super.postProcess(object);
    filter.setFilterProcessesUrl(filterProcessesUrl);
    // 解决第三方登录在app环境下错误处理器返回token
    if (socialAuthenticationFilterPostProcessor != null) {
      socialAuthenticationFilterPostProcessor.process(filter);
    }
    return (T) filter;
  }

  public String getFilterProcessesUrl() {
    return filterProcessesUrl;
  }

  public void setFilterProcessesUrl(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }

  public SocialAuthenticationFilterPostProcessor getSocialAuthenticationFilterPostProcessor() {
    return socialAuthenticationFilterPostProcessor;
  }

  public void setSocialAuthenticationFilterPostProcessor(
      SocialAuthenticationFilterPostProcessor socialAuthenticationFilterPostProcessor) {
    this.socialAuthenticationFilterPostProcessor = socialAuthenticationFilterPostProcessor;
  }

}
