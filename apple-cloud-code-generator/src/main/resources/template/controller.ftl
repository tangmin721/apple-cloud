package com.gasq.cloud.provider.${CONFIG.serverName}.controller;

import com.gasq.cloud.common.result.Result;
import com.gasq.cloud.common.utils.collections.IdsUtils;
import com.gasq.cloud.common.utils.json.JsonUtils;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;
import com.gasq.cloud.provider.${CONFIG.serverName}.service.${entity.className}Service;
import com.google.common.collect.Lists;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@RestController
@RequestMapping("/${CONFIG.requestMapPath}")
public class ${entity.className}Controller{

	private final static Logger log = LoggerFactory.getLogger(${entity.className}Controller.class);

	@Autowired
	private ${entity.className}Service ${entity.firstLowName}Service;

	/**
	* 分页查询
	* @param query
	* @return Result data：List<${entity.className}>
	*/
	@PostMapping("listPage")
	public Result listPage(@RequestBody ${entity.className}Query query){
		/** 只查询其中几个字段
		query.setFields("id,sortField1,sortField2");
		*/

		/**
		* 指定排序规则，也可前端自由传参
		* query.setOrderField("sortField1").setOrderSort("desc");
		*/

		/**
		* 多字段排序，只能代码限定
		query.getOrderFields().add(new OrderField("sortField1", "asc"));
		query.getOrderFields().add(new OrderField("sortField2", "desc"));*/

		return Result.OK().setData(${entity.firstLowName}Service.selectListPage(query));
	}

	/**
	* 分页查询
	* @param query
	* @return Result data：Pagination
	*/
	@PostMapping("listPagination")
	public Result listPagination(@RequestBody ${entity.className}Query query){
		/** 查询方式同上*/

		return Result.OK().setData(${entity.firstLowName}Service.selectListPagination(query));
	}

	/**
	* 根据主键查询
	* @param id
	* @return Result data:${entity.className}
	*/
	@PostMapping("getById/{id}")
	public Result getById(@PathVariable <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id){
		${entity.className} entity = ${entity.firstLowName}Service.selectById(id);

		/**只查询实体其中的几个字段
		${entity.className} entity = ${entity.firstLowName}Service.selectById(id,"id,fieldName1,fieldName2");*/

		if(entity == null){
			return Result.FAIL("找不到记录");
		}
		return Result.OK().setData(entity);
	}

	/**
	* 根据主键ids查询
	* @param ids
	* @return Result data: List<${entity.className}>
    */
    @PostMapping("getByIds/{ids}")
    public Result getByIds(@PathVariable String ids){
		List<${entity.className}> ${entity.firstLowName}s = ${entity.firstLowName}Service.selectByIds(IdsUtils.list<#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>(ids));
        //List<${entity.className}> ${entity.firstLowName}s = ${entity.firstLowName}Service.selectByIds(IdsUtils.list<#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>(ids),"id,fieldName1,fieldName2");

		if(${entity.firstLowName}s != null && ${entity.firstLowName}s.size()>0){
			return Result.OK().setData(${entity.firstLowName}s);
		}
		return Result.FAIL("找不到记录");
	}

    /**
    * 保存方法，合并了新增修改。
    * @param entity
    * @return Result data: String
    */
	@PostMapping("save")
	public Result save(@RequestBody ${entity.className} entity){
		log.debug("provider-${entity.firstLowName}:save-->{}", JsonUtils.toJson(entity));
		return Result.OK().setData(${entity.firstLowName}Service.saveOrUpdate(entity));
	}

    /**
    * 根据Id删除
    * @param id
    * @return Result data: String
    */
	@DeleteMapping("deleteById/{id}")
	public Result deleteById(@PathVariable <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if> id){
		${entity.firstLowName}Service.<#if CONFIG.extendBaseEntity=="true">deleteById</#if><#if CONFIG.extendBaseEntity=="false">removeById</#if>(id);
		return Result.OK("删除成功！");
	}

    /**
    * 根据ids删除，id逗号隔开
    * @param ids
    * @return Result data: String
    */
	@DeleteMapping("deleteByIds/{ids}")
	public Result deleteByIds(@PathVariable String ids){
		${entity.firstLowName}Service.<#if CONFIG.extendBaseEntity=="true">deleteByIds</#if><#if CONFIG.extendBaseEntity=="false">removeByIds</#if>(IdsUtils.list<#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>(ids));
		return Result.OK("删除成功！");
	}

}
