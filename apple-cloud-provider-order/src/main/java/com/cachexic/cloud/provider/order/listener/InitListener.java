package com.cachexic.cloud.provider.order.listener;

import com.cachexic.cloud.provider.order.listener.rocketmq.OrderCreateRocketmqConsumer;
import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

/**
 * @author tangmin
 * @Description: 系统web容器初始化的监听器,获取spring容器上下文
 * @date 2017-06-19 19:32:42
 */
public class InitListener implements ServletContextListener{
    private Logger logger = Logger.getLogger(this.getClass());

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        logger.info("======================contextInitialized===========================");
        ServletContext sc = sce.getServletContext();
        ApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(sc);
        SpringContext.setApplicationContext(context);

        new Thread(new OrderCreateRocketmqConsumer()).start();
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        logger.info("======================contextDestroyed===========================");
    }
}
