<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Home</title>
</head>
<body>
<h3>
    ${msg}
</h3>
<h1>
    Show current email config
</h1>
<p>Language: ${emailConfig.getLanguage()}</p>
<p>Page size: ${emailConfig.getPageSize()}</p>
<c:if test="${emailConfig.isAllowSpam() == true}">
    <p>Spams filter: Enable</p>
</c:if>
<c:if test="${emailConfig.isAllowSpam() == false}">
    <p>Spams filter: Not Enable</p>
</c:if>
<p>Signature: ${emailConfig.getSignature()}</p>
<a href="/showUpdate"><button type="submit">Update</button></a>
</body>
</html>