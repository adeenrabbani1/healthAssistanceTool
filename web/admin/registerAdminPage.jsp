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



        <jsp:include page="../common/header.html"/>
    </head>
    <body>

        <div class="row mt-5">
            <div class="col-md-6 m-auto">
                <div class="card card-body">
                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i> Register An Admin</h1>
                    <form action="../adminController" method="post">
                        <input type="hidden" name="command" value="ADD-ADMIN" />
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
                        <label for="rights">Select Admin Authority</label> <br>
                        
                        <input type="checkbox" name="canAssign" value="1"> He can Assign a Surveyor to Hospital<br>
                        <input type="checkbox" name="canRegisterAdmin" value="1"> He can register new Admins<br>
                        <input type="checkbox" name="canRegisterSurveyor" value="1" checked> He can Register new Surveyors<br>
                        <input type="checkbox" name="canSeeResults" value="1" checked> he can view results of the hospitals<br><br><br>
                        <button type="submit" class="btn btn-primary btn-lg">Register Admin</button>
                    </form>

                </div>
            </div>
        </div>

        
        <script>
        $("form").submit(function () {

    var this_master = $(this);
    this_master.find('input[type="checkbox"]').each( function () {
        var checkbox_this = $(this);


        if( checkbox_this.is(":checked") == true ) {
            checkbox_this.attr('value','1');
        } else {
            checkbox_this.prop('checked',true);
            //DONT' ITS JUST CHECK THE CHECKBOX TO SUBMIT FORM DATA    
            checkbox_this.attr('value','0');
        }
    })
})
        
        
        </script>