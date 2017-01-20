<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Panel Serwisu</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2 class="text-center">Panel Serwisu</h2>
    <div class="col-xs-12"><br></div>
    <div class="container-fluid bg-primary">
        <a href="${pageContext.request.contextPath}/pojazdy/zmienBadanie" class="btn btn-success col-xs-12">Zmien datę następnego badania technicznego</a>
        <div class="col-xs-12"><br></div>
        <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-danger col-xs-12">Wróć</a>
    </div>
</div>
<div class="container bg-primary"><br></div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
