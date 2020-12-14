# Mybatis配置文件结构详解

	<configuration>
    <!-- typeAliases标签用于设置别名,避免写全限定的类名 -->
    	<typeAliases>
        	<!-- 这种方式可以用来批量别名定义，扫描整个包下的类，别名为类名（首字母大写或小写都可以） -->
        	<!-- name用于指定要配置别名的包，指定后，该包下的实体类都会注册别名，并且类名就是别名，不再区分大小写 -->
        	<package name="com.zbc.mybatis"/>
    	</typeAliases>
    	<!-- environments标签用于数据配置设置，可配置多个environment，default用于指定默认配置 -->
	    <environments default="development">
    	    <!-- environment可以配置事务管理器和数据源，id用来标识配置 -->
   			<environment id="development">
            	<!-- 指定使用的事务管理器为JDBC -->
            	<transactionManager type="JDBC"/>
            	<!-- 标识使用的数据源，pooled是PooledDataSourceFactory.class的别名，数据库连接池 -->
            	<dataSource type="POOLED">
                	<!-- 数据库基础信息：驱动，url，账号，密码 -->
                	<property name="driver" value="com.mysql.jdbc.Driver"/>
                	<property name="url" value="jdbc:mysql://localhost:3306/person?characterEncoding=UTF-8"/>
                	<property name="username" value="root"/>
                	<property name="password" value="@happy2019"/>
            	</dataSource>
        	</environment>
    	</environments>
    	<!-- 指定映射表所在位置 -->
    	<mappers>
        	<mapper resource="com/zbc/mybatis/Category.xml"/>
    	</mappers>
	</configuration>