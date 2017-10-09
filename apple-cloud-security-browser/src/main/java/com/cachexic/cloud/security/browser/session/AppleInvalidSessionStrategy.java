package com.cachexic.cloud.security.browser.session;

import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.security.web.session.InvalidSessionStrategy;

/**
 * @Description: 默认的session失效处理策略
 * @author tangmin
 * @date 2017-10-09 15:53:35
 */
public class AppleInvalidSessionStrategy extends AbstractSessionStrategy implements InvalidSessionStrategy {

	public AppleInvalidSessionStrategy(SecurityProperties securityProperties) {
		super(securityProperties);
	}

	@Override
	public void onInvalidSessionDetected(HttpServletRequest request, HttpServletResponse response)
			throws IOException, ServletException {
		onSessionInvalid(request, response);
	}

}
