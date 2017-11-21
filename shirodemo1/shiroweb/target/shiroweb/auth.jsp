<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

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
