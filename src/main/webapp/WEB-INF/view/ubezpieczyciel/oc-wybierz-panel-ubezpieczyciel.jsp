<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Ubezpieczyciela</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2 class="text-center">Wybierz ubezpieczyciela</h2>
</div>
<div class="container bg-primary">
    <br>
    <div>
        <div class="col-xs-1"></div>
    <form:form action="wejdzUbezpieczyciel" role="form" data-toggle="validator" modelAttribute="oc" cssClass="form-horizontal" method="POST">
    <div class="form-group col-xs-10">
        <form:select path="Ubezpieczyciel" id="ubezpieczycielInput" cssClass="selectpicker form-control">
            <form:option value="AVIVA Direct">AVIVA Direct</form:option>
            <form:option value="PZU">PZU</form:option>
            <form:option value="ALLIANZ Direct">ALLIANZ Direct</form:option>
            <form:option value="LINK4">LINK4</form:option>
            <form:option value="MetLife">MetLife</form:option>
            <form:option value="HESTIA">HESTIA</form:option>
        </form:select>
    </div>
        <div class="col-xs-1"></div>
    </div>
    <div>
        <input type="submit" value="Wejdź" class="btn btn-success col-xs-12"/>
    </div>
    </form:form>
</div>
<div class="container bg-primary"><br></div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>