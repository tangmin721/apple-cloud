package com.cachexic.cloud.common.base.vo;

import java.io.Serializable;

/**
 * @author tangmin
 * @version V1.0
 * @Title: ValueDescVo.java
 * @Package com.cachexic.sjdbc.common.vo
 * @Description: 
 * @date 2017-08-25 23:04:10
 */
public class ValueDescVo implements Serializable{
    private static final long serialVersionUID = -8498932351402616916L;
    private String value;
    private String desc;

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
