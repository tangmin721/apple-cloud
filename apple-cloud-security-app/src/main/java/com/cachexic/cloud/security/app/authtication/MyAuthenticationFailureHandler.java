package com.cachexic.cloud.security.app.authtication;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 自定义实现登录验证失败返回结果, 再配置SecurityConfig
 * @date 2017-09-29 10:25:11
 */
@Component("myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {

  private static final Logger log = LoggerFactory
      .getLogger(MyAuthenticationFailureHandler.class);

  @Override
  public void onAuthenticationFailure(HttpServletRequest request, HttpServletResponse response,
      AuthenticationException exception) throws IOException, ServletException {
    log.info("====>登录失败");
    //response.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
    response.setContentType("application/json;charset=UTF-8");
    response.getWriter().write(JsonUtil.toJson(Result.FAIL(exception.getMessage())));
  }

}
