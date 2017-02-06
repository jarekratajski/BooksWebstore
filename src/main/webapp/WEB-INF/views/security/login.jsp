<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<%@ page contentType="text/html;charset=UTF-8" language="java"%>


<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link href="${pageContext.request.contextPath}/resources/css/style.css"	rel="stylesheet" type="text/css">
        <title>Ksiegarnia</title>
    </head>
    <body>
        <div id="wrapper">
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

                    <table class="login_table">

                        <form:form action=""	method="post">

                            <h1>Zaloguj sie</h1>

                            <tr>
                                <td><label for="username">Login</label></td>
                                <td><input type="text" name="username" placeholder="Nazwa uzytkownika" /></td>
                            </tr>

                            <tr>
                                <td><label for="password">Haslo </label></td>
                                <td><input type="password" name="password" placeholder="Haslo" /></td>
                            </tr>

                            <tr>
                                <td><input type="submit" value="Zaloguj" /></td>
                                <td><c:if test="${error == true}">
                                        <div>
                                            <p>
                                                <span style="color: red;">Nieprawidlowe dane</span>
                                            </p>
                                        </div>
                                    </c:if>
                                </td>
                            </tr>
                        </form:form>
                    </table>
                    <a href="${pageContext.request.contextPath}/user/new">Nie masz konta? Zarejestruj sie</a>
                </div>
                <div id="footer">
                    <jsp:include page="../footer.jsp"/>
                </div>
            </div>
    </body>
</html>