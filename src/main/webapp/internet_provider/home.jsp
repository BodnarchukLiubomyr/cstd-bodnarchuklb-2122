<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 26.11.2021
  Time: 13:15
  To change this template use File | Settings | File Templates.
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Internet Provider</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
</head>
<body>
<header class="p-3 bg-dark text-white">
    <div class="container">
        <div class="d-flex flex-wrap align-items-center justify-content-center justify-content-lg-start">
            <a href="/" class="d-flex align-items-center mb-2 mb-lg-0 text-white text-decoration-none">
                <svg class="bi me-2" width="40" height="32" role="img" aria-label="Bootstrap">
                    <use xlink:href="#bootstrap"></use>
                </svg>
            </a>

            <ul class="nav col-12 col-lg-auto me-lg-auto mb-2 justify-content-center mb-md-0">
                <li><a href="#" class="nav-link px-2 text-secondary">Home</a></li>
                <li><a href="/internet_provider/suggestTariffs" class="nav-link px-2 text-white">Internet</a></li>
                <li><a href="/internet_provider/suggestTariffs" class="nav-link px-2 text-white">Cable_TV</a></li>
                <li><a href="/internet_provider/suggestTariffs" class="nav-link px-2 text-white">Phone</a></li>
                <li><a href="/internet_provider/suggestTariffs" class="nav-link px-2 text-white">IP_TV</a></li>
            </ul>

            <ul class="nav navbar-right gap-4">
                <c:if test="${user != null}">
                    <li class="mt-2 text-warning">${user.details.firstnameEn} ${user.details.lastnameEn}<a href="/internet_provider/ownWallet"></a></li>
                    <c:if test="${user.role == \"USER\"}">
                        <li><a class="btn btn-outline-light" href="/payments">My payments</a></li>
                    </c:if>
                    <c:if test="${user.role == \"ADMIN\"}">
                        <li class="mt-2 text-warning">ADMIN</li>
                        <li><a class="btn btn-outline-light" href="/internet_provider/addTariff">Add new tariff</a></li>
                    </c:if>
                    <li><a class="btn btn-outline-light" href="/internet_provider?name=logout">Log Out</a></li>
                </c:if>
            </ul>
            <c:if test="${user == null}">
                <li><a class="btn btn-outline-light" href="/internet_provider/registration">Create account</a></li>
                <li><a class="btn btn-outline-light" href="/internet_provider/login">Log In</a></li>
            </c:if>
        </div>
    </div>
</header>
<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
    <h1 class="display-4 fw-normal">Novelty</h1>
</div>
<div class="sort d-flex justify-content-center">
    <ul class="nav gap-4">
        <li>
            <form class="mt-4 mb-4 timetable" style="width: 500px; height: 125px" method="post">
                <p class="h3 text-center text-dark mb-2">Sort by:</p>
                <ul class="nav gap-4 d-flex justify-content-center">
                    <li>
                        <input type="submit" class="btn btn-outline-dark btn-width" value="Name" name="sortBy">
                    </li>
                    <li>
                        <input type="submit" class="btn btn-outline-dark btn-width" value="Price" name="sortBy">
                    </li>
                </ul>
            </form>
        </li>
    </ul>
</div>
<div class="row row-cols-1 row-cols-md-3 mb-3 text-center">
    <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
            <div class="card-header py-3">
                <h4 class="my-0 fw-normal">Free</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$0<small class="text-muted fw-light">/mo</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>10 users included</li>
                    <li>2 GB of storage</li>
                    <li>Email support</li>
                    <li>Help center access</li>
                </ul>
                <form action="/internet_provider/placeChoose">
                    <button type="button" class="w-100 btn btn-lg btn-outline-primary">Choose</button>
                </form>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm">
            <div class="card-header py-3">
                <h4 class="my-0 fw-normal">Pro</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$15<small class="text-muted fw-light">/mo</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>20 users included</li>
                    <li>10 GB of storage</li>
                    <li>Priority email support</li>
                    <li>Help center access</li>
                </ul>
                <form action="/internet_provider/placeChoose">
                    <button type="button" class="w-100 btn btn-lg btn-outline-primary">Choose</button>
                </form>
            </div>
        </div>
    </div>
    <div class="col">
        <div class="card mb-4 rounded-3 shadow-sm border-primary">
            <div class="card-header py-3 text-white bg-primary border-primary">
                <h4 class="my-0 fw-normal">Enterprise</h4>
            </div>
            <div class="card-body">
                <h1 class="card-title pricing-card-title">$29<small class="text-muted fw-light">/mo</small></h1>
                <ul class="list-unstyled mt-3 mb-4">
                    <li>30 users included</li>
                    <li>15 GB of storage</li>
                    <li>Phone and email support</li>
                    <li>Help center access</li>
                </ul>
                <form action="/internet_provider/placeChoose">
                    <button type="button" class="w-100 btn btn-lg btn-outline-primary">Choose</button>
                </form>
            </div>
        </div>
    </div>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>
