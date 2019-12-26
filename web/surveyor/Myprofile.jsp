<%-- 
    Document   : Myprofile
    Created on : Dec 25, 2019, 5:07:48 PM
    Author     : adeen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>                            
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../common/header.jsp"/>
        
    </head>
    <body>
        <jsp:include page="../common/errorFlash.jsp"/>
        <div class="container-fluid" style="padding: 140px">
            <div class="card text-center">
                <div class="card-header" style="background-color: orange;">
                    <ul class="nav nav-tabs card-header-tabs" style="background-color: orange;">
                        <li class="nav-item" >
                            <a class="nav-link active" href="#">User Profile</a>
                        </li>

                    </ul>
                </div>
                <div class="card-body" style="background-color: whitesmoke">
                    <h2 class="card-title">${user.getName()}</h2>
                    <p><h6>Phone : </h6> ${user.getPhone()}</p>
                    <p><h6>Email :</h6> ${user.getEmail()}</p>
                    <c:if test="${user.getStatus() == 'active'}">

                    <h6>Status :</h6> <p style="color: green; font-size: medium">${user.getStatus()}</p>

                    </c:if>
                    <c:if test="${user.getStatus() == 'deactive'}">

                    <h6>Status :</h6> <p style="color: red; font-size: medium">${user.getStatus()}</p>

                    </c:if>

                    <a href="../surveyorController?command=CHANGE" class="btn btn-primary">Change Status</a>
                </div>
            </div>
        </div>
    </body>
</html>
