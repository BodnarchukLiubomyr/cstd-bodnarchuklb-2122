<%--
  Created by IntelliJ IDEA.
  User: User
  Date: 28.11.2021
  Time: 23:31
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
<header class="header">
    <nav class="navbar navbar-style mt-4">
        <div class="container">
            <div class="navbar-header">
                <ul class="nav gap-4">
                    <li>
                        <a href="/internet_provider">
                        </a>
                    </li>
                    <c:if test="${user != null}">
                        <c:if test="${user.role == \"USER\"}">
                            <li><a class="btn btn-outline-light mt-1" href="/internet_provider/suggestTariffs">Suggest tariff</a></li>
                        </c:if>
                    </c:if>
                </ul>
            </div>
            <ul class="nav navbar-right gap-4">
                <c:if test="${user != null}">
                    <li class="mt-2 text-warning">${user.details.firstnameEn} ${user.details.lastnameEn}</li>
                    <li><a class="btn btn-outline-light" href="/internet_provider?name=logout">Log Out</a></li>
                </c:if>
            </ul>
        </div>
    </nav>
</header>
<p class="h3 mt-4 mb-4 text-center text-white">My payments</p>
<c:if test="${payments == []}">
    <p class="h1 mt-4 mb-4 text-center text-white">You don't have any payments yet.</p>
</c:if>
<c:forEach var="payment" items="${payments}">
    <form class="ticket mt-5 mb-4 mx-auto bg-white p-4">
        <p class="h3 text-center text-black mb-4">Payment</p>
        <ul>
            <li>
                <p class="h4">${payment.name_en}</p>
            </li>
            <li>
                <p class="h5">Price: ${payment.price}</p>
            </li>
            <li>
                <p class="h5">Time: ${payment.time} min</p>
            </li>
            <br>
        </ul>
    </form>
</c:forEach>
<c:if test="${lastPage > 1}">
    <nav>
        <div class="d-flex justify-content-center mt-5 mb-4">
            <ul class="pagination">
                <c:if test="${currentPage == firstPage}">
                    <li class="page-item disabled">
                        <span class="page-link">Previous</span>
                    </li>
                </c:if>
                <c:if test="${currentPage != firstPage}">
                    <li class="page-item">
                        <a href="/myPayments?page=${currentPage-1}" style="text-decoration: none">
                            <span class="page-link">Previous</span>
                        </a>
                    </li>
                </c:if>
                <c:forEach var="pageNumber" items="${pages}">
                    <c:choose>
                        <c:when test="${pageNumber.equals(currentPage)}">
                            <li class="page-item disabled">
                                <span class="page-link">${pageNumber}</span>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="page-item">
                                <a href="//myPayments?page=${pageNumber}" style="text-decoration: none">
                                    <span class="page-link">${pageNumber}</span>
                                </a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
                <c:if test="${currentPage == lastPage}">
                    <li class="page-item disabled">
                        <span class="page-link">Next</span>
                    </li>
                </c:if>
                <c:if test="${currentPage != lastPage}">
                    <li class="page-item">
                        <a href="//myPayments?page=${currentPage+1}" style="text-decoration: none">
                            <span class="page-link">Next</span>
                        </a>
                    </li>
                </c:if>
            </ul>
        </div>
    </nav>
</c:if>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.0-beta1/dist/js/bootstrap.bundle.min.js"
        integrity="sha384-ygbV9kiqUc6oa4msXn9868pTtWMgiQaeYH7/t7LECLbyPA2x65Kgf80OJFdroafW"
        crossorigin="anonymous">
</script>
</body>
</html>
