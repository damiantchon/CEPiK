<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Baza oc</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container" style="background: white">
    <input class="btn btn-danger" value="Wróc" onClick="history.go(-1);return true;">
    <table class="table table-bordered table-hover">
        <tr>
            <th>Numer rejestracyjny</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Kradziony</th>
            <th>Stan OC</th>
            <th>Właściciel</th>
        </tr>
        <!-- loop over and print out pojazdy-->
        <c:forEach var="tempPojazd" items="${pojazdy}">

            <c:url var="ocLink" value="/oc/pokazOc">
                <c:param name="ocId" value="${tempPojazd.idOc}"/>
            </c:url>

            <c:url var="wlascicielLink" value="/oc/pokazKierowce">
                <c:param name="idKierowcy" value="${tempPojazd.idKierowcy}"/>
            </c:url>

            <tr>
                <td class="text-nowrap">${tempPojazd.numerRejestracyjny}</td>
                <td class="text-nowrap">${tempPojazd.marka}</td>
                <td class="text-nowrap">${tempPojazd.model}</td>
                <td class="text-nowrap">${tempPojazd.czyKradziony}</td>
                <td class="text-nowrap"><a href="${ocLink}" >Sprawdź</a></td>
                <td class="text-nowrap"><a href="${wlascicielLink}" >Sprawdź</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
