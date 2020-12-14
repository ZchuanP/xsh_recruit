# ssm mybatis映射文件注意事项

---
记第一次搭建ssm框架出现的bug

### 配置问题

+ ssm框架中可以将建立数据库连接，配置事务管理器，指定mapper文件配置扫描器，扫描service都交给spring来做。
+ 在mybatis配置文件中进行别名配置，别名配置后最好在其它地方使用到时都用别名。
+ springMVC的配置文件中配置视图解析器，指定扫描的包，配置注解驱动。


### 映射文件规则
1. mapper.xml 文件中的namespace必须指定对应的映射接口。
2. 接口中定义的方法名和映射文件中的映射id必须完全相同。
3. 接口中的方法的具体实现由SQLsession实现
4. 接口中定义的方法的返回值需要和SQL返回匹配，delete，add可以用int，select以定义的pojo类型返回
5. resultType 和resultMap
> +  resultType是直接表示返回类型的，而resultMap则是对外部ResultMap的引用，但是resultType跟resultMap不能同时存在。
+ 



