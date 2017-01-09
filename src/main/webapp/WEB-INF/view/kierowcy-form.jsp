<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 08.01.2017
  Time: 15:28
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dodaj kierowce</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <h2></h2>
        <form:form action="zapiszKierowce"  modelAttribute="kierowca" cssClass="form-horizontal" method="POST">
            <form:hidden path="IdKierowcy"/>
            <div class="form-group">
                <form:label path="Imie" for="imieInput" cssClass="control-label col-xs-2">Imię:</form:label><!--TODO-->
                <div class="col-xs-10">
                <form:input path="Imie" id="imieInput"  cssClass="form-control" placeholder="Wpisz imię"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="Nazwisko" for="nazwiskoInput" class="control-label col-xs-2">Nazwisko:</form:label>
                <div class="col-xs-10">
                <form:input path="Nazwisko" id="nazwiskoInput"  cssClass="form-control" placeholder="Wpisz nazwisko"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="EMail" for="emailInput" class="control-label col-xs-2">E-mail:</form:label>
                <div class="col-xs-10">
                <form:input path="EMail" id="emailInput"  cssClass="form-control" placeholder="Wpisz e-mail"/>
                </div>
            </div>
            <div class="form-group">
                <form:label path="CzyPosiadaUprawnienia" for="uprawnieniaInput" class="control-label col-xs-2">Uprawnienia:</form:label>
                <div class="col-xs-2">
                    <form:select path="CzyPosiadaUprawnienia" id="uprawnieniaInput" cssClass="form-control">
                        <form:option value="TAK">TAK</form:option>
                        <form:option value="NIE">NIE</form:option>
                    </form:select>
                </div>
            </div>
            <div class="col-xs-2"></div>
            <div class="col-xs-10">
                <a href="${pageContext.request.contextPath}/kierowcy/lista" class="btn btn-danger">Wróć</a>
                <input type="submit" value="Zapisz" class="btn btn-success"/>
            </div>
        </form:form>
    </div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
