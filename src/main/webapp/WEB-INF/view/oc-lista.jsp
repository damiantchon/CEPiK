<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Baza oc</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2> Lista oc </h2>
    <table class="table table-hover table-bordered">
        <tr>
            <th>IdOc</th>
            <th>Rozpoczęcie</th>
            <th>Zakończenie</th>
            <th>Ubezpieczyciel</th>
        </tr>
        <c:forEach var="tempOc" items="${Oc}">
            <tr>
                <td>${tempOc.idOc}</td>
                <td>${tempOc.rozpoczecie}</td>
                <td>${tempOc.zakonczenie}</td>
                <td>${tempOc.ubezpieczyciel}</td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
