<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Home</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar bg-light" style="height: 15%">
    <div class="container-fluid" style="height: 100%">
        <a class="navbar-brand" href="#" style="width: 100%">
            Ho Ha Minh
        </a>
    </div>
</nav>
<nav class="navbar navbar-expand-lg bg-light" style="height: 15%">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav justify-content-center" style="width: 70%">
                <li class="nav-item">
                    <a class="nav-link active fs-4" aria-current="page" href="/home?action=displayBook">List of book available</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-4" aria-current="page" href="/home?action=displayBorrowBook">List of borrowed book</a>
                </li>
            </ul>
        </div>
    </div>
</nav>
<div class="container-fluid" style="height: 80%">
    <div class="d-flex align-items-start">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical"
             style="width: 20%">
            <a href="/home?action=displayBook" style="text-decoration: none">
                <button class="nav-link active" id="v-pills-profile-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile"
                        aria-selected="false">List of book available
                </button>
            </a>
            <a href="/home?action=displayBorrowBook" style="text-decoration: none">
                <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-messages"
                        type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false">List of borrowed book
                </button>
            </a>
        </div>
        <div class="tab-content" id="v-pills-tabContent" style="width: 80%; height: 100%">
            <div class="tab-pane fade active show" id="v-pills-profile" role="tabpanel"
                 aria-labelledby="v-pills-profile-tab" tabindex="0" style="width: 100%; height: 100%">
                <div style="height: 10%; width: 100%">
                    <c:if test="${mess != null}">
                        <h10 style="text-align: left" class="text-danger">${mess}</h10>
                    </c:if>
                    <h4 style="text-align: center" class="text-primary">Borrow book</h4>
                </div>
                <div style="height: 90%; width: 100%">
                    <form class="row" method="post">
                        <div class="col-md-4">
                            <label class="form-label">Borrow id</label>
                        </div>
                        <div class="col-md-8">
                            <input type="text" class="form-control" name="borrowId">
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Book name</label>
                        </div>
                        <div class="col-md-8">
                            <select class="form-select mb-3" aria-label=".form-select example" name="book">
                                <option>Choose book</option>
                                <c:forEach var="book" items="${books}">
                                    <option value="${book.getBook_id()}">${book.getBook_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-md-4">
                            <label class="form-label">Student name</label>
                        </div>
                        <div class="col-md-8">
                            <select class="form-select mb-3" aria-label=".form-select example" name="studentName">
                                <option>Choose student</option>
                                <c:forEach var="student" items="${students}">
                                    <option value="${student.getStudent_id()}">${student.getStudent_name()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-4">
                            <label class="form-label">Start Date</label>
                        </div>
                        <div class="col-8">
                            <%--                            <c:if test="${!errorMap.isEmpty()}">--%>
                            <%--                                <p style="color: red"> ${errorMap.get('birthday')}</p>--%>
                            <%--                            </c:if>--%>
                            <input type="date" class="form-control" name="startDate">
                        </div>
                        <div class="col-4">
                            <label class="form-label">End Date</label>
                        </div>
                        <div class="col-8">
                            <%--                            <c:if test="${!errorMap.isEmpty()}">--%>
                            <%--                                <p style="color: red"> ${errorMap.get('birthday')}</p>--%>
                            <%--                            </c:if>--%>
                            <input type="date" class="form-control" name="endDate" readonly value="${now}">
                        </div>
                        <div class="col-6">
                            <button type="submit" class="btn btn-primary" href="/home?action=borrow">Borrow</button>
                        </div>
                        <div class="col-6">
                            <button type="submit" class="btn btn-primary" href="/home?action=displayBook">Cancel</button>
                        </div>
                    </form>
                </div>
            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab"
                 tabindex="0"></div>
            <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab"
                 tabindex="0"></div>
        </div>
    </div>
</div>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</body>
</html>
