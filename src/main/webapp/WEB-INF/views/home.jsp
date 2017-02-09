<%-- 
    Document   : home
    Created on : 2017-01-30, 11:13:23
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
                <jsp:include page="loginbar.jsp" />
            </div>

            <div class="header">
                <jsp:include page="header.jsp" />
            </div>

            <div class="leftmenu">
                <jsp:include page="leftmenu.jsp" />                
            </div>
            <div class="content">
                <div>
                    <table class="books">
                        <c:forEach items="${books}" var="book">
                            <tr>
                                <td><a href="${pageContext.request.servletContext.contextPath}/book/${book.id}">
                                                <img src="${pageContext.request.servletContext.contextPath}/picture/${book.picture.id}"
                                                     height="150" width="220" alt="Zdjecie ksiazki" />             
                                    </a></td>
                                <td>
                                    <ul class="table_ul">
                                        <li>${book.title}</li>
                                        <li>${book.author}</li>
                                        <li>${book.price}zl</li>
                                        <li><a class="table_a" href="${pageContext.request.servletContext.contextPath}/order/buy/add?id=${book.id}">Dodaj do koszyka</a></li>
                                    </ul>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
            <div class="footer">
                <jsp:include page="footer.jsp"/>
            </div>
        </div>
    </body>
</html>
