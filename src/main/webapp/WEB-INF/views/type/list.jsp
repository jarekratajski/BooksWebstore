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
                    <table class="type_list_table">
                        <c:forEach items="${types}" var="type">
                            <tr style="height: 50px;">
                                <td>                   
                                    <a class="type_button"href="${pageContext.request.servletContext.contextPath}/book/type/${type.id}">${type.type}</a>    
                                </td>
                                <sec:authorize access="hasAnyRole('ROLE_DEALER','ROLE_ADMIN')"> 
                                    <td>
                                        <a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/dealer/types/edit/${type.id}">Edytuj</a>
                                        <a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/dealer/types/delete/${type.id}">Skasuj</a>                               
                                    </td>
                                </sec:authorize>                               
                            </tr>
                        </c:forEach>
                    </table>
                </div>    
            </div> 
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>

