<%-- 
    Document   : header
    Created on : 2017-01-30, 17:48:45
    Author     : Matuidi
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>

<section>

	<div class="headertext">
		<h1>
			<span style="font-size: 35px;">Najlepsze ksiazki</span> 
			<span style="font-size: 15px;">jakie tylko mozesz miec</span>
		</h1>

	</div>

	<div class="menu">

		<a class="menu_a" href="${pageContext.request.contextPath}">Strona glowna</a> 
		<a class="menu_a" href="${pageContext.request.contextPath}/underconstruction">Kontakt</a>
		<sec:authorize access="hasAnyRole('ROLE_ADMIN','ROLE_USER','ROLE_DEALER')">
		<a class="menu_a" href="${pageContext.request.contextPath}/order/buy/${pageContext.request.userPrincipal.name}/list" >Moje zamowiania</a>
		</sec:authorize>
                <a class="menu_a" style="float: right;" href="${pageContext.request.contextPath}/order/buy/cart" >Moj koszyk</a>
	</div>

</section>
	
