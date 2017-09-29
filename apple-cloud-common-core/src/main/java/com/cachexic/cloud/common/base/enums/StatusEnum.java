package com.cachexic.cloud.common.base.enums;

import com.cachexic.cloud.common.base.vo.ValueDescVo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author tangmin
 * @Description: 消息状态
 * @date 2017-09-09 16:11:03
 */
public enum StatusEnum {

  invalid("无效"),
  normal("正常"),
  deleted("删除"),
  disabled("禁用"),
  frozen("冻结");

  /**
   * 备注信息
   */
  private final String desc;

  StatusEnum(String desc) {
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
    for (StatusEnum _enum : StatusEnum.values()) {
      list.add(new ValueDescVo(_enum.name(), _enum.getDesc()));
    }
    return list;
  }

}
