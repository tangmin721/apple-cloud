package com.cachexic.cloud.security.core.config.properties;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.enums.LoginType;

/**
 * @author tangmin
 * @Description: 浏览器的相关配置项
 * @date 2017-09-28 17:41:24
 */
public class BrowserProperties {

  private String loginPage = SecurityConstants.DEFAULT_LOGIN_PAGE_URL;
  private String logoutPage = SecurityConstants.DEFAULT_LOGOUT_PAGE_URL;

  private LoginType loginType = LoginType.JSON;

  /**
   * 3600*24*7 = 604 800 默认的记住7天
   */
  private int rememberMeSeconds = 604800;

  public String getLoginPage() {
    return loginPage;
  }

  public void setLoginPage(String loginPage) {
    this.loginPage = loginPage;
  }

  public LoginType getLoginType() {
    return loginType;
  }

  public void setLoginType(LoginType loginType) {
    this.loginType = loginType;
  }

  public int getRememberMeSeconds() {
    return rememberMeSeconds;
  }

  public void setRememberMeSeconds(int rememberMeSeconds) {
    this.rememberMeSeconds = rememberMeSeconds;
  }

  public String getLogoutPage() {
    return logoutPage;
  }

  public void setLogoutPage(String logoutPage) {
    this.logoutPage = logoutPage;
  }
}
