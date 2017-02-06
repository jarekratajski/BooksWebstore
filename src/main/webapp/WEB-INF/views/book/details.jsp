<%-- 
    Document   : details
    Created on : 2017-02-02, 15:42:21
    Author     : Matuidi
--%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
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
                <div id="addBook">
                    <div class="select">
                        <table class="login_table">
                            <tr>
                                <td>Tytul:</td>
                                <td>${book.title}</td>
                            </tr>
                            <tr>
                                <td>Autor:</td>
                                <td>${book.author}</td>
                            </tr>
                            <tr>
                                <td>Wydawnictwo:</td>
                                <td>${book.publisher.name}</td>
                            </tr>
                            <tr>
                                <td>Cena:</td>
                                <td>${book.price}</td>
                            </tr>
                            <tr>
                                <td>Rok wydania:</td>
                                <td>${book.year}</td>
                            </tr>
                            <tr>
                                <td>Gatunek:</td>
                                <td>${book.type.type}</td>
                            </tr>
                            <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')">
                                <tr>
                                    <td> <a href="${pageContext.request.servletContext.contextPath}/dealer/books/edit/${book.id}">Edytuj</a></td>
                                    <td> <a href="${pageContext.request.servletContext.contextPath}/dealer/books/delete/${book.id}">Skasuj</a></td>
                                </tr>
                            </sec:authorize>
                        </table>

                    </div>
                </div>
            </div>
            <div id="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
