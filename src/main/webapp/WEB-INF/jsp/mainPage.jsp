<%--
  Created by IntelliJ IDEA.
  User: kostya-skorik
  Date: 5/13/25
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <style>
        .nice-button {
            display: inline-block;
            padding: 12px 24px;
            background: linear-gradient(135deg, #6e8efb, #a777e3);
            color: white;
            text-decoration: none;
            border-radius: 30px;
            font-weight: 600;
            font-family: 'Segoe UI', sans-serif;
            box-shadow: 0 4px 15px rgba(0,0,0,0.2);
            transition: all 0.3s ease;
            border: none;
            cursor: pointer;
            text-align: center;
        }

        .nice-button:hover {
            background: linear-gradient(135deg, #a777e3, #6e8efb);
            transform: translateY(-2px);
            box-shadow: 0 6px 20px rgba(0,0,0,0.25);
        }

        .nice-button:active {
            transform: translateY(0);
        }
    </style>
</head>
<body>


<h1 style="text-align: center">Hello ${pageContext.findAttribute("user").getUsername()}</h1>
<div style="text-align: center">
    <a href="${pageContext.request.contextPath}/createTask" class="nice-button">
        Create Task
    </a>
</div><br>

<div style="text-align: center">
    <a href="${pageContext.request.contextPath}/showTask" class="nice-button">
        Show Task
    </a>
</div>


</body>
</html>
