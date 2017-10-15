package com.cachexic.cloud.security.core.social.qq.connect;

import com.cachexic.cloud.security.core.social.qq.api.QQ;
import com.cachexic.cloud.security.core.social.qq.api.QQUserInfo;
import org.springframework.social.connect.ApiAdapter;
import org.springframework.social.connect.ConnectionValues;
import org.springframework.social.connect.UserProfile;

/**
 * @Description: 定义ApiAdapter
 * @author tangmin
 * @date 2017-10-03 21:51:35
 */
public class QQAdapter implements ApiAdapter<QQ>{

  /**
   * 测试qq API 是否可用
   * @param api
   * @return
   */
  @Override
  public boolean test(QQ api) {
    return true;
  }

  /**
   * 属性做适配
   * @param api
   * @param values
   */
  @Override
  public void setConnectionValues(QQ api, ConnectionValues values) {
    QQUserInfo userInfo = api.getUserInfo();
    values.setDisplayName(userInfo.getNickname());
    values.setImageUrl(userInfo.getFigureurl_qq_1());
    values.setProfileUrl(null);
    values.setProviderUserId(userInfo.getOpenId());//用户的ID，与QQ号码一一对应。可通过调用https://graph.qq.com/oauth2.0/me?access_token=YOUR_ACCESS_TOKEN 来获取。
  }

  /**
   * 绑定解绑时用到
   * @param api
   * @return
   */
  @Override
  public UserProfile fetchUserProfile(QQ api) {
    return null;
  }

  @Override
  public void updateStatus(QQ api, String message) {

  }
}
