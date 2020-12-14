# Mybatis XML映射文件

##基础CRUD

---
### select标签
	<select id="selectPerson" parameterType="int" resultType="hashmap">
  	SELECT * FROM PERSON WHERE ID = #{id}
	</select>
上述示例，就是根据id查询person表中的一行。<br>
参数符号`#{id}`告诉Mybatis创建一个预处理语句参数。

### update标签
	<update id="updateAuthor">
  	  update Author set
    	username = #{username},
    	password = #{password},
    	email = #{email},
    	bio = #{bio}
  	  where id = #{id}
	</update>
**注意：update时所写的字段若没有对应的输入若设置了该列不能会null则会报错，否则会变为null**


### delete标签
	<delete id="deleteAuthor">
  		delete from Author where id = #{id}
	</delete>

### insert标签

	<insert id="insertAuthor">
  	  insert into Author (id,username,password,email,bio)
  	  values (#{id},#{username},#{password},#{email},#{bio})
	</insert> 

#### 常用标签属性
+ `id` 在命名空间的唯一的标识符，用来引用这条语句
+ `parameterType` （可选）传入这条语句的参数的类全限定名或别名。MyBatis 可以通过类型处理器（TypeHandler）推断出具体传入语句的参数，默认值为未设置（unset）。
+ `resultType` 期望从这条语句中返回结果的类全限定名或别名。**如果返回的是集合，那应该设置为集合包含的类型，而不是集合本身的类型。**
+ `resultMap` 对外部 resultMap 的命名引用。**resultType 和 resultMap 之间只能同时使用一个。**
+ `timeout` 这个设置是在抛出异常之前，驱动程序等待数据库返回请求结果的秒数。默认值为未设置（unset）（依赖数据库驱动）。
+ `fetchSize` 这是一个给驱动的建议值，尝试让驱动程序每次批量返回的结果行数等于这个设置值。 默认值为未设置（unset）（依赖驱动）
+ `flushCache` 将其设置为 true 后，只要语句被调用，都会导致本地缓存和二级缓存被清空，默认值：（对 insert、update 和 delete 语句）true。


#### 当需要使用其它标签属性时：
## [查询资料](https://mybatis.org/mybatis-3/zh/sqlmap-xml.html )