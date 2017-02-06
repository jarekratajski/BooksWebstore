<%-- 
    Document   : list
    Created on : 2017-01-30, 18:46:44
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
                <div class="select">
                    <table class="books">
                        <c:forEach items="${publishers}" var="publisher">
                            <tr>
                                <td><a href="${pageContext.request.servletContext.contextPath}/publisher/${publisher.id}">
                                        <img src="${pageContext.request.servletContext.contextPath}/picture/${publisher.logo.id}"
                                             height="150" width="220" alt="Brak loga firmy" />
                                    </a>
                                </td>
                                <td>
                                    <ul>
                                        <li>${publisher.name}</li>
                                            <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')">
                                            <li><a href="${pageContext.request.servletContext.contextPath}/dealer/publishers/edit/${publisher.id}">Edytuj</a></li>
                                            <li><a href="${pageContext.request.servletContext.contextPath}/dealer/publishers/delete/${publisher.id}">Skasuj</a></li>
                                            </sec:authorize>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>       
            </div>
            <div id="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>

