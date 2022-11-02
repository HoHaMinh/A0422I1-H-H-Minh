<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 31/10/2022
  Time: 12:38 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
         pageEncoding="UTF-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <title>User Management Application</title>
</head>
<body>
<center>
    <h1>User Management</h1>
    <h2>
        <a href="user?action=user">List All Users</a>
    </h2>
</center>
<div align="center">
    <form method="post">
        <caption>
            <h2>
                Find user by country
            </h2>
        </caption>
        <span>Pls input name of country: </span>
        <input type="text" name="countryToFind">
        <input type="text" value="findCountry" hidden name="action">
        <input type="submit">
    </form>
</div>
<c:if test="${list != null}">
    <div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of Users Find By Country</h2></caption>
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Email</th>
                <th>Country</th>
                <th>Actions</th>
            </tr>
            <c:forEach var="user" items="${list}">
                <tr>
                    <td><c:out value="${user.id}"/></td>
                    <td><c:out value="${user.name}"/></td>
                    <td><c:out value="${user.email}"/></td>
                    <td><c:out value="${user.country}"/></td>
                    <td>
                        <a href="/user?action=edit&id=${user.id}">Edit</a>
                        <a href="/user?action=delete&id=${user.id}">Delete</a>
                    </td>
                </tr>
            </c:forEach>
        </table>
    </div>
</c:if>
</body>
</html>
