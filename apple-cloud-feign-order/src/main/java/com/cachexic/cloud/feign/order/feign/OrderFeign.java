package com.cachexic.cloud.feign.order.feign;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.fallback.OrderFeignFallback;
import java.util.List;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 23:45:19
 */
@FeignClient(name = "provider-order", path = "/order", fallbackFactory = OrderFeignFallback.class)
public interface OrderFeign{

    /**
     * List
     * @param query
     */
    @PostMapping("list")
    Result<List<Order>> list(@RequestBody OrderQuery query);

    /**
     * 分页查询
     * @param query
     */
    @PostMapping("pagination")
    Result<Pagination<Order>> pagination(@RequestBody OrderQuery query);

    /**
     * 根据主键查询
     * @param id
     */
    @GetMapping("{id}")
    Result<Order> getById(@PathVariable("id") Long id);

    /**
     * 根据主键ids查询
     * @param ids
     */
    @GetMapping("{ids}")
    Result<List<Order>> getByIds(@PathVariable("ids") String ids);

    /**
     * 新增方法
     * @param entity
     */
    @PostMapping
    Result save(@RequestBody Order entity);

    /**
     * 修改方法
     * @param entity
     */
    @PutMapping
    Result update(@RequestBody Order entity);

    /**
     * 根据Id删除
     * @param id
     */
    @DeleteMapping("{id}")
    Result deleteById(@PathVariable("id") Long id);

    /**
     * 根据ids删除，id逗号隔开
     * @param ids
     */
    @DeleteMapping("{ids}")
    Result deleteByIds(@PathVariable("ids") String ids);
}
