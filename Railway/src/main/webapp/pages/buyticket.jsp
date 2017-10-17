<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 12.10.2017
  Time: 13:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Buy Ticket</title>
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
            <th>Train name</th>
            <th>Route</th>
            <th>Departure station</th>
            <th>Departure date</th>
            <th>Arrival station</th>
            <th>Arrival date</th>
            <th>Price</th>
        </tr>
    </thead>
        <tr>
            <td>${trip.trainName}</td>
            <td>${trip.route}</td>
            <td>${trip.stationFrom}</td>
            <td>${trip.arrivalDateTime}</td>
            <td>${trip.stationTo}</td>
            <td>${trip.depatureDateTime}</td>
            <td>${trip.price}</td>
        </tr>
</table>

<form method="post" action="${pageContext.request.contextPath}/addTicket">
    <input type="hidden" value="${trip.arrivalDateTime}" name="dateTime" >
    <input type="hidden" value="${board.id}" name="boardId">
    <input type="hidden" value="${wpFrom.id}" name="wpFromId">
    <input type="hidden" value="${wpTo.id}" name="wpToId">
    <label>First name
        <input type="text" value="" name="firstName" required>
    </label>
    <label>Last name
        <input type="text" value="" name="lastName" required>
    </label>
    <label>Birth date
        <input type="text" value="" name="birthdate" required>
    </label>
    <label>Passport
        <input type="text" name="passport" value="" required>
    </label>
    <%--<label>Price--%>
    <%--<input type="text" name="price" value="${price}" required readonly>--%>
    <%--</label>--%>
    <button type="submit">Buy ticket</button>
</form>
</body>
</html>
