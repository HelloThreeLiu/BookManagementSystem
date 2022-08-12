# BookManagementSystem（图书管理系统）

这只是一次javaweb项目练手，结构不复杂，功能很简单，主要是用来了解web开发的三层结构，还有部分功能没有完成。且前端部分JSP，CSS，JS等都是借用的模板。

## 一、设计题目及要求

**题目**：图书管理系统

**要求**：设计一个图书管理系统，实现登录，用户管理，图书管理，修改密码等功能。

## 二、开发环境

* 操作系统版本：Windows 10
* java环境: Jdk1.8
* IDE: Jetbrains Idea 2021.2
* 数据库:mysql8.0
* 数据库图形化界面工具：Navicat Premium
* 服务器：Tomcat9.0.54
* 浏览器：Microsoft edge

## 三、软件架构

本系统为javaweb工程，采用servlet，JSP，CSS，JS等开发，以mysql数据库作为数据源存储数据，servlet来实现前后台和数据库之间的数据交互。结构不复杂，就是最基本的Dao（持久层）、Service（业务层）、web（视图展现层）三层架构。功能也很简单，用户的登录，退出，用户信息的增删改查，书籍信息的增删改查。本项目不是maven项目，所以需要导入jar包

## 四、功能简介

* 登录功能
* 注册功能（新增）
* 用户信息管理功能
* * 用户信息查询（模糊查询，全部查询）并分页 显示
  * 用户信息增添
  * 用户信息修改
  * 用户信息删除
* 图书信息管理功能
* * 图书信息查询（模糊查询，全部查询）并分页 显示
  * 图书信息增添
  * 图书信息修改
  * 图书信息删除
* 修改密码（已完成）
* 退出系统

## 五、数据库设计

本系统只有两张表，user（用户表）、book（书籍表）。

user表设计（用户id、用户名称、用户密码、用户年龄、用户性别、用户手机、居住地址）

|    名    |  类型   | 长度 | 小数点 | 不是null | 主键  |
| :------: | :-----: | :--: | :----: | :------: | :---: |
|    id    |   int   |  0   |   0    |    √     | 主键1 |
| username | varchar | 255  |   0    |          |       |
| password | varchar | 255  |   0    |          |       |
|   age    |   int   |  0   |   0    |          |       |
|   sex    | varchar | 255  |   0    |          |       |
|  phone   | varchar | 255  |   0    |          |       |
| address  | varchar | 255  |   0    |          |       |

SQL语句：

```sql
CREATE TABLE `user` (
  `id` int NOT NULL AUTO_INCREMENT,
  `username` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `password` varchar(255) DEFAULT NULL,
  `age` int DEFAULT NULL,
  `sex` varchar(255) DEFAULT NULL,
  `phone` varchar(255) DEFAULT NULL,
  `address` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=13 DEFAULT CHARSET=utf8mb3;
```

book表设计（图书id、图书编码、图书名称、作者、图书类型、入馆时间、馆藏地址、图书状态、图书数量）

|     名     |  类型   | 长度 | 小数点 | 不是null | 主键  |
| :--------: | :-----: | :--: | :----: | :------: | :---: |
|     id     |   int   |  0   |   0    |    √     | 主键1 |
|  bookcode  | varchar | 255  |   0    |          |       |
|  bookname  | varchar | 255  |   0    |          |       |
|   author   | varchar | 255  |   0    |          |       |
| bookstype  | varchar | 255  |   0    |          |       |
| entrydate  |  date   |  0   |   0    |          |       |
|  location  | varchar | 255  |   0    |          |       |
| bookstatus | varchar | 255  |   0    |          |       |
|   amount   | varchar | 255  |   0    |          |       |

SQL语句：

```sql
CREATE TABLE `book` (
  `id` int NOT NULL AUTO_INCREMENT,
  `bookcode` varchar(255) DEFAULT NULL,
  `bookname` varchar(255) DEFAULT NULL,
  `author` varchar(255) DEFAULT NULL,
  `bookstype` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `entrydate` date DEFAULT NULL,
  `location` varchar(255) DEFAULT NULL,
  `bookstatus` varchar(255) CHARACTER SET utf8 COLLATE utf8_general_ci DEFAULT NULL,
  `amount` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=utf8mb3;
```

## 六、安装配置

1. 通过navicat新建数据库bookmanagement，将bookmanagement.sql文件导入；
2. 修改BaseDao.java，将数据库名称，端口号，版本等更改为与自己的数据库一致，我用的mysql8.0，用mysql5.0还需导入jar包；
3. 启动，链接数据库；
4. 项目发布到Tomcat中，启动Tomcat**（这里Tomcat换成自己的版本）**；
5. 登录，登录账户可查看数据库表；



