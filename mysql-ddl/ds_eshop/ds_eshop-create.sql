-- DROP DATABASE IF EXISTS ds_eshop;
CREATE DATABASE ds_eshop DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;
-- SET utf8mb4 COLLATE utf8mb4_unicode_ci;

USE ds_eshop;
-- DROP TABLE IF EXISTS `t_eshop`;

CREATE TABLE IF NOT EXISTS `t_eshop` (
  `id` bigint AUTO_INCREMENT,
  `name` varchar(255) NOT NULL DEFAULT '' COMMENT '店铺名称',
  `code` varchar(255) NOT NULL DEFAULT '' COMMENT '店铺编号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='e店';

-- 根据具体业务需求添加索引
ALTER TABLE `t_eshop` ADD INDEX(`code`) COMMENT 'for select by code';

