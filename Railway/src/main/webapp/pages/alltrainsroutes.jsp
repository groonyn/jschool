<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 09.10.2017
  Time: 10:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>All Trains Routes</title>
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
<h1>All Trains Routes</h1>
<table>
    <thead>
    <tr>
        <th>Train Number</th>
        <th>Route</th>
        <th>Date</th>
        <th>Registered passengers</th>
    </tr>
    </thead>
    <c:forEach items="${listBoards}" var="board">
        <tr>
            <td>${board.trainName}</td>
            <td>${board.routeWaypoints}</td>
            <td>${board.date}</td>
            <td>
                <a href="<c:url value='/registredpassengers/${board.boardId}'/>">Find registered passengers</a>
            </td>
        </tr>
    </c:forEach>
</table>
</body>
</html>
