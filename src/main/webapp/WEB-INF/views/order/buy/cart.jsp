<%-- 
    Document   : cart
    Created on : 2017-02-04, 11:48:16
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
                <div class="cart">
                    <h1>Twoj koszyk</h1>

                    <c:if test="${buyModel.buyTotalCost == 0}">
                        <div>
                            <p>Twoja koszyk jest aktualnie pusty</p>
                        </div>
                    </c:if>
                    <c:if test="${buyModel.buyTotalCost != 0}">
                        <form:form method="post" modelAttribute="buyModel">
                            <c:forEach items="${buyModel.products}" var="product">
                                <div>
                                    <table class="basket">
                                        <tr>
                                            <td>${message}</td>
                                        </tr>
                                        <tr>
                                            <td><label>Tytul</label></td>
                                            <td>${product.book.title}</td>
                                        </tr>
                                        <tr>
                                            <td><label>Autor</label></td>
                                            <td>${product.book.author}</td>
                                        </tr>
                                        <tr>
                                            <td><label>Cena</label></td>
                                            <td>${product.book.price}</td>
                                        </tr>
                                        <tr>
                                            <td><label>Ilosc</label></td>
                                            <td> <input type="text" name="quantity" value="${product.quantity}"/></td>
                                        </tr>
                                        <tr>
                                            <td><label>Maksymalnie dostepnych:</label></td>
                                            <td> ${product.book.quantity}</td>
                                        </tr>
                                        <tr>
                                            <td></td>
                                            <td><input class="a_buttonSmall" style="margin-top: 0px;"type="submit" value="Zapisz zmiany"/></td>
                                        </tr>
                                        <tr>
                                            <td><label>Cena calkowita danych ksiazek</label></td>
                                            <td>${product.bookTotalCost}</td>
                                        </tr>
                                        <tr>
                                            <td><a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/order/buy/delete?id=${product.book.id}">
                                                    Usun ksiazke z zamowienia</a></td>
                                        </tr>
                                        <tr>
                                            <td><h1>-----</h1></td>
                                        </tr>
                                    </table>
                                </div>
                            </c:forEach>                  
                        </form:form>
                    </c:if>
                    <div>
                        <a class="a_buttonSmall" href="<spring:url value="/book/list"/>">Wroc do kupowania</a>
                    </div>
                    <h1>Calkowita kwota zakupow:${buyModel.buyTotalCost}zl</h1>
                    <c:if test="${buyModel.buyTotalCost != 0}">
                        <c:if test="${pageContext.request.userPrincipal.name != null}">
                            <a class="a_buttonSmall" href="${pageContext.request.servletContext.contextPath}/order/buy/${pageContext.request.userPrincipal.name}/confirm">Zloz zamowienie</a>
                        </c:if>
                        <c:if test="${pageContext.request.userPrincipal.name == null}">
                            <a class="a_buttonSmall" href="${pageContext.request.contextPath}/login"><input type="submit" value="Zaloguj sie aby zlozyc zamowienie"/></a>
                            </c:if>
                        </c:if>
                </div>
            </div>
            <div id="footer">
                <jsp:include page="../../footer.jsp"/>
            </div>
        </div>
    </body>
</html>
