<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<br>
<div class="container bg-primary">
    <h2>${pojazd.marka} ${pojazd.model} (${pojazd.numerRejestracyjny})</h2>
    <h4 style="color: lightgray;">Właściciel: ${kierowca.nazwisko} ${kierowca.imie} (ID: ${kierowca.idKierowcy}) | e-mail: ${kierowca.eMail}</h4>
    <h4></h4>
</div>
<div class="container" style="background: white">
    <h3>Kradziony: ${pojazd.czyKradziony}</h3>
    <h3>Termin badania: ${pojazd.terminBadania}</h3>
    <c:choose>
    <c:when  test="${oc.zakonczenie!=null}">
        <h3>Data ważności oc: ${oc.zakonczenie}</h3>
    </c:when>
    <c:otherwise>
        <h3 style="color: red">Brak OC!</h3>
    </c:otherwise>
    </c:choose>
</div>

<div class="container" style="background: white">
    <h3>Zdarzenia:</h3>
    <table class="table table-hover table-bordered">
        <tr>
            <th>ID</th>
            <th class="text-nowrap">ID kierowcy</th>
            <th class="text-nowrap">Data zdarzenia</th>
            <th class="text-nowrap">Typ zdarzenia</th>
            <th class="text-nowrap">Opis zdarzenia</th>

        </tr>
        <c:forEach var="tempZdarzenia" items="${zdarzenia}">
            <tr>
                <td>${tempZdarzenia.idZdarzenia}</td>
                <td>${tempZdarzenia.idKierowcy}</td>
                <td>${tempZdarzenia.dataZdarzenia}</td>
                <td>${tempZdarzenia.typZdarzenia}</td>
                <td>${tempZdarzenia.opisZdarzenia}</td>
            </tr>
        </c:forEach>
    </table>
    <a class="btn btn-danger col-xs-2" href="${pageContext.request.contextPath}/pojazdy/sprawdzaniePojazduForm" >Wróc</a>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
