package com.cachexic.cloud.security.core.config.bo;

/**
 * @Description: 权限精确拦截url和method
 * @author tangmin
 * @date 2017-09-29 17:37:47
 */
public class UrlAndMethod {
  private String url;
  private String method;

  public UrlAndMethod(String url) {
    this.url = url;
  }

  public UrlAndMethod(String url, String method) {
    this.url = url;
    this.method = method;
  }

  public String getUrl() {
    return url;
  }

  public void setUrl(String url) {
    this.url = url;
  }

  public String getMethod() {
    return method;
  }

  public void setMethod(String method) {
    this.method = method;
  }
}
