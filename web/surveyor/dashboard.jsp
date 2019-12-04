<%-- 
    Document   : dashboard
    Created on : Oct 30, 2019, 7:29:14 PM
    Author     : SHERIF ABOUELMAGD
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <jsp:include page="../common/header.html"/>
    </head>
    <body style="background-color: #f5f5f5">
        
        
        <main role="main">

      <!-- Main jumbotron for a primary marketing message or call to action -->
      <div class="jumbotron">
        <div class="container">
            <h1 class="display-3">Hello,</h1> <h2>${surveyor.getName()}</h2>
          <p>Welcome to your dashboard. Please review your assigned Hospitals below! HAPPY SCORING!</p>
          <p><a class="btn btn-danger" href="#" role="button"> View Profile&raquo;</a></p>
        </div>
      </div>
    </main>
        
        
        
        

        <c:if test="${empty surveyorHospitals}">
            <h1>You Dont have any Hospitals to Score! Have a chill time!</h1>
        </c:if>
        <div class="container-fluid">
            <div class="row mt-3 mb-3 justify-content-center">
                <c:forEach items="${surveyorHospitals}" var="hospital">
                    <div class="card text-dark bg-white m-3 border-dark" style="width: 20rem;">
                        <div class="card-header bg-primary text-white"><i class="fa fa-hospital-o" style="font-size: 1.3em" aria-hidden="true"></i> ${festival.getName()}</div>
                        <div class="card-body">
                            <h4 class="card-title">${hospital.getCountry()}</h4>
                            <p class="card-text">${hospital.getAddress()}, ${hospital.getPhone()}, ${hospital.getLicenseNum()}</p>
                        </div>
                        <div class="card-footer">
                            <button type="button" class="btn btn-info col-md-12" style="background-color: #136384" data-toggle="modal" data-target="#model${hospital.getHospitalId()}">
                                <i class="fa fa-info-circle" style="font-size: 1.1em" aria-hidden="true"></i> More Info
                            </button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>


        <c:forEach items="${surveyorHospitals}" var="festival">
            <div class="modal fade" id="model${festival.getHospitalId()}">
                <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                    <div class="modal-content" style="background-color: #000005">
                        <div class="modal-header">
                            <h4 class="modal-title text-white pl-4">Hospital Name: ${festival.getName()}</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                <span aria-hidden="true">&times;</span>
                            </button>
                        </div>

                        <div class="modal-body row pl-5 pr-5" style="font-weight: bold">
                            <div class="col-md-4 text-info">
                                <h3 class="text-white">Hospital Details</h3>
                                <p>
                                <div class="form-group">
                                    <label class="col-form-label col-form-label-sm" for="inputDefault">Number Of Out Patient:</label>
                                    <input type="number" class="form-control form-control-sm" value="${festival.getNumOfOutPatient()}" placeholder="Number Of Out Patient" id="inputDefault" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault1">Number Of In Patient:</label>
                                    <input type="number" class="form-control form-control-sm" value="${festival.getNumOfInPatient()}" placeholder="Number Of In Patient" id="inputDefault1" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault2">Number Of Patient:</label>
                                    <input type="number" class="form-control form-control-sm" value="${festival.getNumOfPatients()}" placeholder="Number Of Patient" id="inputDefault2" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault3">Number Of Beds:</label>
                                    <input type="number" class="form-control form-control-sm" value="${festival.getNumOfBeds()}" placeholder="Number Of Beds" id="inputDefault3" disabled>
                                </div>
                                </p>
                            </div>
                            <div class="col-md-4 text-info">
                                <h3 class="text-white">Director Details</h3>
                                <p>
                                <div class="form-group">
                                    <label class="col-form-label col-form-label-sm" for="inputDefault4">Director Email:</label>
                                    <input type="email" class="form-control form-control-sm" value="${festival.getDirectorEmail()}" placeholder="Director Email" id="inputDefault4" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault5">Director Name:</label>
                                    <input type="text" class="form-control form-control-sm" value="${festival.getDirectorName()}" placeholder="Director Name" id="inputDefault5" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault6">Director Phone:</label>
                                    <input type="tel" class="form-control form-control-sm" value="${festival.getDirectorPhone()}" placeholder="Director Phone" id="inputDefault6" disabled>
                                </div>
                                </p>
                            </div>
                            <div class="col-md-4 text-info">
                                <h3 class="text-white">Contact Details</h3>
                                <p>
                                <div class="form-group">
                                    <label class="col-form-label col-form-label-sm" for="inputDefault7">License Number:</label>
                                    <input type="text" class="form-control form-control-sm" value="${festival.getLicenseNum()}" placeholder="License Number" id="inputDefault7" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault8">Phone:</label>
                                    <input type="tel" class="form-control form-control-sm" value="${festival.getPhone()}" placeholder="Phone" id="inputDefault8" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault9">Address:</label>
                                    <input type="text" class="form-control form-control-sm" value="${festival.getAddress()}" placeholder="Address" id="inputDefault9" disabled>

                                    <label class="col-form-label col-form-label-sm" for="inputDefault10">Country:</label>
                                    <input type="text" class="form-control form-control-sm" value="${festival.getCountry()}" placeholder="Country" id="inputDefault10" disabled>
                                </div>
                                </p>
                            </div>
                        </div>
                        <div class="col-md-6 btn-group mb-1">
                            <button type="button" name="upd" style="background-color: #136384" class="btn btn-primary btn-md"><i class="fa fa-wrench" style="font-size: 1.1em" aria-hidden="true"></i> Score Hospital</button>

                        </div>
                    </div>
                </div>  

            </div>
        </div>
    </div>
</c:forEach>
</body>
</html> 
