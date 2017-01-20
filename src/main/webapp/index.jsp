<%--
  Created by IntelliJ IDEA.
  User: Damian
  Date: 04.01.2017
  Time: 16:55
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>CEPiK</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary text-center">
    <h1>CEPiK</h1>
</div>
<div class="container bg-primary">
    <a href="starosta-panel.jsp" class="btn btn-success col-xs-12">Panel Starosty</a>
    <a href="policja-panel.jsp" class="btn btn-success  col-xs-12">Panel Policji</a>
    <a href="/oc/wybierzUbezpieczyciela" class="btn btn-success  col-xs-12">Panel OC</a>
    <a href="serwis-panel.jsp" class="btn btn-success col-xs-12">Panel Serwisu</a>
</div>
<div class="container bg-primary"><br></div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
