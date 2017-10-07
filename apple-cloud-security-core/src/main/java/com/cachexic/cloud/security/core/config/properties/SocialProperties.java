package com.cachexic.cloud.security.core.config.properties;

/**
 * @Description: 统一第三方登录配置
 * @author tangmin
 * @date 2017-10-03 22:43:17
 */
public class SocialProperties {

  /**
   *
   */
  private String filterProcessesUrl = "/auth";

  private QQProperties qq = new QQProperties();

  public QQProperties getQq() {
    return qq;
  }

  public void setQq(QQProperties qq) {
    this.qq = qq;
  }

  public String getFilterProcessesUrl() {
    return filterProcessesUrl;
  }

  public void setFilterProcessesUrl(String filterProcessesUrl) {
    this.filterProcessesUrl = filterProcessesUrl;
  }
}
