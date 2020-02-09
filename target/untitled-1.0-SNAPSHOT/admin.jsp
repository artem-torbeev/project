<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<html>
<head>
    <title>List</title>
</head>
<body>

<h2>Все пользователи</h2>

<c:forEach var="user" items="${listUser}">

    <p><i>Имя: <c:out value="${user.name}"/></i></p>

    <p><i>Фамилия: <c:out value="${user.lastname}"/></i></p>

    <p><i>Email: <c:out value="${user.email}"/></i></p>

    <p><b><a href="${pageContext.servletContext.contextPath}/admin/edit?id=<c:out value='${user.id}' />">Edit</a></b></p>

    <p><b><a href="${pageContext.servletContext.contextPath}/delete?id=<c:out value='${user.id}' />">Delete</a></b></p>

</c:forEach>

<p><b><a href="${pageContext.servletContext.contextPath}/admin/create">Create</a></b></p>

<%--<p><i>Имя: <c:out value="${Message}"/></i></p>--%>
<%--${pageContext.servletContext.contextPath}/edit--%>

</body>
</html>
