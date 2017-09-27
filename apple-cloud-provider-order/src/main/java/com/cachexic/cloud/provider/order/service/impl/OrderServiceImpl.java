package com.cachexic.cloud.provider.order.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.common.utils.date.DateUtil;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.provider.order.service.OrderService;
import java.util.Date;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 22:31:40
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderQuery> implements OrderService{

    /**
     * 定时任务开启：
     * 1、springBoot启动类增加注解@EnableScheduling
     * 2、@Scheduled(fixedRate = 60000)在无参数的方法上 60s
     */
    @Scheduled(fixedRate = 60000)
    public void reportCurrenTime(){
        System.out.println(DateUtil.formatDateTime(new Date()));
        System.out.println("====>order service pagination:"+ JsonUtil.toJson(this.selectList(new OrderQuery())));
    }

}