package com.cachexic.cloud.order.dao;


import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import com.cachexic.cloud.order.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;


@MybatisDao
public interface OrderDao {
    Long insert(Order order);
    Order selectById(@Param("id") Long id);

    List<Order> selectList();
    List<Order> selectTestOrderById();
    List<Order> selectTestOrderByIdLimit(@Param("rowStart") Long rowStart, @Param("pageSize") int pageSize);

}
