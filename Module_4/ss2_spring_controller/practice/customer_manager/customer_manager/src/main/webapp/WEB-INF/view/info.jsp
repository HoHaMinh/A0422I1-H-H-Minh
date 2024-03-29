<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Info</title>
</head>
<body>
<form action="/" method="post">
    <fieldset>
        <legend>Customer Information</legend>
        <c:forEach var="customer" items="${customers}">
            <input type="hidden" name="id" value="${customer.getId()}">
            <table>
                <tr>
                    <td>Id</td>
                    <td>
                            ${customer.getId()}
                    </td>
                </tr>
                <tr>
                    <td>Name</td>
                    <td>
                        <input type="text" name="name" value="${customer.getName()}">
                    </td>
                </tr>
                <tr>
                    <td>Email</td>
                    <td>
                        <input type="text" name="email" value="${customer.getEmail()}">
                    </td>
                </tr>
                <tr>
                    <td>Address</td>
                    <td>
                        <input type="text" name="address" value="${customer.getAddress()}">
                    </td>
                </tr>
                <tr>
                    <td colspan="2">
                        <input type="submit" value="Update">
                    </td>
                </tr>
            </table>
        </c:forEach>
    </fieldset>
</form>
<a href="/list">Back to list</a>.
</body>
</html>
