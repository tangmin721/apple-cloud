package com.cachexic.cloud.security.core.social.qq.connect;

import com.cachexic.cloud.security.core.social.qq.api.QQ;
import com.cachexic.cloud.security.core.social.qq.api.QQImpl;
import org.springframework.social.oauth2.AbstractOAuth2ServiceProvider;

/**
 * @Description: 获取授权码 和 accessToken
 * @author tangmin
 * @date 2017-10-03 18:52:02
 */
public class QQServiceProvider extends AbstractOAuth2ServiceProvider<QQ> {

  private String appId;

  /**
   * http://wiki.connect.qq.com/%E4%BD%BF%E7%94%A8authorization_code%E8%8E%B7%E5%8F%96access_token
   * Step1：获取Authorization Code
   */
  private static final String URL_AUTHORIZE = "https://graph.qq.com/oauth2.0/authorize";

  /**
   * Step2：通过Authorization Code获取Access Token
   */
  private static final String URL_ACCESS_TOKEN = "https://graph.qq.com/oauth2.0/token";

  /**
   * 构造方法，获取授权码和accessToken,用自己的template实现
   * @param appId
   * @param appSecret
   */
  public QQServiceProvider(String appId,String appSecret) {
    super(new QQOAuth2Template(appId,appSecret,URL_AUTHORIZE,URL_ACCESS_TOKEN));
    this.appId = appId;
  }

  @Override
  public QQ getApi(String accessToken) {
    return new QQImpl(accessToken,appId);
  }
}
