<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<%@ include file="../header.jsp" %>
<head>
    <title>Zarejestruj się!</title>
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
        <div class="form">
            <label>Hasło</label>
            <form:input placeholder="ustaw hasło" path="password"/>
            <form:errors path="password"/><br>
        </div>
        <div class="form">
            <label>E-mail</label>
            <form:input placeholder="podaj swój email" path="email"/>
            <form:errors path="email"/><br>
        </div>
        <button class="button1" type="submit" onclick="return confirm('Chcesz zapisać zmiany?');">Zarejestruj się</button>

    </form:form>
</div>
</body>
</html>
