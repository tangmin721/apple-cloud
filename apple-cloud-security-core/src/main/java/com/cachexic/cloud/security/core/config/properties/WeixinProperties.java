package com.cachexic.cloud.security.core.config.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author tangmin
 * @Description: 微信登录配置项
 * @date 2017-10-15 22:25:56
 */
public class WeixinProperties extends SocialProperties {

  /**
   * 第三方id，用来决定发起第三方登录的url，默认是 weixin。
   */
  private String providerId = "weixin";

  /**
   * @return the providerId
   */
  public String getProviderId() {
    return providerId;
  }

  /**
   * @param providerId the providerId to set
   */
  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }


}
