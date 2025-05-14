<%--
  Created by IntelliJ IDEA.
  User: kostya-skorik
  Date: 5/13/25
  Time: 8:45 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
    <title>Title</title>
</head>
<body>


<h1>${pageContext.findAttribute("user").getUsername()}</h1>


</body>
</html>
