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
                <div id="addBook">
                    <div>
                        <table class="book_add_table">
                            <form:form commandName="book"
                                       action="new?${_csrf.parameterName}=${_csrf.token}"
                                       method="post" modelAttribute="book"
                                       enctype="multipart/form-data">

                                <h1>Dodawanie ksiazki</h1>
                                <tr>
                                    <td class="book_add_table_td" ><label  for="type">Gatunek:</label></td>
                                    <td class="book_add_table_td" >
                                        <form:select class="book_add_table_select" path="type.id" items="${types}" itemLabel="type" itemValue="id" size="3" >
                                        </form:select>
                                    </td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td" ></td>
                                        <td class="book_add_table_td" ><form:errors path="type.id" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td" ><label for="publisher">Wydawnictwo:</label></td>
                                    <td class="book_add_table_td" >
                                        <form:select class="book_add_table_select" path="publisher.id" items="${publishers}" itemLabel="name" itemValue="id" size="3"></form:select>
                                        </td>
                                    </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td" ></td>
                                        <td class="book_add_table_td"><form:errors path="publisher.id" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td"><label for="title">Tytul:</label></td>
                                    <td class="book_add_table_td"><form:input class="book_add_table_input" path="title" id="title" placeholder="Tytul"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td"></td>
                                        <td class="book_add_table_td"><form:errors path="title" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td"><label for="author">Autor:</label></td>
                                    <td class="book_add_table_td"><form:input class="book_add_table_input" path="author" id="author" placeholder="Autor"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td"></td>
                                        <td class="book_add_table_td"><form:errors path="author" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td"><label for="price">Cena:</label></td>
                                    <td class="book_add_table_td"><form:input class="book_add_table_input" path="price" id="price" placeholder="Cena"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td"></td>
                                        <td class="book_add_table_td"><form:errors path="price" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td"><label for="year">Rok wydania:</label></td>
                                    <td class="book_add_table_td"><form:input class="book_add_table_input" path="year" id="year" placeholder="Rok wydania"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td"></td>
                                        <td class="book_add_table_td"><form:errors path="year" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td"><label for="quantity">Ilosc:</label></td>
                                    <td class="book_add_table_td"><form:input class="book_add_table_input" path="quantity" id="quantity" placeholder="Ilosc"/></td>
                                </tr>
                                <c:if test="${pageContext.request.method=='POST'}">
                                    <tr>
                                        <td class="book_add_table_td"></td>
                                        <td class="book_add_table_td"><form:errors path="quantity" /></td>
                                    </tr>
                                </c:if>
                                <tr>
                                    <td class="book_add_table_td">
                                        <input type="file" name="uploadFile" />
                                    </td>
                                </tr>

                                <form:input type="hidden" path="id"/>
                                <td><input class="a_button"type="submit" value="Dodaj"/></td>
                                </form:form>
                        </table>
                    </div>
                </div>
            </div>
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
