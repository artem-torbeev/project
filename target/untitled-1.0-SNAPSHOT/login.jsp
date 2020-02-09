<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login</title>
</head>
<body>
<h1>Cтраница регистрации</h1>

<form method="post" action="login">
    <br/>Имя:<input type="text" name="name">
    <br/>Пароль:<input type="password" name="password">
    <br/><input type="submit" value="Submit">
</form>

</body>
</html>
