<%-- 
    Document   : history.jsp
    Created on : Dec 24, 2019, 10:06:01 PM
    Author     : adeen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="shortcut icon" type="image/png" href="../img/WHO.png" />
        <jsp:include page="../common/header.jsp"/>
    </head>
    <body >

        <h2 style="text-align: center">Scoring History</h2>
        <br>

        <p style="color: red">*Following are the hospitals you have scored. If you want to make any changes, please contact the admin</p>

        <div class="container-fluid">
            <table class="table" style="margin-top: 20px">
                <thead class="thead-dark">

                    <tr>
                        <th scope="col">Name</th>
                        <th scope="col">License#</th>
                        <th scope="col">Director Name</th>
                        <th scope="col">Director Email</th>
                         <th scope="col">Status</th>
                    </tr>
                </thead>

                <c:forEach items="${values}" var="festival">
                    <tbody>

                        <tr>
                            <th scope="row">${festival.getName()}</th>
                            <td>${festival.getLicenseNum()}</td>
                            <td>${festival.getDirectorName()}</td>
                            <td>${festival.getDirectorEmail()}</td>
                            <td style="color: green; font-weight: bold">SCORED</td>
                        </tr>
                        <tr>
                            </thead>
                    </tbody> 
                </c:forEach>
        </div> 
    </body>
</html>
