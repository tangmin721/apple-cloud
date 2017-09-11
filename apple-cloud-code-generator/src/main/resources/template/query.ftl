package com.cachexic.cloud.feign.${CONFIG.serverName}.entity;

import com.cachexic.cloud.common.base.entity.query.<#if CONFIG.extendBaseEntity=="false">Pojo</#if>BaseQuery;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
public class ${entity.className}Query extends <#if CONFIG.extendBaseEntity=="false">Pojo</#if>BaseQuery{
    private static final long serialVersionUID = 1L;

<#list entity.myfieldListNotTransient as e><#if e.fieldTypeClassName=="class java.util.Date">    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
</#if>    private ${e.simpleTypeName} ${e.fieldName};<#if e.fieldTypeClassName=="class java.lang.String">
    private Boolean ${e.fieldName}Like = false;</#if>

</#list>
<#list entity.myfieldListNotTransient as e>    public ${e.simpleTypeName} get${e.supFiledName}() {
        return ${e.fieldName};
    }

    public ${entity.className}Query set${e.supFiledName}(${e.simpleTypeName} ${e.fieldName}) {
        this.${e.fieldName} = ${e.fieldName};
        return this;
    }

<#if e.fieldTypeClassName=="class java.lang.String">    public Boolean get${e.supFiledName}Like() {
        return ${e.fieldName}Like;
    }

    public ${entity.className}Query set${e.supFiledName}Like(Boolean ${e.fieldName}Like) {
        this.${e.fieldName}Like = ${e.fieldName}Like;
        return this;
    }
</#if>
</#list>

}