# sql语法小知识

+ CREATE DATABASE xxx;创建数据库
+ 用USE xxx;来选择数据库
+ 用CREATE TABLE XXX();来创建表
+ 用DROP TABLE XXX;删除表
+ ALTER TABLE 改变表
+ DROP INDEX 删除索引
#	
	CREATE TABLE students (
  		id BIGINT AUTO_INCREMENT NOT NULL,
  		name VARCHAR(50) NOT NULL,
  		gender TINYINT(1) NOT NULL,
  		grade INT NOT NULL,
  		score INT NOT NULL,
  		PRIMARY KEY(id)
		) Engine=INNODB DEFAULT CHARSET=UTF8;
+ name TYPE 创建一列 NOT NULL表示字段不能为空。 PRIMARY KEY(id)：创建主键。 最后声明编码方式。

+ ``INSERT INTO students (name, gender, grade, score) VALUES ('小明', 1, 1, 88);``
插入数据。
+ ``SELECT 列名称 FROM 表名称``从表中选取指定的列，若需要所有列，则列名称用*代替；若需要对筛选出的数据按某一属性排序，则添加`ORDER BY`语句。
+ `SELECT DISTINCT 列名称 FROM 表名称`选出唯一不同的值。
+ 若要在依条件选出某些值，则直接在select语句后添加`WHERE`关键字。**注意：** <>表示不等于，BETWEEN表示在某个范围类，LIKE搜索某种模式，条件还通过AND和OR进行组合。
+ `UPDATE 表名称 SET 列名称 = 新值 WHERE 列名称 = 某值` 用于修改表中的数据，可以同时更新多个列。
+ `DELETE FROM 表名称 WHERE 列名称 = 值`删除表中的某一行；**注意：**`DELETE * FROM table_name`表示删除表中的所有行。