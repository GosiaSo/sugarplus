<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<%@ include file="../header.jsp"%>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/hidenForm.js" ></script>
    <title>Dodaj nowy pomiar</title>
</head>
<body>

<div id="form">
    <form:form method="post" modelAttribute="sugar">
        <div class="form">
            <label>Poziom cukru</label>
            <form:input placeholder="wpisz poziom cukru" path="value"/>
            <form:errors path="value"/><br>
        </div>
        <div class="form">
            <label>Data</label>
            <form:input path="date"/>
            <form:errors path="date"/><br>
        </div>
        <div class="form">
            <label>Godzina pomiaru</label>
            <form:input path="time"/>
            <form:errors path="time"/><br>
        </div>

        <%--    rozwinięcie by dodać szczegóły pomiaru--%>
        <div class="form">
            <input class="form-check-input" type="checkbox" id="details">
            <label class="form-check-label" for="details">Chcę dodać szczegóły</label>
        </div>
        <%--    to co po rozwinięciu--%>
        <div id="sugarDetails">
            <div class="form">
                <label>Korekta na wysoki cukier</label>
                <form:input placeholder="wpisz podane jednostki insuliny" path="correctionForHypo"/>
                <form:errors path="correctionForHypo"/><br>
            </div>
            <div class="form">
                <label>Ilość zjedzonych wymienników węglowodanowych</label>
                <form:input placeholder="wpisz zjedzone WW" path="carbohydratesInMeal"/>
                <form:errors path="carbohydratesInMeal"/><br>
            </div>
            <div class="form">
                <label>Podany bolus</label>
                <form:input placeholder="wpisz jednostki podanej insulinę" path="bolusForMeal"/>
                <form:errors path="bolusForMeal"/><br>
            </div>
            <div class="form">
                Aktywność fizyczna: <form:checkbox path="physicalActivity"/>
            </div>
        </div>


        <button type="submit" onclick="return confirm('Chcesz zapisać zmiany?');">Zapisz</button>
    </form:form>
</div>

</body>
<%@ include file="../footer.jsp"%>
</html>
