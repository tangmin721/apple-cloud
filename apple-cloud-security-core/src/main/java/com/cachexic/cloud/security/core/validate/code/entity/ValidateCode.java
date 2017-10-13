package com.cachexic.cloud.security.core.validate.code.entity;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * @Description: 验证码(SMS)
 * @author tangmin
 * @date 2017-09-30 12:01:44
 */
public class ValidateCode implements Serializable{

  private static final long serialVersionUID = 2562392569646589147L;
  private String code;

  /**
   * 验证码过期时刻
   */
  private LocalDateTime expireTime;

  /**
   * 本校验码校验次数,防暴力破解
   */
  private int checkTimes;

  /**
   * 注意:传入一个expireIn:多少秒过期
   */
  public ValidateCode(String code, int expireIn) {
    this.code = code;
    this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
  }

  /**
   * 存储到session
   * @param code
   * @param expireTime
   */
  public ValidateCode(String code, LocalDateTime expireTime, int checkTimes) {
    this.code = code;
    this.expireTime = expireTime;
    this.checkTimes = checkTimes;
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

  public int getCheckTimes() {
    return checkTimes;
  }

  public void setCheckTimes(int checkTimes) {
    this.checkTimes = checkTimes;
  }

  /**
   * 校验是否过期
   * @return
   */
  public boolean isExpried() {
    return LocalDateTime.now().isAfter(expireTime);
  }

  /**
   * 校验是否操作次数限制 最多3次输错机会
   * @return
   */
  public boolean isOverTimes() {
    return checkTimes>2;
  }
}
