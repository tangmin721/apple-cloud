/*
注意：为了不侵入实体类的代码，本ddl语句仅供创建字段，
为了数据库最多性能，请建表后调整各字段的：类型，长度，注释 等，需要加索引的列也加上
*/

CREATE TABLE `${entity.tableName}` (
<#if CONFIG.idType==0>  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'ID',</#if>
<#if CONFIG.idType==1>  `id` char(32) COLLATE utf8mb4_unicode_ci NOT NULL COMMENT '主键',</#if>
<#list entity.myfieldList as e>  `${e.columnName}` varchar(32) COLLATE utf8mb4_unicode_ci COMMENT '@TODO注释',
  </#list>
  <#if CONFIG.extendBaseEntity=="true">`create_user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人ID',
  `create_time` datetime DEFAULT NULL COMMENT '记录创建时间',
  `update_user_id` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人ID',
  `update_time` datetime DEFAULT NULL COMMENT '记录更新时间',
  `status` enum('yes','no') COLLATE utf8mb4_unicode_ci DEFAULT 'no' COMMENT '删除状态',
  `enable` enum('yes','no') COLLATE utf8mb4_unicode_ci DEFAULT 'yes' COMMENT '有效状态',</#if>
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='${CONFIG.modelName}';