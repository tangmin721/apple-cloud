/**
 *
 */
package com.cachexic.cloud.provider.order.security;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 第三方登录后，自动注册
 * @date 2017-10-15 22:21:00
 */
@Component
public class OrderConnectionSignUp implements ConnectionSignUp {

  private static final Logger log = LoggerFactory.getLogger(OrderConnectionSignUp.class);

  @Override
  public String execute(Connection<?> connection) {
    //根据社交用户信息默认创建用户并返回用户唯一标识
    //@TODO 真实信息
    log.info("====>OrderConnectionSignUp:displayName:{},openId:{}",connection.getDisplayName(),connection.getKey().getProviderUserId());
    return connection.getDisplayName();
  }

}
