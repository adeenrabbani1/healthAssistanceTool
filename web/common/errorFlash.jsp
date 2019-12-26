<%-- 
    Document   : errorFlash
    Created on : Dec 3, 2019, 7:19:10 AM
    Author     : SHERIF ABOUELMAGD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <link rel="stylesheet" type="text/css" href="https://fonts.googleapis.com/css?family=Roboto:300,400,500,700|Roboto+Slab:400,700|Material+Icons" />
        <script src="../assets/js/plugins/bootstrap-notify.js"></script>
        <link rel="stylesheet" href="../assets/css/material-dashboard.css" type="text/css"/>
    </head>
    <body>
        <c:choose>
            <c:when test="${flash == 'updated'}">
                <script>showNotification("<strong>Success!</strong> Hospital has been updated.")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'deleted'}">
                <script>showNotification("<strong>Success!</strong> Hospital has been deleted.")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'assigned'}">
                <script>showNotification("<strong>Success!</strong> Hospital has been assigned.")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'addStd'}">
                <script>showNotification("<strong>Success!</strong> Standard has been added.")</script>
                <% session.removeAttribute("flash"); %>
            </c:when>
            <c:when test="${flash == 'deleteStd'}">
                <script>showNotification("<strong>Success!</strong> Standard has been deleted.")</script>
                <% session.removeAttribute("flash"); %>
            </c:when>
            <c:when test="${flash == 'updatedStd'}">
                <script>showNotification("<strong>Success!</strong> Standard has been updated.")</script>
                <% session.removeAttribute("flash"); %>
            </c:when>
            <c:when test="${flash == 'scored'}">
                <script>showNotification("<strong>Success!</strong> Your Scores Have been saved Successfully")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'status'}">
                <script>showNotification("<strong>Success!</strong> Your account is now deactivated! Hospitals cannot be assigned to you..")</script>
                <% session.removeAttribute("flash");%>
            </c:when>
        </c:choose>
    </body>
</html>
