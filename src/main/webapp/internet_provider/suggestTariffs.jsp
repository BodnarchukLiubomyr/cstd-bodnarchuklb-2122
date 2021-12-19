<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2021
  Time: 11:42
  To change this template use File | Settings | File Templates.
--%>
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
                <li><a href="#" class="nav-link px-2 text-white">Internet</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Cable_TV</a></li>
                <li><a href="#" class="nav-link px-2 text-white">Phone</a></li>
                <li><a href="#" class="nav-link px-2 text-white">IP_TV</a></li>
            </ul>
        </div>
    </div>
</header>
<div class="pricing-header p-3 pb-md-4 mx-auto text-center">
    <h1 class="display-4 fw-normal">Pricing</h1>
</div>
<div class="container text-center mb-5 mb-4">
    <ul class="list-group list-group-horizontal mb-3 d-flex justify-content-center gap-4">
        <li>
            <form class="timetable mt-4 mx-auto" style="width: 500px; height: 250px">
                <ul class="list-group list-group-horizontal">
                    <li>
                        <ul>
                            <li><p class="h2 text-info">${tariff.name_en}</p></li>
                            <li><p class="h5 text-black">${tariff.description}</p></li>
                            <li><p class="h5 text-black">Time: ${tariff.time} days</p></li>
                            <li><p class="h5 text-black">Price: ${tariff.price}$</p></li>
                        </ul>
                    </li>
                </ul>
            </form>
        </li>
    </ul>
</div>
</body>
</html>

