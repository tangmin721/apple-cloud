package com.cachexic.cloud.security.core.config.properties;

/**
 * @author tangmin
 * @Description: 认证服务器注册的第三方应用配置项
 * @date 2017-10-12 21:05:25
 */
public class OAuth2ClientProperties {

  /**
   * 第三方应用appId
   */
  private String clientId;
  /**
   * 第三方应用appSecret
   */
  private String clientSecret;
  /**
   * 针对此应用发出的token的有效时间 默认2小时。如果是0表示永不过期
   */
  private int accessTokenValidateSeconds = 7200;

  public String getClientId() {
    return clientId;
  }

  public void setClientId(String clientId) {
    this.clientId = clientId;
  }

  public String getClientSecret() {
    return clientSecret;
  }

  public void setClientSecret(String clientSecret) {
    this.clientSecret = clientSecret;
  }

  public int getAccessTokenValidateSeconds() {
    return accessTokenValidateSeconds;
  }

  public void setAccessTokenValidateSeconds(int accessTokenValidateSeconds) {
    this.accessTokenValidateSeconds = accessTokenValidateSeconds;
  }

}
