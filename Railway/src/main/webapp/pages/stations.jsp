<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 02.10.2017
  Time: 13:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=utf-8" %>

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
<body>
    <h1>Stations</h1>
        <form action="addStation" method="post">
            <input type="text" placeholder="Name" name="stationName" required>
                <button>Add</button>
        </form>
    <table>
        <c:forEach items="${listStations}" var="station">
            <tr>
                <td>${station.name}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>

