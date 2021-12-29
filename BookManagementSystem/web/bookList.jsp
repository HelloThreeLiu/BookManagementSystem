<%@ page import="java.util.List" %>
<%@ page import="com.itlsr.domain.Book" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
                <li><a href="/passwordServlet">密码修改</a></li>
                <li><a href="login.jsp">退出系统</a></li>
            </ul>
        </nav>
    </div>
    <div class="right">
        <div class="location">
            <strong>你现在所在的位置是:</strong>
            <span>图书管理页面</span>
        </div>
        <div class="search">
            <span>图书名称：</span>
            <form action="/bookList">
                <input type="text" value="${bookname}" name="bookname" placeholder="请输入图书的名称"/>
                <input type="submit" value="查询"/>
            </form>
            <a href="bookAdd.jsp">添加书籍</a>
        </div>
        <!--图书操作表格-->
        <table class="providerTable" cellpadding="0" cellspacing="0">
            <tr class="firstTr">
                <th width="10%">图书id</th>
                <th width="10%">图书编码</th>
                <th width="10%">图书名称</th>
                <th width="10%">图书作者</th>
                <th width="10%">图书类型</th>
                <th width="10%">入馆时间</th>
                <th width="10%">馆藏地址</th>
                <th width="10%">借阅状态</th>
                <th width="10%">图书数量</th>
                <th width="10%">操作</th>
            </tr>
            <%--<%
                List<Book> list = (List<Book>) request.getAttribute("list");
                for (int i=0;i<list.size();i++){
            %>--%>
            <c:forEach items="${list}" var="b">
            <tr>
                <td>${b.id}</td>
                <td>${b.bookcode}</td>
                <td>${b.bookname}</td>
                <td>${b.author}</td>
                <td>${b.bookstype}</td>
                <td>${b.entrydate}</td>
                <td>${b.location}</td>
                <td>${b.bookstatus}</td>
                <td>${b.amount}</td>
                <td>
                    <a href="/viewBookServlet?id=${b.id}"><img src="images/read.png" alt="查看" title="查看"/></a>
                    <a href="/searchBook?id=${b.id}"><img src="images/xiugai.png" alt="修改" title="修改"/></a>
                    <a href="javascript:void(0)" class="removeProvider" onclick="a('${b.id}')"><img src="images/schu.png" alt="删除" title="删除"/></a>
                </td>
            </tr>
            </c:forEach>
           <%-- <%
                }
            %>--%>
        </table>

        <div>
            共${page.totalCount}条记录，${page.pageNum}/${page.totalPageCount}页

            <c:if test="${page.pageNum<=1}">
                <a href="javascript:void(0)">上一页</a>
            </c:if>

            <c:if test="${page.pageNum>1}">
                <a href="/bookList?pageNum=${page.pageNum-1}&bookname=${bookname}">上一页</a>
            </c:if>

            <c:forEach begin="1" end="${page.totalPageCount}" var="i">
                <a href="/bookList?pageNum=${i}&bookname=${bookname}">${i}</a>
            </c:forEach>

            <c:if test="${page.pageNum==page.totalPageCount}">
                <a href="javascript:void(0)">下一页</a>
            </c:if>

            <c:if test="${page.pageNum != page.totalPageCount}">
                <a href="/bookList?pageNum=${page.pageNum+1}&bookname=${bookname}">下一页</a>
            </c:if>

        </div>
    </div>
</section>

<!--点击删除按钮后弹出的页面-->
<div class="zhezhao"></div>
<div class="remove" id="removeProv">
    <div class="removerChid">
        <h2>提示</h2>
        <div class="removeMain" >
            <p>你确定要删除该供应商吗？</p>
            <a href="javascript:void(0)" onclick="b()" id="yes">确定</a>
            <a href="#" id="no">取消</a>
        </div>
    </div>
</div>




<script src="js/jquery.js"></script>
<script src="js/js.js"></script>
<script src="js/time.js"></script>
<script>
    var ids;
    function a(id){
        ids=id;
    }
    function b(){
        window.location.href="/deleteBook?id="+ids;
    }
</script>

</body>
</html>