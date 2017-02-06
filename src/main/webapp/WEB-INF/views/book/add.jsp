<%-- 
    Document   : add
    Created on : 2017-01-30, 12:07:02
    Author     : Matuidi
--%>
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
                            <form:form commandName="book"
                                       action="new?${_csrf.parameterName}=${_csrf.token}"
                                       method="post" modelAttribute="book"
                                       enctype="multipart/form-data">

                                <h1>Dodawanie ksiazki</h1>
                                <tr>
                                    <td><label  for="type">Gatunek:</label></td>
                                    <td>
                                        <form:select path="type.id" items="${types}" itemLabel="type" itemValue="id" size="3" >
                                        </form:select>
                                    </td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="type.id" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td><label for="publisher">Wydawnictwo:</label></td>
                                    <td>
                                        <form:select path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" size="3"></form:select>
                                        </td>
                                    </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="publisher.id" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td><label for="title">Tytul:</label></td>
                                    <td><form:input path="title" id="title" placeholder="Tytul"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="title" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td><label for="author">Autor:</label></td>
                                    <td><form:input path="author" id="author" placeholder="Autor"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="author" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td><label for="price">Cena:</label></td>
                                    <td><form:input path="price" id="price" placeholder="Cena"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="price" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td><label for="year">Rok wydania:</label></td>
                                    <td><form:input path="year" id="year" placeholder="Rok wydania"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="year" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td><label for="quantity">Ilosc:</label></td>
                                    <td><form:input path="quantity" id="quantity" placeholder="Ilosc"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td></td>
                                        <td><form:errors path="quantity" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td>
                                        <input type="file" name="uploadFile" />
                                    </td>
                                </tr>

                                <form:input type="hidden" path="id"/>
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
