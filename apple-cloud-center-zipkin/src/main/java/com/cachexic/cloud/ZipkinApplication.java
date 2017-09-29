package com.cachexic.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import zipkin.server.EnableZipkinServer;

/**
 * @author tangmin
 * @Description: zipkin追踪服务
 * @date 2017-04-12 23:22:05
 */
@SpringBootApplication
@EnableZipkinServer
public class ZipkinApplication {

  public static void main(String[] args) {
    SpringApplication.run(ZipkinApplication.class, args);
  }
}
