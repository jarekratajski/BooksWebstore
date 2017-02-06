<%-- 
    Document   : denied
    Created on : 2017-01-30, 17:11:40
    Author     : Matuidi
--%>

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

                    ` <h1>${message}</h1>
                </div>
                <div id="footer">
                    <jsp:include page="../footer.jsp"/>
                </div>
            </div>
    </body>
</html>
