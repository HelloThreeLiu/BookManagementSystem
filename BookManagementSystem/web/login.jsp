
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head lang="en">
    <meta charset="UTF-8">
    <title>系统登录 - 图书管理系统</title>
    <link rel="stylesheet" href="css/style.css"/>
</head>
<body class="login_bg">
<section class="loginBox">
    <header class="loginHeader">
        <h1>图书管理系统</h1>
    </header>
    <section class="loginCont">
        <form class="loginForm" action="/LoginServlet">
            <div class="inputbox">
                <label style="color: #FFFFFF" for="user">用户名：</label>
                <input id="user" type="text" name="username" placeholder="请输入用户名" required/>
            </div>
            <div class="inputbox">
                <label style="color: #ffffff" for="mima">密码：</label>
                <input id="mima" type="password" name="password" placeholder="请输入密码" required/>
            </div>
            <div class="subBtn">
                <input type="submit" value="登录" />
                <input type="reset" value="重置"/>
                <a style="color: #FFFFFF" href="register.jsp">注册</a>
            </div>

        </form>
    </section>
</section>

</body>
</html>
