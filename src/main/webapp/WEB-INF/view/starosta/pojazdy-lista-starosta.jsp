<%@page contentType="text/html;charset=UTF-8" language="java"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Panel Starosty</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2> Lista pojazdów</h2>
</div>
<div class="container" style="background: white">
    <form:form action="listaFiltrowana" role="form" data-toggle="validator" modelAttribute="pojazd" cssClass="form-horizontal" method="POST">

        <div class="form-group">
            <a href="${pageContext.request.contextPath}/starosta-panel.jsp" class="btn btn-danger col-xs-1">Wróć</a>
            <button type="button" class="col-xs-2 btn btn-success" onclick="window.location.href='dodajPojazd'; return false;">Dodaj pojazd</button>
            <div class="col-xs-4"></div>
            <div class="col-xs-3">
                <form:input path="NumerRejestracyjny" cssClass="form-control" placeholder="Wpisz numer rejestracyjny"/>
            </div>
            <input  type="submit" value="Wyszukaj" class="btn btn-success col-xs-2"/>
        </div>

    </form:form>

    <table class="table table-bordered table-hover">
        <tr>
            <th>Numer rejestracyjny</th>
            <th>Marka</th>
            <th>Model</th>
            <th>Termin badania</th>
            <th>Kradziony</th>
            <th>Id Oc</th>
            <th>Id Kierowcy</th>
            <th>Akcja</th>
        </tr>
        <!-- loop over and print out pojazdy-->
        <c:forEach var="tempPojazd" items="${Pojazdy}">

            <c:url var="updateLink" value="/pojazdy/edytujPojazd">
                <c:param name="numerRejestracyjny" value="${tempPojazd.numerRejestracyjny}"/>
            </c:url>

            <c:url var="deleteLink" value="/pojazdy/usunPojazd">
                <c:param name="numerRejestracyjny" value="${tempPojazd.numerRejestracyjny}"/>
            </c:url>

            <tr>
                <td class="text-nowrap">${tempPojazd.numerRejestracyjny}</td>
                <td class="text-nowrap">${tempPojazd.marka}</td>
                <td class="text-nowrap">${tempPojazd.model}</td>
                <td class="text-nowrap">${tempPojazd.terminBadania}</td>
                <td class="text-nowrap">${tempPojazd.czyKradziony}</td>
                <td class="text-nowrap">${tempPojazd.idOc}</td>
                <td class="text-nowrap">${tempPojazd.idKierowcy}</td>
                <td class="text-nowrap">
                    <a href="${updateLink}" >Edytuj</a>
                    <a href="${deleteLink}" onclick="if(!(confirm('Czy na pewno chcesz usunąć tegn Pojazd?'))) return false">Usuń</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="container bg-primary"><br></div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>
