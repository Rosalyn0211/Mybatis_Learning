# Mybatis_Learning
### 目录
 - 第一天：  
 mybatis入门  
 mybatis的概述  
 mybatis的环境搭建  
 mybatis入门案例
	自定义mybatis框架（了解mybatis中执行细节）
 - 第二天：  
 mybatis基本使用  
 mybatis的单表crud操作  
 mybatis的参数和返回值  
 mybatis的dao编写  
 mybatis配置的细节  
 几个标签的使用
 - 第三天：  
 mybatis的深入和多表  
 mybatis的连接池  
 mybatis的事务控制及设计的方法  
 mybatis的多表查询 一对多（多对一）多对多
- 第四天：  
mybatis的缓存和注解开发  
mybatis中的加载时机（查询的时机）  
mybatis中的一级缓存和二级缓存  
mybatis的注解开发  
单表CRUD  
多表查询

### day01笔记
```
1、什么是框架？
	它是我们软件开发中的一套解决方案，不同的框架解决的是不同的问题。
	使用框架的好处：
		框架封装了很多的细节，使开发者可以使用极简的方式实现功能。大大提高开发效率。
2、三层架构
	表现层：
		是用于展示数据的
	业务层：
		是处理业务需求
	持久层：
		是和数据库交互的
3、持久层技术解决方案
	JDBC技术：
		Connection
		PreparedStatement
		ResultSet
	Spring的JdbcTemplate：
		Spring中对jdbc的简单封装
	Apache的DBUtils：
		它和Spring的JdbcTemplate很像，也是对Jdbc的简单封装

	以上这些都不是框架
		JDBC是规范
		Spring的JdbcTemplate和Apache的DBUtils都只是工具类

4、mybatis的概述
	mybatis是一个持久层框架，用java编写的。
	它封装了jdbc操作的很多细节，使开发者只需要关注sql语句本身，而无需关注注册驱动，创建连接等繁杂过程
	它使用了ORM思想实现了结果集的封装。

	ORM：
		Object Relational Mappging 对象关系映射
		简单的说：
			就是把数据库表和实体类及实体类的属性对应起来
			让我们可以操作实体类就实现操作数据库表。

			user			User
			id			userId
			user_name		userName
	今天我们需要做到
		实体类中的属性和数据库表的字段名称保持一致。
			user			User
			id			id
			user_name		user_name
5、mybatis的入门
	mybatis的环境搭建
		第一步：创建maven工程并导入坐标
		第二步：创建实体类和dao的接口
		第三步：创建Mybatis的主配置文件
				SqlMapConifg.xml
		第四步：创建映射配置文件
				IUserDao.xml
	环境搭建的注意事项：
		第一个：创建IUserDao.xml 和 IUserDao.java时名称是为了和我们之前的知识保持一致。
			在Mybatis中它把持久层的操作接口名称和映射文件也叫做：Mapper
			所以：IUserDao 和 IUserMapper是一样的
		第二个：在idea中创建目录的时候，它和包是不一样的
			包在创建时：com.itheima.dao它是三级结构
			目录在创建时：com.itheima.dao是一级目录
		第三个：mybatis的映射配置文件位置必须和dao接口的包结构相同
		第四个：映射配置文件的mapper标签namespace属性的取值必须是dao接口的全限定类名
		第五个：映射配置文件的操作配置（select），id属性的取值必须是dao接口的方法名

		当我们遵从了第三，四，五点之后，我们在开发中就无须再写dao的实现类。
	mybatis的入门案例
		第一步：读取配置文件
		第二步：创建SqlSessionFactory工厂
		第三步：创建SqlSession
		第四步：创建Dao接口的代理对象
		第五步：执行dao中的方法
		第六步：释放资源

		注意事项：
			不要忘记在映射配置中告知mybatis要封装到哪个实体类中
			配置的方式：指定实体类的全限定类名
		
		mybatis基于注解的入门案例：
			把IUserDao.xml移除，在dao接口的方法上使用@Select注解，并且指定SQL语句
			同时需要在SqlMapConfig.xml中的mapper配置时，使用class属性指定dao接口的全限定类名。
	明确：
		我们在实际开发中，都是越简便越好，所以都是采用不写dao实现类的方式。
		不管使用XML还是注解配置。
		但是Mybatis它是支持写dao实现类的。

6、自定义Mybatis的分析：
	mybatis在使用代理dao的方式实现增删改查时做什么事呢？
		只有两件事：
			第一：创建代理对象
			第二：在代理对象中调用selectList
		
	自定义mybatis能通过入门案例看到类
		class Resources
		class SqlSessionFactoryBuilder
		interface SqlSessionFactory
		interface SqlSession
```
### day02 笔记
```
1、回顾mybatis自定义和环境搭建+完善自定义Mybatis的注解开发
2、Mybatis基于代理Dao的CRUD操作					重点内容
3、CRUD中可能遇到的问题：参数的传递以及返回值的封装
4、介绍Mybatis基于传统dao方式的使用（自己编写dao的实现类）	了解的内容
5、mybatis主配置文件中的常用配置
	properties标签
	typeAliases标签				---解释Integer的写法
	mappers标签的子标签：package

-----------------------------------------
OGNL表达式：
	Object Graphic Navigation Language
	对象	图	导航	   语言
	
	它是通过对象的取值方法来获取数据。在写法上把get给省略了。
	比如：我们获取用户的名称
		类中的写法：user.getUsername();
		OGNL表达式写法：user.username
	mybatis中为什么能直接写username,而不用user.呢：
		因为在parameterType中已经提供了属性所属的类，所以此时不需要写对象名
```
### day03 笔记
```
1、mybatis中的连接池以及事务控制			原理部分了解，应用部分会用
	mybatis中连接池使用及分析
	mybatis事务控制的分析
2、mybatis基于XML配置的动态SQL语句使用		会用即可
	mappers配置文件中的几个标签：
		<if>
		<where>
		<foreach>
		<sql>
3、mybatis中的多表操作				掌握应用
	一对多
	一对一（？）
	多对多
--------------------------------------------------------------------------------
1、连接池：
	我们在实际开发中都会使用连接池。
	因为它可以减少我们获取连接所消耗的时间。
2、mybatis中的连接池
	mybatis连接池提供了3种方式的配置：
		配置的位置：
			主配置文件SqlMapConfig.xml中的dataSource标签，type属性就是表示采用何种连接池方式。
		type属性的取值：
			POOLED	 采用传统的javax.sql.DataSource规范中的连接池，mybatis中有针对规范的实现
			UNPOOLED 采用传统的获取连接的方式，虽然也实现Javax.sql.DataSource接口，但是并没有使用池的思想。
			JNDI	 采用服务器提供的JNDI技术实现，来获取DataSource对象，不同的服务器所能拿到DataSource是不一样。
				 注意：如果不是web或者maven的war工程，是不能使用的。
				 我们课程中使用的是tomcat服务器，采用连接池就是dbcp连接池。
3、mybatis中的事务
	什么是事务
	事务的四大特性ACID
	不考虑隔离性会产生的3个问题
	解决办法：四种隔离级别

	它是通过sqlsession对象的commit方法和rollback方法实现事务的提交和回滚
4、mybatis中的多表查询
	表之间的关系有几种：
		一对多
		多对一
		一对一
		多对多
	举例：
		用户和订单就是一对多
		订单和用户就是多对一
			一个用户可以下多个订单
			多个订单属于同一个用户

		人和身份证号就是一对一
			一个人只能有一个身份证号
			一个身份证号只能属于一个人

		老师和学生之间就是多对多
			一个学生可以被多个老师教过
			一个老师可以交多个学生
	特例：
		如果拿出每一个订单，他都只能属于一个用户。
		所以Mybatis就把多对一看成了一对一。
	
	mybatis中的多表查询：
		示例：用户和账户
			一个用户可以有多个账户
			一个账户只能属于一个用户（多个账户也可以属于同一个用户）
		步骤：
			1、建立两张表：用户表，账户表
				让用户表和账户表之间具备一对多的关系：需要使用外键在账户表中添加
			2、建立两个实体类：用户实体类和账户实体类
				让用户和账户的实体类能体现出来一对多的关系
			3、建立两个配置文件
				用户的配置文件
				账户的配置文件
			4、实现配置：
				当我们查询用户时，可以同时得到用户下所包含的账户信息
				当我们查询账户时，可以同时得到账户的所属用户信息

		示例：用户和角色
			一个用户可以有多个角色
			一个角色可以赋予多个用户
		步骤：
			1、建立两张表：用户表，角色表
				让用户表和角色表具有多对多的关系。需要使用中间表，中间表中包含各自的主键，在中间表中是外键。
			2、建立两个实体类：用户实体类和角色实体类
				让用户和角色的实体类能体现出来多对多的关系
				各自包含对方一个集合引用
			3、建立两个配置文件
				用户的配置文件
				角色的配置文件
			4、实现配置：
				当我们查询用户时，可以同时得到用户所包含的角色信息
				当我们查询角色时，可以同时得到角色的所赋予的用户信息
```
