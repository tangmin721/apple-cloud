package com.cachexic.cloud.feign.order.entity.query;

import com.cachexic.cloud.common.base.entity.query.BaseQuery;

/**
 * 订单管理
 * @author tangmin
 * @date 2017-09-11 21:39:52
 */
public class OrderQuery extends BaseQuery{
    private static final long serialVersionUID = 1L;

    private String userId;
    private Boolean userIdLike = false;
    private String userName;
    private Boolean userNameLike = false;
    private String orderSn;
    private Boolean orderSnLike = false;
    private String memo;
    private Boolean memoLike = false;
    private String totalActualPrice;
    private Boolean totalActualPriceLike = false;

    public String getUserId() {
        return userId;
    }
    public OrderQuery setUserId(String userId) {
        this.userId = userId;
        return this;
    }
    public Boolean getUserIdLike() {
        return userIdLike;
    }
    public OrderQuery setUserIdLike(Boolean userIdLike) {
        this.userIdLike = userIdLike;
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
    public String getTotalActualPrice() {
        return totalActualPrice;
    }
    public OrderQuery setTotalActualPrice(String totalActualPrice) {
        this.totalActualPrice = totalActualPrice;
        return this;
    }
    public Boolean getTotalActualPriceLike() {
        return totalActualPriceLike;
    }
    public OrderQuery setTotalActualPriceLike(Boolean totalActualPriceLike) {
        this.totalActualPriceLike = totalActualPriceLike;
        return this;
    }

}