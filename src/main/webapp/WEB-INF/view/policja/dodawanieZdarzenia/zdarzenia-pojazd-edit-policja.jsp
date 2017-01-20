<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Panel Policji</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h4>Zmiana statusu dla ${kierowca.imie} ${kierowca.nazwisko} (ID: ${kierowca.idKierowcy})</h4>
</div>
<div class="container" style="background: white">
    <form:form action="zapiszPojazdIZdarzenie" role="form" data-toggle="validator" modelAttribute="pojazd" cssClass="form-horizontal" method="POST">

        <form:hidden path="NumerRejestracyjny"/>
        <form:hidden path="Marka"/>
        <form:hidden path="Model"/>
        <form:hidden path="TerminBadania"/>
        <div class="form-group">
            <form:label path="CzyKradziony" for="kradzionyInput" class="control-label col-xs-1">Kradziony:</form:label>
            <div class="col-xs-1"></div>
            <div class="col-xs-2">
                <form:select path="CzyKradziony" id="kradzionyInput" cssClass="form-control">
                    <form:option value="TAK">TAK</form:option>
                    <form:option value="NIE">NIE</form:option>
                </form:select>
            </div>
        </div>
        <input class="btn btn-danger col-xs-2" value="Wróc" onClick="history.go(-1);return true;">
        <input type="submit" value="Zapisz" class="btn btn-success col-xs-2"/>

    </form:form>

</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>