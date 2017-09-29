package com.cachexic.cloud.security.core.validate.code;

import java.io.IOException;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Description: 在user password之前加一个图验证码的校验,在securityconfig里addFilter
 * @author tangmin
 * @date 2017-09-29 15:47:05
 */
public class ValidateCodeFilter extends OncePerRequestFilter {

  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

  @Autowired
  private AuthenticationFailureHandler authenticationFailureHandler;

  /**
   * 验证码过滤器
   * @param request
   * @param response
   * @param filterChain
   * @throws ServletException
   * @throws IOException
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {
    if (StringUtils.equals("/authentication/form", request.getRequestURI())
        && StringUtils.equalsIgnoreCase(request.getMethod(), "post")) {
      try {
        validate(new ServletWebRequest(request));
      } catch (ValidateCodeException e) {
        authenticationFailureHandler.onAuthenticationFailure(request, response, e);
        return;
      }
    }
    filterChain.doFilter(request, response);
  }

  private void validate(ServletWebRequest request) throws ServletRequestBindingException {
    ImageCode codeInSession = (ImageCode) sessionStrategy
        .getAttribute(request, ValidateCodeController.SESSION_KEY);

    String codeInRequest = ServletRequestUtils
        .getStringParameter(request.getRequest(), "imageCode");

    if (StringUtils.isBlank(codeInRequest)) {
      throw new ValidateCodeException("验证码的值不能为空");
    }

    if (codeInSession == null) {
      throw new ValidateCodeException("验证码不存在");
    }

    if (codeInSession.isExpried()) {
      sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
      throw new ValidateCodeException("验证码已过期");
    }

    if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
      throw new ValidateCodeException("验证码不匹配");
    }

    sessionStrategy.removeAttribute(request, ValidateCodeController.SESSION_KEY);
  }

  public AuthenticationFailureHandler getAuthenticationFailureHandler() {
    return authenticationFailureHandler;
  }

  public void setAuthenticationFailureHandler(
      AuthenticationFailureHandler authenticationFailureHandler) {
    this.authenticationFailureHandler = authenticationFailureHandler;
  }
}
