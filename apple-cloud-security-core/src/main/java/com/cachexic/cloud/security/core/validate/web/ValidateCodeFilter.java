package com.cachexic.cloud.security.core.validate.web;

import com.cachexic.cloud.security.core.config.bo.UrlAndMethod;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.validate.code.ValidateCodeProcessor;
import com.cachexic.cloud.security.core.validate.code.entity.ImageCode;
import com.cachexic.cloud.security.core.validate.exceptions.ValidateCodeException;
import java.io.IOException;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.assertj.core.util.Lists;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.social.connect.web.HttpSessionSessionStrategy;
import org.springframework.social.connect.web.SessionStrategy;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.ServletRequestUtils;
import org.springframework.web.context.request.ServletWebRequest;
import org.springframework.web.filter.OncePerRequestFilter;

/**
 * @Description: 在user password之前加一个图验证码的校验,在securityconfig里addFilter
 * 实现InitializingBean是为了在其他参数组装完毕后,组装urlAndMethods
 * @author tangmin
 * @date 2017-09-29 15:47:05
 */
public class ValidateCodeFilter extends OncePerRequestFilter implements InitializingBean {

  private SessionStrategy sessionStrategy = new HttpSessionSessionStrategy();

  private AuthenticationFailureHandler authenticationFailureHandler;

  private SecurityProperties securityProperties;

  private Set<String> urlAndMethods = new HashSet<>();
  private List<UrlAndMethod> urlAndMethodList = Lists.newArrayList();

  //匹配url工具类
  private AntPathMatcher pathMatcher = new AntPathMatcher();

  /**
   * 在properties参数初始化完毕后,组装urlMethods
   */
  @Override
  public void afterPropertiesSet() throws ServletException {
    super.afterPropertiesSet();
    try {
      String[] configUrls = StringUtils.splitByWholeSeparatorPreserveAllTokens(
          securityProperties.getCode().getImage().getUrlAndMethods(), ",");
      for (String configUrl : configUrls) {
        urlAndMethods.add(configUrl);
      }
      for (String urlAndMethod : urlAndMethods) {
        if (urlAndMethod.contains(":")) {
          String[] split = urlAndMethod.split(":");
          urlAndMethodList.add(new UrlAndMethod(split[0], split[1]));
        } else {
          urlAndMethodList.add(new UrlAndMethod(urlAndMethod));
        }
      }

      urlAndMethodList.add(new UrlAndMethod("/authentication/form", "post"));
    } catch (Exception e) {
      throw new ValidateCodeException(
          "====>ValidateCodeFilter afterPropertiesSet() throw exception:" + e.getMessage());
    }
  }

  /**
   * 验证码过滤器
   */
  @Override
  protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
      FilterChain filterChain) throws ServletException, IOException {

    if (isAction(request)) {
      try {
        validate(new ServletWebRequest(request));
      } catch (ValidateCodeException e) {
        authenticationFailureHandler.onAuthenticationFailure(request, response, e);
        return;
      }
    }
    filterChain.doFilter(request, response);
  }

  /**
   * 判断是否需要过滤请求
   */
  private boolean isAction(HttpServletRequest request) {
    boolean action = false;
    for (UrlAndMethod urlAndMethod : urlAndMethodList) {
      String requestURI = request.getRequestURI();
      if(requestURI.endsWith("/")){
        requestURI = requestURI.substring(0,requestURI.length()-1);
      }

      if (StringUtils.isBlank(urlAndMethod.getMethod())) {
        if (pathMatcher.match(urlAndMethod.getUrl(), requestURI)) {
          action = true;
          break;
        }
      } else {
        if (pathMatcher.match(urlAndMethod.getUrl(), requestURI)
            && StringUtils.equalsIgnoreCase(urlAndMethod.getMethod(), request.getMethod())) {
          action = true;
          break;
        }
      }

    }
    return action;
  }

  private void validate(ServletWebRequest request) throws ServletRequestBindingException {
    ImageCode codeInSession = (ImageCode) sessionStrategy
        .getAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX);

    String codeInRequest = ServletRequestUtils
        .getStringParameter(request.getRequest(), "imageCode");

    if (StringUtils.isBlank(codeInRequest)) {
      throw new ValidateCodeException("验证码的值不能为空");
    }

    if (codeInSession == null) {
      throw new ValidateCodeException("验证码不存在");
    }

    if (codeInSession.isExpried()) {
      sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX);
      throw new ValidateCodeException("验证码已过期");
    }

    if (!StringUtils.equals(codeInSession.getCode(), codeInRequest)) {
      throw new ValidateCodeException("验证码不匹配");
    }

    sessionStrategy.removeAttribute(request, ValidateCodeProcessor.SESSION_KEY_PREFIX);
  }


  public SecurityProperties getSecurityProperties() {
    return securityProperties;
  }

  public void setSecurityProperties(
      SecurityProperties securityProperties) {
    this.securityProperties = securityProperties;
  }

  public AuthenticationFailureHandler getAuthenticationFailureHandler() {
    return authenticationFailureHandler;
  }

  public void setAuthenticationFailureHandler(
      AuthenticationFailureHandler authenticationFailureHandler) {
    this.authenticationFailureHandler = authenticationFailureHandler;
  }

}
