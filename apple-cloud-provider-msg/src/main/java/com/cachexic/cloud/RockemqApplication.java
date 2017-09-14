package com.cachexic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author tangmin
 * @Description: rocketmq消息队列服务提供方，只对外提供服务，所以，不需要@EnableFeignClients和@EnableCircuitBreaker
 * @date 2017-09-06 22:20:18
 */
@SpringBootApplication
@EnableFeignClients
@EnableEurekaClient
@EnableCircuitBreaker
public class RockemqApplication {
    public static void main(String[] args) {
        SpringApplication.run(RockemqApplication.class, args);
    }
}
