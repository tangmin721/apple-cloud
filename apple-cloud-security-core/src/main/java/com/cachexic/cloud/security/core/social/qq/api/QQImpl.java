package com.cachexic.cloud.security.core.social.qq.api;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.oauth2.AbstractOAuth2ApiBinding;
import org.springframework.social.oauth2.TokenStrategy;

/**
 * @Description: 继承AbstractOAuth2ApiBinding
 * @author tangmin
 * @date 2017-10-03 17:17:48
 */
public class QQImpl extends AbstractOAuth2ApiBinding implements QQ{

  private final static Logger log = LoggerFactory.getLogger(QQImpl.class);

  /**
   * 获取openId：http://wiki.connect.qq.com/openapi%E8%B0%83%E7%94%A8%E8%AF%B4%E6%98%8E_oauth2-0
   */
  private static final String URL_GET_OPENID = "https://graph.qq.com/oauth2.0/me?access_token=%s";

  /**
   * 获取用户id
   * http://wiki.connect.qq.com/get_user_info
   * @return
   */
  private static final String URL_GET_USERINFO = "https://graph.qq.com/user/get_user_info?"
      + "access_token=%s"
      + "&oauth_consumer_key=%s"
      + "&openid=%s";

  private String appId;

  private String openId;

  public QQImpl(String accessToken,String appId){
    super(accessToken, TokenStrategy.ACCESS_TOKEN_PARAMETER);
    this.appId = appId;

    //获取openId
    //http://wiki.connect.qq.com/%E8%8E%B7%E5%8F%96%E7%94%A8%E6%88%B7openid_oauth2-0
    String url = String.format(URL_GET_OPENID, accessToken);
    //callback( {"client_id":"YOUR_APPID","openid":"YOUR_OPENID"} );
    String result = getRestTemplate().getForObject(url, String.class);
    log.debug("URL_GET_OPENID===>result:" + result);
    this.openId = StringUtils.substringBetween(result,"\"openid\":","}");
  }

  /**
   * 自定义实现
   * @return
   */
  @Override
  public QQUserInfo getUserInfo() {

    String url = String.format(URL_GET_USERINFO, appId, openId);
    String result = getRestTemplate().getForObject(url, String.class);
    log.debug("URL_GET_USERINFO===>result:" + result);

    return JsonUtil.toEntity(result,QQUserInfo.class);
  }
}
