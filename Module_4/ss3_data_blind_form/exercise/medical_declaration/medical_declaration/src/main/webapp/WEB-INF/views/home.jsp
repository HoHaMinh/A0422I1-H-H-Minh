<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Home</title>
    <style>
        a, button {
            height: 50px;
        }
    </style>
</head>
<body>
<p style="color: red">${msg}</p>
<h1>Menu khai báo y tế</h1>
<a href="/detail">
    <button type="submit">Thể hiện tờ khai gần nhất</button>
</a>
<br>
<a href="/showForm">
    <button type="submit">Thêm mới hoặc cập nhật mới tờ khai y tế</button>
</a>
</body>
</html>
