package com.cachexic.cloud.security.core.social.weixin.api;

/**
 * @author tangmin
 * @Description: 微信API调用接口
 * @date 2017-10-15 22:34:49
 */
public interface Weixin {

  /**
   * 比qq多一个参数
   * @param openId
   * @return
   */
  WeixinUserInfo getUserInfo(String openId);

}
