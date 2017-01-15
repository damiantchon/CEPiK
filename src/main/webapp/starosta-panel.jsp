<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 14.01.2017
  Time: 16:45
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2 class="text-center">Panel Starosty</h2>
<div class="container-fluid bg-primary">
    <a href="${pageContext.request.contextPath}/pojazdy/lista" class="btn btn-success col-xs-12">Lista pojazdów</a>
    <br>
    <a href="${pageContext.request.contextPath}/kierowcy/lista" class="btn btn-success col-xs-12">Lista kierowców</a>
</div>
</div>
<div class="container bg-primary"><br></div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
