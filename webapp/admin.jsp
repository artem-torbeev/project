<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List</title>
    <style>
        table {
            width: 600px; /* Ширина таблицы */
            border: 4px double black; /* Рамка вокруг таблицы */
            border-collapse: collapse; /* Отображать только одинарные линии */
        }
        th, td {
            text-align: left; /* Выравнивание по левому краю */
            padding: 5px; /* Поля вокруг содержимого ячеек */
            border: 1px solid black; /* Граница вокруг ячеек */
        }
    </style>
</head>
<body>

<h2>Все пользователи</h2>

<table>
    <tr>
        <th>Имя</th>
        <th>Фамилия</th>
        <th>Email</th>
        <th>Action</th>
    </tr>

    <c:forEach var="user" items="${listUser}">
    <tr>
        <td><i><c:out value="${user.name}"/></i></td>
        <td><i><c:out value="${user.lastname}"/></i></td>
        <td><i><c:out value="${user.email}"/></i></td>
        <td>
            <a href="${pageContext.servletContext.contextPath}/admin/edit?id=<c:out value='${user.id}' />">Edit</a>
            <a href="${pageContext.servletContext.contextPath}/delete?id=<c:out value='${user.id}' />">Delete</a>
        </td>
    </tr>
    </c:forEach>
</table>

    <p><b><a href="${pageContext.servletContext.contextPath}/admin/create">Create</a></b></p>

    <%--<p><i>Имя: <c:out value="${Message}"/></i></p>--%>
    <%--${pageContext.servletContext.contextPath}/edit--%>

</body>
</html>
