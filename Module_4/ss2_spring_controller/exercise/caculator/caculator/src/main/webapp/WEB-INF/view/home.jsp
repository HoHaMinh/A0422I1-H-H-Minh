<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h1>
    Caculator
</h1>
<form method="get" action="/caculate">
    <input type="number" name="number1" step=".01" required>
    <input type="number" name="number2" step=".01" required> <br>
    <button type="submit" value="addition" name="caculate">Addition (+)</button>
    <button type="submit" value="subtraction" name="caculate">Subtraction (-)</button>
    <button type="submit" value="multiplication" name="caculate">Multiplication (X)</button>
    <button type="submit" value="division" name="caculate">Division (/)</button>
</form>
<h4 style="color: blue">Result is: ${result}</h4>
<c:if test="${not empty mess}">
    <p style="color: red">${mess}</p>
</c:if>
</body>
</html>