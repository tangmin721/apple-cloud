package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import com.cachexic.cloud.provider.order.service.OrderService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 23:45:19
 */
@RestController
@RequestMapping("/order")
public class OrderController implements OrderFeign {

    @Autowired
    private OrderService orderService;

    /**
     * list
     * @param query
     */
    @Override
    public Result<List<Order>> list(@RequestBody OrderQuery query){
        return Result.OK().setData(orderService.selectListPage(query));
    }

    /**
     * 分页查询
     * @param query
     */
    @Override
    public Result<Pagination<Order>> pagination(@RequestBody OrderQuery query){
        return Result.OK().setData(orderService.selectListPagination(query));
    }

    /**
     * 根据主键查询
     * @param id
     */
    @Override
    public Result<Order> getById(@PathVariable("id") Long id){
        return Result.OK().setData(orderService.selectById(id));
    }

    /**
     * 根据主键ids查询
     * @param ids
     */
    @Override
    public Result<List<Order>> getByIds(@PathVariable String ids){
        return Result.OK().setData(orderService.selectByIds(IdsUtil.listLong(ids)));
    }

    /**
     * 新增方法
     * @param entity
     */
    @Override
    public Result save(@RequestBody Order entity){
        orderService.insert(entity);
        return Result.OK("新增成功");
    }

    /**
     * 修改方法
     * @param entity
     */
    @Override
    public Result update(@RequestBody Order entity){
        orderService.update(entity);
        return Result.OK("修改成功");
    }

    /**
     * 根据Id删除
     * @param id
     */
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return Result.OK("删除成功");
    }

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        orderService.deleteByIds(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }




}
