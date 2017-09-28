package com.cachexic.cloud.feign.order.entity;

import com.cachexic.cloud.common.base.annotations.Entity;
import com.cachexic.cloud.common.base.annotations.Transient;
import com.cachexic.cloud.common.base.entity.BaseEntity;
import com.cachexic.cloud.common.base.validator.annotations.Insert;
import com.cachexic.cloud.common.base.validator.annotations.Update;
import io.swagger.annotations.ApiModelProperty;
import java.math.BigDecimal;
import javax.validation.constraints.Size;

/**
 * Created by tangm on 2017/8/20.
 */
@Entity("t_order")
public class Order extends BaseEntity {

    @ApiModelProperty("用户id")
    private Long userId;

    @ApiModelProperty("用户名")
    @Transient
    private String userName;

    @ApiModelProperty("订单号")
    private String orderSn;

    @ApiModelProperty("备注")
    @Size(max = 255, message = "备注长度不能超过255个字节", groups = {Insert.class, Update.class})
    private String memo;

    @ApiModelProperty("实付总价")
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
