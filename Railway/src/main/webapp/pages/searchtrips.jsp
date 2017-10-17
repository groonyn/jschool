<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 11.10.2017
  Time: 10:54
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
    <title>Search Trips</title>
</head>
<body>
<h1>Search Trips</h1>
<form:form method="POST" action="findTrip" modelAttribute="searchTripDto">
    <table>
        <tr>
            <td>Select the station of departure :</td>
            <td><form:select path="stationFrom">
                    <form:option value="0">station of departure</form:option>
                        <c:forEach items="${allStations}" var="station">
                            <form:option value="${station.name}">${station.name}</form:option>
                        </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td>Select the station of arrival :</td>
            <td><form:select path="stationTo">
                    <form:option value="0">station of arrival</form:option>
                         <c:forEach items="${allStations}" var="station">
                            <form:option value="${station.name}">${station.name}</form:option>
                        </c:forEach>
                </form:select>
            </td>
        </tr>
        <tr>
            <td><form:label path="dateTimeFrom">Select start date</form:label></td>
            <td><form:input path="dateTimeFrom" type="text" value=""/></td>
        </tr>
        <tr>
            <td><form:label path="dateTimeTo">Select end date</form:label></td>
            <td><form:input path="dateTimeTo" type="text" value=""/></td>
        </tr>
        </tr>
            <td><input type="submit" value="Submit"/></td>
        </tr>
    </table>
</form:form>
<%--<form>--%>
    <%--<div>--%>
    <%--<label>Select the station of departure--%>
        <%--<select name="stationFrom" required>--%>
            <%--<option value="0">station of departure</option>--%>
            <%--<c:forEach items="${allStations}" var="station">--%>
                <%--<option value="${station.name}">${station.name}</option>--%>
            <%--</c:forEach>--%>
        <%--</select>--%>
    <%--</label>--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<label>Select the station of arrival--%>
            <%--<select name="stationTo" required>--%>
                <%--<option value="0">station of arrival</option>--%>
                <%--<c:forEach items="${allStations}" var="station">--%>
                    <%--<option value="${station.name}">${station.name}</option>--%>
                <%--</c:forEach>--%>
            <%--</select>--%>
        <%--</label>--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<label>Select start date--%>
            <%--<input type="text" value="" name="dateTimeFrom" required >--%>
        <%--</label>--%>
    <%--</div>--%>
    <%--<div>--%>
        <%--<label>Select end date--%>
            <%--<input type="text" value="" name="dateTimeTo" required >--%>
        <%--</label>--%>
    <%--</div>--%>
    <%--<button type="submit">Submit</button>--%>
<%--</form>--%>
</body>
</html>
