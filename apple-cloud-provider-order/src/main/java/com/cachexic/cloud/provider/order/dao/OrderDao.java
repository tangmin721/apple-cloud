package com.cachexic.cloud.provider.order.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;


@MybatisDao
public interface OrderDao extends BaseDao<Order,OrderQuery>{


}
