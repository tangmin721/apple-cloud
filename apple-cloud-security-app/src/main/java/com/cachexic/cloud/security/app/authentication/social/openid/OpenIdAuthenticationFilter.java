package com.cachexic.cloud.security.app.authentication.social.openid;

import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
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
 * @Description: openId 过滤器
 * @date 2017-10-17 10:04:26
 */
public class OpenIdAuthenticationFilter extends AbstractAuthenticationProcessingFilter {
  // ~ Static fields/initializers
  // =====================================================================================

  private String openIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_OPENID;
  private String providerIdParameter = SecurityConstants.DEFAULT_PARAMETER_NAME_PROVIDERID;
  private boolean postOnly = true;

  // ~ Constructors
  // ===================================================================================================

  public OpenIdAuthenticationFilter() {
    super(
        new AntPathRequestMatcher(SecurityConstants.DEFAULT_SIGN_IN_PROCESSING_URL_OPENID, "POST"));
  }

  // ~ Methods
  // ========================================================================================================
  @Override
  public Authentication attemptAuthentication(HttpServletRequest request,
      HttpServletResponse response)
      throws AuthenticationException {
    if (postOnly && !request.getMethod().equals("POST")) {
      throw new AuthenticationServiceException(
          "Authentication method not supported: " + request.getMethod());
    }

    String openId = obtainOpenId(request);
    String providerId = obtainProviderId(request);

    if (openId == null) {
      openId = "";
    }
    if (providerId == null) {
      providerId = "";
    }

    openId = openId.trim();
    providerId = providerId.trim();

    OpenIdAuthenticationToken authRequest = new OpenIdAuthenticationToken(openId, providerId);

    // Allow subclasses to set the "details" property
    setDetails(request, authRequest);

    return this.getAuthenticationManager().authenticate(authRequest);
  }


  /**
   * 获取openId
   */
  protected String obtainOpenId(HttpServletRequest request) {
    return request.getParameter(openIdParameter);
  }

  /**
   * 获取提供商id
   */
  protected String obtainProviderId(HttpServletRequest request) {
    return request.getParameter(providerIdParameter);
  }

  /**
   * Provided so that subclasses may configure what is put into the
   * authentication request's details property.
   *
   * @param request that an authentication request is being created for
   * @param authRequest the authentication request object that should have its details set
   */
  protected void setDetails(HttpServletRequest request, OpenIdAuthenticationToken authRequest) {
    authRequest.setDetails(authenticationDetailsSource.buildDetails(request));
  }

  /**
   * Sets the parameter name which will be used to obtain the username from
   * the login request.
   */
  public void setOpenIdParameter(String openIdParameter) {
    Assert.hasText(openIdParameter, "Username parameter must not be empty or null");
    this.openIdParameter = openIdParameter;
  }


  /**
   * Defines whether only HTTP POST requests will be allowed by this filter.
   * If set to true, and an authentication request is received which is not a
   * POST request, an exception will be raised immediately and authentication
   * will not be attempted. The <tt>unsuccessfulAuthentication()</tt> method
   * will be called as if handling a failed authentication.
   * <p>
   * Defaults to <tt>true</tt> but may be overridden by subclasses.
   */
  public void setPostOnly(boolean postOnly) {
    this.postOnly = postOnly;
  }

  public final String getOpenIdParameter() {
    return openIdParameter;
  }

  public String getProviderIdParameter() {
    return providerIdParameter;
  }

  public void setProviderIdParameter(String providerIdParameter) {
    this.providerIdParameter = providerIdParameter;
  }

}
