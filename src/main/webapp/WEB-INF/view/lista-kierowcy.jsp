<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 05.01.2017
  Time: 10:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Baza kierowców</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2> Lista kierowców

    <button type="button"  class="btn btn-primary" onclick="window.location.href='dodajKierowce'; return false;">
        Dodaj kierowcę
    </button>
    </h2>
    <table class="table table-striped">
        <tr>
            <th>IdKierowcy</th>
            <th>Nazwisko</th>
            <th>Imie</th>
            <th>EMail</th>
            <th>CzyPosiadaUprawnienia</th>
        </tr>
        <c:forEach var="tempKierowca" items="${Kierowcy}">
            <tr>
                <td>${tempKierowca.idKierowcy}</td>
                <td>${tempKierowca.nazwisko}</td>
                <td>${tempKierowca.imie}</td>
                <td>${tempKierowca.eMail}</td>
                <td>${tempKierowca.czyPosiadaUprawnienia}</td>
            </tr>
        </c:forEach>
    </table>
</div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
