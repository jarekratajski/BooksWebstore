<%-- 
    Document   : list
    Created on : 2017-02-04, 12:48:54
    Author     : Matuidi
--%>

<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
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
                <jsp:include page="../../loginbar.jsp" />
            </div>

            <div class="header">
                <jsp:include page="../../header.jsp" />
            </div>

            <div class="leftmenu">
                <jsp:include page="../../leftmenu.jsp" />                
            </div>
            <div class="content">
                <div>
                    <c:if test="${empty orders}">
                        <h1>Nie masz zadnych zamowien</h1>
                    </c:if>
                    <c:if test="${not empty orders}">
                        <div>
                            <h1>Twoje zamowienia</h1>
                        </div>
                        <table>
                            <tr>
                                <td>Numer</td>
                                <td>&nbsp&nbsp&nbsp&nbsp</td>
                                <td>Cena zamowienia</td>
                                <td>&nbsp&nbsp&nbsp&nbsp</td>
                                <td>Data utworzenia</td>
                            </tr>
                            <c:forEach items="${orders}" var="order" varStatus="count">
                                <tr>
                                    <td>${count.index + 1}.</td>
                                    <td></td>
                                    <td>${order.buyTotalCost}zl</td>
                                    <td></td>
                                    <td>${order.dateCreated}</td>
                                </tr>
                            </c:forEach>
                        </table>
                    </c:if>
                </div>
            </div>
            <div class="footer">
                <jsp:include page="../../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
