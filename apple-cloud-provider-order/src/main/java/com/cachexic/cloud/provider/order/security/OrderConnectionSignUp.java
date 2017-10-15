/**
 *
 */
package com.cachexic.cloud.provider.order.security;

import org.springframework.social.connect.Connection;
import org.springframework.social.connect.ConnectionSignUp;

/**
 * @author tangmin
 * @Description: 第三方登录后，自动注册
 * @date 2017-10-15 22:21:00
 */
//@Component
public class OrderConnectionSignUp implements ConnectionSignUp {

  @Override
  public String execute(Connection<?> connection) {
    //根据社交用户信息默认创建用户并返回用户唯一标识
    return connection.getDisplayName();
  }

}
