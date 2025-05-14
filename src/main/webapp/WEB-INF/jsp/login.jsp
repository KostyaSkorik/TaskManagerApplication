<%--
  Created by IntelliJ IDEA.
  User: kostya-skorik
  Date: 5/12/25
  Time: 8:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>Login</title>
    <style>
        .login-container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 2px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }

        .login-heading {
            text-align: center;
        }

        .input-field {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }
    </style>
</head>
<body>

<div class="login-container">
    <h2 class="login-heading">Login Form</h2>
    <form action="${pageContext.request.contextPath}/login" method="post">
        <label for="username">Username</label>
        <input type="text" id="username" name="username" class="input-field" required><br>
        <label for="password">Password</label>
        <input type="password" id="password" name="password" class="input-field" required><br>
        <input type="submit" value="Login">
        <a href="${pageContext.request.contextPath}/registration">
            <button type="button">Registration</button>
        </a>
    </form>
    <c:if test="${not empty requestScope.error}">
        <h2 style="color: red" class="login-heading">${requestScope.error}</h2>
    </c:if>
</div>
</body>
</html>
