<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
    <title>Dodaj kierowce</title>
    <link href="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
<br>
<div class="container bg-primary">
    <h2>Wyszukiwanie kierowcy</h2>
</div>
<div class="container" style="background: white">
    <h2></h2>
    <form:form action="sprawdzKierowce" role="form" data-toggle="validator" modelAttribute="kierowca" cssClass="form-horizontal" method="GET">
        <div class="form-group">
            <form:label path="IdKierowcy" for="idInput" cssClass="control-label col-xs-2 text-nowrap">ID kierowcy:</form:label>
            <div class="col-xs-2">
                <form:input path="IdKierowcy" id="idInput"  cssClass="form-control" placeholder="ID" required="required" type="number" value=""/>
            </div>
            <input type="submit" value="Wyszukaj" class="btn btn-success"/>
            <a href="${pageContext.request.contextPath}/policja-panel.jsp" class="btn btn-danger">Wróć</a>
        </div>

    </form:form>
</div>
<script src="${pageContext.request.contextPath}/webjars/jquery/2.1.1/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/webjars/bootstrap/3.2.0/js/bootstrap.min.js"></script>
</body>
</html>
