package com.cachexic.cloud.security.browser;

import com.cachexic.cloud.common.base.Result;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.savedrequest.HttpSessionRequestCache;
import org.springframework.security.web.savedrequest.RequestCache;
import org.springframework.security.web.savedrequest.SavedRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author tangmin
 * @Description: 自定义的登录请求
 * @date 2017-09-28 17:07:27
 */
@RestController
public class BrowserSecurityController {
    private static final Logger log = LoggerFactory.getLogger(BrowserSecurityController.class);

    private RequestCache requestCache = new HttpSessionRequestCache();

    private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();

    @RequestMapping("/authorized/require")
    //@ResponseStatus(code = HttpStatus.UNAUTHORIZED)
    public Result authorized(HttpServletRequest request,HttpServletResponse response) throws IOException {

        SavedRequest savedRequest = requestCache.getRequest(request, response);

        if(savedRequest!=null){
            String targetUrl = savedRequest.getRedirectUrl();
            log.info("引发跳转的请求是:"+targetUrl);
            if (StringUtils.endsWithIgnoreCase(targetUrl,".html")){
                redirectStrategy.sendRedirect(request, response, "mubiao");
            }
        }

        return Result.UNAUTHORIZED();
    }
}
