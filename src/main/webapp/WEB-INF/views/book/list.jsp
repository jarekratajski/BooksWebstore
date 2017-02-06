<%-- 
    Document   : list
    Created on : 2017-02-02, 13:39:30
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
                <div class="select">
                    <table class="books">
                        <c:forEach items="${books}" var="book">
                            <tr>
                                <td><a href="${pageContext.request.servletContext.contextPath}/book/${book.id}">
                                        <img src="${pageContext.request.servletContext.contextPath}/picture/${book.picture.id}"
                                             height="150" width="220" alt="Brak zdjecia ksiazki" />
                                    </a>
                                </td>
                                <td>
                                    <ul>
                                        <li>${book.title}</li>
                                        <li>${book.author}</li>
                                        <li>${book.price}zl</li>
                                        <li><a href="${pageContext.request.servletContext.contextPath}/order/buy/add?id=${book.id}">Dodaj do koszyka</a>
                                            <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')">
                                                <a href="${pageContext.request.servletContext.contextPath}/dealer/books/edit/${book.id}">Edytuj</a>
                                                <a href="${pageContext.request.servletContext.contextPath}/dealer/books/delete/${book.id}">Skasuj</a>
                                            </sec:authorize>
                                        </li>
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