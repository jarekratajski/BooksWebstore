<%-- 
    Document   : details
    Created on : 2017-02-04, 21:55:10
    Author     : Matuidi
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/style.css"	rel="stylesheet" type="text/css">
        <title>Ksiegarnia</title>
    </head>
    <body>
        <div class="container">
            <div class="loginbar">
                <jsp:include page="../loginbar.jsp" />
            </div>

            <div class="header">
                <jsp:include page="../header.jsp" />
            </div>

            <div class="leftmenu">
                <jsp:include page="../leftmenu.jsp" />                
            </div>
            <div class="content">
                <div>
                    <h1>Szczegoly uzytkownika</h1>
                    <table class="user_table_details">
                        <tr>
                            <td>Nazwa uzytkownika</td>
                            <td>${user.username}</td>
                        </tr>
                        <tr>
                            <td>Email</td>
                            <td>${user.email}</td>
                        </tr>
                        <tr>
                            <td>Ilosc zamowien</td>
                            <td>${user.ordersAmount}</td>
                        </tr>
                        <tr id="a_button">
                            <td>
                                <a class="a_buttonSmall" href="${pageContext.request.contextPath}/user/change/password/${pageContext.request.userPrincipal.name}">Zmien haslo</a>
                            </td>
                        </tr>
                    </table>
                </div>
            </div>
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>