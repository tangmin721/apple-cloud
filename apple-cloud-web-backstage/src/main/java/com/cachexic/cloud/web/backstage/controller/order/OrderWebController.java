package com.cachexic.cloud.web.backstage.controller.order;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.utils.json.JsonUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Created by tangm on 2017/9/6.
 */
@RestController
@RequestMapping("/order")
public class OrderWebController {

    @Autowired
    private OrderFeign orderFeign;

    @RequestMapping("selectList")
    public Result<List<Order>> selectList(@RequestBody OrderQuery orderQuery){
        Result<List<Order>> listResult = orderFeign.selectList(orderQuery);
        if(listResult.getStatus()==0){
            System.out.println(listResult.getStatus());
            System.out.println(listResult.getMessage());

            List<Order> data = listResult.getData();
            for (Order order : data) {
                System.out.println(JsonUtil.toJson(order));
            }
        }
        return listResult;
    }

}
