package com.cachexic.cloud.feign.order.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;
import com.cachexic.cloud.common.utils.json.JsonUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @Description:
 * @date 2017-09-06 16:20:20
 */
public enum PaywayEnum {

  onLinePay("在线支付"),
  offLinePay("货到付款");

  /**
   * 备注信息
   */
  private final String desc;

  PaywayEnum(String desc) {
    this.desc = desc;
  }

  public String getDesc() {
    return desc;
  }

  /**
   * 转换为list
   */
  public static List toList() {
    List list = new ArrayList();
    for (PaywayEnum _enum : PaywayEnum.values()) {
      list.add(new ValueDescVo(_enum.name(), _enum.getDesc()));
    }
    return list;
  }

  public static void main(String[] args) {
    System.out.println(JsonUtil.toJson(PaywayEnum.toList()));
  }

}
