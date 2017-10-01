package com.cachexic.cloud.security.core.authtication.mobile;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.InternalAuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;

/**
 * @author tangmin
 * @Description: 自定义一个provider，通过AuthenicationManager加入到authenticationProvider集合里去
 * @date 2017-10-01 15:22:15
 */
public class SmsCodeAuthenticationProvider implements AuthenticationProvider {

  private UserDetailsService userDetailsService;

  /**
   * 返回已认证的用户信息
   */
  @Override
  public Authentication authenticate(Authentication authentication) throws AuthenticationException {
    SmsCodeAuthenticationToken authenticationToken = (SmsCodeAuthenticationToken) authentication;
    UserDetails userDetails = userDetailsService
        .loadUserByUsername((String) authenticationToken.getPrincipal());

    if(userDetails==null){
      throw new InternalAuthenticationServiceException("无法获取用户信息");
    }

    SmsCodeAuthenticationToken authenticationResult = new SmsCodeAuthenticationToken(userDetails,
        userDetails.getAuthorities());

    authenticationResult.setDetails(authenticationToken.getDetails());

    return authenticationResult;
  }

  /**
   * 判断认证类型
   */
  @Override
  public boolean supports(Class<?> authentication) {
    return SmsCodeAuthenticationToken.class.isAssignableFrom(authentication);
  }

  public UserDetailsService getUserDetailsService() {
    return userDetailsService;
  }

  public void setUserDetailsService(
      UserDetailsService userDetailsService) {
    this.userDetailsService = userDetailsService;
  }
}
