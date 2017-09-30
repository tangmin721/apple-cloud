package com.cachexic.cloud.security.core.validate.code.entity;

import java.awt.image.BufferedImage;
import java.time.LocalDateTime;

/**
 * @author tangmin
 * @Description: 图形验证码
 * @date 2017-09-29 13:23:53
 */
public class ImageCode {

  private BufferedImage image;

  private String code;

  /**
   * 验证码过期时刻
   */
  private LocalDateTime expireTime;

  /**
   * 注意:传入一个expireIn:多少秒过期
   */
  public ImageCode(BufferedImage image, String code, int expireIn) {
    this.image = image;
    this.code = code;
    this.expireTime = LocalDateTime.now().plusSeconds(expireIn);
  }

  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
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
