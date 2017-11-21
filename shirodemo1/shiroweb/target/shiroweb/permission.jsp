<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>

    <shiro:hasPermission name="user:query">
        <p>hasPermission user:query</p>
    </shiro:hasPermission>

    <shiro:lacksPermission name="user">
        <p>lacksPermission user</p>
    </shiro:lacksPermission>

</body>
</html>
