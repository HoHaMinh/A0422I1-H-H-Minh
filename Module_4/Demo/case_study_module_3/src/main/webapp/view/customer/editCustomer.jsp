<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Home</title>
    <link rel="stylesheet" href="/bootstrap-5.1.3-dist/css/bootstrap.min.css">
</head>
<body>
<nav class="navbar bg-white" style="height: 20%">
    <div class="container-fluid" style="height: 100%">
        <a class="navbar-brand" href="#" style="width: 100%">
            <img src="view/furama.png" alt="Logo" width="20%" height="100%" class="d-inline-block text-end">
            Ho Ha Minh
        </a>
    </div>
</nav>
<nav class="navbar navbar-expand-lg bg-white" style="height: 10%">
    <div class="container-fluid">
        <div class="collapse navbar-collapse" id="navbarSupportedContent">
            <ul class="nav justify-content-center" style="width: 70%">
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="/home?action=">Home</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="#">Employee</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="/home?action=displayCustomer">Customer</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="/home?action=displayTemporary">Special query</a>
                </li>
                <li class="nav-item">
                    <a class="nav-link active fs-6" aria-current="page" href="#">Contract</a>
                </li>
            </ul>
            <form class="d-flex" role="search">
                <input class="form-control me-2" type="search" placeholder="Search by name" aria-label="Search">
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
        <div class="tab-content" id="v-pills-tabContent" style="width: 80%">
            <div class="tab-pane fade" id="v-pills-home" role="tabpanel" aria-labelledby="v-pills-home-tab"
                 tabindex="0"></div>
            <div class="tab-pane fade active show" id="v-pills-profile" role="tabpanel"
                 aria-labelledby="v-pills-profile-tab"
                 tabindex="0">
                <div style="height: 10%; width: 100%">
                    <h4 style="text-align: center" class="text-primary">Edit new customer</h4>
                </div>
                <div style="height: 90%; width: 100%">
                    <form class="row" method="post">
                        <div class="col-12">
                            <input type="text" hidden name="id" class="form-control" value="${customer.getCustomerId()}" placeholder="${customer.getCustomerId()}">
                        </div>
                        <div class="col-12">
                            <label class="form-label">Ranking</label>
                            <select class="form-select mb-3" aria-label=".form-select example" name="typeId">
                                <option>Choose ranking</option>
                                <c:forEach var="typeId" items="${customerTypeList}">
                                    <option value="${typeId.getCustomerTypeId()}">${typeId.getCustomerTypeName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Name</label>
                            <input type="text" class="form-control" name="name" placeholder="${customer.getCustomerName()}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Birthday</label>
                            <input type="text" class="form-control" name="birthday" placeholder="${customer.getCustomerBirthday()}" onfocus="(this.type='date')">
                        </div>
                        <div class="col-12">
                            <label class="form-label">Gender</label>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" value="true">
                                <label class="form-check-label">
                                    Male
                                </label>
                            </div>
                            <div class="form-check">
                                <input class="form-check-input" type="radio" name="gender" value="false">
                                <label class="form-check-label" >
                                    Female
                                </label>
                            </div>
                        </div>
                        <div class="col-6">
                            <label class="form-label">Id card</label>
                            <input type="text" class="form-control" name="idCard" placeholder="${customer.getCustomerIdCard()}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Phone</label>
                            <input type="text" class="form-control" name="phone" placeholder="${customer.getCustomerPhone()}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Email</label>
                            <input type="text" class="form-control" name="email" placeholder="${customer.getCustomerEmail()}">
                        </div>
                        <div class="col-6">
                            <label class="form-label">Address</label>
                            <input type="text" class="form-control" name="address" placeholder="${customer.getCustomerAddress()}">
                        </div>
                        <div class="col-12">
                            <button type="submit" class="btn btn-primary">Save</button>
                        </div>
                    </form>
                </div>
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
