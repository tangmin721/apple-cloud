/**
 *
 */
package com.cachexic.cloud.common.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.task.AsyncTaskExecutor;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;
import org.springframework.web.servlet.config.annotation.AsyncSupportConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @author tangmin
 * @Description: 配置异步接口线程池支持,如果不配置,spring 默认会一直使用一个新的线程.
 * @date 2017-09-27 14:30:21
 */
@Configuration
public class WebMvcAsyncExecutorConfig extends WebMvcConfigurerAdapter {

    @Override
    public void configureAsyncSupport(AsyncSupportConfigurer configurer) {
        configurer.setTaskExecutor(mvcAsyncExecutor());
    }

    @Bean
    public AsyncTaskExecutor mvcAsyncExecutor() {
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        executor.setCorePoolSize(20);//线程池维护线程的最小数量.
        executor.setMaxPoolSize(300);//最大线程数
        executor.setKeepAliveSeconds(3000);//某线程空闲超过这个时间，就回收该线程3s
        executor.setQueueCapacity(600);//队列最大长度>=mainExecutor.maxSize
        return executor;
    }

}
