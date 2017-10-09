package com.cachexic.cloud.security.browser.session;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.util.UrlUtils;
import org.springframework.util.Assert;

/**
 * @author tangmin
 * @Description: 抽象的session失效处理器
 * @date 2017-10-09 15:49:32
 */
public class AbstractSessionStrategy {

  private final static Logger log = LoggerFactory.getLogger(AbstractSessionStrategy.class);
  /**
   * 跳转的url
   */
  private String destinationUrl;
  /**
   * 系统配置信息
   */
  private SecurityProperties securityProperties;
  /**
   * 重定向策略
   */
  private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
  /**
   * 跳转前是否创建新的session
   */
  private boolean createNewSession = true;

  public AbstractSessionStrategy(SecurityProperties securityProperties) {
    String invalidSessionUrl = securityProperties.getBrowser().getSession().getSessionInvalidUrl();
    Assert.isTrue(UrlUtils.isValidRedirectUrl(invalidSessionUrl),
        "url must start with '/' or with 'http(s)'");
    Assert.isTrue(StringUtils.endsWithIgnoreCase(invalidSessionUrl, ".html"),
        "url must end with '.html'");
    this.destinationUrl = invalidSessionUrl;
    this.securityProperties = securityProperties;
  }

  protected void onSessionInvalid(HttpServletRequest request, HttpServletResponse response)
      throws IOException {

    log.info("session失效");

    if (createNewSession) {
      request.getSession();
    }

    String sourceUrl = request.getRequestURI();
    String targetUrl;

    if (StringUtils.endsWithIgnoreCase(sourceUrl, ".html")) {
      if (StringUtils.equals(sourceUrl, securityProperties.getBrowser().getSignInPage())
          || StringUtils.equals(sourceUrl, securityProperties.getBrowser().getSignOutUrl())) {
        targetUrl = sourceUrl;
      } else {
        targetUrl = destinationUrl;
      }
      log.info("跳转到:" + targetUrl);
      redirectStrategy.sendRedirect(request, response, targetUrl);
    } else {
      Result result = buildResponseContent(request);
      //response.setStatus(HttpStatus.UNAUTHORIZED.value());
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(JsonUtil.toJson(result));
    }

  }

  /**
   * @param request
   * @return
   */
  protected Result buildResponseContent(HttpServletRequest request) {
    String message = "session已失效";
    if (isConcurrency()) {
      message = message + "，有可能是并发登录导致的";
    }
    return Result.UNAUTHORIZED(message);
  }

  /**
   * session失效是否是并发导致的
   */
  protected boolean isConcurrency() {
    return false;
  }

  public void setCreateNewSession(boolean createNewSession) {
    this.createNewSession = createNewSession;
  }

}
