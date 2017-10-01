package com.cachexic.cloud.security.core.authtication.mobile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.authentication.AuthenticationServiceException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.util.Assert;

/**
 * @author tangmin
 * @Description: 2.短信验证码认证过滤器，参考UsernamePasswordAuthenticationFilter
 * @date 2017-10-01 15:04:58
 */
public class SmsCodeAuthenticationFilter extends AbstractAuthenticationProcessingFilter {

  // ~ Static fields/initializers
  // =====================================================================================

  public static final String SMS_CODE_FORM_MOBILE_KEY = "mobile";

  private String mobileParameter = SMS_CODE_FORM_MOBILE_KEY;
  private boolean postOnly = true;

  // ~ Constructors
  // ===================================================================================================

  public SmsCodeAuthenticationFilter() {
    super(new AntPathRequestMatcher("/authentication/mobile", "POST"));
  }

  // ~ Methods
  // ========================================================================================================

  /**
   * 认证流程
   */
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response) throws AuthenticationException {
    if (postOnly && !request.getMethod().equals("POST")) {
      throw new AuthenticationServiceException(
          "Authentication method not supported: " + request.getMethod());
    }

    String mobile = obtainMobile(request);

    if (mobile == null) {
      mobile = "";
    }

    mobile = mobile.trim();

    SmsCodeAuthenticationToken authRequest = new SmsCodeAuthenticationToken(
        mobile);

    // Allow subclasses to set the "details" property
    setDetails(request, authRequest);

    return this.getAuthenticationManager().authenticate(authRequest);
  }


  protected String obtainMobile(HttpServletRequest request) {
    return request.getParameter(mobileParameter);
  }

  protected void setDetails(HttpServletRequest request,
      SmsCodeAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }


  public void setMobileParameter(String mobileParameter) {
    Assert.hasText(mobileParameter, "mobile parameter must not be empty or null");
    this.mobileParameter = mobileParameter;
  }


  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  public final String getMobileParameter() {
    return mobileParameter;
  }


}
