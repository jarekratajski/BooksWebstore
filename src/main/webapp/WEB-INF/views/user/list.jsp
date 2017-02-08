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
                <div id="addBook">
                    <div class="select">
                        <sec:authorize access="hasRole('ROLE_ADMIN')">
                            <table class=basket>
                                <tr>
                                    <td>Nazwa uzytkownika</td>
                                    <td>Rola uzytkownika</td>
                                    <td></td>
                                </tr>
                                <c:forEach items="${users}" var="user">
                                    <tr>
                                        <td>
                                            ${user.username}
                                        </td>
                                        <td>
                                            ${user.role}
                                        </td>
                                        <td style="width: 480px;">
                                            <ul>
                                                <li><a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/admin/edit/${user.username}">Edytuj</a>
                                                <a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/user/${user.username}">Skasuj</a>
                                                 <a  class="a_buttonSmall" href="${pageContext.request.contextPath}/user/change/password/${user.username}">Zmien haslo</a></li>
                                            </ul>
                                        </td>
                                    </tr>
                                </c:forEach>
                            </table>
                        </sec:authorize>
                    </div>
                </div>
            </div>
            <div id="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>

