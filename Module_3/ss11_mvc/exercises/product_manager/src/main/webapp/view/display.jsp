<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24/10/2022
  Time: 7:41 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Display list of products</title>
    <style>
        td {
            width: 10em;
            text-align: center;
        }
    </style>
</head>
<body>
<h1 style="text-align: center">List of products</h1>
<table border="1">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacture</th>
    </tr>
    <c:forEach var="product" items="${ProductList}">
        <tr>
            <td>${product.getId()}</td>
            <td>${product.getName()}</td>
            <td>${product.getPrice()}</td>
            <td>${product.getDescription()}</td>
            <td>${product.getManufacture()}</td>
        </tr>
    </c:forEach>
</table>
<h4><a href="/index.jsp">Back to home</a></h4>
</body>
</html>
