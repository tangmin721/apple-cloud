package com.cachexic.cloud.security.browser.web;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import java.io.IOException;
import java.util.Collection;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author tangmin
 * @Description: 自定义的登录请求, 用浏览器登录的与app登录的分别处理
 * @date 2017-09-28 17:07:27
 */
@Controller
public class BrowserSecurityController {

  private static final Logger log = LoggerFactory.getLogger(BrowserSecurityController.class);

  private RequestCache requestCache = new HttpSessionRequestCache();

  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

  @Autowired
  private SecurityProperties securityProperties;

  /**
   * 网页请求的拦截
   */
  @RequestMapping(value = "/authentication/require", produces = "text/html")
  //@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public void requireAuthenticationHtml(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    SavedRequest savedRequest = requestCache.getRequest(request, response);

    if (savedRequest != null) {
      String targetUrl = savedRequest.getRedirectUrl();
      log.info("原始url请求是:" + targetUrl);

      Collection<String> names = savedRequest.getHeaderNames();
      for (String name : names) {
        System.out.println(name + ":" + savedRequest.getHeaderValues(name));
      }

      //重定向到网页
      redirectStrategy
          .sendRedirect(request, response, securityProperties.getBrowser().getLoginPage());

    }
  }

  /**
   * application/json 请求权限拦截
   */
  @RequestMapping("/authentication/require")
  @ResponseBody
  //@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
  public Result requireAuthenticationApp(HttpServletRequest request,
      HttpServletResponse response) throws IOException {

    SavedRequest savedRequest = requestCache.getRequest(request, response);
    if (savedRequest != null) {
      String targetUrl = savedRequest.getRedirectUrl();
      log.info("原始url请求是:" + targetUrl);
      Collection<String> names = savedRequest.getHeaderNames();
      for (String name : names) {
        System.out.println(name + ":" + savedRequest.getHeaderValues(name));
      }
    }

    return Result.UNAUTHORIZED();
  }
}
