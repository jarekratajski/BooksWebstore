<%-- 
    Document   : confirm
    Created on : 2017-02-04, 13:08:23
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
        <div id="wrapper">
            <div class="loginbar">
                <jsp:include page="../../loginbar.jsp" />
            </div>

            <div id="header">
                <jsp:include page="../../header.jsp" />
            </div>

            <div id="leftcolumn">
                <jsp:include page="../../leftmenu.jsp" />                
            </div>
            <div id="rightcolumn">
                <div>

                    <h1>Potwierdz zamowienie</h1>
                    <table class="basket">
                        <tr>
                            <td>Uzytkownik</td>
                            <td>${user.username}</td>
                        </tr>
                        <tr>
                            <td>Email:</td>
                            <td>${user.email}</td>
                        </tr>
                        <c:forEach items="${buyModel.products}" var="product">
                            <tr>
                                <td>Tytul</td> 
                                <td>${product.book.title}</td>
                            </tr>
                            <tr>
                                <td>Autor</td> 
                                <td>${product.book.author}</td>
                            </tr>
                            <tr>
                                <td>Wydawnictwo</td> 
                                <td>${product.book.publisher.name}</td>
                            </tr>
                        </c:forEach>
                        <tr>
                            <td>Cena calkowita koszyka</td>
                            <td>${buyModel.buyTotalCost}</td>
                        </tr>
                    </table>
                    <form:form method="post">
                        <input class="a_buttonSmall" type="submit" value="Zamow"/>
                    </form:form>
                </div>
            </div>
            <div id="footer">
                <jsp:include page="../../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
