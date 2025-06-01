<%--
  Created by IntelliJ IDEA.
  User: kostya-skorik
  Date: 6/1/25
  Time: 2:54 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>updateTask</title>

    <style>
        .createTask-container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 2px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }

        .createTask-heading {
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
<div class="createTask-container">
    <h2 class="createTask-heading">Update Task "${param.taskTitle}"</h2>
    <form action="${pageContext.request.contextPath}/updateTask" method=post>
        <input type="hidden" name="taskId" value="${param.taskId}">
        <label for="priority">Priority:</label>
        <select name="priority" id="priority" class="input-field">
            <option value=${param.taskPriority}>${param.taskPriority}</option>
            <c:forEach var="priority" items="${requestScope.priority}">
                <c:if test="${priority ne param.taskPriority}">
                    <option value="${priority}">${priority}</option>
                </c:if>
            </c:forEach>
        </select>
        <label for="status">Status:</label>
        <select name="status" id="status" class="input-field" onchange="checkStatus()" >
            <option value="${param.taskStatus}">${param.taskStatus}</option>
            <c:forEach var="status" items="${requestScope.status}">
                <c:if test="${status ne param.taskStatus}">
                    <option value="${status}">${status}</option>
                </c:if>
            </c:forEach>
        </select>
        <div id="deadline_date_div">
            <label for="deadline_date">Deadline</label>
            <input type="datetime-local" name="deadline_date" id="deadline_date" required><br>
        </div>

        <input type="submit" value="Update" class="input-field">
    </form>
    <c:if test="${not empty requestScope.timeError}">
        <h3 style="color: red">${requestScope.timeError}</h3>
    </c:if>
</div>
<script>
    function checkStatus() {
        const status = document.getElementById('status');
        const secretCodeContainer = document.getElementById('deadline_date_div');

        if ((status.value === 'NEW')  || (status.value === 'IN_PROGRESS')) {
            secretCodeContainer.style.display = 'block';
            document.getElementById('deadline_date').required = true;
        } else {
            secretCodeContainer.style.display = 'none';
            document.getElementById('deadline_date').required = false;
        }
    }
</script>

</body>
</html>
