package com.cachexic.cloud.feign.order.feign.fallback;

import com.cachexic.cloud.common.base.Result;
import com.cachexic.cloud.common.base.entity.query.Pagination;
import com.cachexic.cloud.feign.order.entity.Order;
import com.cachexic.cloud.feign.order.entity.query.OrderQuery;
import com.cachexic.cloud.feign.order.feign.OrderFeign;
import feign.hystrix.FallbackFactory;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 * 订单管理  feign hystrix快速返回实现
 * @author tangmin
 * @date 2017-09-11 22:31:40
 */
@Component
public class OrderFeignFallback implements FallbackFactory<OrderFeign> {

    @Override
    public OrderFeign create(Throwable cause) {
        return new OrderFeign() {

            @Override
            public Result<List<Order>> list(OrderQuery query) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<Pagination<List<Order>>> pagination(OrderQuery query) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<Order> getById(Long id) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result<List<Order>> getByIds(String ids) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result save(Order entity) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result update(Order entity) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result deleteById(Long id) {
                return Result.FALLBACK(cause);
            }

            @Override
            public Result deleteByIds(String ids) {
                return Result.FALLBACK(cause);
            }
        };
    }
}
