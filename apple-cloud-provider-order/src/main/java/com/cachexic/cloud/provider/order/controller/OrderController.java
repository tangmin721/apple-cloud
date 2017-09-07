package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import com.cachexic.cloud.provider.order.dao.OrderDao;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: OrderController.java
 * @Package com.cachexic.cloud.provider.order.controller
 * @Description: 
 * @date 2017-09-06 18:13:33
 */
@RestController
@RequestMapping("/order")
public class OrderController implements OrderFeign{
    private final static Logger log = LoggerFactory.getLogger(OrderController.class);

    @Autowired
    private OrderDao orderDao;

    @Override
    public Result<List<Order>> selectList(@RequestBody OrderQuery orderQuery) {
        log.debug("selectList:",JsonUtil.toJson(orderQuery));
        List<Order> orders = orderDao.selectList();
        return Result.OK().setData(orders);
    }

    @Override
    public Result<Order> getById(@PathVariable Long id) {
        log.debug("getById:{}",id);
        return Result.OK().setData(orderDao.selectById(id));
    }
}
