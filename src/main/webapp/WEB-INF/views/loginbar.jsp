<%-- 
    Document   : loginbar
    Created on : 2017-01-30, 17:53:42
    Author     : Matuidi
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<section id="login_section">
    <sec:authorize access="!hasAnyRole('ROLE_USER', 'ROLE_DEALER' , 'ROLE_ADMIN')">

        <a class="a_button" href="${pageContext.request.contextPath}/login">Logowanie</a>
        <a class="a_button" href="${pageContext.request.contextPath}/user/new">Rejestracja</a>
    </sec:authorize>

    <c:if test="${pageContext.request.userPrincipal.name != null}">
        <div id="user_hello">
            <h1>Witaj <a style="color:black;" href="${pageContext.request.contextPath}/user/${pageContext.request.userPrincipal.name}">${pageContext.request.userPrincipal.name}</a></h1>
                <sec:authorize access="hasRole('ROLE_USER')">

                Witaj w sklepie

            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_DEALER')">

                Witaj w sklepie sprzedawco

            </sec:authorize>

            <sec:authorize access="hasRole('ROLE_ADMIN')">

                Witaj w swoim sklepie

            </sec:authorize>

        </div>
    </c:if>


    <div id="usersbutton">
        <div id="user_list">
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <a class="a_button" href="${pageContext.request.contextPath}/admin/users">Uzytkownicy</a>
            </sec:authorize>
        </div>
        <div id="user_logout">
            <c:if test="${pageContext.request.userPrincipal.name != null}">
                <a class="a_button" href="${pageContext.request.contextPath}/logout">Wyloguj</a>
            </c:if>
        </div>
    </div>
</section>
