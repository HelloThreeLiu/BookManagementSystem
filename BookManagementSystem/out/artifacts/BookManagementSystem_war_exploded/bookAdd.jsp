
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
                <li id="active"><a href="/bookList">图书管理</a></li>
                <li><a href="/userList">用户管理</a></li>
                <li><a href="/password.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>图书管理页面 >> 图书添加页面</span>
        </div>
        <div class="providerAdd">
            <form action="/addBookServlet">
                <div>
                    <label for="bookcode">书籍编码：</label>
                    <input type="text" name="bookcode" id="bookcode">
                    <span>*请输入书籍编码</span>
                </div>
                <div>
                    <label for="bookname">书籍名称：</label>
                    <input type="text" name="bookname" id="bookname"/>
                    <span >*请输入书籍名称</span>
                </div>
                <div>
                    <label for="author">作者：</label>
                    <input type="text" name="author" id="author"/>
                    <span>*请输入作者</span>
                </div>
                <div>
                    <label for="bookstype">书籍类型：</label>
                    <input type="text" name="bookstype" id="bookstype"/>
                    <span>*请输入书籍类型</span>
                </div>
                <div>
                    <label for="entrydate">入馆时间：</label>
                    <input type="date" name="entrydate" id="entrydate">
                </div>
                <div>
                    <label for="location">馆藏地址</label>
                    <input type="text" name="location" id="location">
                </div>
                <div>
                    <label >书籍状态：</label>
                    <select name="bookstatus">
                        <option value="可借">可借</option>
                        <option value="已借">已借</option>
                    </select>
                    <span></span>
                </div>
                <div>
                    <label for="amount">书籍数量：</label>
                    <input type="text" name="amount" id="amount"/>
                </div>
                <div class="providerAddBtn">
                    <!--<a href="#">保存</a>-->
                    <!--<a href="userList.html">返回</a>-->
                    <input type="submit" value="保存"/>
                    <input type="button" value="返回" onclick="history.back(-1)"/>
                </div>
            </form>
        </div>

    </div>
</section>

<script src="js/time.js"></script>

</body>
</html>
