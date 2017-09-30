package com.cachexic.cloud.security.core.config.properties;

/**
 * @author tangmin
 * @Description: 图形验证码与短信验证码封装
 * @date 2017-09-29 17:09:59
 */
public class ValidateCodeProperties {

  private ImageCodeProperties image = new ImageCodeProperties();
  private SmsCodeProperties sms = new SmsCodeProperties();

  public ImageCodeProperties getImage() {
    return image;
  }

  public void setImage(ImageCodeProperties image) {
    this.image = image;
  }

  public SmsCodeProperties getSms() {
    return sms;
  }

  public void setSms(SmsCodeProperties sms) {
    this.sms = sms;
  }
}
