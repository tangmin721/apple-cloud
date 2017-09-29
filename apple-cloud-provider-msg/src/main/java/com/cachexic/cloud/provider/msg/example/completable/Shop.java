package com.cachexic.cloud.provider.msg.example.completable;

import java.util.Random;

public class Shop {

  private final String name;
  private final Random random;

  public Shop(String name) {
    this.name = name;
    random = new Random(name.charAt(0) * name.charAt(1) * name.charAt(2));
  }

  public String getPrice(String product) {
    double price = calculatePrice(product);
    Discount.Code code = Discount.Code.values()[random.nextInt(Discount.Code.values().length)];

    if (code.equals(Discount.Code.NONE)) {
      try {
        Thread.sleep(3000L);//故意超时
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      //throw new RuntimeException("故意抛异常");
    }

    return name + ":" + price + ":" + code;
  }

  public double calculatePrice(String product) {
    Util.delay();
    return Util.format(random.nextDouble() * product.charAt(0) + product.charAt(1));
  }

  public String getName() {
    return name;
  }
}
