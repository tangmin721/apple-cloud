-- 创建数据库脚本(如果是inline表达式db_${0..3}表示有db_0,db_1,db_2,db_3四个数据库,创建表的时候得修改下面的db_0) 注意是分表还是单表--
-- create database ds0 --
DROP DATABASE IF EXISTS ds_1;

CREATE DATABASE ds_1 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE ds_1;

-- ----------------------------------分表分割线------------------------------------------------------
CREATE TABLE IF NOT EXISTS `t_order_0` (
  `id` bigint AUTO_INCREMENT,
  `user_id` bigint  COMMENT '用户id',
  `order_sn` varchar(255) DEFAULT '' COMMENT '订单号',
  `memo` varchar(255) DEFAULT '' COMMENT '备注',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT '实付总价',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='订单';

ALTER TABLE `t_order_0` ADD INDEX(`user_id`) COMMENT 'for select by user_id';
ALTER TABLE `t_order_0` ADD INDEX(`order_sn`) COMMENT 'for select by order_sn';

CREATE TABLE IF NOT EXISTS `t_order_1` (
  `id` bigint AUTO_INCREMENT,
  `user_id` bigint  COMMENT '用户id',
  `order_sn` varchar(255) DEFAULT '' COMMENT '订单号',
  `memo` varchar(255) DEFAULT '' COMMENT '备注',
  `total_actual_price` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT '实付总价',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='订单';

ALTER TABLE `t_order_1` ADD INDEX(`user_id`) COMMENT 'for select by user_id';
ALTER TABLE `t_order_1` ADD INDEX(`order_sn`) COMMENT 'for select by order_sn';

-- DROP TABLE IF EXISTS `t_demo_0`;

CREATE TABLE IF NOT EXISTS `t_demo_0` (
  `id` bigint AUTO_INCREMENT,
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `birthday` date NOT NULL COMMENT '出生日期',
  `age` int NOT NULL DEFAULT '18' COMMENT '年龄',
  `class_mater` enum('yes','no') DEFAULT 'no' COMMENT '是否班主任',
  `supper` bit(1) DEFAULT b'1' COMMENT '是否是特级教师',
  `account` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT '账户金额',
  `type` varchar(255) DEFAULT '' COMMENT '类型',
  `memo` varchar(400) DEFAULT '' COMMENT '备注',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='DEMO';

ALTER TABLE `t_demo_0` ADD INDEX(`name`) COMMENT 'for select by name';

-- DROP TABLE IF EXISTS `t_demo_1`;

CREATE TABLE IF NOT EXISTS `t_demo_1` (
  `id` bigint AUTO_INCREMENT,
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `name` varchar(20) NOT NULL DEFAULT '' COMMENT '姓名',
  `birthday` date NOT NULL COMMENT '出生日期',
  `age` int NOT NULL DEFAULT '18' COMMENT '年龄',
  `class_mater` enum('yes','no') DEFAULT 'no' COMMENT '是否班主任',
  `supper` bit(1) DEFAULT b'1' COMMENT '是否是特级教师',
  `account` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT '账户金额',
  `type` varchar(255) DEFAULT '' COMMENT '类型',
  `memo` varchar(400) DEFAULT '' COMMENT '备注',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='DEMO';

ALTER TABLE `t_demo_1` ADD INDEX(`name`) COMMENT 'for select by name';

-- -----------------------------------单表分割线--------------------------------------------------
-- DROP TABLE IF EXISTS `t_teacher`;

CREATE TABLE IF NOT EXISTS `t_teacher` (
  `id` bigint AUTO_INCREMENT,
  `name` varchar(20) NOT NULL DEFAULT 'hehe' COMMENT '姓名',
  `id_card` varchar(18) DEFAULT '' COMMENT '身份证',
  `birthday` date NOT NULL COMMENT '出生日期',
  `birthday_time` datetime COMMENT '出生时间',
  `score` bigint NOT NULL  COMMENT '分数',
  `book` bigint NOT NULL DEFAULT '2' COMMENT '出版的书籍数量',
  `num` int NOT NULL DEFAULT '0' COMMENT '数量',
  `age` int NOT NULL DEFAULT '18' COMMENT '年龄',
  `class_mater` enum('yes','no') DEFAULT 'no' COMMENT '是否班主任',
  `account` decimal(20,2) NOT NULL DEFAULT '0.00'  COMMENT '账户金额',
  `supper` bit(1) DEFAULT b'1' COMMENT '是否是特级教师',
  `version` int DEFAULT 0 COMMENT '乐观锁版本号',
  `create_time` datetime COMMENT '创建时间',
  `create_user_id` bigint COMMENT '创建人id',
  `create_user_name` varchar(32) DEFAULT '' COMMENT '创建人name',
  `update_time` datetime COMMENT '最后修改时间',
  `update_user_id` bigint COMMENT '修改人id',
  `update_user_name` varchar(32) DEFAULT '' COMMENT '修改人name',
  `status` enum ('invalid','normal','deleted','disabled','frozen') DEFAULT 'invalid' COMMENT '状态',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE utf8_general_ci COMMENT='教师测试实体';

ALTER TABLE `t_teacher` ADD INDEX(`id_card`) COMMENT 'for select by id_card';
ALTER TABLE `t_teacher` ADD INDEX(`name`) COMMENT 'for select by name';
