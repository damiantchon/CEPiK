<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head><!--TODO-->
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2>${kierowca.imie} ${kierowca.nazwisko} (${kierowca.eMail})</h2>
</div>
<div class="container" style="background: white">
    <c:choose>
        <c:when  test="${kierowca.czyPosiadaUprawnienia=='TAK'}">
            <h3>Uprawnienia: ${kierowca.czyPosiadaUprawnienia}</h3>
        </c:when>
        <c:otherwise>
            <h3 style="color: red">Uprawnienia: ${kierowca.czyPosiadaUprawnienia}</h3>
        </c:otherwise>
    </c:choose>

    <h3>Pojazdy:</h3>
    <table class="table table-bordered">
        <tr>
            <th>Numer rejestracyjny</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Termin badania</th>
            <th>Kradziony</th>
            <th>Oc</th>
        </tr>
        <!-- loop over and print out pojazdy-->
        <c:forEach var="tempPojazd" items="${pojazdy}">
            <c:url var="checkOcLink" value="/oc/sprawdzOc">
                <c:param name="IdOc" value="${tempPojazd.idOc}"/>
            </c:url>
            <tr>
                <td class="text-nowrap">${tempPojazd.numerRejestracyjny}</td>
                <td class="text-nowrap">${tempPojazd.marka}</td>
                <td class="text-nowrap">${tempPojazd.model}</td>
                <td class="text-nowrap">${tempPojazd.terminBadania}</td>
                <td class="text-nowrap">${tempPojazd.czyKradziony} </td>
                <td class="text-nowrap">
                    <a href="${checkOcLink}" >Sprawdź</a>
                </td>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container" style="background: white">
    <h3>Zdarzenia:</h3>
    <table class="table table-hover table-bordered">
        <tr>
            <th>ID</th>
            <th class="text-nowrap">Nr rejestracyjny</th>
            <th class="text-nowrap">ID kierowcy</th>
            <th class="text-nowrap">Typ zdarzenia</th>
            <th class="text-nowrap">Data</th>
            <th>Opis zdarzenia</th>
        </tr>
        <c:forEach var="tempZdarzenia" items="${zdarzenia}">
            <tr>
                <td>${tempZdarzenia.idZdarzenia}</td>
                <td>${tempZdarzenia.numerRejestracyjny}</td>
                <td>${tempZdarzenia.idKierowcy}</td>
                <td>${tempZdarzenia.typZdarzenia}</td>
                <td class="text-nowrap">${tempZdarzenia.dataZdarzenia}</td>
                <td>${tempZdarzenia.opisZdarzenia}</td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-danger col-xs-2" href="${pageContext.request.contextPath}/kierowcy/sprawdzanieKierowcyForm" >Wróc</a>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
