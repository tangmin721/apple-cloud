package com.cachexic.cloud.security.core.validate.code.entity;

import java.awt.image.BufferedImage;

/**
 * @author tangmin
 * @Description: 图形验证码(比sms多一个图片属性)
 * @date 2017-09-29 13:23:53
 */
public class ImageCode extends ValidateCode {

  private BufferedImage image;

  /**
   * 注意:传入一个expireIn:多少秒过期
   */
  public ImageCode(BufferedImage image, String code, int expireIn) {
    super(code, expireIn);
    this.image = image;
  }


  public BufferedImage getImage() {
    return image;
  }

  public void setImage(BufferedImage image) {
    this.image = image;
  }


}
