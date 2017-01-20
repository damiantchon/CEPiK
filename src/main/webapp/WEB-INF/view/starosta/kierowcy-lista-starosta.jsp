<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Panel Starosty</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/bs/jq-2.2.4/dt-1.10.13/af-2.1.3/b-1.2.4/b-colvis-1.2.4/r-2.1.0/sc-1.4.2/se-1.2.0/datatables.min.css"/>

</head>
<body>
<br>
<div class="container bg-primary">
    <h3>Lista kierowców</h3>
</div>
    <div class="container" style="background: white">

        <form:form action="listaFiltrowana" role="form" data-toggle="validator" modelAttribute="kierowca" cssClass="form-horizontal" method="POST">

            <div class="form-group">
                <a href="${pageContext.request.contextPath}/starosta-panel.jsp" class="btn btn-danger col-xs-1">Wróć</a>
                <button type="button"  class="col-xs-2 btn btn-success" onclick="window.location.href='dodajKierowce'; return false;">Dodaj kierowcę</button>
                <div class="col-xs-4"></div>
                <div class="col-xs-3">
                    <form:input path="Nazwisko" cssClass="form-control" placeholder="Wpisz nazwisko"/>
                </div>
                <input  type="submit" value="Wyszukaj" class="btn btn-success col-xs-2"/>
            </div>

        </form:form>

        <table class="table table-hover table-bordered"> <!-- display -->
            <thead>
            <tr>
                <th class="text-nowrap">ID Kierowcy</th>
                <th>Nazwisko</th>
                <th>Imie</th>
                <th>E-mail</th>
                <th>Uprawnienia</th>
                <th>Akcja</th>
            </tr>
            </thead>
            <tbody>
            <c:forEach var="tempKierowca" items="${Kierowcy}">

                <c:url var="updateLink" value="/kierowcy/edytujKierowce">
                    <c:param name="IdKierowcy" value="${tempKierowca.idKierowcy}"/>
                </c:url>

                <c:url var="deleteLink" value="/kierowcy/usunKierowce">
                    <c:param name="IdKierowcy" value="${tempKierowca.idKierowcy}"/>
                </c:url>

                <tr>
                    <td class="text-nowrap">${tempKierowca.idKierowcy}</td>
                    <td class="text-nowrap">${tempKierowca.nazwisko}</td>
                    <td class="text-nowrap">${tempKierowca.imie}</td>
                    <td class="text-nowrap">${tempKierowca.eMail}</td>
                    <td class="text-nowrap">${tempKierowca.czyPosiadaUprawnienia}</td>
                    <td class="text-nowrap">
                        <a href="${updateLink}" >Edytuj</a>
                        <a href="${deleteLink}" onclick="if(!(confirm('Czy na pewno chcesz usunąć tego kierowcę?'))) return false">Usuń</a>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
    </div>

<div class="container bg-primary"><br></div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>

</body>
</html>
