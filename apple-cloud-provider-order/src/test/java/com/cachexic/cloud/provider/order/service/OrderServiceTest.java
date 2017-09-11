package com.cachexic.cloud.provider.order.service;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.feign.order.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangm on 2017/9/11.
 */
public class OrderServiceTest extends TestParent {

    @Autowired
    private OrderService orderService;

    @Test
    public void insert(){
        Order order = new Order();
        order.setUserId(1l);
        orderService.insert(order);
    }

}