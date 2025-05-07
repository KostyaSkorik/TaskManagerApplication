<%@ page contentType="text/html;charset=UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Registration Form</title>
    <style>
        .registration-container {
            width: 600px;
            margin: 0 auto;
            padding: 20px;
            border: 2px solid #ccc;
            border-radius: 10px;
            background-color: #f9f9f9;
        }
        .registration-heading {
            text-align: center;
        }
        .input-field {
            width: 100%;
            padding: 8px;
            margin: 5px 0;
            box-sizing: border-box;
        }
        #secretCodeContainer {
            display: none;
            margin-top: 10px;
        }
    </style>
</head>
<body>

<div class="registration-container">
    <h2 class="registration-heading">Registration Form</h2>
    <form action="${pageContext.request.contextPath}/registration" method="post">
        <label for="username">UserName:</label>
        <input type="text" id="username" name="username" class="input-field" required><br>

        <label for="email">Email:</label>
        <input type="email" id="email" name="email" class="input-field" required><br>

        <label for="password">Password:</label>
        <input type="password" id="password" name="password" class="input-field" required><br>

        <label for="roleSelect">Role:</label>
        <select name="role" id="roleSelect" class="input-field" onchange="checkRole()">
            <option value="">--Please choose role--</option>
            <c:forEach var="role" items="${requestScope.roles}">
                <option value="${role}">${role}</option>
            </c:forEach>
        </select>

        <div id="secretCodeContainer">
            <label for="secretCode">Secret Code (for ADMIN only):</label>
            <input type="password" id="secretCode" name="secretCode" class="input-field">
        </div>

        <input type="submit" value="Register" class="input-field">
    </form>
</div>

<script>
    function checkRole() {
        const roleSelect = document.getElementById('roleSelect');
        const secretCodeContainer = document.getElementById('secretCodeContainer');

        if (roleSelect.value === 'ADMIN') {
            secretCodeContainer.style.display = 'block';
            document.getElementById('secretCode').required = true;
        } else {
            secretCodeContainer.style.display = 'none';
            document.getElementById('secretCode').required = false;
        }
    }

    // Вызываем при загрузке страницы на случай, если форма перезагружается с ошибкой
    document.addEventListener('DOMContentLoaded', function() {
        checkRole();
    });
</script>

</body>
</html>