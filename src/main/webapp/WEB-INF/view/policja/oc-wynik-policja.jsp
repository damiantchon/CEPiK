<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>Oc:</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2> OC </h2>
</div>
<div class="container" style="background: white">
    <br>
    <p style="font-size: 20px" class="col-xs-3">ID:</p><p style="font-size: 20px" class="col-xs-9">${Oc.get(0).idOc}</p>
    <p style="font-size: 20px" class="col-xs-3">Rozpoczęcie:</p><p style="font-size: 20px" class="col-xs-9">${Oc.get(0).rozpoczecie}</p>
    <p style="font-size: 20px" class="col-xs-3">Zakończenie:</p><p style="font-size: 20px" class="col-xs-9">${Oc.get(0).zakonczenie}</p>
    <p style="font-size: 20px" class="col-xs-3">Ubezpieczyciel:</p><p style="font-size: 20px" class="col-xs-9">${Oc.get(0).ubezpieczyciel}</p>
</div>
<div class="container" style="background: white">
    <br>
    <input class="btn btn-danger" value="Wróc" onClick="history.go(-1);return true;">
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
