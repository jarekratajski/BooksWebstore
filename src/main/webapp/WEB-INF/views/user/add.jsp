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
                    <h1>Rejestracja</h1>
                </div>
                <table class="user_add_table">
                    <form:form action="new" method="post" modelAttribute="user">
                        <tr>
                            <td class="user_add_table_td"><label for="username">Nazwa uzytkownika</label></td>
                            <td class="user_add_table_td"><form:input class="user_add_table_input" path="username" id="username" placeholder="Nazwa uztkownika"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="username" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>${errorUsername}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <td class="user_add_table_td"><label for="password">Haslo</label></td>
                            <td class="user_add_table_td"><form:input class="user_add_table_input" path="password" id="password" placeholder="Haslo"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="password" /></td>
                            </tr>
                        </c:if>
                        <tr>
                            <td class="user_add_table_td"><label for="passwordRepeat">Powtorz haslo</label></td>
                            <td class="user_add_table_td"><form:input class="user_add_table_input" path="passwordRepeat" id="passwordRepeat" placeholder="Powtorz haslo"/></td>
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
                            <td class="user_add_table_td"><label for="email">E-mail</label></td>
                            <td class="user_add_table_td"><form:input class="user_add_table_input" path="email" id="email" placeholder="E-mail"/></td>
                        </tr>
                        <c:if test="${pageContext.request.method=='POST'}">
                            <tr>
                                <td></td>
                                <td><form:errors path="email" /></td>
                            </tr>
                            <tr>
                                <td></td>
                                <td>${errorEmail}</td>
                            </tr>
                        </c:if>
                        <tr>
                            <td></td>
                            <td><input class="a_button" type="submit" value="Zarejestruj"</td>
                        </tr>
                    </form:form>
                </table>
            </div>
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>