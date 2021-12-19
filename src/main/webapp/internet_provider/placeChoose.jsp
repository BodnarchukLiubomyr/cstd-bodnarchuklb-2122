<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 27.11.2021
  Time: 11:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="utf-8">
    <title>Internet Provider</title>
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
          integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
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
        </div>
    </div>
</header>
<div class="container text-center">
    <form style="width: 330px; margin: auto; margin-top: 110px; padding: 30px;" action="/internet_provider/placeChoose"
          method="post">
        <h1 class="h3 mb-3 font-weight-normal">Select place</h1>
        <input type="text" placeholder="Street" class="form-control" name="street" required>
        <input type="text" placeholder="District" class="form-control" name="district" required>
        <input type="text" placeholder="City" class="form-control" name="city" required>
        <div class="mt-3">
            <input type="submit" class="btn btn-sm btn-primary" value="Enter">
        </div>
    </form>
</div>
</body>
</html>
