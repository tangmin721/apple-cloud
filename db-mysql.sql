

-- 创建数据库脚本(dev) --
-- create database ds0 --
DROP DATABASE
IF EXISTS ds_0;

CREATE DATABASE ds_0 DEFAULT charACTER
SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- create database ds1 --

DROP DATABASE
IF EXISTS ds_1;

CREATE DATABASE ds_1 DEFAULT charACTER
SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- ds0 -------------------------------------------------------------------------------------
DROP TABLE
IF EXISTS `ds_0`.`sys_role`;

CREATE TABLE `ds_0`.`sys_role` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '角色表';


DROP TABLE
IF EXISTS `ds_0`.`t_order_0`;

CREATE TABLE `ds_0`.`t_order_0` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint NOT NULL COMMENT '下单用户ID',
  `order_sn` char(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '订单编号',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;



DROP TABLE
IF EXISTS `ds_0`.`t_order_1`;

CREATE TABLE `ds_0`.`t_order_1` (
  `id` bigint AUTO_INCREMENT,
  `user_id` bigint  COMMENT 'userId描述',
  `order_sn` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'orderSn描述',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'memo描述',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT 'totalActualPrice描述',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `create_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `update_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人name',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单';

DROP TABLE
IF EXISTS `ds_0`.`t_order_item_0`;

CREATE TABLE `ds_0`.`t_order_item_0` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `ds_0`.`t_order_item_1`;

CREATE TABLE `ds_0`.`t_order_item_1` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `ds_0`.`sys_dict_catlog`;

CREATE TABLE `ds_0`.`sys_dict_catlog` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `isTree` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否是树行字典',
  `canCheckParent` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否能选中父节点',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典目录(全局表)';

DROP TABLE
IF EXISTS `ds_0`.`sys_dict_item`;

CREATE TABLE `ds_0`.`sys_dict_item` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `catlog_id` bigint NOT NULL COMMENT '字典目录id(sys_dict_catlog的id)',
  `parent_id` bigint DEFAULT NULL COMMENT '父节点id',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典项(全局表)';

DROP TABLE
IF EXISTS `ds_0`.`test_uuid_entity_0`;

CREATE TABLE `ds_0`.`test_uuid_entity_0` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `ds_0`.`test_uuid_entity_1`;

CREATE TABLE `ds_0`.`test_uuid_entity_1` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `ds_0`.`test_uuid_entity_0`;

CREATE TABLE `ds_0`.`test_uuid_entity_0` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `ds_0`.`t_product_0`;

CREATE TABLE `ds_0`.`t_product_0` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';

DROP TABLE
IF EXISTS `ds_0`.`t_product_1`;

CREATE TABLE `ds_0`.`t_product_1` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';
-- ds1 -------------------------------------------------------------------------

DROP TABLE
IF EXISTS `ds_1`.`t_order_0`;

CREATE TABLE `ds_1`.`t_order_0` (
  `id` bigint AUTO_INCREMENT,
  `user_id` bigint  COMMENT 'userId描述',
  `order_sn` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'orderSn描述',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'memo描述',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT 'totalActualPrice描述',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `create_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `update_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人name',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单';

DROP TABLE
IF EXISTS `ds_1`.`t_order_item_0`;

CREATE TABLE `ds_1`.`t_order_item_0` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `ds_1`.`t_order_1`;

CREATE TABLE `ds_1`.`t_order_1` (
  `id` bigint AUTO_INCREMENT,
  `user_id` bigint  COMMENT 'userId描述',
  `order_sn` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'orderSn描述',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT ''  COMMENT 'memo描述',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT 'totalActualPrice描述',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `create_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `update_user_name` varchar(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '更新人name',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci COMMENT='订单';

DROP TABLE
IF EXISTS `ds_1`.`t_order_item_1`;

CREATE TABLE `ds_1`.`t_order_item_1` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;



DROP TABLE
IF EXISTS `ds_1`.`sys_dict_catlog`;

CREATE TABLE `ds_1`.`sys_dict_catlog` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `isTree` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否是树行字典',
  `canCheckParent` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否能选中父节点',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典目录(全局表)';

DROP TABLE
IF EXISTS `ds_1`.`sys_dict_item`;

CREATE TABLE `ds_1`.`sys_dict_item` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `catlog_id` bigint NOT NULL COMMENT '字典目录id(sys_dict_catlog的id)',
  `parent_id` bigint DEFAULT NULL COMMENT '父节点id',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典项(全局表)';




DROP TABLE
IF EXISTS `ds_1`.`test_uuid_entity_0`;

CREATE TABLE `ds_1`.`test_uuid_entity_0` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `ds_1`.`test_uuid_entity_1`;

CREATE TABLE `ds_1`.`test_uuid_entity_1` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `ds_1`.`t_product_0`;

CREATE TABLE `ds_1`.`t_product_0` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';

DROP TABLE
IF EXISTS `ds_1`.`t_product_1`;

CREATE TABLE `ds_1`.`t_product_1` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';
-- ------------------------------------------------------------------------------

-- INSERT intO ds_0.t_order_0 (id,user_id,order_sn,version,STATUS,create_time,create_user_id) VALUES (1,1,'o1234567o1234567o1234567o1234567',0,'normal',now(),'1');
-- INSERT intO ds_1.t_order_0 (id,user_id,order_sn,version,STATUS,create_time,create_user_id) VALUES (2,1,'o2234567o1234567o1234567o1234567',0,'normal',now(),'1');




-- --------------------------------------------------------------------------------------------------
-- --------------------------------------------------------------------------------------------------
-- 创建数据库脚本(dev) --
-- create database ds0 --
DROP DATABASE
IF EXISTS prod_ds_0;

CREATE DATABASE prod_ds_0 DEFAULT charACTER
SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- create database ds1 --

DROP DATABASE
IF EXISTS prod_ds_1;

CREATE DATABASE prod_ds_1 DEFAULT charACTER
SET utf8mb4 COLLATE utf8mb4_unicode_ci;

-- ds0 -------------------------------------------------------------------------------------

DROP TABLE
IF EXISTS `prod_ds_0`.`t_order_0`;

CREATE TABLE `prod_ds_0`.`t_order_0` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint NOT NULL COMMENT '下单用户ID',
  `order_sn` char(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '订单编号',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_0`.`t_order_1`;

CREATE TABLE `prod_ds_0`.`t_order_1` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint NOT NULL COMMENT '下单用户ID',
  `order_sn` char(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '订单编号',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_0`.`t_order_item_0`;

CREATE TABLE `prod_ds_0`.`t_order_item_0` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_0`.`t_order_item_1`;

CREATE TABLE `prod_ds_0`.`t_order_item_1` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_0`.`sys_dict_catlog`;

CREATE TABLE `prod_ds_0`.`sys_dict_catlog` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `isTree` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否是树行字典',
  `canCheckParent` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否能选中父节点',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典目录(全局表)';

DROP TABLE
IF EXISTS `prod_ds_0`.`sys_dict_item`;

CREATE TABLE `prod_ds_0`.`sys_dict_item` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `catlog_id` bigint NOT NULL COMMENT '字典目录id(sys_dict_catlog的id)',
  `parent_id` bigint DEFAULT NULL COMMENT '父节点id',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典项(全局表)';

DROP TABLE
IF EXISTS `prod_ds_0`.`test_uuid_entity_0`;

CREATE TABLE `prod_ds_0`.`test_uuid_entity_0` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `prod_ds_0`.`test_uuid_entity_1`;

CREATE TABLE `prod_ds_0`.`test_uuid_entity_1` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `prod_ds_0`.`test_uuid_entity_0`;

CREATE TABLE `prod_ds_0`.`test_uuid_entity_0` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `prod_ds_0`.`t_product_0`;

CREATE TABLE `prod_ds_0`.`t_product_0` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';

DROP TABLE
IF EXISTS `prod_ds_0`.`t_product_1`;

CREATE TABLE `prod_ds_0`.`t_product_1` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';
-- ds1 -------------------------------------------------------------------------

DROP TABLE
IF EXISTS `prod_ds_1`.`t_order_0`;

CREATE TABLE `prod_ds_1`.`t_order_0` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint NOT NULL COMMENT '下单用户ID',
  `order_sn` char(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '订单编号',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_1`.`t_order_item_0`;

CREATE TABLE `prod_ds_1`.`t_order_item_0` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_1`.`t_order_1`;

CREATE TABLE `prod_ds_1`.`t_order_1` (
  `id` bigint PRIMARY KEY,
  `user_id` bigint NOT NULL COMMENT '下单用户ID',
  `order_sn` char(32) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '订单编号',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;

DROP TABLE
IF EXISTS `prod_ds_1`.`t_order_item_1`;

CREATE TABLE `prod_ds_1`.`t_order_item_1` (
  `id` bigint PRIMARY KEY,
  `order_id` bigint NOT NULL COMMENT '订单id',
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_id` bigint NOT NULL COMMENT '商品id',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4;



DROP TABLE
IF EXISTS `prod_ds_1`.`sys_dict_catlog`;

CREATE TABLE `prod_ds_1`.`sys_dict_catlog` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `isTree` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否是树行字典',
  `canCheckParent` enum ('yes', 'no') DEFAULT 'no' COMMENT '是否能选中父节点',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典目录(全局表)';

DROP TABLE
IF EXISTS `prod_ds_1`.`sys_dict_item`;

CREATE TABLE `prod_ds_1`.`sys_dict_item` (
  `id` bigint AUTO_INCREMENT PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `catlog_id` bigint NOT NULL COMMENT '字典目录id(sys_dict_catlog的id)',
  `parent_id` bigint DEFAULT NULL COMMENT '父节点id',
  `code` varchar(40) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '编码(唯一)',
  `name` varchar(100) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '名称',
  `memo` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '备注',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT charSET = utf8mb4 COMMENT '字典项(全局表)';




DROP TABLE
IF EXISTS `prod_ds_1`.`test_uuid_entity_0`;

CREATE TABLE `prod_ds_1`.`test_uuid_entity_0` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `prod_ds_1`.`test_uuid_entity_1`;

CREATE TABLE `prod_ds_1`.`test_uuid_entity_1` (
  `id` char(32) PRIMARY KEY,
  `seq` int DEFAULT 0 COMMENT '排序序号',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET = utf8mb4 COMMENT '测试uuid分库分表';

DROP TABLE
IF EXISTS `prod_ds_1`.`t_product_0`;

CREATE TABLE `prod_ds_1`.`t_product_0` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';

DROP TABLE
IF EXISTS `prod_ds_1`.`t_product_1`;

CREATE TABLE `prod_ds_1`.`t_product_1` (
  `id` bigint PRIMARY KEY,
  `eshop_id` bigint NOT NULL COMMENT '商品店铺id',
  `eshop_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品店铺name',
  `product_name` varchar(255) COLLATE utf8mb4_unicode_ci DEFAULT '' COMMENT '商品名称name',
  `actual_price` decimal(20,2) NOT NULL DEFAULT '0.00' COMMENT '实付价格',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint COMMENT '更新人ID',
  `status` enum ('normal', 'deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE = INNODB DEFAULT charSET = utf8mb4 COMMENT '商品';
-- ------------------------------------------------------------------------------

CREATE TABLE `ds_1`.`test_other_ds` (
  `id` bigint PRIMARY KEY,
  `seq` int DEFAULT '0' COMMENT '排序序号',
  `version` int DEFAULT '0' COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '记录创建时间',
  `create_user_id` bigint DEFAULT NULL COMMENT '创建人ID',
  `update_time` datetime COMMENT '记录更新时间',
  `update_user_id` bigint DEFAULT NULL COMMENT '更新人ID',
  `status` enum('normal','deleted','disabled','frozen') DEFAULT 'normal' COMMENT '状态'
) ENGINE=InnoDB DEFAULT charSET=utf8mb4 COMMENT='测试第三方库，指定数据源';


-- ------------------------------------------------------------------------------

-- INSERT intO prod_ds_0.t_order_0 (id,user_id,order_sn,version,STATUS,create_time,create_user_id) VALUES (3,1,'o3234567o1234567o1234567o1234567',0,'normal',now(),'1');
-- INSERT intO prod_ds_1.t_order_1 (id,user_id,order_sn,version,STATUS,create_time,create_user_id) VALUES (4,1,'o4234567o1234567o1234567o1234567',0,'normal',now(),'1');


