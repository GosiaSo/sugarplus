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
<%--TO DO wykresy:--%>
<div class="button1">
    <a href="<c:url value="/sugarplus/sugars/graphs"/>"><button class="button1">Wykresy</button></a>
</div>
<div class="button1">
    <a href="<c:url value="/sugarplus/sugars/testy"/>"><button class="button1">test wykresóóów</button></a>
</div>
<br>

<div>
    <table>
        <thead>
        <tr>
            <th>Średnia z 7 dni</th>
            <th>Średnia z 14 dni</th>
            <th>Średnia z 90 dni</th>
            <th>Średnia z 90 dni</th>
        </tr>
        </thead>
        <tbody>
                <tr></tr>
                <tr></tr>
                <tr></tr>
                <tr></tr>
        </tbody>
    </table>
</div>
<div>

    <table>
        <thead>
        <tr>
            <th>Data</th>
            <th>Godzina</th>
            <th>Cukier</th>
            <th>Korekta</th>
            <th>WW</th>
            <th>Bolus</th>
            <th>Aktywność fizyczna</th>
        </tr>
        </thead>
        <tbody>
        <c:forEach items="${sugars}" var="sugar">
            <tr>
                <td>${sugar.date}</td>
                <td>${sugar.time}</td>
                <td>${sugar.value}</td>
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
