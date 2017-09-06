package com.cachexic.cloud.feign.order.entity;


import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.annotations.Field;
import com.cachexic.cloud.common.base.annotations.Transient;
import com.cachexic.cloud.common.base.entity.BaseEntity;

import java.math.BigDecimal;

/**
 * Created by tangm on 2017/8/20.
 */
@Entity("t_order")
public class Order extends BaseEntity {

    @Field("用户id")
    private Long userId;
    @Transient
    private String userName;

    private String orderSn;

    @Field(value = "用户id",notNull = false,length = 200)
    private String memo;

    @Field(value = "实付总金额")
    private BigDecimal totalActualPrice;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getOrderSn() {
        return orderSn;
    }

    public void setOrderSn(String orderSn) {
        this.orderSn = orderSn;
    }

    public String getMemo() {
        return memo;
    }

    public void setMemo(String memo) {
        this.memo = memo;
    }

    public BigDecimal getTotalActualPrice() {
        return totalActualPrice;
    }

    public void setTotalActualPrice(BigDecimal totalActualPrice) {
        this.totalActualPrice = totalActualPrice;
    }
}
