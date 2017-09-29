package com.cachexic.cloud.security.core.properties;

/**
 * @author tangmin
 * @Description: 图形验证码与短信验证码封装
 * @date 2017-09-29 17:09:59
 */
public class ValidateCodeProperties {

  private ImageCodeProperties image = new ImageCodeProperties();

  public ImageCodeProperties getImage() {
    return image;
  }

  public void setImage(ImageCodeProperties image) {
    this.image = image;
  }
}
