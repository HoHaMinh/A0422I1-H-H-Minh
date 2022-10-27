<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 24/10/2022
  Time: 7:42 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Edit product</title>
</head>
<body>
<h4>Edit product</h4>
<c:if test="${empty ProductFind}">
    <p>Wrong id of products</p>
</c:if>
<c:if test="${not empty ProductFind}">
    <p>Pls edit information of product</p>
    <form method="post" action="/servlet" id="name">
        <table style="border: solid">
            <tr>
                <th>ID</th>
                <th>Name</th>
                <th>Price</th>
                <th>Description</th>
                <th>Manufacture</th>
            </tr>
            <tr>
                <td><input type="number" name="id" value="${ProductFind.getId()}" hidden></td>
                <td><input type="text" name="name" placeholder="${ProductFind.getName()}"></td>
                <td><input type="number" name="price" placeholder="${ProductFind.getPrice()}"></td>
                <td><input type="text" name="description" placeholder="${ProductFind.getDescription()}"></td>
                <td><input type="text" name="manufacture" placeholder="${ProductFind.getManufacture()}"></td>
            </tr>
        </table>
        <input type="text" name="action" value="edit" hidden>
        <input type="submit">
    </form>
</c:if>


<h4><a href="/index.jsp">Back to home</a></h4>
</body>
</html>
