package com.cachexic.cloud.security.browser.web;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import com.cachexic.cloud.security.core.social.SocialController;
import com.cachexic.cloud.security.core.social.support.SocialUserInfo;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description: 自定义的登录请求, 用浏览器登录的与app登录的分别处理
 * @date 2017-09-28 17:07:27
 */
@RestController
public class BrowserSecurityController extends SocialController {

  private static final Logger log = LoggerFactory.getLogger(BrowserSecurityController.class);

  private RequestCache requestCache = new HttpSessionRequestCache();

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Autowired
  private SecurityProperties securityProperties;

  @Autowired
  private ProviderSignInUtils providerSignInUtils;

  /**
   * 网页请求的拦截,当需要身份认证时，跳转到这里
   */
  @RequestMapping(SecurityConstants.DEFAULT_UNAUTHENTICATION_URL)
  //@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public Result requireAuthenticationHtml(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    SavedRequest savedRequest = requestCache.getRequest(request, response);

    if (savedRequest != null) {
      String targetUrl = savedRequest.getRedirectUrl();
      log.debug("引发跳转的请求是:" + targetUrl);
    /*  Collection<String> names = savedRequest.getHeaderNames();
      for (String name : names) {
        log.debug(name + ":" + savedRequest.getHeaderValues(name));
      }*/

      if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
        redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getSignInPage());
      }
    }

    return Result.UNAUTHORIZED("访问的服务需要身份认证，请引导用户到登录页");
  }

  /**
   * 用户第一次社交登录时，会引导用户进行用户注册或绑定，此服务用于在注册或绑定页面获取社交网站用户信息
   *
   * @param request
   * @return
   */
  @GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
  public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
    Connection<?> connection = providerSignInUtils.getConnectionFromSession(new ServletWebRequest(request));
    return buildSocialUserInfo(connection);
  }
}
