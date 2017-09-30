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

  private LoginType loginType = LoginType.JSON;

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
}
