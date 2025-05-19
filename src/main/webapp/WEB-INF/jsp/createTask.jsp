<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Create Task Form</title>
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
    <h2 class="createTask-heading">Create Task</h2>
    <form action="${pageContext.request.contextPath}/createTask" method="post">
        <label for="title">Title</label>
        <input type="text" id="title" name="title" class="input-field" required><br>

        <label for="description">Description</label>
        <input type="text" id="description" name="description" class="input-field" required><br>

        <label for="status">Status:</label>
        <select name="status" id="status" class="input-field">
            <option value="">--Please choose status</option>
            <c:forEach var="status" items="${requestScope.status}">
                <option value="${status}">${status}</option>
            </c:forEach>
        </select>

        <label for="priority">Priority:</label>
        <select name="priority" id="priority" class="input-field">
            <option value="">--Please choose priority</option>
            <c:forEach var="priority" items="${requestScope.priority}">
                <option value="${priority}">${priority}</option>
            </c:forEach>
        </select>

        <label for="deadline_date">Deadline</label>
        <input type="date" name="deadline_date" id="deadline_date" required><br>

        <input type="submit" value="Create" class="input-field">
    </form>
</div>

</body>
</html>