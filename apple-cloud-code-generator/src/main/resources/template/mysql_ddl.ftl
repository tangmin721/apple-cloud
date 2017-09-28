-- DROP TABLE IF EXISTS `${entity.tableName}`;

CREATE TABLE `${entity.tableName}` (
  `id` bigint AUTO_INCREMENT,
<#list entity.myfieldListNotTransient as e>  ${e.mysqlFieldStr},
  </#list>
  <#if CONFIG.extendBaseEntity=="true">`version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',</#if>
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='${CONFIG.modelName}';
-- 如果需要支持emoji      CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci

-- 根据具体业务需求添加索引
-- 更新索引(Normal类型,单列)
-- ALTER TABLE `${entity.tableName}` ADD INDEX(`create_user_id`) COMMENT 'for select by create_user_id';

-- 更新索引(Unique类型,多列)
-- ALTER TABLE `${entity.tableName}` ADD UNIQUE KEY(`create_user_id`,`id`) COMMENT 'ignore insert on duplicate';
