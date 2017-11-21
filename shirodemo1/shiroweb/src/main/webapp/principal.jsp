<%@ page import="org.apache.shiro.SecurityUtils" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <p>User ID: <%= SecurityUtils.getSubject().getPrincipals().oneByType(String.class) %></p>

    <p><shiro:principal type="com.wangyu.model.User" property="firstName"></shiro:principal></p>

    <p><shiro:principal type="com.wangyu.model.User" property="lastName"></shiro:principal></p>

</body>
</html>
