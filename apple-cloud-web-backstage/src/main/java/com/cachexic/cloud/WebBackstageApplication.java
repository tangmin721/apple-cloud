package com.cachexic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author tangmin
 * @version V1.0
 * @Title: WebBackstageApplication.java
 * @Package com.cachexic.cloud
 * @Description:
 * @date 2017-09-06 22:29:56
 */
@SpringBootApplication
@EnableFeignClients
//@EnableEurekaClient
@EnableDiscoveryClient
@EnableCircuitBreaker
public class WebBackstageApplication {

  public static void main(String[] args) {
    SpringApplication.run(WebBackstageApplication.class, args);
  }
}
