<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>List</title>
  <style>
    table {
      border: 1px solid #000;
    }
    th, td {
      border: 1px dotted #555;
    }
  </style>
</head>
<body>
<p>There are ${requestScope.customers.size()} customer(s) in list.</p>
<table>
  <caption>Customers List</caption>
  <thead>
  <tr>
    <th>Id</th>
    <th>Name</th>
    <th>Email</th>
    <th>Address</th>
  </tr>
  </thead>
  <tbody>
  <c:forEach var="c" items="${requestScope.customers}">
    <tr>
      <td>
        <c:out value="${c.id}"/>
      </td>
      <td>
        <a href="info.jsp?id=${c.id}">${c.name}</a>
      </td>
      <td>
        <c:out value="${c.email}"/>
      </td>
      <td>
        <c:out value="${c.address}"/>
      </td>
    </tr>
  </c:forEach>
  </tbody>
</table>
</body>
</html>
