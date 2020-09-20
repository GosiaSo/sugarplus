<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<link rel="stylesheet" href="${pageContext.request.contextPath}/css/style.css"/>
<header>

    <ul class="header">
        <li>
            <a href="<c:url value="/sugarplus/home"/>"><img src="<c:url value="/img/glukometr.png"/>" alt="glukometr"/></a>
        </li>
        <li>Sugar Plus</li>

        <%--security and user profile--%>
        <sec:authorize access="isAuthenticated()">
            <li id="logout">
                    <%--TO DO: tutaj można a href i do środka włożyć img i javascript na rozwinięcie edit profile--%>
                <img src="<c:url value="/img/icon.png"/>" alt="person round icon">
                <a href="<c:url value="/logout"/>">
                    <button class="button2">
                        Witaj <sec:authentication
                            property="principal.username"/> !
                        Wyloguj się
                    </button>
                </a>
            </li>
        </sec:authorize>

        <sec:authorize access="!isAuthenticated()">
            <li id="logout">
                    <%--TO DO: tutaj można a href i do środka włożyć img--%>
                <img src="<c:url value="/img/icon.png"/>" alt="person round icon">
                <a href="<c:url value="/login"/>">
                    <button class="button2">Zaloguj się</button>
                </a>
            </li>
        </sec:authorize>
    </ul>


</header>
</html>
