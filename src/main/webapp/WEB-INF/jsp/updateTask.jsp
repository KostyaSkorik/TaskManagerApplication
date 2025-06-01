<%--
  Created by IntelliJ IDEA.
  User: kostya-skorik
  Date: 6/1/25
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>updateTask</title>
</head>
<body>
    <h2>${pageContext.findAttribute('user').getUsername()}</h2>
    <h3>Task Id = ${param.taskId}</h3>
</body>
</html>
