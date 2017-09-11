package com.cachexic.cloud.provider.order.service;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.junit.TestParent;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import org.junit.Assert;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * Created by tangm on 2017/9/11.
 */
public class OrderServiceTest extends TestParent {

    @Autowired
    private OrderService orderService;

    @Test
    public void insert(){
        for(long i=1;i<10;i++){
            Order order = new Order();
            order.setUserId(i);
            orderService.insert(order);
        }
    }

    @Test
    public void select(){
        System.out.println(JsonUtil.toJson(orderService.selectById(114136970911170560L)));
    }

    @Test
    public void update(){
        Order order = this.orderService.selectById(114136970911170560L);
        order.setUserId(3l);
        int update = orderService.update(order);
        Assert.assertTrue(update>0);
    }

    @Test
    public void selectList(){
        OrderQuery query = new OrderQuery();
        System.out.println(JsonUtil.toJson(this.orderService.selectList(query)));
    }

    @Test
    public void selectPagination(){
        OrderQuery query = new OrderQuery();
        query.setUserId(10L);
        System.out.println(JsonUtil.toJson(this.orderService.selectListPagination(query)));


    }

    @Test
    public void test(){
        String s = "{\"total\":0,\"pageCount\":0,\"pageSize\":10,\"currentPage\":1}";
        Pagination pagination = JsonUtil.toEntity(s, Pagination.class);
        System.out.println(pagination.getList().size());

        String p = "{\"list\":[{\"id\":114136970911170560,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":1,\"totalActualPrice\":0.00},{\"id\":114136972018466816,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":2,\"totalActualPrice\":0.00},{\"id\":114136972148490240,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":5,\"totalActualPrice\":0.00},{\"id\":114136972249153536,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":8,\"totalActualPrice\":0.00},{\"id\":114136972211404800,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":7,\"totalActualPrice\":0.00},{\"id\":114136972286902272,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":9,\"totalActualPrice\":0.00},{\"id\":114136972106547200,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":4,\"totalActualPrice\":0.00},{\"id\":114136972064604160,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":3,\"totalActualPrice\":0.00},{\"id\":114136972177850368,\"version\":0,\"createTime\":\"2017-09-11 22:59:34\",\"status\":\"normal\",\"userId\":6,\"totalActualPrice\":0.00}],\"total\":9,\"pageCount\":1,\"pageSize\":10,\"currentPage\":1}}";
        Result<Pagination<Order>> pagination2 = JsonUtil.toEntity(s, Result.class);
        System.out.println(pagination2.getData().getList().get(1).getId());

    }

}