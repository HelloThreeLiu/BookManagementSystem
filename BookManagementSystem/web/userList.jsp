<%@ page import="java.util.List" %>
<%@ page import="com.itlsr.domain.User" %><%--
  Created by IntelliJ IDEA.
  User: 刘思睿
  Date: 2021/12/27
  Time: 23:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <a href="login.html">退出</a>
    </div>
</header>
<!--时间-->
<section class="publicTime">
    <span id="time">2015年1月1日 11:11  星期一</span>
    <a href="#">温馨提示：为了能正常浏览，请使用高版本浏览器！（IE10+）</a>
</section>
<!--主体内容-->
<section class="publicMian ">
    <div class="left">
        <h2 class="leftH2"><span class="span1"></span>功能列表 <span></span></h2>
        <nav>
            <ul class="list">
                <li><a href="/bookList">图书管理</a></li>
                <li id="active"><a href="/userList">用户管理</a></li>
                <li><a href="/passwordServlet">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>用户管理页面</span>
        </div>
        <div class="search">
            <span>用户名：</span>
            <form action="/userList">
                <input type="text" value="${username}" name="username" placeholder="请输入用户名"/>
                <input type="submit" value="查询"/>
            </form>
            <a href="userAdd.jsp">添加用户</a>
        </div>
        <!--用户-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">用户编码</th>
                <th width="10%">用户名称</th>
                <th width="10%">用户密码</th>
                <th width="10%">年龄</th>
                <th width="10%">性别</th>
                <th width="10%">电话</th>
                <th width="30%">地址</th>
                <th width="10%">操作</th>
            </tr>
            <%--<%
                List<User> list = (List<User>) request.getAttribute("list");
                for (int i=0;i<list.size();i++){
            %>--%>
            <c:forEach items="${list}" var="u">

            <tr>
                <td>${u.id}</td>
                <td>${u.username}</td>
                <td>${u.password}</td>
                <td>${u.age}</td>
                <td>${u.sex}</td>
                <td>${u.phone}</td>
                <td>${u.address}</td>
                <td>
                    <a href="/viewUserServlet?id=${u.id}"><img src="images/read.png" alt="查看" title="查看"/></a>
                    <a href="/searchUser?id=${u.id}"><img src="images/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="javascript:void(0)" class="removeUser" onclick="a('${u.id}')"><img src="images/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            </c:forEach>

         <%--   <%
                }
            %>--%>
        </table>

        <div>
            共${page.totalCount}条记录，${page.pageNum}/${page.totalPageCount}页

            <c:if test="${page.pageNum<=1}">
                <a href="javascript:void(0)">上一页</a>
            </c:if>

            <c:if test="${page.pageNum>1}">
                <a href="/userList?pageNum=${page.pageNum-1}&username=${username}">上一页</a>
            </c:if>

            <c:forEach begin="1" end="${page.totalPageCount}" var="i">
                <a href="/userList?pageNum=${i}&username=${username}">${i}</a>
            </c:forEach>

            <c:if test="${page.pageNum==page.totalPageCount}">
                <a href="javascript:void(0)">下一页</a>
            </c:if>

            <c:if test="${page.pageNum != page.totalPageCount}">
                <a href="/userList?pageNum=${page.pageNum+1}&username=${username}">下一页</a>
            </c:if>

        </div>

    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeUse">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain">
            <p>你确定要删除该用户吗？</p>
            <a href="javascript:void(0)" onclick="b()" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>

<footer class="footer">
    版权归千锋教育
</footer>

<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script>
    var ids;
    function a(id){
        ids=id;
    }
    function b(){
        window.location.href="/deleteUser?id="+ids;
    }

</script>

</body>
</html>
