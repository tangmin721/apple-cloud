package com.cachexic.cloud.security.core.config.enums;

/**
 * @author tangmin
 * @Description: 登录成功或失败返回结果类型 REDIRECT:登录成功后重定向到原请求url JSON: 返回登录成功JSON信息
 * @date 2017-09-29 10:46:49
 */
public enum LoginResponseType {
  /**
   * 跳转
   */
  REDIRECT,
  /**
   * 返回json
   */
  JSON
}
