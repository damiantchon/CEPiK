<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Panel Serwisu</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2></h2>
    <form:form action="zapiszEdytowanyPojazdSerwis" type="form" data-toggle="validator"  modelAttribute="pojazd" cssClass="form-horizontal" method="POST">
        <div class="form-group">
            <form:label path="NumerRejestracyjny" for="numerInput" cssClass="text-nowrap control-label col-xs-2">Numer rejestracyjny:</form:label>
            <div class="col-xs-10">
                <form:input  path="NumerRejestracyjny" id="numerInput" cssClass="form-control" placeholder="Wpisz numer rejestracyjny" required="required" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="Marka" for="markaInput" cssClass="control-label col-xs-2">Marka:</form:label>
            <div class="col-xs-10">
                <form:input path="Marka" id="markaInput" cssClass="form-control" placeholder="Wpisz markę" required="required" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="Model" for="modelInput" cssClass="control-label col-xs-2">Model:</form:label>
            <div class="col-xs-10">
                <form:input path="Model" id="modelInput" cssClass="form-control" placeholder="Wpisz model" required="required" readonly="true"/>
            </div>
        </div>
        <div class="form-group">
            <form:label id="rangeForm" path="TerminBadania" for="terminInput" cssClass="text-nowrap control-label col-xs-2">Termin badania tech. :</form:label>
            <div class="col-xs-10" >
                <form:input path="TerminBadania" id="terminInput" cssClass="form-control" type="date" required="required" min=""/>
            </div>
        </div>
        <form:hidden path="IdOc"/>
        <form:hidden path="IdKierowcy"/>
        </div>
        <div class="col-xs-2"></div>
        <div class="col-xs-10">
            <a href="${pageContext.request.contextPath}/serwis-panel.jsp" class="btn btn-danger">Wróć</a>
            <input type="submit" value="Zapisz" class="btn btn-success"/>
        </div>
    </form:form>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
