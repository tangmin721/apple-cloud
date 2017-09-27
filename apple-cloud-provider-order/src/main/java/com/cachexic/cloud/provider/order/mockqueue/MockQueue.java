package com.cachexic.cloud.provider.order.mockqueue;

import com.cachexic.cloud.provider.order.controller.AsyncTeacherController;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

/**
 * @author tangmin
 * @Description: 模拟一个消息队列
 * @date 2017-09-27 17:00:59
 */
@Component
public class MockQueue {

    private static final Logger log = LoggerFactory.getLogger(AsyncTeacherController.class);

    /** 接到下单请求 */
    private String placeOrder;

    /** 下单请求(只是请求,实际下单生成订单过程是通过监听消息队列异步处理)处理完毕 */
    private String completeOrder;

    public String getPlaceOrder() {
        return placeOrder;
    }

    /**
     * 模拟下单请求
     * @param placeOrder
     */
    public void setPlaceOrder(String placeOrder) {
        new Thread(() -> {
            log.info("接到下单请求, " + placeOrder);
            try {
                Thread.sleep(1000);
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.completeOrder = placeOrder;
            log.info("下单请求处理完毕," + placeOrder);
        }).start();
        this.placeOrder = placeOrder;
    }

    public String getCompleteOrder() {
        return completeOrder;
    }

    public void setCompleteOrder(String completeOrder) {
        this.completeOrder = completeOrder;
    }
}
