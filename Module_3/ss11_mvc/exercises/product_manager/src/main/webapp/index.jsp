<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
</head>
<body>
<h1>Product manager</h1>
<ol>
    <li>
        <a href="/servlet?action=display">Display list of products</a>
    </li>
    <li>
        <a href="#idEdit" id="edit" onclick="show(this.id)" style="display: block">Edit product by id</a>
        <form method="get" action="/servlet" id="idEdit" style="display: none">
            <p>Pls enter id of product need to edit</p>
            <input type="number" name="id">
            <input type="text" name="action" value="edit" hidden>
            <input type="submit">
        </form>
    </li>
    <li>
        <a href="#idDelete" id="deleteLink" onclick="show(this.id)" style="display: block">Delete product by id</a>
        <form method="get" action="/servlet" id="idDelete" style="display: none">
            <p>Pls enter id of product need to delete</p>
            <input type="number" name="id">
            <input type="text" name="action" value="delete" hidden>
            <input type="submit">
        </form>
    </li>
    <li>
        <a href="#idShow" id="show" onclick="show(this.id)" style="display: block">Show a product by id</a>
        <form method="get" action="/servlet" id="idShow" style="display: none">
            <p>Pls enter id of product need to show</p>
            <input type="number" name="id">
            <input type="text" name="action" value="show" hidden>
            <input type="submit">
        </form>
    </li>
    <li>
        <a href="#name" id="find" onclick="show(this.id)" style="display: block">Find product by name</a>
        <form method="get" action="/servlet" id="name" style="display: none">
            <p>Pls enter the name of product</p>
            <input type="text" name="find">
            <input type="text" name="action" value="find" hidden>
            <input type="submit">
        </form>
    </li>
</ol>
<script>
    const find = document.getElementById('find');
    const name = document.getElementById('name');
    const edit = document.getElementById('edit');
    const idEdit = document.getElementById('idEdit');
    const showLink = document.getElementById('show');
    const idShow = document.getElementById('idShow');
    const deleteLink = document.getElementById('deleteLink');
    const idDelete = document.getElementById('idDelete');

    function show(id) {
        switch (id) {
            case "find" :
                find.style.display = "none";
                name.style.display="block";
                break;
            case "edit":
                edit.style.display = "none";
                idEdit.style.display="block";
                break;
            case "show":
                showLink.style.display = "none";
                idShow.style.display="block";
                break;
            case "deleteLink":
                deleteLink.style.display = "none";
                idDelete.style.display="block";
        }
    }
</script>
</body>
</html>