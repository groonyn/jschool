<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 14.10.2017
  Time: 6:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Registred passengers</title>
</head>
<style>
    table, form, h1 {
        font-family: "Lucida Sans Unicode", "Lucida Grande", Sans-Serif;
        text-align: left;
        border-collapse: separate;
        border-spacing: 5px;
        background: #ECE9E0;
        color: #656665;
        border: 16px solid #ECE9E0;
        border-radius: 20px;
    }
    th {
        font-size: 18px;
        padding: 10px;
    }
    td {
        background: #F5D7BF;
        padding: 10px;
    }
</style>
<body>
<h1>Registered passengers</h1>
<table>
    <thead>
    <tr>
        <th>First name</th>
        <th>Last name</th>
        <th>Birth date</th>
        <th>Passport</th>
    </tr>
    </thead>
    <c:forEach items="${allPassengers}" var="passenger">
        <tr>
            <td>${passenger.firstName}</td>
            <td>${passenger.lastName}</td>
            <td>${passenger.birthdate}</td>
            <td>${passenger.passport}</td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
