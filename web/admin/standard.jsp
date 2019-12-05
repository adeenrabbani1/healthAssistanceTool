<%-- 
    Document   : dashboard
    Created on : Oct 30, 2019, 7:29:14 PM
    Author     : SHERIF ABOUELMAGD
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
    if (session.getAttribute("user") == null) {
        response.sendRedirect("../");
    } else {
        if (session.getAttribute("user").getClass().toString().equals("class entity.Admin")) {
            //nothing
        } else {
            response.sendRedirect("../");
        }
    }
%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../common/header.html"/>
    </head>
    <body style="background-color: #f5f5f5">
        <div class="container-fluid">
<!--            <div class="mt-5 mb-3 text-center">
                <h1><small>Hello</small> ${user.getName()}</h1>
                <hr>
                
            </div>-->
            <jsp:include page="../common/errorFlash.jsp"/>
            <div class="row mt-3 mb-3 justify-content-center">
                <div class="col mb-4">
                    <div class="card text-white bg-primary border-primary m-3" style="box-shadow: 0 4px 8px 4px rgba(0, 0, 0, 0.4); border-radius: 5px">
                        <img src="https://pngimage.net/wp-content/uploads/2018/06/standard-png-5.png" class="card-img" alt="...">
                        <div class="card-body">
                            <h5 class="card-title"></h5>
                            <p class="card-text">
                            <form action="../adminController" method="post">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="title">Title</label>
                                        <input type="text" class="form-control" id="title" name="title" placeholder="eg Waste management">
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="code">Code</label>
                                        <input type="text" class="form-control" id="code" name="code" placeholder="eg E.1.2.1">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="des">Description</label>
                                    <input type="text" class="form-control" id="des" name="des" placeholder="eg All hospital staff are provided with a patient safety...">
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="category">Category</label>
                                        <select id="category" class="form-control" name="category">
                                            <option selected>Choose...</option>
                                            <option>Critical</option>
                                            <option>Core</option>
                                            <option>Development</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="domain">Domain</label>
                                        <select id="domain" class="form-control" name="domain">
                                            <option selected>Choose...</option>
                                            <option value="leadership Management">leadership Management</option>
                                            <option value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option value="Safe Environment">Safe Environment</option>
                                            <option value="Life Long Learning">Life Long Learning</option>
                                        </select>
                                    </div>
                                </div>
                                <button type="submit" name="command" value="addStand" class="btn btn-warning">Add Standard</button>
                            </form>
                            </p>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html> 
