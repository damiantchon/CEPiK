<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Baza oc</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<div class="container bg-primary">
    <h3>Panel ubezpieczyciela ${ubezpieczyciel}</h3>

    <form:form action="przegladajOc" role="form" data-toggle="validator" modelAttribute="oc" cssClass="form-horizontal" method="POST">
        <form:hidden path="Ubezpieczyciel"/>
        <input type="submit" value="Przeglądaj ubezpieczenia" class="btn btn-success col-xs-12"/>
    </form:form>

    <c:url var="dodajUbezpieczenie" value="/oc/ubezpieczenieForm">

    </c:url>
    <a href="${dodajUbezpieczenie}" class="btn btn-success col-xs-12">Dodaj ubezpieczenie</a>

</div>
<div class="container bg-primary"><br></div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
