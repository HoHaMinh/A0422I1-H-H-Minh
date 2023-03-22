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
          <a class="nav-link active fs-4" aria-current="page" href="/home?action=displayList">List of rent house</a>
        </li>
      </ul>
      <form class="d-flex" role="search" action="/home" method="get">
        <input hidden type="text" name="action" value="search">
        <input class="form-control me-2" type="text" name="searchId" placeholder="Search by id rent"
               aria-label="Search">
        <input class="form-control me-2" type="text" name="searchName" placeholder="Search by name">
        <input class="form-control me-2" type="text" name="searchPhone" placeholder="Search by phone">
        <button class="btn btn-outline-primary" type="submit">Search</button>
      </form>
    </div>
  </div>
</nav>
<div class="container-fluid" style="height: 70%">
  <div class="d-flex align-items-start">
    <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical"
         style="width: 10%">
      <a href="/home?action=displayList" style="text-decoration: none">
        <button class="nav-link active" id="v-pills-profile-tab" data-bs-toggle="pill"
                data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile"
                aria-selected="false">List of rent house
        </button>
      </a>
    </div>
    <div class="tab-content" id="v-pills-tabContent" style="width: 90%; height: 100%">
      <div class="tab-pane fade active show" id="v-pills-profile" role="tabpanel"
           aria-labelledby="v-pills-profile-tab" tabindex="0" style="width: 100%; height: 100%">
        <div style="height: 20%; width: 100%">
          <c:if test="${mess != null}">
            <h10 style="text-align: left" class="text-danger">${mess}</h10>
          </c:if>
          <a href="/home?action=add" style="text-decoration: none">
            <button type="button" class="btn btn-primary">Add new</button>
          </a>
          <h3 style="text-align: center; height: 10%" class="text-primary">List of rent house</h3>
        </div>
        <c:if test="${!empty list}">
          <table class="table table-primary table-hover" style="height: 70%; width: 100%">
            <tr>
              <th class="col-auto">ID rent house</th>
              <th class="col-auto">Rent Name</th>
              <th class="col-auto">Phone</th>
              <th class="col-auto">Start Date</th>
              <th class="col-auto">Payment type</th>
              <th class="col-auto">Note</th>
              <th class="col-auto">Action</th>
            </tr>
            <c:forEach var="list" items="${list}">
              <tr>
                <td>${list.getHouse_id()}</td>
                <td>${list.getRent_name()}</td>
                <td>${list.getPhone()}</td>
                <td>${list.getStart_date()}</td>
                <td>${list.getPayment_type()}</td>
                <td>${list.getNote()}</td>
                <td>
                  <a href="/home?action=delete&id=${list.getHouse_id()}">
                    <button type="button" class="btn btn-secondary">Delete</button>
                  </a>
                </td>
              </tr>
            </c:forEach>
          </table>
        </c:if>
<%--        <nav aria-label="Page navigation example" style="height: 10%">--%>
<%--          <ul class="pagination">--%>
<%--            <li class="page-item ${page == 1 ? 'disabled' : ''} "><a class="page-link" href="/home?action=choosePageCustomer&id=${page-1}">--%>
<%--              Previous</a></li>--%>
<%--            <c:if test="${empty pages}">--%>
<%--              <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=1">1</a></li>--%>
<%--            </c:if>--%>
<%--            <c:if test="${!empty pages}">--%>
<%--              <c:forEach var="pages" items="${pages}">--%>
<%--                <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=${pages}">${pages}</a></li>--%>
<%--              </c:forEach>--%>
<%--            </c:if>--%>
<%--            <li class="page-item ${pages.size() == page ? 'disabled' : ''}"><a class="page-link"--%>
<%--                                                                               href="/home?action=choosePageCustomer&id=${page+1}">Next</a></li>--%>
<%--          </ul>--%>
<%--        </nav>--%>
      </div>
    </div>
  </div>
</div>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</body>
</html>

