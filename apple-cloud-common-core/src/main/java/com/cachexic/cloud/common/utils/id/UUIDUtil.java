package com.cachexic.cloud.common.utils.id;

import java.util.UUID;

/**
 * @author tangmin
 * @version V1.0
 * @Title: UUIDUtil.java
 * @Package com.cachexic.cloud.common.utils.id
 * @Description: UUID
 * @date 2017-09-05 18:35:25
 */
public class UUIDUtil {

    public static String getUUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
