package com.cachexic.cloud.security.browser.authentication;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.security.core.enums.LoginType;
import com.cachexic.cloud.security.core.properties.SecurityProperties;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 自定义实现登录验证失败返回结果, 再配置SecurityConfig
 * @date 2017-09-29 10:25:11
 */
@Component("browserAuthenticationFailureHandler")
public class BrowserAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  private static final Logger log = LoggerFactory
      .getLogger(BrowserAuthenticationFailureHandler.class);

  @Autowired
  private SecurityProperties securityProperties;

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    log.info("====>登录失败");
    if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
      //response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
      response.setContentType("application/json;charset=UTF-8");
      response.getWriter().write(JsonUtil.toJson(Result.FAIL(exception.getMessage())));
    } else {
      super.onAuthenticationFailure(request, response, exception);
    }

  }
}
