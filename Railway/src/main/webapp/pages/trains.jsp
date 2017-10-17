<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 01.10.2017
  Time: 13:00
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=utf-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

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
    <h1>Trains</h1>
    <form:form method="POST" action="addTrain" modelAttribute="train">
                     <table>
                        <tr>
                            <td><form:label path="name">Name</form:label></td>
                            <td><form:input path="name"/></td>
                        </tr>
                        <tr>
                            <td><form:label path="capacity">Number of seats</form:label></td>
                            <td><form:input path="capacity"/></td>
                        </tr>
                            <td><input type="submit" value="Submit"/></td>
                        </tr>
                    </table>
    </form:form>
    <table>
        <thead>
        <tr>
            <th>Name</th>
            <th>Capacity</th>
            <th>Assign the route</th>
        </tr>
        </thead>
        <c:forEach items="${listTrains}" var="train">
            <tr>
                <td>${train.name}</td>
                <td>${train.capacity}</td>
                <td>
                    <a href="<c:url value='/addroute/${train.id}'/>">Add route</a>
                </td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
