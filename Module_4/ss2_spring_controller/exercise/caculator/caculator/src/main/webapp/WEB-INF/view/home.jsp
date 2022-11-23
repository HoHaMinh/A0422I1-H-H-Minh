<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>

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
    <input type="number" name="number1" required>
    <input type="number" name="number2" required> <br>
    <button type="submit" value="addition" name="caculate">Addition (+)</button>
    <button type="submit" value="subtraction" name="caculate">Subtraction (-)</button>
    <button type="submit" value="multiplication" name="caculate">Multiplication (X)</button>
    <button type="submit" value="division" name="caculate">Division (/)</button>
</form>
<h4>Result is</h4>
    <p>
        ${result}. ${mess}
    </p>
</body>
</html>