package com.cachexic.cloud.security.app;

import com.cachexic.cloud.security.app.authentication.social.AppSingUpUtils;
import com.cachexic.cloud.security.core.config.contants.SecurityConstants;
import com.cachexic.cloud.security.core.social.SocialController;
import com.cachexic.cloud.security.core.social.support.SocialUserInfo;
import javax.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.social.connect.Connection;
import org.springframework.social.connect.web.ProviderSignInUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.ServletWebRequest;

/**
 * @author tangmin
 * @Description:
 * @date 2017-10-17 10:38:38
 */
@RestController
public class AppSecurityController extends SocialController {

  @Autowired
  private ProviderSignInUtils providerSignInUtils;

  @Autowired
  private AppSingUpUtils appSingUpUtils;

  /**
   * 需要注册时跳到这里，返回401和用户信息给前端
   */
  @GetMapping(SecurityConstants.DEFAULT_SOCIAL_USER_INFO_URL)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  public SocialUserInfo getSocialUserInfo(HttpServletRequest request) {
    Connection<?> connection = providerSignInUtils
        .getConnectionFromSession(new ServletWebRequest(request));
    appSingUpUtils.saveConnectionData(new ServletWebRequest(request), connection.createData());
    return buildSocialUserInfo(connection);
  }

}
