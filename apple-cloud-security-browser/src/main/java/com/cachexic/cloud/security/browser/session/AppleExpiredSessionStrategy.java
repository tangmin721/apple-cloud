package com.cachexic.cloud.security.browser.session;

import com.cachexic.cloud.security.core.config.properties.SecurityProperties;
import java.io.IOException;
import javax.servlet.ServletException;
import org.springframework.security.web.session.SessionInformationExpiredEvent;
import org.springframework.security.web.session.SessionInformationExpiredStrategy;

/**
 * @Description: 并发登录导致session失效时，默认的处理策略
 * @author tangmin
 * @date 2017-10-16 18:53:09
 */
public class AppleExpiredSessionStrategy extends AbstractSessionStrategy implements SessionInformationExpiredStrategy {

	public AppleExpiredSessionStrategy(SecurityProperties securityPropertie) {
		super(securityPropertie);
	}

	@Override
	public void onExpiredSessionDetected(SessionInformationExpiredEvent event) throws IOException, ServletException {
		onSessionInvalid(event.getRequest(), event.getResponse());
	}

	@Override
	protected boolean isConcurrency() {
		return true;
	}

}
