
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
                <li><a href="updatePassword.jsp">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>书籍管理页面 >> 书籍修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="/updateBook">

                <input type="hidden" name="id" value="${s.id}" />

                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="bookcode">书籍编码：</label>
                    <input type="text" name="bookcode" id="bookcode" value="${s.bookcode}" placeholder="">
                    <span>*</span>
                </div>
                <div>
                    <label for="bookname">书籍编码：</label>
                    <input type="text" name="bookname" id="bookname" value="${s.bookname}" placeholder=""/>
                    <span >*</span>
                </div>
                <div>
                    <label for="author">作者：</label>
                    <input type="text" name="author" id="author" value="${s.author}"  placeholder=""/>
                    <span>*</span>
                </div>
                <div>
                    <label for="bookstype">书籍类型：</label>
                    <input type="text" name="bookstype" id="bookstype"  value="${s.bookstype}" placeholder=""/>
                    <span >*</span>
                </div>
                <div>
                    <label for="entrydate">入馆时间：</label>
                    <input type="date" name="entrydate" id="entrydate" value="${s.entrydate}" placeholder=""/>
                    <span >*</span>
                </div>
                <div>
                    <label for="location">馆藏地址：</label>
                    <input type="text" name="location" id="location" value="${s.location}" placeholder="">
                    <span>*</span>
                </div>
                <div>
                    <label >图书状态：</label>

                    <select name="sex">
                        <option value="可借">可借</option>
                        <option value="已借">已借</option>
                    </select>
                </div>
                <div>
                    <label for="amount">图书数量：</label>
                    <input type="text" name="amount" id="amount" value="${s.amount}" placeholder=""/>
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
