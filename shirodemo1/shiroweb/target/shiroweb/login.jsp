<%--
  Created by IntelliJ IDEA.
  User: admin
  Date: 2017/11/20
  Time: 14:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
login.jsp
<form action="/login/index.do" method="post">
    <br />用户帐号： <input type="text" name="username" id="username" value="" />
    <br />登录密码： <input type="password" name="password" id="password" value="" /> <br />
    <input type="hidden" name="rememberMe" value="true" />
    <input value="登录" type="submit">
</form>

</body>
</html>
