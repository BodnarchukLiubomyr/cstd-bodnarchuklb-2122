<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.11.2021
  Time: 18:17
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
<div class="container text-center mt-5 mb-4">
    <form style="width: 400px; margin: auto; padding: 30px;" method="post" enctype="multipart/form-data">
        <h1 class="h3 mb-3 font-weight-normal">Tariff</h1>
        <div class="dropdown mb-2">
            <select name="service" class="btn btn-outline-secondary dropdown-toggle" required>
                <c:forEach items="${services}" var="service">
                    <option value="${service.id}">${service.service_en}</option>
                </c:forEach>
            </select>
            <select>
                <c:forEach var="status" items="${statuses}">
                    <option value="${status.id}">${status.status_en}</option>
                </c:forEach>
            </select>
        </div>
        <label class="form-label">You can add service below, if it doesn't exist.</label>
        <label class="form-label">You can add tariff status below, if it doesn't exist.</label>
        <input name="name_en" type="text" class="start form-control" placeholder="Tariff name" required>
        <input name="description" type="text" placeholder="Description" class="in form-control" required>
        <input name="time" type="text" class="in form-control" placeholder="Time (days)" required>
        <input name="price" type="number" placeholder="Price" class="finish form-control mb-2" required>
        <div>
            <input type="submit" name="action" class="btn btn-sm btn-dark" value="Add tariff" style="width: 270px;">
        </div>
    </form>
</div>
<div class="container text-center mb-4">
    <form style="width: 400px; margin: auto; padding: 30px;" method="post">
        <h1 class="h3 mb-3 font-weight-normal">Add service</h1>
        <input name="service_en" type="text" class="start form-control mb-3" placeholder="Service" required>
        <div>
            <input type="submit" name="action" class="btn btn-sm btn-dark" value="Add service" style="width: 270px;">
        </div>
    </form>
</div>

</body>
</html>
