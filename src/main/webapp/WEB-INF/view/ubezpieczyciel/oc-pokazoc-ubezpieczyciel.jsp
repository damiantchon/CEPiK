<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Panel ${ubezpieczyciel}</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container bg-primary"><br></div>
<div class="container bg-primary">
    <h2>OC (ID: ${oc.idOc})</h2>
</div>
<div class="container" style="background: white">
    <h3>Data rozpoczęcia: ${oc.rozpoczecie}</h3>
    <h3>Data zakończenia: ${oc.zakonczenie}</h3>
    <input class="btn btn-danger" value="Wróc" onClick="history.go(-1);return true;">
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
