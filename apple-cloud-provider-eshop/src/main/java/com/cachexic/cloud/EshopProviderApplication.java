package com.cachexic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

/**
 * @author tangmin
 * @Description:
 * @date 2017-09-06 22:20:18
 */
@SpringBootApplication
@EnableFeignClients
@EnableDiscoveryClient
@EnableCircuitBreaker
public class EshopProviderApplication {

  public static void main(String[] args) {
    SpringApplication.run(EshopProviderApplication.class, args);
  }
}
