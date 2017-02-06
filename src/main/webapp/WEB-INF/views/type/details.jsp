<%-- 
    Document   : details
    Created on : 2017-02-02, 18:40:38
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
    </    <body>
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
                                <td>Gatunek</td>
                                <td>${type.name}</td>
                            </tr> 
                            <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')">
                                <tr>
                                    <td> <a href="${pageContext.request.servletContext.contextPath}/dealer/types/edit/${type.id}">Edytuj</a></td>
                                    <td> <a href="${pageContext.request.servletContext.contextPath}/dealer/types/delete/${type.id}">Skasuj</a></td>
                                </tr>
                            </sec:authorize>
                            <tr>
                                <td>Ksiazki danego gatunku</td>
                            </tr>
                            <c:forEach items="${books}" var="book">
                                <tr>             
                                    <td>${book.title}</td>
                                    <td><a href="${pageContext.request.servletContext.contextPath}/book/${book.id}">Szczególy ksiazki</a></td>
                                </tr> 
                            </c:forEach>
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
