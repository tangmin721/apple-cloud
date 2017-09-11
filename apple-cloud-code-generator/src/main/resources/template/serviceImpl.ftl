package com.gasq.cloud.common.provider.${CONFIG.serverName}.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import ${entity.fullClassName};
import ${entity.fullQueryClassName}Query;
import com.gasq.cloud.provider.${CONFIG.serverName}.service.${entity.className}Service;
import org.springframework.stereotype.Service;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service
public class ${entity.className}ServiceImpl extends BaseServiceImpl<${entity.className}, ${entity.className}Query> implements ${entity.className}Service{

}