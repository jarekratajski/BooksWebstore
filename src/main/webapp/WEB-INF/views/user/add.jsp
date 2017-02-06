<%-- 
    Document   : add
    Created on : 2017-02-04, 17:55:11
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
        <div id="wrapper">
            <div class="loginbar">
                <jsp:include page="../loginbar.jsp" />
            </div>

            <div id="header">
                <jsp:include page="../header.jsp" />
            </div>

            <div id="leftcolumn">
                <jsp:include page="../leftmenu.jsp" />                
            </div>
            <div id="rightcolumn">
                <div>
                    <h1>Rejestracja</h1>
                </div>
                <form:form action="new" method="post" modelAttribute="user">
                    <table>
                        <tr>
                            <td><label for="username">Nazwa uzytkownika</label></td>
                            <td><form:input path="username" id="username" placeholder="Nazwa uztkownika"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="username" /></td>
                            </tr>
                        </c:if>
                        <tr>
                            <td><label for="password">Haslo</label></td>
                            <td><form:input path="password" id="password" placeholder="Haslo"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="password" /></td>
                            </tr>
                        </c:if>
                        <tr>
                            <td><label for="passwordRepeat">Powtorz haslo</label></td>
                            <td><form:input path="passwordRepeat" id="passwordRepeat" placeholder="Powtorz haslo"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="passwordRepeat" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td><form:errors path="" /></td>
                            </tr>
                        </c:if>
                        <tr>
                            <td><label for="email">E-mail</label></td>
                            <td><form:input path="email" id="email" placeholder="E-mail"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="email" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>${error}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <td></td>
                            <td><input class="a_buttonSmall" type="submit" value="Zarejestruj"</td>
                        </tr>
                    </table>

                </form:form>
            </div>
            <div id="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>