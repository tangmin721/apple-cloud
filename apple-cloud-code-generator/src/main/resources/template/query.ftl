package com.cachexic.cloud.feign.${CONFIG.serverName}.entity;

import com.cachexic.cloud.common.base.entity.query.<#if CONFIG.extendBaseEntity=="false">Pojo</#if>BaseQuery;

/**
 * @Description: ${CONFIG.modelName}管理
 * @author ${CONFIG.author}
 * @date ${.now?string("yyyy-MM-dd HH:mm:ss")}
 */
public class ${entity.className}Query extends <#if CONFIG.extendBaseEntity=="false">Pojo</#if>BaseQuery{
  private static final long serialVersionUID = 1L;

<#list entity.myfieldListNotTransient as e><#if e.simpleTypeName=="Date">  @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
  @ApiModelProperty(value = "${e.columnComment}", example = "2018-08-08 09:09:09")</#if>  <#if e.simpleTypeName!="Date">@ApiModelProperty("${e.columnComment}")</#if><#if e.simpleTypeName=="Boolean" || e.simpleTypeName=="boolean" || e.simpleTypeName=="Date">
  private ${e.simpleTypeName} ${e.fieldName};<#else>
  private String ${e.fieldName};<#if e.simpleTypeName=="String">
  private Boolean ${e.fieldName}Like = false;</#if></#if>

</#list>
<#list entity.myfieldListNotTransient as e>  public <#if e.simpleTypeName=="Boolean" || e.simpleTypeName=="boolean" || e.simpleTypeName=="Date">${e.simpleTypeName}<#else>String</#if> get${e.supFiledName}() {
    return ${e.fieldName};
  }

  public ${entity.className}Query set${e.supFiledName}(<#if e.simpleTypeName=="Boolean" || e.simpleTypeName=="boolean" || e.simpleTypeName=="Date">${e.simpleTypeName}<#else>String</#if> ${e.fieldName}) {
    this.${e.fieldName} = ${e.fieldName};
    return this;
  }

<#if e.simpleTypeName=="String">  public Boolean get${e.supFiledName}Like() {
    return ${e.fieldName}Like;
  }

  public ${entity.className}Query set${e.supFiledName}Like(Boolean ${e.fieldName}Like) {
    this.${e.fieldName}Like = ${e.fieldName}Like;
    return this;
  }
</#if>
</#list>
}