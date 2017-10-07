package com.cachexic.cloud.security.core.social.qq.connect;

import com.cachexic.cloud.security.core.social.qq.api.QQ;
import org.springframework.social.connect.support.OAuth2ConnectionFactory;

/**
 * @Description: QQConnectionFactory
 * @author tangmin
 * @date 2017-10-03 21:50:49
 */
public class QQConnectionFactory extends OAuth2ConnectionFactory<QQ>{

  public QQConnectionFactory(String providerId,String appId,String appSecret) {
    /**
     * 把serviceProvider和Adapter作为参数传入
     */
    super(providerId, new QQServiceProvider(appId,appSecret), new QQAdapter());
  }
}
