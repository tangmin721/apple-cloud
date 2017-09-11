package com.cachexic.cloud.common.utils.json;

import java.util.List;

/**
 * @author tangmin
 * @version V1.0
 * @Title: JsonUtil.java
 * @Package com.cachexic.cloud.common.utils.json
 * @Description: Json转换工具类
 * @date 2017-09-05 17:53:03
 */
public class JsonUtil {

    /*** 将对象序列化为JSON文本 */
    public static <T> String toJson(Object object) {
        return JsonMapper.nonEmptyMapper().toJson(object);
    }

    /***
     * 将字符串==>转换为传入类型的对象
     * @param
     * @param json
     * @param beanClass
     * @return
     */
    public static <T> T toEntity(String json, Class<T> beanClass) {
        return JsonMapper.nonEmptyMapper().fromJson(json,beanClass);
    }

    /***
     * 将Object对象==>转换为传入类型的对象
     * @param
     * @param object
     * @param beanClass
     * @return
     */
    public static <T> T toEntity(Object object, Class<T> beanClass) {
        return JsonMapper.nonEmptyMapper().fromJson(toJson(object),beanClass);
    }

    /***
     * 将字符串==>转换为传入类型的List
     * @param
     * @param objectClass
     * @return
     */
    public static <T> List<T> toList(String jsonString, Class<T> objectClass){
        return JsonMapper.nonEmptyMapper().fromJsonToList(jsonString,objectClass);
    }

    /***
     * 将object对象=>转换为传入类型的List
     * @param
     * @param objectClass
     * @return
     */
    public static <T> List<T> toList(Object object, Class<T> objectClass) {
        return toList(toJson(object),objectClass);
    }

}