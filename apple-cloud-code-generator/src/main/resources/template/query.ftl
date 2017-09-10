package com.gasq.cloud.feign.${CONFIG.serverName}.entity;

import com.gasq.cloud.common.core.entity.<#if CONFIG.extendBaseEntity=="false">Pojo</#if>BaseQuery;

/**
 * ${CONFIG.modelName}管理
 * @author tangmin
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
public class ${entity.className}Query extends <#if CONFIG.extendBaseEntity=="false">Pojo</#if>BaseQuery{
    private static final long serialVersionUID = 1L;

    <#list entity.myfieldList as e>
    private String ${e.fieldName};
    private Boolean ${e.fieldName}Like = false;
    </#list>

    <#list entity.myfieldList as e>
    public String get${e.supFiledName}() {
        return ${e.fieldName};
    }
    public ${entity.className}Query set${e.supFiledName}(String ${e.fieldName}) {
        this.${e.fieldName} = ${e.fieldName};
        return this;
    }
    public Boolean get${e.supFiledName}Like() {
        return ${e.fieldName}Like;
    }
    public ${entity.className}Query set${e.supFiledName}Like(Boolean ${e.fieldName}Like) {
        this.${e.fieldName}Like = ${e.fieldName}Like;
        return this;
    }
</#list>

}