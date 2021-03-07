<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>
<html>
<head>
    <title>Registration</title>
</head>
<body>

    <form:form modelAttribute="user" method="post" action="register">
        <table>
            <tr>
                <td>
                    <spring:message code="firstName"/>
                </td>
                <td>
                    <form:input path="firstName"/>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="lastName"/>
                </td>
                <td>
                    <form:input path="lastName"/>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="age"/>
                </td>
                <td>
                    <form:input path="age"/>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="username"/>
                </td>
                <td>
                    <form:input path="username"/>
                </td>
            </tr>

            <tr>
                <td>
                    <spring:message code="password"/>
                </td>
                <td>
                    <form:input path="password"/>
                </td>
            </tr>

            <tr>
                <td>
                    <input type="submit" value="Add user"/>
                </td>
            </tr>
        </table>
    </form:form>
</body>
</html>
