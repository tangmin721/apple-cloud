package com.cachexic.cloud.provider.order.dao;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Created by tangm on 2017/10/10.
 */
public class TestMain {

  public static void main(String[] args) {
    System.out.println(DateFormatUtils.format(1507599060000L,"yyyy-MM-dd HH:mm:ss"));
    System.out.println(RandomStringUtils.randomAlphabetic(6,10));
  }

}
