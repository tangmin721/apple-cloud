package com.cachexic.cloud.security.core.exceptions;

/**
 * @Description: 安全模块自定义业务异常信息
 * @author tangmin
 * @date 2017-10-15 17:06:35
 */
public enum SecurityBizExceptionEnum {
  GET_QQ_INFO(-1, "获取QQ用户信息失败"),
  SOCIAL_CHACHE_INFO_NOT_FOUND(-1, "无法找到缓存的用户社交账号信息");

  private int code;
  private String msg;

  /**
   * 构造方法
   */
  SecurityBizExceptionEnum(int code, String msg) {
    this.code = code;
    this.msg = msg;
  }

  public int getCode() {
    return code;
  }

  public String getMsg() {
    return msg;
  }
}
