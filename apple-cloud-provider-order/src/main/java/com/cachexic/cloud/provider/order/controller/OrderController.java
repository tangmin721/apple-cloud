package com.cachexic.cloud.provider.order.controller;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.common.utils.id.IdsUtil;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import com.cachexic.cloud.provider.order.service.OrderService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-28 12:51:58
 */
@Api(description = "订单管理")
@RestController
@RequestMapping("/order")
public class OrderController implements OrderFeign {

    @Autowired
    private OrderService orderService;

    @ApiOperation(value = "list:批量获取数据", notes = "不带分页信息的list集合")
    @Override
    public Result<List<Order>> list(@RequestBody OrderQuery query){
        return Result.OK().setData(orderService.selectListPage(query));
    }

    @ApiOperation(value = "pagination:分页查询", notes = "带分页信息的Pagination对象")
    @Override
    public Result<Pagination<Order>> pagination(@RequestBody OrderQuery query){
        return Result.OK().setData(orderService.selectListPagination(query));
    }

    @ApiOperation("getById:根据主键查询")
    @Override
    public Result<Order> getById(@PathVariable("id") Long id){
        return Result.OK().setData(orderService.selectById(id));
    }

    @ApiOperation(value = "getByIds:根据主键ids查询",notes = "逗号分隔")
    @Override
    public Result<List<Order>> getByIds(@PathVariable("ids") String ids){
        return Result.OK().setData(orderService.selectByIds(IdsUtil.listLong(ids)));
    }

    @ApiOperation("save:新增方法")
    @Override
    public Result save(@RequestBody Order entity){
        orderService.insert(entity);
        return Result.OK("新增成功");
    }

    @ApiOperation("update:修改方法")
    @Override
    public Result update(@RequestBody Order entity){
        orderService.update(entity);
        return Result.OK("修改成功");
    }

    @ApiOperation("deleteById:根据Id删除")
    @Override
    public Result deleteById(@PathVariable("id") Long id){
        orderService.deleteById(id);
        return Result.OK("删除成功");
    }

    @ApiOperation(value = "deleteByIds:根据ids批量删除",notes = "逗号分隔")
    @Override
    public Result deleteByIds(@PathVariable("ids") String ids){
        orderService.deleteByIds(IdsUtil.listLong(ids));
        return Result.OK("删除成功");
    }

}
