<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<%@	include file="header.jsp"%>
<head>
    <title>Sugar Plus</title>
</head>
<body>
<br/>
<h4>Sugar plus- diabetes tracker</h4><br/>
<%--${message}--%>
<%--TO DO flash message when deleting sth--%>
<div class="button1">
    <a href="<c:url value="/sugarplus/sugars/add"/>"><button class="button1">Dodaj nowy pomiar</button></a>
</div>
<br>

<div>

    <table>
        <thead>
        <tr>
            <th>#</th>
            <th>Data</th>
            <th>Cukier</th>
            <th>Godzina</th>
            <th>Korekta</th>
            <th>WW</th>
            <th>Bolus</th>
            <th>Aktywność fizyczna</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sugars}" var="sugar">
            <tr>
                <th>${sugar.id}</th>
                <td>${sugar.date}</td>
                <td>${sugar.value}</td>
                <td>${sugar.time}</td>
                <td>${sugar.correctionForHypo}</td>
                <td>${sugar.carbohydratesInMeal}</td>
                <td>${sugar.bolusForMeal}</td>
                <td>${sugar.physicalActivity}</td>
                <td>
<%--                    <a href='<c:url value = '/sugarplus/home/delete/${sugar.id}'/>'>usuń</a> --%>
                    <a href='<c:url value = '/sugarplus/sugars/edit/${sugar.id}'/>'>edytuj</a>
                </td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
</body>
<%@	include file="footer.jsp"%>
</html>
