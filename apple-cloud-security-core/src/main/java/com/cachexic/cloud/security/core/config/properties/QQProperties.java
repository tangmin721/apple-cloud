package com.cachexic.cloud.security.core.config.properties;

import org.springframework.boot.autoconfigure.social.SocialProperties;

/**
 * @author tangmin
 * @Description: 定义qq的providerId
 * @date 2017-10-03 22:41:21
 */
public class QQProperties extends SocialProperties {
  private String providerId = "qq";

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }
}
