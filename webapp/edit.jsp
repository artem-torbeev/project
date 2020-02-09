<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>Edit</title>
</head>
<body>

<p><i>Имя: <c:out value="${user.name}"/></i></p>

<p><i>Фамилия: <c:out value="${user.lastname}"/></i></p>

<p><i>Email: <c:out value="${user.email}"/></i></p>

<form method="post" action="edit">

    <p><i>Имя: <label>
        <input type="text" name="name">
    </label></i></p>
    <p><i>Фомилия: <label>
        <input type="text" name="lastname">
    </label></i></p>
    <p><i>Email: <label>
        <input type="text" name="email">
    </label></i></p>

    <input type="hidden" name="id" value="<c:out value='${user.id}' />"/>
    <p><b><input type="submit" value="Edit"/></b></p>

</form>

</body>
</html>
