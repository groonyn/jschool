<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 04.10.2017
  Time: 15:50
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>New Route</title>
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
        <h1>Routes</h1>
        <form role="form" id="routeForm">
                <div>
                    <label>Route number
                        <input type="text" name="routeNumber" value="" class="form-control" required>
                    </label>
                </div>
                <div class="row waypoint-row">
                    <label>Station
                         <select name="stations" class="form-control" required>
                             <option value="0">Select the station</option>
                                <c:forEach items="${allStations}" var="station">
                                    <option value="${station.name}">${station.name}</option>
                                </c:forEach>
                        </select>
                    </label>
                    <label>Travel time (min)
                        <input type="text" name="travelTime" value="0" readonly class="form-control" required>
                    </label>
                    <label>Stop time (min)
                        <input type="text" name="stopTime" value="0" readonly class="form-control" required>
                    </label>
                </div>
                <div class="row waypoint-row">
                    <label>Station
                        <select name="stations" class="form-control" required>
                            <option value="0">Select the station</option>
                                <c:forEach items="${allStations}" var="station">
                                    <option value="${station.name}">${station.name}</option>
                                </c:forEach>
                        </select>
                    </label>
                    <label>Travel time (min)
                        <input type="text" value="" name="travelTime" class="form-control" required>
                    </label>
                    <label>Stop time (min)
                        <input type="text" value="" name="stopTime" class="form-control" required>
                    </label>
                </div>
            <button type="button" class="btn btn-primary" name="saveRoute">Save</button>
        </form>

        <script type="text/javascript">
            <%@include file="jquery.min.js"%>
        </script>
        <script type="text/javascript">
            <%@include file="saveroute.js"%>
        </script>
    </body>
</html>
