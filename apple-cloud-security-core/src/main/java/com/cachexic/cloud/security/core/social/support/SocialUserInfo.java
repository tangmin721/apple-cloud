package com.cachexic.cloud.security.core.social.support;

/**
 * @author tangmin
 * @Description:
 * @date 2017-10-15 17:19:11
 */
public class SocialUserInfo {

  private String providerId;

  private String providerUserId;

  private String nickname;

  private String headimg;

  public String getProviderId() {
    return providerId;
  }

  public void setProviderId(String providerId) {
    this.providerId = providerId;
  }

  public String getProviderUserId() {
    return providerUserId;
  }

  public void setProviderUserId(String providerUserId) {
    this.providerUserId = providerUserId;
  }

  public String getNickname() {
    return nickname;
  }

  public void setNickname(String nickname) {
    this.nickname = nickname;
  }

  public String getHeadimg() {
    return headimg;
  }

  public void setHeadimg(String headimg) {
    this.headimg = headimg;
  }

}
