# JDBC
---
### 概述
- jdbc是java datebase connectivity 的缩写，是java标准库自带的java程序访问数据库的标准接口。在java中，不能直接通过TCP连接去访问数据库。必须先编写代码操作JDBC接口。


- 要访问具体的数据库，同时还需要引入厂商的JDBC驱动，就可以通过JDBC接口来访问。
![JDBC_框架](https://raw.githubusercontent.com/baixi123/picture_home/main/JDBC%E7%BB%93%E6%9E%84.png)
- Java标准库自带的JDBC接口其实就是定义了一组接口，而某个具体的JDBC驱动其实就是实现了这些接口的类
- 实际上，一个MySQL的JDBC的驱动就是一个jar包，它本身也是纯Java编写的。我们自己编写的代码只需要引用Java标准库提供的java.sql包下面的相关接口，由此再间接地通过MySQL驱动的jar包通过网络访问MySQL服务器，所有复杂的网络通讯都被封装到JDBC驱动中，因此，Java程序本身只需要引入一个MySQL驱动的jar包就可以正常访问MySQL服务器

---
### JDBC连接
* JDBC连接即是java到数据库的连接（通常为TCP）。
* - JDBC是一些接口规范，不能直接实例化。要实例化的是对应的实现类。**要用哪个数据库，我们就实例化哪个数据库的实现类！**把某个数据库实现了JDBC接口的jar包称为JDBC驱动。在编写项目时直接添加一个maven依赖即可。
* 打开一个Connection时，需要准备URL（由数据库厂商指定格式）、用户名和口令，才能成功连接到数据库。
* MySQL的url格式``jdbc:mysql://<hostname>:<port>/<db>?key1=value1&key2=value2``
<br/>hostname 为IP，port为使用端口（MySQL标准端口为3306），db为数据库名称。
另外可以选择是否使用SSL加密，编码方式（以？传入参数。）
连接代码
#
	// JDBC连接的URL, 不同数据库有不同的格式:
	String JDBC_URL = "jdbc:mysql://localhost:3306/test";
	String JDBC_USER = "root";
	String JDBC_PASSWORD = "password";
	// 获取连接:
	Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD);
	// TODO: 访问数据库...
	// 关闭连接:
	conn.close();

* 使用try (resoure)来自动释放JDBC连接。
#
	try (Connection conn =DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    ...
	}

---
### JDBC查询
1. 通过Connection提供的createStatement()方法创建一个Statement对象，用于执行一个查询；
2. 执行Statement对象提供的executeQuery("SELECT * FROM students")并传入SQL语句，执行查询并获得返回的结果集，使用ResultSet来引用这个结果集；
3. 反复调用ResultSet的next()方法并读取每一行结果。
###### 注意
* rs.next()用于判断是否有下一行记录，如果有，将自动把当前行移动到下一行（**一开始获得ResultSet时当前行不是第一行**）；
* ResultSet获取列时，索引从1开始而不是0；
* 必须根据SELECT的列的对应位置来调用getLong(1)，getString(2)这些方法，否则对应位置的数据类型不对，将报错。
* 使用statement将十分容易导致SQL注入的问题，
所以一般使用PaperStatemen。PaperedStatement使用？作为占位符，并把数据连同SQL本身也传给数据库。

		try (Connection conn = DriverManager.getConnection(JDBC_URL, JDBC_USER, JDBC_PASSWORD)) {
    		try (PreparedStatement ps = conn.prepareStatement("SELECT id, grade, name, gender FROM students WHERE gender=? AND grade=?")) {
        		ps.setObject(1, "M"); // 注意：索引从1开始
        		ps.setObject(2, 3);
        		try (ResultSet rs = ps.executeQuery()) {
            		while (rs.next()) {
                		long id = rs.getLong("id");
                		long grade = rs.getLong("grade");
                		String name = rs.getString("name");
                		String gender = rs.getString("gender");
            		}
        		}
    		}
		}

---