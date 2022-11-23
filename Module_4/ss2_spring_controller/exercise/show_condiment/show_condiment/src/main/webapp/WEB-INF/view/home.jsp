<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Show condiment</title>
</head>
<body>
<h1>Sandwich Condiments</h1>
<form method="get" action="/save">
    <input type="checkbox" name="condiment" id="Lettuce" value="Lettuce">
    <label for="Lettuce">Lettuce</label>
    <input type="checkbox" name="condiment" id="Tomato" value="Tomato">
    <label for="Tomato">Tomato</label>
    <input type="checkbox" name="condiment" id="Mustard" value="Mustard">
    <label for="Mustard">Mustard</label>
    <input type="checkbox" name="condiment" id="Sprout" value="Sprout">
    <label for="Sprout">Sprout</label><br>
    <input type="submit">
</form>
<c:if test="${not empty condiments}">
    <h4>Your selection: </h4>
    <c:forEach var="condiment" items="${condiments}">
        <h4>
            ${condiment}
        </h4>
    </c:forEach>
</c:if>

</body>
</html>