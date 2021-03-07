<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>



<html>
<head>
    <title>Users</title>
</head>
<body>
    <ul>
        <c:choose>
            <c:when test="${displayUsername}">
                <c:forEach items="${users}" var="user">
                    <li>
                        <spring:message code="username"/>
                        <c:out value="${user.username}"/>
                    </li>
                </c:forEach>
            </c:when>

            <c:when test="${displayUser}">
                <li>
                    <spring:message code="username"/>
                    <c:out value="${user.username}"/>
                </li>
                <li>
                    <spring:message code="firstName"/>
                    <c:out value="${user.firstName}"/>
                </li>
                <li>
                    <spring:message code="lastName"/>
                    <c:out value="${user.lastName}"/>
                </li>

                <c:if test="${displayDetailsFull}">
                    <li>
                        <spring:message code="age"/>
                        <c:out value="${user.age}"/>
                    </li>
                </c:if>

            </c:when>

<%--            <c:when test="${displayDetailsFull} ">--%>
<%--                <li>--%>
<%--                    <spring:message code="username"/>--%>
<%--                    <c:out value="${user.username}"/>--%>
<%--                    --%>
<%--                    <spring:message code="firstName"/>--%>
<%--                    <c:out value="${user.firstName}"/>--%>

<%--                    <spring:message code="lastName"/>--%>
<%--                    <c:out value="${user.lastName}"/>--%>

<%--                    <spring:message code="age"/>--%>
<%--                    <c:out value="${user.age}"/>--%>

<%--                </li>--%>
<%--            </c:when>--%>

            <c:otherwise>
                Not a valid request
            </c:otherwise>
        </c:choose>

    </ul>

</body>
</html>
