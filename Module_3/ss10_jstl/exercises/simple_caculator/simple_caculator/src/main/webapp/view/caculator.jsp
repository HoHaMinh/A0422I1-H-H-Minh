<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 23/10/2022
  Time: 1:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Caculator</title>
</head>
<body>
<h2>Simple Caculator</h2>
<form action="/caculator" method="post">
    <label>First operand: </label>
    <input type="number" name="first" placeholder="first number" value="0"/><br/>
    <label>Operator: </label>
    <select name="caculator">
        <option value="addition">Addition</option>
        <option value="subtraction">Subtraction</option>
        <option value="multiplication">Multiplication</option>
        <option value="division">Division</option>
    </select><br/>
    <label>Second operand: </label>
    <input type="number" name="second" placeholder="second number" value="0"/><br/>
    <input type = "submit" id = "submit" value = "caculator"/>
</form>
</body>
</html>
