
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>图书管理系统</title>
    <link rel="stylesheet" href="css/public.css"/>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body>
<!--头部-->
<header class="publicHeader">
    <h1>图书管理系统</h1>

    <div class="publicHeaderR">
        <p><span>下午好！</span><span style="color: #fff21b"> ${name}</span> , 欢迎你！</p>
        <a href="login.jsp">退出</a>
    </div>
</header>

<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li ><a href="/bookList">供应商管理</a></li>
                <li id="active"><a href="/userList">用户管理</a></li>
                <li><a href="/password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>图书管理页面 >> 图书信息查看页面</span>
        </div>
        <div class="providerView">
            <p><strong>书籍编码：</strong><span>${book.bookcode}</span></p>
            <p><strong>书籍名称：</strong><span>${book.bookname}</span></p>
            <p><strong>作者：</strong><span>${book.author}</span></p>
            <p><strong>书籍类型：</strong><span>${book.bookstype}</span></p>
            <p><strong>入馆时间：</strong><span>${book.entrydate}</span></p>
            <p><strong>馆藏地址：</strong><span>${book.location}</span></p>
            <p><strong>书籍状态：</strong><span>${book.bookstatus}</span></p>
            <p><strong>书籍数量：</strong><span>${book.amount}</span></p>
            <a href="javascript:history.go(-1)">返回</a>
        </div>
    </div>
</section>

<script src="js/time.js"></script>

</body>
</html>

