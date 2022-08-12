
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
            <span>用户管理页面 >> 用户修改页面</span>
        </div>
        <div class="providerAdd">
            <form action="/updateUser">

                <input type="hidden" name="id" value="${s.id}" />

                <!--div的class 为error是验证错误，ok是验证成功-->
                <div>
                    <label for="username">用户名称：</label>
                    <input type="text" name="username" id="username" value="${s.username}" placeholder="韩露"/>
                    <span >*</span>
                </div>

                <div>
                    <label for="password">用户密码：</label>
                    <input type="text" name="password" id="password" value="${s.password}" placeholder="12345"/>
                    <span>*</span>
                </div>

                <div>
                    <label >用户性别：</label>

                    <select name="sex">
                        <option value="男">男</option>
                        <option value="女">女</option>
                    </select>
                </div>
                <div>
                    <label for="age">年龄：</label>
                    <input type="text" name="age" id="age"  value="${s.age}" placeholder="18"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="phone">用户电话：</label>
                    <input type="text" name="phone" id="phone" value="${s.phone}" placeholder="13533667897"/>
                    <span >*</span>
                </div>
                <div>
                    <label for="address">用户地址：</label>
                    <input type="text" name="address" id="address" value="${s.address}" placeholder="北京"/>
                </div>
               <%-- <div>
                    <label >用户类别：</label>
                    <input type="radio" name="userlei" value="1"  <c:if test="${s.userRole==1}">checked</c:if>/>管理员
                    <input type="radio" name="userlei" value="2" <c:if test="${s.userRole==2}">checked</c:if>/>经理
                    <input type="radio" name="userlei" value="3" <c:if test="${s.userRole==3}">checked</c:if>/>普通用户

                </div>--%>
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