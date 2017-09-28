-- 创建数据库脚本(如果是inline表达式db_${0..3}表示有db_0,db_1,db_2,db_3四个数据库,创建表的时候得修改下面的db_0) --
-- create database ds0 --
DROP DATABASE IF EXISTS db_0;

CREATE DATABASE db_0 DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE db_0;

-- -------------------------------------------------------------------------------------


