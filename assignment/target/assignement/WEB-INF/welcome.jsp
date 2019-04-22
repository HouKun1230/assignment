<%--
  Created by IntelliJ IDEA.
  User: kunhou
  Date: 2019-04-06
  Time: 3:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>User</title>

    <body>
    <h2 class="hello-title">Hello ${name}!</h2>
    <a href="${pageContext.request.contextPath}/user/{id}">Get user</a>
    <a href="${pageContext.request.contextPath}/signup">Create user</a>
    <a href="${pageContext.request.contextPath}/update/{id}">Update user</a>
    <a href="${pageContext.request.contextPath}/delete/{id}">Delete user</a>
</body>

</head>
<body>

</body>
</html>
