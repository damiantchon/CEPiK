<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<html>
<head>
    <title>Panel ${ubezpieczyciel}</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2 class="text-center">Panel ubezpieczyciela ${ubezpieczyciel}</h2>

    <form:form action="przegladajOc" role="form" data-toggle="validator" modelAttribute="oc" cssClass="form-horizontal" method="POST">
        <form:hidden path="Ubezpieczyciel"/>
        <input type="submit" value="Przeglądaj ubezpieczenia" class="btn btn-success col-xs-12"/>
    </form:form>

    <c:url var="dodajUbezpieczenie" value="/oc/ubezpieczenieForm">

    </c:url>
    <a href="${dodajUbezpieczenie}" class="btn btn-success col-xs-12">Dodaj ubezpieczenie</a>
    <div class="col-xs-12"><br></div>
    <a href="${pageContext.request.contextPath}/index.jsp" class="btn btn-danger col-xs-12">Wróć</a>
</div>
<div class="container bg-primary"><br></div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
