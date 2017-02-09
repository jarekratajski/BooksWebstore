<%-- 
    Document   : leftmenu
    Created on : 2017-01-30, 17:23:03
    Author     : Matuidi
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<section>
    <div id="allleftmenubuttons" class="leftmenu">
        <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')">
            <ul class="leftmenu_ul">
                <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/dealer/books/new">Dodaj nowa ksiazke</a></li>
                <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/dealer/publishers/new">Dodaj nowe wydawnictwo</a></li>
                <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/dealer/types/new">Dodaj nowy gatunek</a></li>
            </ul>
        </sec:authorize>
        <ul class="leftmenu_ul">
            <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/book/list">Wszystkie ksiazki</a></li>
            <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/publisher/list">Wszystkie wydawnictwa</a></li>
            <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/type/list">Wszystkie gatunki</a></li>

            <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/book/type/2">Sci-Fi</a></li>
            <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/book/type/1">Akcji</a></li>
            <li><a class="leftmenu_a" href="${pageContext.request.contextPath}/book/type/5">Fantasy</a></li>
        </ul>  
    </div>
</section>
