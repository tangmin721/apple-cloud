# 数据库开发规范

## 1.0.0发布之前

> * 所有建表语句都纪录在[dbnames]-create.sql语句中
> * 所有清空数据语句都纪录在[dbnames]-clear.sql语句中

## 1.0.0发布之后

> * 所有建表语句,修改表结构,都纪录在[dbnames]-ddl.sql语句中,并以版本号分割
> * 所有清空数据语句都纪录在[dbnames]-clear.sql语句中
