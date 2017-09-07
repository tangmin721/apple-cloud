package com.cachexic.cloud.config.redis;

import org.springframework.boot.actuate.health.Health;
import org.springframework.boot.actuate.health.HealthIndicator;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @version V1.0
 * @Title: DbHealthIndicator.java
 * @Package com.cachexic.cloud.provider.config
 * @Description: 让eureka不进行redis的状态检查
 * @date 2017-09-07 14:58:57
 */
@Component
public class RedisHealthIndicator implements HealthIndicator{
    @Override
    public Health health() {
        return Health.up().build();
    }
}



