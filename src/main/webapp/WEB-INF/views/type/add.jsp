<%-- 
    Document   : add
    Created on : 2017-01-30, 18:24:38
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
                    <table class="type_add_table">
                        <form:form action="new"
                                   method="POST" modelAttribute="type"
                                   >
                            <h1>Dodawanie gatunkow:</h1>
                            <tr>
                                <td class="type_add_table_td"><label for="name">Gatunek:</label></td>
                                <td class="type_add_table_td"><form:input class="type_add_table_input" path="type" id="name" placeholder="Gatunek"/></td>
                            </tr>
                            <tr>
                                <td><input class="a_button" type="submit" value="Dodaj"/></td>
                            </tr>
                        </form:form>
                    </table>
                </div>
            </div>
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>

