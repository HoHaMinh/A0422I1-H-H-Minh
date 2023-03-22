<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <title>Customer</title>
    <link rel="stylesheet" href="\webjars\bootstrap\5.1.3\css\bootstrap.min.css">
</head>
<body>
<nav class="navbar bg-white" style="height: 18%">
    <div class="container-fluid" style="height: 100%">
        <a class="navbar-brand" href="#" style="width: 100%">
            <img src="view/furama.png" alt="Logo" width="20%" height="100%" class="d-inline-block text-end">
            Ho Ha Minh
        </a>
    </div>
</nav>
<nav class="navbar navbar-expand-lg bg-white" style="height: 7%">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav justify-content-center" style="width: 70%">
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href=/home?action=">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="/home?action=displayCustomer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="/home?action=displayTemporary">Special querry</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex" role="search" action="/home" method="get">
                <input hidden type="text" name="action" value="searchCustomer">
                <input class="form-control me-2" type="text" name="searchName" placeholder="Search by name"
                       aria-label="Search">
                <input class="form-control me-2" type="text" name="searchAddress" placeholder="Search by address">
                <select class="form-select" aria-label=".form-select example" name="typeId" style="margin:0;">
                    <option value="">--Choose ranking-- </option>
                    <c:forEach var="typeId" items="${customerTypeList}">
                        <option value="${typeId.getCustomerTypeId()}">${typeId.getCustomerTypeName()}</option>
                    </c:forEach>
                </select>
                <button class="btn btn-outline-primary" type="submit">Search</button>
            </form>
        </div>
    </div>
