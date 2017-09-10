package com.gasq.cloud.common.provider.${CONFIG.serverName}.service;

import com.gasq.cloud.common.provider.config.service.BaseService;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
public interface ${entity.className}Service extends BaseService<${entity.className}, ${entity.className}Query, <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>>{

    /**
     * 校验是否存在
     * @param
     * @return
     */
    Boolean checkNameExit(${entity.className} entity);

    /**
     * 保存或添加
     * @return
     */
    String saveOrUpdate(${entity.className} entity);

}
