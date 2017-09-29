package com.cachexic.cloud.provider.order.mockqueue;

import com.google.common.collect.Maps;
import java.util.Map;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.async.DeferredResult;

/**
 * @author tangmin
 * @Description: 下单返回结果的
 * @date 2017-09-27 17:08:39
 */
@Component
public class DeferredResultHolder<T> {

  /**
   * 异步结果返回给前端,key为唯一主键(例如预创建的订单号,value即为返回给前端的信息)
   */
  private Map<String, DeferredResult<T>> map = Maps.newHashMap();

  public Map<String, DeferredResult<T>> getMap() {
    return map;
  }

  public void setMap(Map<String, DeferredResult<T>> map) {
    this.map = map;
  }
}
