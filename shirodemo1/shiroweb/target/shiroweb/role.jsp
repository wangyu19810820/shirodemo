<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="shiro" uri="http://shiro.apache.org/tags" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <shiro:hasRole name="goodguy">
        <p>has role goodguy</p>
    </shiro:hasRole>

    <shiro:lacksRole name="goodguy">
        <p>no role goodguy</p>
    </shiro:lacksRole>

    <shiro:lacksRole name="abc">
        <p>no role abc</p>
    </shiro:lacksRole>

    <shiro:hasAnyRoles name="goodguy,abc">
        <p>hasAnyRoles goodguy,abc</p>
    </shiro:hasAnyRoles>

    <shiro:hasAnyRoles name="abc,xyz">
        <p>hasAnyRoles abc,xyz</p>
    </shiro:hasAnyRoles>

</body>
</html>
