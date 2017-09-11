package com.cachexic.cloud.web.backstage.controller.order;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 22:31:40
 */
@RestController
@RequestMapping("/order/order")
public class OrderWebController{

    @Autowired
    private OrderFeign orderFeign;

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("list")
    public Result<List<Order>> list(@RequestBody OrderQuery query){
        return orderFeign.list(query);
    }

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    public Result<Pagination<List<Order>>> pagination(@RequestBody OrderQuery query){
        return orderFeign.pagination(query);
    }

    /**
     * 根据主键查询
     * @param id
     */
    @GetMapping("getById/{id}")
    public Result<Order> getById(@PathVariable Long id){
        return orderFeign.getById(id);
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("{ids}")
    public Result<List<Order>> getByIds(@PathVariable("ids") String ids){
        return orderFeign.getByIds(ids);
    }

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    public Result save(@RequestBody Order entity){
        return orderFeign.save(entity);
    }

    /**
     * 修改方法
     * @param entity
     */
    @PutMapping
    public Result update(@RequestBody Order entity){
        return orderFeign.update(entity);
    }

    /**
     * 根据Id删除
     * @param id
     */
    @DeleteMapping("{id}")
    public Result deleteById(@PathVariable("id") Long id){
        return orderFeign.deleteById(id);
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @DeleteMapping("{ids}")
    public Result deleteByIds(@PathVariable("ids") String ids){
        return orderFeign.deleteByIds(ids);
    }
}
