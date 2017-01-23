<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
    <title>Panel ${ubezpieczyciel}</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2>Wybierz pojazd (panel ${ubezpieczyciel})</h2>
</div>
<div class="container" style="background: white">
    <h4>Wpisz numer rejestracyjny pojazdu, któremu chcesz dodać ubezpieczenie OC:</h4>
    <form:form action="znajdzPojazd" type="form" data-toggle="validator"  modelAttribute="pojazd" cssClass="form-horizontal" method="POST">
        <div class="form-group">
            <div class="col-xs-12">
                <form:input  path="NumerRejestracyjny" id="numerInput" cssClass="form-control" placeholder="np. WB9876M" required="required"/>
                <br>
            </div>
            <c:choose>
                <c:when  test="${pojazd.numerRejestracyjny!=null}">
                    <h4 style="color: red;">Brak pojazdu o podanym numerze rejestracyjnym w bazie danych!</h4>
                </c:when>
                <c:otherwise>
                </c:otherwise>
            </c:choose>
            <a href="${pageContext.request.contextPath}/oc/wejdzUbezpieczyciel" class="btn btn-danger col-xs-2">Wróć</a>
        <input class="btn btn-success col-xs-2" value="Wybierz" type="submit"/>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
