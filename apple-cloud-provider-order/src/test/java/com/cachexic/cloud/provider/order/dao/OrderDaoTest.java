package com.cachexic.cloud.provider.order.dao;

import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * Created by tangm on 2017/9/6.
 */
public class OrderDaoTest extends TestParent {

    @Autowired
    private OrderDao orderDao;

    @Test
    public void selectList() throws Exception {
        List<Order> orders = orderDao.selectList();
        System.out.println(JsonUtil.toJson(orders));
    }

}