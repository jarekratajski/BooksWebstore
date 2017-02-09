<%-- 
    Document   : edit
    Created on : 2017-02-06, 14:37:20
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
                    <h1>Edycja danych</h1>
                </div>
                <form:form action="${user.username}" method="post" modelAttribute="user">
                    <table class="user_edit_table">
                        <tr>
                            <td><label for="username">Nazwa uzytkownika</label></td>
                            <td><form:input class="user_edit_table_input" path="username" id="username" placeholder="Nazwa uztkownika"/></td>
                        </tr>
                        <tr>
                            <td><label for="email">E-mail</label></td>
                            <td><form:input class="user_edit_table_input" path="email" id="email" placeholder="E-mail"/></td>
                        </tr>
                        <tr>
                            <td><label for="role">Rola:</label></td>
                            <td><form:select class="user_edit_table_select" path="role" id="role" size="3">
                                    <form:option value="ROLE_USER" />
                                    <form:option value="ROLE_DEALER"/>
                                    <form:option value="ROLE_ADMIN"/>
                            </form:select></td>
                        </tr>
                        <tr>
                            <td></td>
                            <td><input class="a_button" type="submit" value="Edytuj"</td>
                        </tr>
                    </table>
                        
                </form:form>
            </div>
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
