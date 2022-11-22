<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Currency convert</title>
</head>
<body>
<h1>Currency convert</h1>
<form method="get" action="/convert">
  <p>Pls input your USD want to exchange. Rate: 1 USD = 24,857 VND</p>
  <input type="number" name="usd" placeholder="input usd">
    <input type="submit">
</form>
<c:if test="${not empty vnd}">
  <p>Result is: ${vnd}</p>
</c:if>

</body>
</html>
