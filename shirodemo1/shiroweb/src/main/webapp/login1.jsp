<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>

<html>
<head>
    <title>Title</title>
</head>
<body>
login1.jsp
<form action="/login/index1.do" method="post">
    <br />用户帐号： <input type="text" name="username1" id="username" value="" />
    <br />登录密码： <input type="password" name="password1" id="password" value="" /> <br />
    <input type="hidden" name="rememberMe1" value="true" />
    <input value="登录" type="submit">
</form>

</body>
</html>
