<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24/10/2022
  Time: 7:49 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Show detailed of a product</title>
</head>
<body>
<h4>Detailed product by id</h4>
<table style="border: solid">
    <tr>
        <th>ID</th>
        <th>Name</th>
        <th>Price</th>
        <th>Description</th>
        <th>Manufacture</th>
    </tr>
    <tr>
        <td>${ProductFind.getId()}</td>
        <td>${ProductFind.getName()}</td>
        <td>${ProductFind.getPrice()}</td>
        <td>${ProductFind.getDescription()}</td>
        <td>${ProductFind.getManufacture()}</td>
    </tr>
</table>
<h4><a href="/index.jsp">Back to home</a></h4>
</body>
</html>
