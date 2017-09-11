package com.cachexic.cloud.provider.order.service;

import com.cachexic.cloud.common.base.service.BaseService;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;

/**
 * @author tangmin
 * @Description:
 * @date 2017-09-11 14:12:44
 */
public interface OrderService extends BaseService<Order,OrderQuery> {
    //void testRedis();
}
