package com.gasq.cloud.common.provider.${CONFIG.serverName}.dao;

import com.cachexic.cloud.common.base.dao.BaseDao;
import com.cachexic.cloud.config.mybatis.annotation.MybatisDao;
import ${entity.fullClassName};
import ${entity.fullQueryClassName};

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@MybatisDao
public interface ${entity.className}Dao extends BaseDao<${entity.className}, ${entity.className}Query>{

}
