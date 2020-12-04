# sql语法小知识

+ CREATE DATABASE xxx;创建数据库
+ 用USE xxx;来选择数据库
+ 用CREATE TABLE XXX();来创建表
#	
	CREATE TABLE students (
  		id BIGINT AUTO_INCREMENT NOT NULL,
  		name VARCHAR(50) NOT NULL,
  		gender TINYINT(1) NOT NULL,
  		grade INT NOT NULL,
  		score INT NOT NULL,
  		PRIMARY KEY(id)
		) Engine=INNODB DEFAULT CHARSET=UTF8;
name TYPE 创建一列 NOT NULL表示字段不能为空。 PRIMARY KEY(id);创建主键。 最后声明编码方式。

+ ``INSERT INTO students (name, gender, grade, score) VALUES ('小明', 1, 1, 88);``
插入数据。
