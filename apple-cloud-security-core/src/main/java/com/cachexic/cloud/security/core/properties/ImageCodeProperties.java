package com.cachexic.cloud.security.core.properties;

/**
 * @author tangmin
 * @Description: 图形验证码的配置
 * @date 2017-09-29 17:04:37
 */
public class ImageCodeProperties {

  /**
   * 图形宽高
   */
  private int width = 67;
  private int height = 23;

  /**
   * 验证码位数
   */
  private int length = 4;

  /**
   * 过期时间单位:秒
   */
  private int expireIn = 60;

  /**
   * 可配置的指定哪个url的请求需要做验证码拦截格式
   * 格式要求: url必填,method选填,以:隔开,不同url以逗号隔开
   * /usr/*:post,/usr2/list
   */
  private String urlAndMethods;

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

  public int getLength() {
    return length;
  }

  public void setLength(int length) {
    this.length = length;
  }

  public int getExpireIn() {
    return expireIn;
  }

  public void setExpireIn(int expireIn) {
    this.expireIn = expireIn;
  }

  public String getUrlAndMethods() {
    return urlAndMethods;
  }

  public void setUrlAndMethods(String urlAndMethods) {
    this.urlAndMethods = urlAndMethods;
  }
}
