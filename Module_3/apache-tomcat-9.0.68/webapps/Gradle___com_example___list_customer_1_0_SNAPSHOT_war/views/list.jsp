<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 21/10/2022
  Time: 7:31 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
<h1 style="text-align: center">Danh sách khách hàng</h1>
<table border="1">
    <tr>
        <th>Name</th>
        <th>Birthday</th>
        <th>Address</th>
        <th>Image</th>
    </tr>
    <c:forEach var="customer" items="${customerList}">
        <tr>
            <td>${customer.getName}</td>
            <td>${customer.getBirthday}</td>
            <td>${customer.getAddress}</td>
            <td>${customer.getImage}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
