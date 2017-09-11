package com.cachexic.cloud.provider.order.service;

import com.cachexic.cloud.common.base.service.BaseService;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 22:31:40
 */
public interface OrderService extends BaseService<Order, OrderQuery>{

}
