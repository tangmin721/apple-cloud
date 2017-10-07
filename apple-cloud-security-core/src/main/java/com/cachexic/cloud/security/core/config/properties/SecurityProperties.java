package com.cachexic.cloud.security.core.config.properties;

import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author tangmin
 * @Description:顶级的配置
 * @date 2017-09-28 17:36:03
 */
@ConfigurationProperties(prefix = "apple.security")
public class SecurityProperties {

  private BrowserProperties browser = new BrowserProperties();

  private ValidateCodeProperties code = new ValidateCodeProperties();

  private SocialProperties social = new SocialProperties();

  public BrowserProperties getBrowser() {
    return browser;
  }

  public void setBrowser(BrowserProperties browser) {
    this.browser = browser;
  }

  public ValidateCodeProperties getCode() {
    return code;
  }

  public void setCode(ValidateCodeProperties code) {
    this.code = code;
  }

  public SocialProperties getSocial() {
    return social;
  }

  public void setSocial(SocialProperties social) {
    this.social = social;
  }
}
