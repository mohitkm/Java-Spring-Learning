<%--
  Created by IntelliJ IDEA.
  User: mohitmulchandani
  Date: 12/26/17
  Time: 10:04 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Spring MVC -- Customer Confirmation</title>
</head>
<body>

    The customer is confirmed: ${customer.firstName} ${customer.lastName}

    <br><br>

    Free passes: ${customer.freePasses}

    <br><br>

    Postal code: ${customer.postalCode}

    <br><br>

    Course code: ${customer.courseCode}
</body>
</html>
