package com.cachexic.cloud.feign.order.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;
import java.math.BigDecimal;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 22:31:40
 */
public class OrderQuery extends BaseQuery{
    private static final long serialVersionUID = 1L;

    private Long userId;

    private String orderSn;
    private Boolean orderSnLike = false;

    private String memo;
    private Boolean memoLike = false;

    private BigDecimal totalActualPrice;

    public Long getUserId() {
        return userId;
    }

    public OrderQuery setUserId(Long userId) {
        this.userId = userId;
        return this;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public OrderQuery setOrderSn(String orderSn) {
        this.orderSn = orderSn;
        return this;
    }

    public Boolean getOrderSnLike() {
        return orderSnLike;
    }

    public OrderQuery setOrderSnLike(Boolean orderSnLike) {
        this.orderSnLike = orderSnLike;
        return this;
    }
    public String getMemo() {
        return memo;
    }

    public OrderQuery setMemo(String memo) {
        this.memo = memo;
        return this;
    }

    public Boolean getMemoLike() {
        return memoLike;
    }

    public OrderQuery setMemoLike(Boolean memoLike) {
        this.memoLike = memoLike;
        return this;
    }
    public BigDecimal getTotalActualPrice() {
        return totalActualPrice;
    }

    public OrderQuery setTotalActualPrice(BigDecimal totalActualPrice) {
        this.totalActualPrice = totalActualPrice;
        return this;
    }


}