</nav>
<div class="container-fluid" style="height: 65%">
    <div class="d-flex align-items-start">
        <div class="nav flex-column nav-pills me-3" id="v-pills-tab" role="tablist" aria-orientation="vertical"
             style="width: 20%">
            <a href="/home?action=displayCustomer" style="text-decoration: none">
                <button class="nav-link" id="v-pills-home-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-home" type="button" role="tab" aria-controls="v-pills-home"
                        aria-selected="true">Employee Management
                </button>
            </a>
            <a href="/home?action=displayCustomer" style="text-decoration: none">
                <button class="nav-link active" id="v-pills-profile-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-profile" type="button" role="tab" aria-controls="v-pills-profile"
                        aria-selected="false">Customer Management
                </button>
            </a>
            <a href="/home?action=displayTemporary" style="text-decoration: none">
                <button class="nav-link" id="v-pills-messages-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-messages"
                        type="button" role="tab" aria-controls="v-pills-messages" aria-selected="false">Special query
                </button>
            </a>
            <a href="/home?action=displayCustomer" style="text-decoration: none">
                <button class="nav-link" id="v-pills-settings-tab" data-bs-toggle="pill"
                        data-bs-target="#v-pills-settings"
                        type="button" role="tab" aria-controls="v-pills-settings" aria-selected="false">Contract
                    management
                </button>
            </a>
        </div>
        <div class="tab-content" id="v-pills-tabContent" style="width: 80%; height: 100%">
            <div class="tab-pane fade " id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"
                 tabindex="0"></div>
            <div class="tab-pane fade active show" id="v-pills-profile" role="tabpanel"
                 aria-labelledby="v-pills-profile-tab" tabindex="0" style="width: 100%; height: 100%">
                <div style="height: 20%; width: 100%">
                    <c:if test="${mess != null}">
                        <h10 style="text-align: left" class="text-danger">${mess}</h10>
                    </c:if>
                    <h3 style="text-align: center; height: 10%" class="text-primary">List of customers</h3>
                    <a href="/home?action=addCustomer" style="text-decoration: none">
                        <button type="button" class="btn btn-primary">Create new customer</button>
                    </a>
                </div>
                <c:if test="${!empty customers}">
                    <table class="table table-primary table-hover" style="height: 70%; width: 100%">
                        <tr>
                            <th class="col-auto">ID</th>
                            <th class="col-auto">Ranking</th>
                            <th class="col-auto">Name</th>
                            <th class="col-auto">Birthday</th>
                            <th class="col-auto">Gender</th>
                            <th class="col-auto">Id Card</th>
                            <th class="col-auto">Phone</th>
                            <th class="col-auto">Email</th>
                            <th class="col-auto">Address</th>
                            <th class="col-auto">Edit</th>
                            <th class="col-auto">Delete</th>
                        </tr>
                        <c:forEach var="customer" items="${customers}">
                            <tr>
                                <td>${customer.getCustomerId()}</td>
                                <c:if test="${customer.getCustomerTypeId()==1}">
                                    <td>Diamond</td>
                                </c:if>
                                <c:if test="${customer.getCustomerTypeId()==2}">
                                    <td>Planium</td>
                                </c:if>
                                <c:if test="${customer.getCustomerTypeId()==3}">
                                    <td>Gold</td>
                                </c:if>
                                <c:if test="${customer.getCustomerTypeId()==4}">
                                    <td>Silver</td>
                                </c:if>
                                <c:if test="${customer.getCustomerTypeId()==5}">
                                    <td>Member</td>
                                </c:if>
                                <td>${customer.getCustomerName()}</td>
                                <td>${customer.getCustomerBirthday()}</td>
                                <c:if test="${customer.isCustomerGender()}">
                                    <td>Male</td>
                                </c:if>
                                <c:if test="${!customer.isCustomerGender()}">
                                    <td>Female</td>
                                </c:if>
                                <td>${customer.getCustomerIdCard()}</td>
                                <td>${customer.getCustomerPhone()}</td>
                                <td>${customer.getCustomerEmail()}</td>
                                <td>${customer.getCustomerAddress()}</td>
                                <td>
                                    <a href="/home?action=editCustomer&id=${customer.getCustomerId()}">
                                        <button type="button" class="btn btn-secondary">Edit</button>
                                    </a>
                                </td>
                                <td>
                                    <a href="/home?action=deleteCustomer&id=${customer.getCustomerId()}">
                                        <button type="button" class="btn btn-warning">Delete</button>
                                    </a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </c:if>
                <nav aria-label="Page navigation example" style="height: 10%">
                    <ul class="pagination">
                        <li class="page-item ${page == 1 ? 'disabled' : ''} "><a class="page-link" href="/home?action=choosePageCustomer&id=${page-1}">
                            Previous</a></li>
                        <c:if test="${empty pages}">
                            <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=1">1</a></li>
                        </c:if>
                        <c:if test="${!empty pages}">
                            <c:forEach var="pages" items="${pages}">
                                <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=${pages}">${pages}</a></li>
                            </c:forEach>
                        </c:if>
<%--                        <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=1">1</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=2">2</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=3">3</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=4">4</a></li>--%>
<%--                        <li class="page-item"><a class="page-link" href="/home?action=choosePageCustomer&id=5">5</a></li>--%>
                        <li class="page-item ${pages.size() == page ? 'disabled' : ''}"><a class="page-link"
                                                 href="/home?action=choosePageCustomer&id=${page+1}">Next</a></li>
                    </ul>
                </nav>
            </div>
            <div class="tab-pane fade" id="v-pills-messages" role="tabpanel" aria-labelledby="v-pills-messages-tab"
                 tabindex="0"></div>
            <div class="tab-pane fade" id="v-pills-settings" role="tabpanel" aria-labelledby="v-pills-settings-tab"
                 tabindex="0"></div>
        </div>
    </div>
</div>
<div class="container-fluid bg-white" style="height: 5%">
    <h6 style="text-align: center" class="text-primary bg-light">Right reserved by Furama</h6>
</div>
<script src="/bootstrap-5.1.3-dist/js/bootstrap.min.js"></script>
</body>
</html>
