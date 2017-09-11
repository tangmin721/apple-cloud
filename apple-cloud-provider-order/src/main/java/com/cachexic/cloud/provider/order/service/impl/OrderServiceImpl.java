package com.cachexic.cloud.provider.order.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.provider.order.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * Created by tangm on 2017/9/11.
 */
@Service
public class OrderServiceImpl extends BaseServiceImpl<Order,OrderQuery> implements OrderService{



}
