<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/11/20
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
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

<shiro:guest>
    <p>shiro guest</p>
</shiro:guest>

<shiro:user>
    <p>shiro user</p>
</shiro:user>

<shiro:authenticated>
    <p>shiro authenticated</p>
</shiro:authenticated>

<shiro:notAuthenticated>
    <p>shiro notAuthenticated</p>
</shiro:notAuthenticated>

</body>
</html>
