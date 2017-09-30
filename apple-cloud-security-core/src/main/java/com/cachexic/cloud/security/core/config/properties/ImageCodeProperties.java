package com.cachexic.cloud.security.core.config.properties;

/**
 * @author tangmin
 * @Description: 图形验证码的配置
 * @date 2017-09-29 17:04:37
 */
public class ImageCodeProperties extends SmsCodeProperties{

  public ImageCodeProperties() {
    setLength(4);//设置默认图片验证码长度
  }

  /**
   * 图形宽高
   */
  private int width = 67;
  private int height = 23;

  public int getWidth() {
    return width;
  }

  public void setWidth(int width) {
    this.width = width;
  }

  public int getHeight() {
    return height;
  }

  public void setHeight(int height) {
    this.height = height;
  }


}
