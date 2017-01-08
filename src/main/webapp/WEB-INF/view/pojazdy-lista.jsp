<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 04.01.2017
  Time: 17:40
  To change this template use File | Settings | File Templates.
--%>
<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Baza pojazdów</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2> Lista pojazdów </h2>
    <table class="table table-striped">
        <tr>
            <th>NumerRejestracyjny</th>
            <th>Marka</th>
            <th>Model</th>
            <th>TerminBadania</th>
            <th>IdOc</th>
            <th>IdKierowcy</th>
        </tr>
        <!-- loop over and print out pojazdy-->
        <c:forEach var="tempPojazd" items="${Pojazdy}">
            <tr>
                <td>${tempPojazd.numerRejestracyjny}</td>
                <td>${tempPojazd.marka}</td>
                <td>${tempPojazd.model}</td>
                <td>${tempPojazd.terminBadania}</td>
                <td>${tempPojazd.idOc}</td>
                <td>${tempPojazd.idKierowcy}</td>
            </tr>
        </c:forEach>
    </table>
</div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
