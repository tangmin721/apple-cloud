package com.cachexic.cloud.security.core.authtication.mobile;

import java.util.Collection;
import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.SpringSecurityCoreVersion;

/**
 * @author tangmin
 * @Description: 1.sms模仿UsernamePasswordAuthenticationToken实现
 * @date 2017-10-01 14:56:59
 */
public class SmsCodeAuthenticationToken extends AbstractAuthenticationToken {

  private static final long serialVersionUID = SpringSecurityCoreVersion.SERIAL_VERSION_UID;

  // ~ Instance fields
  // ================================================================================================

  /**
   * 认证信息，认证之前放手机号，认证之后放登录成功的用户
   */
  private final Object principal;

  // ~ Constructors
  // ===================================================================================================

  /**
   * 认证之前
   * @param mobile
   */
  public SmsCodeAuthenticationToken(Object mobile) {
    super(null);
    this.principal = mobile;
    setAuthenticated(false);
  }

  /**
   * 认证之后
   * @param principal
   * @param authorities
   */
  public SmsCodeAuthenticationToken(Object principal,
      Collection<? extends GrantedAuthority> authorities) {
    super(authorities);
    this.principal = principal;
    super.setAuthenticated(true); // must use super, as we override
  }

  // ~ Methods
  // ========================================================================================================

  @Override
  public Object getCredentials() {
    return null;
  }

  @Override
  public Object getPrincipal() {
    return this.principal;
  }

  @Override
  public void setAuthenticated(boolean isAuthenticated) throws IllegalArgumentException {
    if (isAuthenticated) {
      throw new IllegalArgumentException(
          "Cannot set this token to trusted - use constructor which takes a GrantedAuthority list instead");
    }

    super.setAuthenticated(false);
  }

  @Override
  public void eraseCredentials() {
    super.eraseCredentials();
  }

}
