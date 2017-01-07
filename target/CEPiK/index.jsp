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
    <title>$Title$</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <div class="container">
        <a href="/pojazdy/lista">Lista pojazdów</a>
        <br>
        <a href="/kierowcy/lista">Lista kierowców</a>
        <br>
        <a href="/oc/lista">Lista oc</a>
        <br>
        <a href="/zdarzenia/lista">Lista zdarzeń</a>
    </div>
    <script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
    <script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
