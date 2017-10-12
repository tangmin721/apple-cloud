package com.cachexic.cloud.security.core.config.properties;

/**
 * @author tangmin
 * @Description:
 * @date 2017-10-12 21:04:30
 */
public class OAuth2Properties {

  /**
   * 使用jwt时为token签名的秘钥
   */
  private String jwtSigningKey = "apple";
  /**
   * 客户端配置
   */
  private OAuth2ClientProperties[] clients = {};

  public OAuth2ClientProperties[] getClients() {
    return clients;
  }

  public void setClients(OAuth2ClientProperties[] clients) {
    this.clients = clients;
  }

  public String getJwtSigningKey() {
    return jwtSigningKey;
  }

  public void setJwtSigningKey(String jwtSigningKey) {
    this.jwtSigningKey = jwtSigningKey;
  }

}
