<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24/10/2022
  Time: 7:51 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Find product by name</title>
</head>
<body>
<h4>Result of find by name</h4>
<c:if test="${empty ProductsToFind}">
    <p>Wrong name of products</p>
</c:if>
<c:if test="${not empty ProductsToFind}">
    <table style="border: solid">
        <tr>
            <th>ID</th>
            <th>Name</th>
            <th>Price</th>
            <th>Description</th>
            <th>Manufacture</th>
        </tr>
        <c:forEach var="product" items="${ProductsToFind}">
            <tr>
                <td>${product.getId()}</td>
                <td>${product.getName()}</td>
                <td>${product.getPrice()}</td>
                <td>${product.getDescription()}</td>
                <td>${product.getManufacture()}</td>
            </tr>
        </c:forEach>
    </table>
</c:if>

<h4><a href="/index.jsp">Back to home</a></h4>
</body>
</html>
