package com.gasq.cloud.common.provider.${CONFIG.serverName}.service.impl;

import com.gasq.cloud.common.exceptions.ValidateException;
import com.gasq.cloud.common.exceptions.enums.ValidateExceptionEnum;
import com.gasq.cloud.common.provider.config.dao.BaseDao;
import com.gasq.cloud.common.provider.config.service.impl.BaseServiceImpl;
import ${entity.fullClassName};
import ${entity.fullClassName}Query;
import com.gasq.cloud.provider.${CONFIG.serverName}.dao.${entity.className}Dao;
import com.gasq.cloud.provider.${CONFIG.serverName}.service.${entity.className}Service;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
@Service("${entity.firstLowName}Service")
public class ${entity.className}ServiceImpl extends BaseServiceImpl<${entity.className}, ${entity.className}Query, <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>> implements ${entity.className}Service{
     @Autowired
     private ${entity.className}Dao dao;

     @Override
     protected BaseDao<${entity.className}, ${entity.className}Query, <#if CONFIG.idType==0>Long</#if><#if CONFIG.idType==1>String</#if>> dao() {
          return this.dao;
     }


     /**
      * 校验entity是否可修改（code是否存在）
      */
     public Boolean checkNameExit(${entity.className} entity) {
          Long count = this.dao.selectCheckNameExit(entity.getName(), entity.getId());
          if(count>0){
               return false;
          }
          return true;
     }

     /**
      * 新增or修改
      */
     @Transactional
     public String saveOrUpdate(${entity.className} entity) {
          if(!checkNameExit(entity)){
               if (<#if CONFIG.idType==0>entity.getId() == null </#if><#if CONFIG.idType==1>StringUtils.isBlank(entity.getId())</#if>) {
                    throw new ValidateException(ValidateExceptionEnum.INSERT_FAILD.getCode(), "名称已经存在，新增失败");
               } else {
                    throw new ValidateException(ValidateExceptionEnum.UPDATE_FAILD.getCode(), "名称已经存在，修改失败");
               }
          }
          String msg = "";
          if (<#if CONFIG.idType==0>entity.getId() == null </#if><#if CONFIG.idType==1>StringUtils.isBlank(entity.getId())</#if>) {
               this.insert(entity);
               msg = "添加成功！";
          } else {
               this.update(entity);
                    msg = "编辑成功！";
          }
          return msg;
     }

}