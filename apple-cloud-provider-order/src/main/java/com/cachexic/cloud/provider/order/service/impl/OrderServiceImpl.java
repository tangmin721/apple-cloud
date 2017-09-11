package com.cachexic.cloud.provider.order.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.provider.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 22:31:40
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order, OrderQuery> implements OrderService{

}