package com.cachexic.cloud.provider.order.listener;

import org.springframework.context.ApplicationContext;

/**
 * @author tangmin
 * @Description: spring上下文
 * @date 2017-09-14 14:59:15
 */
public class SpringContext {

	private static ApplicationContext applicationContext;

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	public static void setApplicationContext(ApplicationContext applicationContext) {
		SpringContext.applicationContext = applicationContext;
	}
	
}
