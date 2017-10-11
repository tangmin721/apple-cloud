package com.cachexic.cloud.provider.msg.example.completable;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.google.common.collect.Lists;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Created by tangm on 2017/10/11.
 */
public class ExecutorProcess {

  private final static Logger log = LoggerFactory.getLogger(ExecutorProcess.class);


  private static final Executor executor = Executors.newFixedThreadPool(10, r -> {
    Thread t = new Thread(r);
    t.setDaemon(true);
    return t;
  });

  public static void main(String[] args) {
    List<String> orderIds = Lists.newArrayList();
    for (int i = 0; i < 100; i++) {
      orderIds.add(String.valueOf(i));
    }

    log.debug(JsonUtil.toJson(orderIds));

    long startTime = System.nanoTime();

   /* orderIds.parallelStream().forEach( orderId -> {
      try {
        Thread.sleep(1000);
      } catch (InterruptedException e) {
        e.printStackTrace();
      }
      System.out.println(orderId);
    });*/

    /*for (String orderId : orderIds) {
      CompletableFuture.runAsync(()->{
        try {
          Thread.sleep(1000);
        } catch (InterruptedException e) {
          e.printStackTrace();
        }
        log.debug("orderId:"+orderId);
      },executor);
    }*/

    orderIds.stream().forEach(orderId -> CompletableFuture
        .runAsync(() -> {
              try {
                //模拟网络延时
                Thread.sleep(1000);
              } catch (InterruptedException e) {
                e.printStackTrace();
              }
              //@TODO httpclient.post....
              log.debug("orderId:"+orderId);
            }
            , executor));

    log.debug("主线程:" + (System.nanoTime() - startTime) / (1000 * 1000) + "ms");
    try {
      Thread.sleep(15000);
      System.out.println("阻止main关闭");
    } catch (InterruptedException e) {
      e.printStackTrace();
    }


  }

}
