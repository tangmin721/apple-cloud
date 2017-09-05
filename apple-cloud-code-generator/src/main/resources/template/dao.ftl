package com.gasq.cloud.common.provider.${CONFIG.serverName}.dao;

import org.apache.ibatis.annotations.Param;
import com.gasq.cloud.common.provider.config.dao.BaseDao;
import com.gasq.cloud.common.provider.config.mybatis.MybatisDao;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@MybatisDao
public interface ${entity.className}Dao extends BaseDao<${entity.className}, ${entity.className}Query, <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>>{

	/**
	 * 查找name为@name，且id不为@id的记录条数
	 * @param name
	 * @param id
	 * @return
	 */
	Long selectCheckNameExit(@Param("name")String name,@Param("id")<#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id);

}
