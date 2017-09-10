/*
注意：为了不侵入实体类的代码，本ddl语句仅供创建字段，
为了数据库最多性能，请建表后调整各字段的：类型，长度，注释 等，需要加索引的列也加上
*/

CREATE TABLE `${entity.tableName}` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
<#list entity.myfieldList as e>  `${e.columnName}` varchar(32) COLLATE utf8mb4_unicode_ci COMMENT '@TODO注释',
  </#list>
  <#if CONFIG.extendBaseEntity=="true">`version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `create_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `update_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人name',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'</#if>
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='${CONFIG.modelName}';