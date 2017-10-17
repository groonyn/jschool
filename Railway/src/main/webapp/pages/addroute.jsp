<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 08.10.2017
  Time: 13:48
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
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
<head>
    <title>Add route</title>
</head>

<body>
<form method="post" action="${pageContext.request.contextPath}/addTrainRoute">
    <label>Train number
        <input type="text" value="${train.name}" readonly name="trainName" required>
    </label>
    <label>Capacity
        <input type="text" value="${train.capacity}" readonly>
    </label>
    <label>Select the route
        <select name="route" required>
            <option value="0">Select the route</option>
                 <c:forEach items="${allRoutes}" var="route">
                     <option value="${route.number}">${route.number}</option>
                </c:forEach>
        </select>
    </label>
    <label>Select dates
        <input type="text" value="" name="date" required >
    </label>
    <button type="submit">Submit</button>
</form>

</body>
</html>
