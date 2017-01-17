<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dodaj zdarzenie</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container">
    <h2></h2>
    <form:form action="zapiszZdarzenie" role="form" data-toggle="validator" modelAttribute="zdarzenie" cssClass="form-horizontal" method="POST">
        <form:hidden path="IdZdarzenia"/>
        <div class="form-group">
            <form:label path="IdKierowcy" for="kieroInput" class="control-label col-xs-2">Id kierowcy:</form:label>
            <div class="col-xs-10">
                <form:input path="IdKierowcy" id="kieroInput"  cssClass="form-control" type="number"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="NumerRejestracyjny" for="numerInput" class="control-label col-xs-2">Numer rejestracyjny:</form:label>
            <div class="col-xs-10">
                <form:input path="NumerRejestracyjny" id="numerInput"  cssClass="form-control" type="text"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="DataZdarzenia" for="dataInput" class="control-label col-xs-2">Data Zdarzenia:</form:label>
            <div class="col-xs-10">
                <form:input path="DataZdarzenia" id="dataInput"  cssClass="form-control" required="required" type="date"/>
            </div>
        </div>
        <div class="form-group">
            <form:label path="TypZdarzenia" for="typInput" class="control-label col-xs-2">Typ Zdarzenia:</form:label>
            <div class="col-xs-10">
                <form:select path="TypZdarzenia" id="typInput" cssClass="form-control">
                    <form:option value="Wypadek">Wypadek</form:option>
                    <form:option value="Stłuczka">Stłuczka</form:option>
                    <form:option value="Wykroczenie">Wykroczenie</form:option>
                    <form:option value="Przestępstwo drogowe">Przestępstwo drogowe</form:option>
                    <form:option value="Odebranie uprawnień">Odebranie uprawnień</form:option>
                    <form:option value="Nadanie uprawnień">Nadanie uprawnień</form:option>
                    <form:option value="Zgłoszenie kradzieży">Zgłoszenie kradzieży</form:option>
                    <form:option value="Inne">Inne</form:option>
                </form:select>
            </div>
        </div>
        <div class="form-group">
            <form:label path="OpisZdarzenia" for="opisInput" class="control-label col-xs-2">Opis Zdarzenia:</form:label>
            <div class="col-xs-10">
                <form:textarea rows="4" path="OpisZdarzenia" id="opisInput"  cssStyle="resize: none" cssClass="form-control" required="required" maxlength="200"/>
            </div>
        </div>
        <div class="col-xs-2"></div>
        <div class="col-xs-10">
            <p style="color: red">Podaj ID kierowcy lub numer rejestracyjny (lub oba)</p>
            <a href="${pageContext.request.contextPath}/policja-panel.jsp" class="btn btn-danger">Wróć</a>
            <input type="submit" value="Zapisz" class="btn btn-success"/>
        </div>
    </form:form>
</div>

<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
