<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
    <title>Internet Provider</title>
</head>
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
                <li>
                    <div class="dropdown">
                        <button class="btn btn-outline-light dropdown-toggle" type="button" id="dropdownMenuButton" data-bs-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Language</button>
                        <div class="dropdown-menu" aria-labelledby="dropdownMenuButton">
                            <a class="dropdown-item text-dark" href="#">English</a>
                            <a class="dropdown-item text-dark" href="#">Українська</a>
                        </div>
                    </div>
                </li>
                <li><a class="btn btn-outline-light" href="/internet_provider/registration">Create account</a></li>
            </ul>
        </div>
    </div>
</header>
<body>
<div class="confirm d-flex justify-content-center gap-2 mt-5" style="margin: auto">
    <ul class="list-group">
        <li><p class="h1 mt-4 mb-4 text-center text-dark">Sorry, something went wrong...</p></li>
        <li class="text-center"><a class="btn btn-warning mt-4 mb-4 btn-lg" href="/internet_provider/home" style="width: 300px">Back to main page</a></li>
    </ul>
</div>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js" integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW" crossorigin="anonymous"></script>
</body>
</html>