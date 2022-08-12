
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>欢迎注册</title>
    <link href="css/register.css" rel="stylesheet">
</head>
<body>

<div class="form-div">
    <div class="reg-content">
        <h1>欢迎注册</h1>
        <span class="span1">已有帐号？</span> <a class="a1" href="login.jsp">登录</a>
    </div>
    <form id="reg-form" action="/registerServlet" method="post">
        <table>
            <tr>
                <td>用户名</td>
                <td class="inputs">
                    <input name="username" type="text" id="username">
                </td>
            </tr>

            <tr>
                <td>密码</td>
                <td class="inputs">
                    <input name="password" type="password" id="password">
                </td>
            </tr>

            <tr>
                <td>年龄</td>
                <td class="inputs">
                    <input name="age" type="text" id="age">
                </td>
            </tr>

            <tr>
                <td>性别</td>
                <td class="inputs">
                    <input name="sex" type="text" id="sex">
                </td>
            </tr>

            <tr>
                <td>电话</td>
                <td class="inputs">
                    <input name="phone" type="text" id="phone">
                </td>
            </tr>

            <tr>
                <td>地址</td>
                <td class="inputs">
                    <input name="address" type="text" id="address">
                </td>
            </tr>
        </table>

        <div class="buttons">
            <input value="注 册" type="submit" id="reg_btn">
        </div>
        <br class="clear">
    </form>

</div>
</body>
</html>

