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

                <table class="login_table">

                    <form:form action=""	method="post">

                        <h1>Zaloguj sie</h1>

                        <tr>
                            <td class="login_table_td"><label for="username">Login</label></td>
                            <td class="login_table_td"><input class="login_table_input" type="text" name="username" placeholder="Nazwa uzytkownika" /></td>
                        </tr>

                        <tr>
                            <td class="login_table_td"><label for="password">Haslo </label></td>
                            <td class="login_table_td"><input class="login_table_input" type="password" name="password" placeholder="Haslo" /></td>
                        </tr>

                        <tr>
                            <td><input class="a_button" type="submit" value="Zaloguj" /></td>
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
            <div class="footer">
                <jsp:include page="../footer.jsp"/>
            </div>
        </div>
    </body>
</html>