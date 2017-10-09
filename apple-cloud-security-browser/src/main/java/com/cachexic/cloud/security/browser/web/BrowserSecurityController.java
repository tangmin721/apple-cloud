package com.cachexic.cloud.security.browser.web;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import java.io.IOException;
import java.util.Collection;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangmin
 * @Description: 自定义的登录请求, 用浏览器登录的与app登录的分别处理
 * @date 2017-09-28 17:07:27
 */
@RestController
public class BrowserSecurityController {

  private static final Logger log = LoggerFactory.getLogger(BrowserSecurityController.class);

  private RequestCache requestCache = new HttpSessionRequestCache();

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * 网页请求的拦截
   */
  @RequestMapping(value = SecurityConstants.DEFAULT_UNAUTHENTICATION_URL, produces = "text/html")
  //@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public Result requireAuthenticationHtml(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    SavedRequest savedRequest = requestCache.getRequest(request, response);


    if (savedRequest != null) {
      String targetUrl = savedRequest.getRedirectUrl();
      log.debug("引发跳转的请求是:" + targetUrl);
      Collection<String> names = savedRequest.getHeaderNames();
      for (String name : names) {
        log.debug(name + ":" + savedRequest.getHeaderValues(name));
      }

      if (StringUtils.endsWithIgnoreCase(targetUrl, ".html")) {
        redirectStrategy.sendRedirect(request, response, securityProperties.getBrowser().getSignInPage());
      }
    }

    return Result.UNAUTHORIZED();
  }

}
