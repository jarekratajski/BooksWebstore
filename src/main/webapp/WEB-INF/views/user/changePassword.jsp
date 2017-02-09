<%-- 
    Document   : changePassword
    Created on : 2017-02-04, 22:21:04
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
                    <h1>Zmien haslo</h1>
                </div>
                <form:form action="${pageContext.request.userPrincipal.name}" method="post" modelAttribute="password">
                    <table class="change_password_table">    
                        <tr>
                            <td class="change_password_table_td"><label for="password">Haslo</label></td>
                            <td class="change_password_table_td"><form:input class="change_password_table_input" type="password"  path="password" id="password" placeholder="Haslo"/></td>
                        </tr>
                        <tr>
                            <td class="change_password_table_td"><label for="passwordRepeat">Powtorz haslo</label></td>
                            <td class="change_password_table_td"><form:input class="change_password_table_input" type="password"  path="passwordRepeat" id="passwordRepeat"  placeholder="Powtorz haslo"/></td>
                        </tr>       
                        <tr>
                            <td></td>
                            <td><input class="a_button" type="submit" value="Zmien haslo"</td>
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