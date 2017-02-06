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
                            <form:form action="new?${_csrf.parameterName}=${_csrf.token}"
                                       method="POST" modelAttribute="publisher"
                                       enctype="multipart/form-data">

                                <h1>Dodawanie wydawnictwa</h1>
                                <tr>
                                    <td><label for="name">Nazwa wydawnictwa:</label></td>
                                    <td><form:input path="name" id="name" placeholder="Nazwa wydawnictwa"/></td>
                                </tr>
                                <tr>
                                    <td><label for="creationYear">Rok powstaniaia</label></td>
                                    <td><form:input path="creationYear" id="creationYear" placeholder="Rok powstaniaia"/></td>
                                </tr>
                                <tr>
                                    <td>
                                        <input type="file" name="uploadFile" />
                                    </td>
                                </tr>
                                <td><input type="submit" value="Dodaj"/></td>
                                </form:form>
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

