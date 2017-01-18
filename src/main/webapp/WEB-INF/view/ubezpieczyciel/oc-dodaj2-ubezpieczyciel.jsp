<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">


</head>
<body>
<br>
<div class="container bg-primary">
    <h2>${pojazd.marka} ${pojazd.model} (${pojazd.numerRejestracyjny})</h2>
</div>
<div class="container" style="background: white">
    <h4></h4>
    <c:choose>
        <c:when  test="${pojazd.idOc==null}">
            <h3 style="color: green;">Brak OC - można dodać nowe OC.</h3>
        </c:when>
        <c:otherwise>
            <h3 style="color: red;">Ten samochód posiada już OC!</h3>
        </c:otherwise>
    </c:choose>

    <form:form action="zapiszOC" role="form" data-toggle="validator" modelAttribute="oc" cssClass="form-horizontal" method="POST">
        <form:hidden path="IdOc"/>
        <form:hidden path="Ubezpieczyciel"/>
        <div class="form-group">
            <form:label path="Rozpoczecie" for="rozpoczecieInput" cssClass="control-label col-xs-2">Rozpoczecie:</form:label>
            <div class="col-xs-10">
                <form:input path="Rozpoczecie" id="rozpoczecieInput"  cssClass="form-control"
                            placeholder="Wpisz imię" required="required" type="date" />
            </div>
        </div>
        <div class="form-group">
            <form:label path="Zakonczenie" for="zakonczenieInput" cssClass="control-label col-xs-2">Zakonczenie:</form:label>
            <div class="col-xs-10">
                <form:input path="Zakonczenie" id="zakonczenieInput"  cssClass="form-control"
                            placeholder="Wpisz imię" required="required" type="date"/>
            </div>
        </div>
        <div class="col-xs-2"></div>
        <div class="col-xs-10">
            <input class="btn btn-danger col-xs-1" value="Wróc" onClick="history.go(-1);return true;">
            <c:choose>
                <c:when  test="${pojazd.idOc==null}">
                    <input type="submit" value="Zapisz" class="btn btn-success"/>
                </c:when>
                <c:otherwise>
                    <input type="submit" value="Zapisz" class="btn btn-success disabled"/>
                </c:otherwise>
            </c:choose>

        </div>
    </form:form>
</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
