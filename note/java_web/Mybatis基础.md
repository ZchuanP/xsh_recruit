# Mybatis基础
---
### 程序结构
![](https://imgconvert.csdnimg.cn/aHR0cDovL3R2YTEuc2luYWltZy5jbi9sYXJnZS8wMDdYOG9sVmx5MWc4ZG1qdXE3N2VqMzByYjBlaHQ5by5qcGc?x-oss-process=image/format,png)

---
### mybatis核心工作

+ 按照JDBC规范建立和数据库的连接并进行管理
+ 利用反射处理java对象和数据库数据之间的转换

---
### mybatis配置使用过程
#### 构造交互环境
+ 类似于网络请求，mybatis应用也是先构建好交互环境，在环境中分为会话信息，最后交换数据。
> 每个基于 MyBatis 的应用都是以一个 SqlSessionFactory 的实例为核心的。SqlSessionFactory 的实例可以通过 SqlSessionFactoryBuilder 获得。而 SqlSessionFactoryBuilder 则可以从 XML 配置文件或一个预先定制的 Configuration 的实例构建出 SqlSessionFactory 的实例。

+  这段话的意思即是会话所基于的环境的配置信息，需要通过解析预先配置后生成，SQLSessionFactory就可以当做是环境。

> 构造Factory的方法
> > 使用类路径下的资源文件（xml）进行配置<br>
``String resource = "org/mybatis/example/mybatis-config.xml";``<br>
``InputStream inputStream = Resources.getResourceAsStream(resource);``<br>
``SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);``
<br/>XML 配置文件中包含了对 MyBatis 系统的核心设置，包括获取数据库连接实例的数据源（DataSource）以及决定事务作用域和控制方式的事务管理器（TransactionManager）

+ 注意
> SqlSessionFactory 一旦被创建就应该在应用的运行期间一直存在，没有任何理由丢弃它或重新创建另一个实例。… 因此 SqlSessionFactory 的最佳作用域是应用作用域。(一般使用单例模式来实现这一目的)<br>
> SqlSessionFactoryBuilder类的生命周期：创建SqlSessionFactory后便不再需要它，所以最好让它成为局部的类。<br>

#### 会话构建
 每个线程都应该有它自己的 SqlSession 实例。SqlSession 的实例不是线程安全的，因此是不能被共享的，所以它的最佳的作用域是请求或方法作用域
#	
	try (SqlSession session = sqlSessionFactory.openSession()) {
	  // 应用逻辑代码
	}

