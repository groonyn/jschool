<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 16.10.2017
  Time: 12:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: Вика
  Date: 01.10.2017
  Time: 13:42
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html class="chrome"><head>
    <meta charset="UTF-8">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <title>Test</title>
    <!-- Favicon-->
    <link rel="icon" type="image/x-icon" href="<c:url value="/resources/favicon.ico"/>"/>

    <!-- Google Fonts -->
    <link rel="stylesheet" type="text/css" href="<c:url value="https://fonts.googleapis.com/css?family=Roboto:400,700&amp;subset=latin,cyrillic-ext"/>"/>
    <link rel="stylesheet" type="text/css" href="<c:url value="https://fonts.googleapis.com/icon?family=Material+Icons"/>"/>

    <!-- Bootstrap Core Css -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/bootstrap/css/bootstrap.css"/> "/>

    <!-- Waves Effect Css -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/node-waves/waves.css"/> "/>

    <!-- Animation Css -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/animate-css/animate.css"/>"/>

    <!-- Wait Me Css -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/waitme/waitMe.css"/>"/>

    <!-- Bootstrap Select Css -->
    <link rel="stylesheet" href="<c:url value="/resources/plugins/bootstrap-select/css/bootstrap-select.css"/>"/> >

    <!-- Custom Css -->
    <link rel="stylesheet" href="<c:url value="/resources/css/style.css" />"/>

    <!-- AdminBSB Themes. You can choose a theme from css/themes instead of get all themes -->
    <link rel="stylesheet" href="<c:url value="/resources/css/themes/all-themes.css"/>"/>
</head>

<body class="theme-red ls-closed">
<!-- Page Loader -->
<div class="page-loader-wrapper" style="display: none;">
    <div class="loader">
        <div class="preloader">
            <div class="spinner-layer pl-red">
                <div class="circle-clipper left">
                    <div class="circle"></div>
                </div>
                <div class="circle-clipper right">
                    <div class="circle"></div>
                </div>
            </div>
        </div>
        <p>Please wait...</p>
    </div>
</div>
<!-- #END# Page Loader -->
<!-- Overlay For Sidebars -->
<div class="overlay" style="display: none;"></div>
<!-- #END# Overlay For Sidebars -->
<!-- Search Bar -->
<div class="search-bar">
    <div class="search-icon">
        <i class="material-icons">search</i>
    </div>
    <input type="text" placeholder="START TYPING...">
    <div class="close-search">
        <i class="material-icons">close</i>
    </div>
</div>
<!-- #END# Search Bar -->
<!-- Top Bar -->
<nav class="navbar">
    <div class="container-fluid">
        <div class="navbar-header">
            <a href="javascript:void(0);" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar-collapse" aria-expanded="false"></a>
            <a href="javascript:void(0);" class="bars"></a>
            <a class="navbar-brand">RAILWAY</a>
        </div>
        <div class="collapse navbar-collapse" id="navbar-collapse">

        </div>
    </div>
</nav>
<!-- #Top Bar -->
<section>
    <!-- Left Sidebar -->
    <aside id="leftsidebar" class="sidebar">
        <!-- Menu -->
        <div class="menu">
            <div class="slimScrollDiv" style="position: relative; overflow: hidden; width: auto; height: 368px;">
                <ul class="list" style="overflow: hidden; width: auto; height: 368px;">
                    <li class="active">
                        <a href="/" class="toggled waves-effect waves-block">
                            <i class="material-icons">home</i>
                            <span>Home</span>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/boardByStation" class=" waves-effect waves-block">
                            <i class="material-icons">text_fields</i>
                            <span>Station timetable</span>
                        </a>
                    </li>
                    <li>
                        <a href="${pageContext.request.contextPath}/searchTrip" class=" waves-effect waves-block">
                            <i class="material-icons">layers</i>
                            <span>Find the trip</span>
                        </a>
                    </li>
                    <li>
                        <%--<a href="../changelogs.html" class=" waves-effect waves-block">--%>
                        <i class="material-icons">update</i>
                        <span>Sign in</span>
                        <%--</a>--%>
                    </li>
                </ul><div class="slimScrollBar" style="background: rgba(0, 0, 0, 0.5); width: 4px; position: absolute; top: 0px; opacity: 0.4; display: none; border-radius: 0px; z-index: 99; right: 1px; height: 368px;"></div><div class="slimScrollRail" style="width: 4px; height: 100%; position: absolute; top: 0px; display: none; border-radius: 0px; background: rgb(51, 51, 51); opacity: 0.2; z-index: 90; right: 1px;"></div></div>
        </div>
        <!-- #Menu -->
    </aside>
    <!-- #END# Left Sidebar -->
