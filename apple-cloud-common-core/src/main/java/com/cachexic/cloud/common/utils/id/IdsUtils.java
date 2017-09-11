package com.cachexic.cloud.common.utils.id;

import com.google.common.collect.Lists;
import java.util.List;

/**
 * @author tangmin
 * @Description: 逗号分隔ids
 * @date 2017-09-11 18:00:01
 */
public class IdsUtils {

    public static List<String> listString(String ids) {
        List<String> idList = Lists.newArrayList();
        String[] split = ids.split(",");
        for(String strId:split){
            idList.add(strId);
        }
        return idList;
    }

    public static List<Long> listLong(String ids) {
        List<Long> idList = Lists.newArrayList();
        String[] split = ids.split(",");
        for(String strId:split){
            idList.add(Long.parseLong(strId));
        }
        return idList;
    }
}
