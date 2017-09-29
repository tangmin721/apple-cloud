package com.cachexic.cloud.security.browser.authentication;

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
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 自定义实现登录验证成功返回结果,再配置SecurityConfig
 * @date 2017-09-29 10:56:00
 */
@Component("browserAuthenticationSuccessHandler")
public class BrowserAuthenticationSuccessHandler extends SavedRequestAwareAuthenticationSuccessHandler {

    private static final Logger log = LoggerFactory.getLogger(BrowserAuthenticationSuccessHandler.class);

    @Autowired
    private SecurityProperties securityProperties;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
        Authentication authentication) throws IOException, ServletException {

        log.info("====>登录成功");

        if (LoginType.JSON.equals(securityProperties.getBrowser().getLoginType())) {
            response.setContentType("application/json;charset=UTF-8");
            response.getWriter().write(JsonUtil.toJson(authentication));
        } else {
            super.onAuthenticationSuccess(request, response, authentication);
        }

    }
}
