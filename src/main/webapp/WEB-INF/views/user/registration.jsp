<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<%@ include file="../header.jsp" %>
<head>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/passwordCheck.js" ></script>
    <title>Zarejestruj się</title>
</head>
<body>
<div id="form">
    <form:form method="post" modelAttribute="user">
        <div class="form">
            <label>Imię</label>
            <form:input placeholder="podaj swoje imię" path="name"/>
            <form:errors path="name"/><br>
        </div>
        <div class="form">
            <label>Nazwisko</label>
            <form:input placeholder="podaj swoje nazwisko" path="surname"/>
            <form:errors path="surname"/><br>
        </div>
        <div class="form">
            <label>Login</label>
            <form:input placeholder="podaj swój login" path="username"/>
            <form:errors path="username"/><br>
        </div>
        <div class="form" id="password1">
            <label>Hasło</label>
            <form:input placeholder="ustaw hasło" path="password"/>
            <form:errors path="password"/><br>
        </div>
        <div class="form" id="password2">
            <label>Hasło</label>
            <form:input placeholder="powtórz hasło" path="passwordTest"/>
            <form:errors path="password"/><br>
        </div>
        <div id="passwordAlert"></div>
        <div class="form">
            <label>E-mail</label>
            <form:input placeholder="podaj swój email" path="email"/>
            <form:errors path="email"/><br>
        </div>
        <button class="button1" type="submit" onclick="return confirm('Chcesz zapisać zmiany?');">Zarejestruj się</button>

    </form:form>
</div>
</body>
<%@	include file="../footer.jsp"%>
</html>
