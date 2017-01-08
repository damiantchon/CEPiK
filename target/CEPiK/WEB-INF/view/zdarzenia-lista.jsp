<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 05.01.2017
  Time: 11:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Baza zdarzeń</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
    <body>
    <div class="container">
    <h2> Lista zdarzeń </h2>
        <table class="table table-striped">
            <tr>
                <th>IdZdarzenia</th>
                <th>NumerRejestracyjny</th>
                <th>IdKierowcy</th>
                <th>TypZdarzenia</th>
                <th>DataZdarzenia</th>
                <th>OpisZdarzenia</th>
            </tr>
            <c:forEach var="tempZdarzenia" items="${Zdarzenia}">
                <tr>
                    <td>${tempZdarzenia.idZdarzenia}</td>
                    <td>${tempZdarzenia.numerRejestracyjny}</td>
                    <td>${tempZdarzenia.idKierowcy}</td>
                    <td>${tempZdarzenia.typZdarzenia}</td>
                    <td>${tempZdarzenia.dataZdarzenia}</td>
                    <td>${tempZdarzenia.opisZdarzenia}</td>
                </tr>
            </c:forEach>
        </table>
    </div>
        <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
        <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
    </body>
</html>
