-- create database remember_me--
-- DROP DATABASE IF EXISTS remember_me;

CREATE DATABASE remember_me DEFAULT CHARACTER SET utf8 COLLATE utf8_general_ci;

USE remember_me;

create table IF NOT EXISTS persistent_logins ( username varchar(64) not null, series varchar(64) primary key, token varchar(64) not null, last_used timestamp not null)
