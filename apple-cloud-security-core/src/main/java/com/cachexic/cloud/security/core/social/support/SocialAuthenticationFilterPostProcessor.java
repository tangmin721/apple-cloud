/**
 *
 */
package com.cachexic.cloud.security.core.social.support;

import org.springframework.social.security.SocialAuthenticationFilter;

/**
 * @Description: SocialAuthenticationFilter后处理器，用于在不同环境下个性化社交登录的配置
 * @author tangmin
 * @date 2017-10-15 17:20:26
 */
public interface SocialAuthenticationFilterPostProcessor {

  /**
   * @param socialAuthenticationFilter
   */
  void process(SocialAuthenticationFilter socialAuthenticationFilter);

}
