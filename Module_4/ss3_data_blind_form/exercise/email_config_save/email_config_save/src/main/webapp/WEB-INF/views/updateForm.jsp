<%@taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Update form</title>
</head>
<body>
<h1>Setting</h1>
<table>
    <form:form action="/update" method="get" modelAttribute="emailConfig">
    <tr>
        <td>
            Languages:
        </td>
        <td>
            <form:select path="language">
                <form:options items="${language}"></form:options>
            </form:select>

        </td>
    </tr>
    <tr>
        <td>
            PageSizes:
        </td>
        <td>
            <form:select path="pageSize">
                Show
                <form:options items="${pageSize}"></form:options>
                emails per page.
            </form:select>
        </td>
    </tr>
    <tr>
        <td>
            Spams filer:
        </td>
        <td>
            <form:checkbox path="allowSpam" value="true"/>Enable Spam filter.
        </td>
    </tr>
    <tr>
        <td>
            Signature:
        </td>
        <td>
            <form:textarea path="signature"/>
        </td>
    </tr>
    <tr>
        <td>
            <button type="submit">Update</button>
        </td>
        </form:form>
        <td>
            <a href="/"><button type="submit">Cancel</button></a>
        </td>
    </tr>
</table>
</body>
</html>
