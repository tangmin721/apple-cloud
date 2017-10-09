package com.cachexic.cloud.security.browser.logout;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.logout.LogoutSuccessHandler;

/**
 * @author tangmin
 * @Description: 默认的退出成功处理器，如果设置了apple.security.browser.signOutUrl，则跳到配置的地址上， 如果没配置，则返回json格式的响应。
 * @date 2017-10-09 19:27:11
 */
public class AppleLogoutSuccessHandler implements LogoutSuccessHandler {

  private final static Logger log = LoggerFactory.getLogger(AppleLogoutSuccessHandler.class);

  public AppleLogoutSuccessHandler(String signOutSuccessUrl) {
    this.signOutSuccessUrl = signOutSuccessUrl;
  }

  private String signOutSuccessUrl;

  @Override
  public void onLogoutSuccess(HttpServletRequest request, HttpServletResponse response,
      Authentication authentication)
      throws IOException, ServletException {

    log.info("退出成功");

    if (StringUtils.isBlank(signOutSuccessUrl)) {
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(JsonUtil.toJson(Result.OK("退出成功")));
    } else {
      response.sendRedirect(signOutSuccessUrl);
    }

  }

}
