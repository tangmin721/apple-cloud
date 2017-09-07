package com.cachexic.cloud.provider.order.dao;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.config.redis.RedisService;
import com.cachexic.cloud.feign.order.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;

import java.util.List;

/**
 * Created by tangm on 2017/9/6.
 */
@ActiveProfiles("prod")
public class OrderDaoTest extends TestParent {

    @Value("${eureka.instance.client.serviceUrl.defaultZone}")
    private String defaultZone;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private RedisService redisService;

    @Test
    public void selectList() throws Exception {
        List<Order> orders = orderDao.selectList();
        System.out.println(JsonUtil.toJson(orders));
    }

    @Test
    public void defaultZone() throws Exception {
        System.out.println(defaultZone);
    }

    @Test
    public void redisService() throws Exception {
        System.out.println(redisService.keys("*"));
    }

}