</section>
<section class="content">
    <div class="container-fluid">
        <div class="row clearfix">
            <div class="col-lg-12 col-md-12 col-sm-12 col-xs-12">
                <div class="card">
                    <div class="header">
                        <h2>FIND THE TRIP</h2>
                    </div>
                    <div class="body">
                        <form:form method="POST" action="findTrip" modelAttribute="searchTripDto">
                            <table class="table">
                                <tr>
                                    <td><form:label path="stationFrom">Select the station of departure :</form:label></td>
                                    <td><form:select class="form-control" path="stationFrom">
                                        <form:option value="0">station of departure</form:option>
                                        <c:forEach items="${allStations}" var="station">
                                            <form:option value="${station.name}">${station.name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><form:label path="stationFrom">Select the station of arrival :</form:label></td>
                                    <td><form:select class="form-control" path="stationTo">
                                        <form:option value="0">station of arrival</form:option>
                                        <c:forEach items="${allStations}" var="station">
                                            <form:option value="${station.name}">${station.name}</form:option>
                                        </c:forEach>
                                    </form:select>
                                    </td>
                                </tr>
                                <tr>
                                    <td><form:label path="dateTimeFrom">Select start date</form:label></td>
                                    <td><form:input path="dateTimeFrom" type="text" value="" class="form-control" placeholder="dd-MM-yyyy HH:mm"/></td>
                                </tr>
                                <tr>
                                    <td><form:label path="dateTimeTo">Select end date</form:label></td>
                                    <td><form:input path="dateTimeTo" type="text" value="" class="form-control" placeholder="dd-MM-yyyy HH:mm"/></td>
                                </tr>
                                </tr>
                                <td><input class="btn bg-red waves-effect" type="submit" value="Submit"/></td>
                                </tr>
                            </table>
                        </form:form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</section>

<!-- Jquery Core Js -->
<script async="" src="https://www.google-analytics.com/analytics.js"></script><script src="../resources/plugins/jquery/jquery.min.js"></script>

<!-- Bootstrap Core Js -->
<script src="../resources/plugins/bootstrap/js/bootstrap.js"></script>

<!-- Select Plugin Js -->
<script src="../resources/plugins/bootstrap-select/js/bootstrap-select.js"></script>

<!-- Slimscroll Plugin Js -->
<script src="../resources/plugins/jquery-slimscroll/jquery.slimscroll.js"></script>

<!-- Waves Effect Plugin Js -->
<script src="../resources/plugins/node-waves/waves.js"></script>

<!-- Autosize Plugin Js -->
<script src="../resources/plugins/autosize/autosize.js"></script>

<!-- Moment Plugin Js -->
<script src="../resources/plugins/momentjs/moment.js"></script>

<!-- Bootstrap Material Datetime Picker Plugin Js -->
<script src="../resources/plugins/bootstrap-material-datetimepicker/js/bootstrap-material-datetimepicker.js"></script>

<!-- Custom Js -->
<script src="../resources/js/admin.js"></script>
<script src="../resources/js/pages/forms/basic-form-elements.js"></script>

<!-- Demo Js -->
<script src="../resources/js/demo.js"></script>
</body></html>

