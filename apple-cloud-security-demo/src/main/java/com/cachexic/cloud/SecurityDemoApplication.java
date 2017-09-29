package com.cachexic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by tangm on 2017/9/24.
 */
@SpringBootApplication
@RestController
public class SecurityDemoApplication {

  public static void main(String[] args) {
    SpringApplication.run(SecurityDemoApplication.class, args);
  }

  @GetMapping("/hello")
  public String hello() {
    return "hello spring security";
  }

}
