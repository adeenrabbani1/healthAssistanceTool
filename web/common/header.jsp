<%-- 
    Document   : header.jsp
    Created on : Dec 24, 2019, 10:55:17 PM
    Author     : adeen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
    <head>
        <title>HAT EMRO - MiddleEast</title>
        <link rel="shortcut icon" type="image/png" href="../img/WHO.png" />
        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <link rel="stylesheet" href="https://use.fontawesome.com/releases/v5.10.2/css/all.css">
        <link rel="stylesheet" href="https://bootswatch.com/4/lux/bootstrap.min.css">
        <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
        <script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"></script>
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"></script>
        <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>

<!--        <script src="../assets/js/main.js"></script>-->

    </head>
    <body>
        <jsp:include page="../common/errorFlash.jsp"/>


        <c:if test="${user.getRole().equals('admin')}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">Hospital Assistance Tool</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor02">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item dropdown active">
                            <a class="nav-link dropdown-toggle" href="#" id="navbardrop" data-toggle="dropdown">
                                <i class="fa fa-area-chart" style="font-size: 15px"></i> Dashboard
                            </a>
                            <div class="dropdown-menu">
                                <a class="dropdown-item" href="../admin/dashboard.jsp"><i class="fa fa-calendar-o" style="font-size:15px"></i> All Hospitals</a>
                                <a class="dropdown-item" href="../admin/assignedHospitals.jsp"><i class="fa fa-calendar-check-o" style="font-size:15px"></i> Assigned Hospitals</a>
                                <a class="dropdown-item" href="../admin/unassignedHospitals.jsp"><i class="fa fa-calendar-minus-o" style="font-size:15px"></i> Unassigned Hospitals</a>
                            </div>
                        </li>

                        <li class="nav-item active">
                            <a class="nav-link" href="../admin/standard.jsp"><i class="fa fa-stack-overflow" aria-hidden="true" style="font-size: 15px"></i> Standards</a>
                        </li>
                    </ul>
                    <div class="form-inline my-2 my-lg-0">
                        <a class="nav-link  text-white" href="../logoutControl"><i class="fa fa-sign-out" aria-hidden="true" style="font-size: 15px"></i> Logout</a>
                    </div>
                </div>
            </nav>
        </c:if>
        <c:if test="${user.getRole().equals('surveyor')}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">Hospital Assistance Tool</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor02">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="../surveyor/dashboard.jsp">Home <span class="sr-only">(current)</span></a>
                        </li>
                        <li class="nav-item active">
                            <a class="nav-link" href="../surveyor/history.jsp">Scoring History </a>
                        </li>
                    </ul>
                </div>
            </nav>
        </c:if>
         <c:if test="${user.getRole()== null}">
            <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
                <a class="navbar-brand" href="#">Hospital Assistance Tool</a>
                <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor02" aria-controls="navbarColor02" aria-label="Toggle navigation">
                    <span class="navbar-toggler-icon"></span>
                </button>

                <div class="collapse navbar-collapse" id="navbarColor02">
                    <ul class="navbar-nav mr-auto">
                        <li class="nav-item active">
                            <a class="nav-link" href="../index.html">Home <span class="sr-only">(current)</span></a>
                        </li>
                        >
                    </ul>
                </div>
            </nav>
        </c:if>



    </body>
</html>
