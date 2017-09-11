package com.cachexic.cloud.provider.order.dao;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.id.UUIDUtil;
import com.cachexic.cloud.config.redis.RedisService;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.provider.order.service.OrderService;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.test.context.ActiveProfiles;

/**
 * Created by tangm on 2017/9/6.
 */
@ActiveProfiles("dev")
public class OrderDaoTest extends TestParent {

    @Value("${eureka.instance.client.serviceUrl.defaultZone}")
    private String defaultZone;

    @Autowired
    private OrderDao orderDao;

    @Autowired
    private OrderService orderService;

    @Autowired
    private RedisService redisService;

    //测试validator
    private static Validator validator;

    @Before
    public void setUpValidator() {
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        validator = factory.getValidator();
    }

    @Test
    public void insert() throws Exception {

        for (long i = 1; i < 11; i++) {
            Order order = new Order();
            order.setUserId(i);
            order.setOrderSn(UUIDUtil.get32UUID());
            order.setCreateUserId(i);
            orderDao.insert(order);
        }
    }


    @Test
    public void defaultZone() throws Exception {
        System.out.println(defaultZone);
    }

    @Test
    public void redisService() throws Exception {
        //System.out.println(redisService.keys("*"));
        //orderService.testRedis();
    }

}