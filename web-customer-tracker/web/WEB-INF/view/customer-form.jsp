<%--
  Created by IntelliJ IDEA.
  User: mohitmulchandani
  Date: 12/29/17
  Time: 9:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>Add customer</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/style.css">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/resources/css/add-customer-style.css">
</head>
<body>
    <div id="wrapper">
        <div id="header">
            <h2>CRM - Customer Relationship Manager</h2>
        </div>
    </div>

    <div id="container">
        <h3>Save Customer</h3>

        <form:form action="saveCustomer" modelAttribute="customer" method="post">
            <form:hidden path="id"/>

            <table>
                <tbody>
                <tr>
                    <td><label>First name: </label></td>
                    <td><form:input path="firstName"/></td>
                </tr>
                <tr>
                    <td><label>Last name: </label></td>
                    <td><form:input path="lastName"/></td>
                </tr>
                <tr>
                    <td><label>Email: </label></td>
                    <td><form:input path="email"/></td>
                </tr>
                <tr>
                    <td><input type="submit" value="Save" class="save"/></td>
                </tr>
                </tbody>
            </table>
        </form:form>

        <div style="clear; both;"></div>
        <p><a href="${pageContext.request.contextPath}/customer/list"/></p>
    </div>
</body>
</html>
