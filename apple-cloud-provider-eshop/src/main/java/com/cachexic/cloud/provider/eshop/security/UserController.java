package com.cachexic.cloud.provider.eshop.security;

import com.cachexic.cloud.security.app.authentication.social.AppSignUpUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @Description: app端第三方登录自动注册
 * @author tangmin
 * @date 2017-10-17 13:45:13
 */
@RequestMapping("/user")
public class UserController {

  @Autowired
  private AppSignUpUtils appSignUpUtils;
  /**
   * 注册用户
   * @param request
   */
  @PostMapping("/regist")
  public void regist(@RequestParam("username") String username, HttpServletRequest request) {

    //不管是注册用户还是绑定用户，都会拿到一个用户唯一标识。
    String userId = username;
    appSignUpUtils.doPostSignUp(new ServletWebRequest(request), userId);
  }
}
