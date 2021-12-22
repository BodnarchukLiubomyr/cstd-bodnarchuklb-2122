<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 25.11.2021
  Time: 10:34
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
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
<div class="container text-center">
    <form style="width: 330px; margin: auto; margin-top: 110px; padding: 30px;" action="/internet_provider/registration" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Sign up</h1>
        <input type="login" placeholder="Login" class="form-control" name="login" required>
        <input type="password" placeholder="Password" class="form-control" name="password" required>
        <input type="password" placeholder="Repeat password" class="form-control" name="repeatPassword" required>

        <ul class="list-group list-group-horizontal mb-3">
            <li><input type="text" placeholder="First name" class="form-control first-name" name="firstnameEn" required></li>
            <li><input type="text" placeholder="Last name" class="form-control last-name" name="lastnameEn" required></li>
        </ul>

        <input type="email" placeholder="Email" class="form-control" name="email" required>
        <input type="text" placeholder="Phone number" class="form-control" name="phone" required>
        <input type="street" placeholder="Street" class="form-control" name="street" required>
        <input type="district" placeholder="District" class="form-control" name="district" required>
        <input type="city" placeholder="City" class="form-control" name="city" required>

        <div class="mt-3" >
            <input type="submit" class="btn btn-sm btn-primary" value="Create account">
        </div>
    </form>
</div>
</body>
</html>
