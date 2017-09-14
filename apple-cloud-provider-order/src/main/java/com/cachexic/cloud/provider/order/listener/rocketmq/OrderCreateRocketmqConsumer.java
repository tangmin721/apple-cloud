package com.cachexic.cloud.provider.order.listener.rocketmq;

import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.provider.order.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by tangm on 2017/9/14.
 */
@Component
public class OrderCreateRocketmqConsumer implements Runnable{

    @Autowired
    private OrderService orderService;

    @Override
    public void run() {
        for(long i=0;i<100;i++){
            OrderQuery query = new OrderQuery();
            query.setUserId(i);
            List<Order> orders = orderService.selectList(query);
            System.out.println("order create consumer:"+JsonUtil.toJson(orders));

            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
