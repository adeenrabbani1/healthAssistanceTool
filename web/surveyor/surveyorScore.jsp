<%-- 
    Document   : surveyorScore.jsp
    Created on : Dec 4, 2019, 6:25:12 PM
    Author     : adeen
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../common/header.html"/>
    </head>
    <body >
        
        <h1 class="text-center" style="margin-top: 1%" >Hospital Score Board</h1>  <br>
        <p class="text-center" style="color:crimson;">Please score the standards of the Hospital below and save accordingly!</p>
            
        <h1> The id is ${val}</h1>
        
        <div class="card text-center" style="margin-top: 2%">
            <div class="card-header">
                <ul class="nav nav-pills card-header-pills">
                    <li class="nav-item">
                        <a class="nav-link active" href="#">Active</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link" href="#">Link</a>
                    </li>
                    <li class="nav-item">
                        <a class="nav-link disabled" href="#" tabindex="-1" aria-disabled="true">Disabled</a>
                    </li>
                </ul>
            </div>
            <div class="card-body">
                <h5 class="card-title">Special title treatment</h5>
                <p class="card-text">With supporting text below as a natural lead-in to additional content.</p>
                <a href="#" class="btn btn-danger float-left" >Previous</a>
                <a href="#" class="btn btn-success float-right" >Next</a>
            </div>
        </div>
    </body>
</html>
