package com.cachexic.cloud.security.core.validate.code.entity;

import java.time.LocalDateTime;

/**
 * @Description: 验证码(SMS)
 * @author tangmin
 * @date 2017-09-30 12:01:44
 */
public class ValidateCode {

  private String code;

  /**
   * 验证码过期时刻
   */
  private LocalDateTime expireTime;

  /**
   * 注意:传入一个expireIn:多少秒过期
   */
  public ValidateCode(String code, int expireIn) {
    this.code = code;
    this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
  }

  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }

  public LocalDateTime getExpireTime() {
    return expireTime;
  }

  public void setExpireTime(LocalDateTime expireTime) {
    this.expireTime = expireTime;
  }

  /**
   * 校验是否过期
   * @return
   */
  public boolean isExpried() {
    return LocalDateTime.now().isAfter(expireTime);
  }
}
