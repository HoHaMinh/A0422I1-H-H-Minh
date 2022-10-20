<%--
  Created by IntelliJ IDEA.
  User: HP
  Date: 20/10/2022
  Time: 10:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>$Title$</title>
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
