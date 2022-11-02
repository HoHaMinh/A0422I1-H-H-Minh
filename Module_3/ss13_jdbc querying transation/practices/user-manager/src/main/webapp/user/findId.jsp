<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 02/11/2022
  Time: 6:45 PM
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
        Find user by id
      </h2>
    </caption>
    <span>Pls input id of user: </span>
    <input type="number" name="idToFind">
    <input type="text" value="findId" hidden name="action">
    <input type="submit" onclick="show()">
  </form>
</div>
<c:if test="${message != null}">
  <div align="center">
    <h2>
        ${message}
    </h2>
  </div>
</c:if>
<c:if test="${list != null}">
  <div align="center">
    <table border="1" cellpadding="5">
      <caption><h2>List of Users Find By Id</h2></caption>
      <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Email</th>
        <th>Country</th>
        <th>Actions</th>
      </tr>
        <tr>
          <td><c:out value="${list.id}"/></td>
          <td><c:out value="${list.name}"/></td>
          <td><c:out value="${list.email}"/></td>
          <td><c:out value="${list.country}"/></td>
          <td>
            <a href="/user?action=edit&id=${user.id}">Edit</a>
            <a href="/user?action=delete&id=${user.id}">Delete</a>
          </td>
        </tr>
    </table>
  </div>
</c:if>
</body>
</html>
