package com.cachexic.cloud.provider.order.dao;

import com.cachexic.cloud.common.enums.YesOrNoEnum;
import java.util.Date;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.time.DateFormatUtils;

/**
 * Created by tangm on 2017/10/10.
 */
public class TestMain {

  public static void main(String[] args) {
    System.out.println(DateFormatUtils.format(1507599060000L,"yyyy-MM-dd HH:mm:ss"));
    System.out.println(RandomStringUtils.randomAlphabetic(6,10));
    System.out.println(long.class.getSimpleName());
    System.out.println(Long.class.getSimpleName());
    System.out.println(Date.class.getSimpleName());
    System.out.println(Boolean.class.getSimpleName());
    System.out.println(boolean.class.getSimpleName());
    System.out.println(Integer.class.getSimpleName());
    System.out.println(YesOrNoEnum.class.getSimpleName());
  }

}
