
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
        <a href="login.html">退出</a>
    </div>
</header>

<!--主体内容-->
<section class="publicMian">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="/bookList">图书管理</a></li>
                <li><a href="/userList">用户管理</a></li>
                <li><a href="/passwordServlet">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <img class="wColck" src="images/clock.jpg" alt=""/>
        <div class="wFont">
            <h2>${name}</h2>
            <p>欢迎来到图书管理系统!</p>
        </div>
    </div>
</section>

<script src="js/time.js"></script>
</body>
</html>