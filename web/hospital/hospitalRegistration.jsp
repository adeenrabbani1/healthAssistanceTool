<%-- 
    Document   : hospitalRegistration
    Created on : Nov 3, 2019, 3:28:47 PM
    Author     : adeen
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../common/header.jsp"/> 
    </head>
    <body>
          <jsp:include page="../common/errorFlash.jsp"/>

        <div class="row mt-5">
            <div class="col-md-6 m-auto">
                <div class="card card-body">
                    <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>Survey Application</h1>
                    <form action="../hospitalController" method="post">
                        <input type="hidden" name="command" value="APPLY" />
                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="name">Hospital Name</label>
                                <input type="text" class="form-control" name="name" required placeholder="Enter Hospital Name">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="Phone">Phone</label>
                                <input type="text" class="form-control" name="phone" required placeholder="Enter phone">
                            </div>
                        </div>

                        <div class="form-row">
                            <div class="form-group col-md-6">
                                <label for="licence">License Number</label>
                                <input type="text" class="form-control" name="license" required placeholder="Enter License Number">
                            </div>
                            <div class="form-group col-md-6">
                                <label for="country">Country</label>
                                <input type="text" class="form-control" name="country" required placeholder="country name">
                            </div>
                        </div>


                        <div class="form-group">
                            <label for="inputAddress">Address</label>
                            <input type="text" class="form-control" name="address" required placeholder="Complete Hospital Address">
                        </div>

                        <div class="form-row" style=" border-bottom: 2px solid black;">
                            <div class="form-group col-md-6">
                                <label for="numBeds">Number of Bed</label>
                                <input type="number" min="1" max="2000" class="form-control" required name="numOfBeds">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="numPatients">Number of Patients</label>
                                <input  type="number" min="1" max="1000" class="form-control" required name="numOfPatient">
                            </div>
                            <div class="form-group col-md-4">
                                <label for="numInPatients">Number of In Patients</label>
                                <input  type="number" min="1" max="1000" class="form-control" required name="numOfInPatient">
                            </div>
                            <div class="form-group col-md-4" >
                                <label for="numOutPatients">Number of out Patients</label>
                                <input  type="number" min="1" max="1000" class="form-control" required name="numOfOutPatient">
                            </div>
                        </div>
                        <h1 class="text-center mb-3"><i class="fas fa-sign-in-alt"></i>Hospital Administration Information</h1>

                        <div class="form-group">
                            <label for="dname">Director Name</label>
                            <input type="name" id="name" name="dname" required class="form-control" placeholder="Director's name" />
                        </div>
                        <div class="form-group">
                            <label for="demail">Director Email</label>
                            <input type="email" id="email" name="demail"required class="form-control" placeholder="Enter Email" />
                        </div>
                        <div class="form-group">
                            <label for="dphone">Director Phone</label>
                            <input type="text"  name="dphone" required pattern="[0-9]{3}-[0-9]{4}-[0-9]{4}" class="form-control" placeholder="Enter Phone" />
                            <span>Format: 011-6161-6768</span>
                        </div>
                        <button type="submit" class="btn btn-primary">Apply</button>
                    </form>
                </div>
            </div>
        </div>


    </body>
</html>
