<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Dictionary</title>
</head>
<body>
<h1>Dictionary</h1>
<form method="get" action="/translate">
<p>Pls input your English word need to translated</p>
    <input type="text" name="word" placeholder="input here">
    <input type="submit">
</form>
<c:if test="${not empty result}">
<p>Result is: ${result}</p>
</c:if>
</body>
</html>
