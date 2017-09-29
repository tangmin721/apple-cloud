package com.gasq.cloud.common.provider.${CONFIG.serverName}.service.impl;

import com.cachexic.cloud.common.base.service.impl.BaseServiceImpl;
import ${entity.fullClassName};
import ${entity.fullQueryClassName}Query;
import com.cachexic.cloud.provider.${CONFIG.serverName}.service.${entity.className}Service;
import org.springframework.stereotype.Service;

/**
 * @Description: ${CONFIG.modelName}管理  /${CONFIG.serverName}
 * @author ${CONFIG.author}
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service("${entity.firstLowName}Service")
public class ${entity.className}ServiceImpl extends BaseServiceImpl<${entity.className}, ${entity.className}Query> implements ${entity.className}Service{

}