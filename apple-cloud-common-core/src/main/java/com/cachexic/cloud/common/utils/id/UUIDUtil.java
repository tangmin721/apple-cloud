package com.cachexic.cloud.common.utils.id;

import java.util.UUID;

/**
 * @author tangmin
 * @Description: UUID
 * @date 2017-09-05 18:35:25
 */
public class UUIDUtil {

    public static String get36UUID() {
        return UUID.randomUUID().toString();
    }

    public static String get32UUID(){
        return UUID.randomUUID().toString().replaceAll("-","");
    }
}
