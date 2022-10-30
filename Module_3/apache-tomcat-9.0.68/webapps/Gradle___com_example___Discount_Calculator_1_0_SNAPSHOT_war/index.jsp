<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>Discount caculator</title>
</head>
<body>
<h2>Discount caculator</h2>
<form action="/discount" method="post">
    <label>Product Description: </label><br/>
    <input type="text" name="description" placeholder="Description"/><br/>
    <label>List Price: </label><br/>
    <input type="text" name="vnd" placeholder="vnd" value="0"/><br/>
    <label>Discount Percent: </label><br/>
    <input type="text" name="percent" placeholder="%" value="0"/><br/>
    <input type = "submit" id = "submit" value = "calculator"/>
</form>
</body>
</html>