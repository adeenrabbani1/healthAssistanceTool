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
        <!--<script src="../assets/js/main.js"></script>-->
        <script>

            function showNotification1(message, type1) {
                console.log("the value is ", type1)
                $.notify({
                    icon: "add_alert",
                    message: message

                }, {
                    type: type1,
                    timer: 30,
                    placement: {
                        from: 'top',
                        align: 'right'
                    }
                });
            }

            $(document).ready(function () {
                $("#addbtn").click(function () {
                    $("#list").toggle("slow");
                });

                $("#listbtn").click(function () {
                    $("#add").toggle("slow");
                });
            });



        </script>

    </head>
    <body>
        <c:choose>
            <c:when test="${flash == 'updated'}">
                <script>showNotification1("<strong>Success!</strong> Hospital has been updated.", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'deleted'}">
                <script>showNotification1("<strong>Success!</strong> Hospital has been deleted.", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'assigned'}">
                <script>showNotification1("<strong>Success!</strong> Hospital has been assigned.", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'addStd'}">
                <script>showNotification1("<strong>Success!</strong> Standard has been added.", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when>
            <c:when test="${flash == 'deleteStd'}">
                <script>showNotification1("<strong>Success!</strong> Standard has been deleted.", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when>
            <c:when test="${flash == 'updatedStd'}">
                <script>showNotification1("<strong>Success!</strong> Standard has been updated.", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when>
            <c:when test="${flash == 'scored'}">
                <script>showNotification1("<strong>Success!</strong> Your Scores Have been saved Successfully", "success")</script>
                <% session.removeAttribute("flash"); %>
            </c:when> 
            <c:when test="${flash == 'status'}">
                <script>showNotification1("<strong>Success!</strong> Your account is now deactivated! Hospitals cannot be assigned to you..", "danger")</script>
                <% session.removeAttribute("flash");%>
            </c:when>
            <c:when test="${flash == 'active'}">
                <script>showNotification1("<strong>Success!</strong> Welcome Back. We missed you!", "success")</script>
                <% session.removeAttribute("flash");%>
            </c:when>
            <c:when test="${flash == 'registered'}">
                <script>showNotification1("<strong>Success!</strong>Your application is submitted. We will email you once your results are ready! Please note it normally take 15 working days.", "success")</script>
                <% session.removeAttribute("flash");%>
            </c:when>
            <c:when test="${flash == 'db'}">
                <script>showNotification1("<strong>Alert!</strong>You have entered incorrect Values. Please fill agian" ,"danger")</script>
                <% session.removeAttribute("flash");%>
            </c:when>
        </c:choose>
    </body>
</html>

