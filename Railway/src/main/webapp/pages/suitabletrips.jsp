<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 12.10.2017
  Time: 6:12
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Suitable Trips</title>
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
<h1>Suitable Trips</h1>
<table>
    <thead>
    <tr>
        <th>Train name</th>
        <th>Route</th>
        <th>Departure station</th>
        <th>Departure date</th>
        <th>Arrival station</th>
        <th>Arrival date</th>
        <th>Buy ticket</th>
    </tr>
    </thead>
    <c:forEach items="${suitableTrips}" var="trip">
        <tr>
            <td>${trip.trainName}</td>
            <td>${trip.route}</td>
            <td>${trip.stationFrom}</td>
            <td>${trip.arrivalDateTime}</td>
            <td>${trip.stationTo}</td>
            <td>${trip.depatureDateTime}</td>
            <td>
                <a href="<c:url value='/buyticket/${trip.boardId}/${trip.waypointFromId}/${trip.waypointToId}'/>">Buy ticket</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
