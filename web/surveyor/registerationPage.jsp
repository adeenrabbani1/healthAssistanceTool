<%-- 
    Document   : registerationPage
    Created on : Nov 1, 2019, 10:12:22 AM
    Author     : adeen
--%>

<%-- 
    Document   : registerAdminPage
    Created on : Oct 31, 2019, 12:30:45 AM
    Author     : adeen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--
To change this license header, choose License Headers in Project Properties.
To change this template file, choose Tools | Templates
and open the template in the editor.
-->
<html>
    <head>

        <meta charset="UTF-8">
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 


        <jsp:"
        <jsp:include page="../common/header.html"/>
    </head>
    <body>

        <div class="row mt-5">
            <div class="col-md-6 m-auto">
                <div class="card card-body">
                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>Surveyor Registration</h1>
                    <form action="../adminController" method="post">
                        <input type="hidden" name="command" value="ADD-SURVEYOR" />
                        <div class="form-group">
                            <label for="name">Name</label>
                            <input type="name" id="name" name="name" required class="form-control" placeholder="Enter name" />
                        </div>
                        <div class="form-group">
                            <label for="email">Email</label>
                            <input type="email" id="email" name="email"required class="form-control" placeholder="Enter Email" />
                        </div>
                        <div class="form-group">
                            <label for="name">age</label>
                            <input type="age" id="age" name="age" required class="form-control" placeholder="Enter age" />
                        </div>
                        <div class="form-group">
                            <label for="password">Password</label>
                            <input type="password" id="password" required name="password" class="form-control" placeholder="Enter Password" />
                        </div>

                        <div class="form-group">
                            <label for="Type">Phone</label>
                            <input type="phone" id="phone" name="phone" required class="form-control" placeholder="Enter Phone number" />
                        </div>

                        <button type="submit" class="btn btn-primary btn-lg">Register Surveyor</button>
                    </form>

                </div>
            </div>
        </div>


