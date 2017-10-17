<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 09.10.2017
  Time: 9:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Routes</title>
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
<table>
    <thead>
    <tr>
        <th>Number</th>
        <th>Waypoints</th>
    </tr>
    </thead>
    <c:forEach items="${allRoutes}" var="route">
        <tr>
            <td>${route.number}</td>
            <td>
                <c:forEach items="${route.waypoints}" var = "waypoint">
                    ${waypoint.station.name}
                </c:forEach>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
