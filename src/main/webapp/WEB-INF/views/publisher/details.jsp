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
                    <table class="publihser_details_table">
                        <tr>                              
                            <td><a href="${pageContext.request.servletContext.contextPath}/publisher/${publisher.id}">
                                    <img src="${pageContext.request.servletContext.contextPath}/picture/${publisher.logo.id}"
                                         height="150" width="220" alt="Brak loga firmy" />
                                </a>
                            </td>                                    
                        <tr>
                            <td>Nazwa wydawnictwa</td>
                            <td>${publisher.name}</td>
                        </tr> 
                        <tr>
                            <td>Rok zalozenia</td>
                            <td>${publisher.creationYear}</td>
                        </tr> 
                        <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')">
                            <tr>
                                <td> <a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/dealer/publishers/edit/${book.id}">Edytuj</a></td>
                                <td> <a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/dealer/publishers/delete/${book.id}">Skasuj</a></td>
                            </tr>
                        </sec:authorize>
                        <tr>
                            <td>Ksiazki wydawnictwa:</td>
                        </tr>    
                        <c:forEach items="${books}" var="book">
                            <tr>             
                                <td>${book.title}</td>
                                <td><a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/book/${book.id}">Szczególy ksiazki</a></td>
                            </tr> 
                        </c:forEach>
                        </td></tr>
                    </table>
                </div>       
            </div>
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
