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
        <div class="container-fluid">
            <div class="row mt-3 mb-3 justify-content-center">
                <c:forEach items="${hospitals}" var="festival">
                    <div class="card text-dark bg-white m-3 border-dark" style="width: 20rem;">
                        <div class="card-header bg-primary text-white"><i class="fa fa-hospital-o" style="font-size: 1.3em" aria-hidden="true"></i> ${festival.getName()}</div>
                        <div class="card-body">
                            <h4 class="card-title">${festival.getCountry()}</h4>
                            <p class="card-text">${festival.getAddress()}, ${festival.getPhone()}, ${festival.getLicenseNum()}</p>
                        </div>
                        <div class="card-footer">
                            <button type="button" class="btn btn-info col-md-12" style="background-color: #136384" data-toggle="modal" data-target="#model${festival.getHospitalId()}">
                                <i class="fa fa-info-circle" style="font-size: 1.1em" aria-hidden="true"></i> More Info
                            </button>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
        
        
        <c:forEach items="${hospitals}" var="festival">
            <div class="modal fade" id="model${festival.getHospitalId()}">
                <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                    <div class="modal-content" style="background-color: #000005">
                        <div class="modal-header">
                            <h4 class="modal-title text-white pl-4">Hospital Name: ${festival.getName()}</h4>
                            <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                              <span aria-hidden="true">&times;</span>
                            </button>
                        </div>
                        <form action="adminController" method="post">
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
                            <div class="modal-footer">
                                <div class="row w-100">
                                    <div class="col-md-6 btn-group mb-1">
                                        <select class="custom-select text-white h-100" style="background-color: #136384">
                                            <option selected="" class="bg-secondary text-dark">Choose Surveyor</option>
                                            <c:forEach items="${surveyors}" var="sur">
                                                <option class="bg-secondary text-dark" value="1">${sur.getName()}</option>
                                            </c:forEach>
                                        </select>
                                        <button type="button" class="btn btn-primary btn-md col-md-4"><i class="fa fa-code-fork" style="font-size: 1.1em" aria-hidden="true"></i> Assign</button>
                                    </div>
                                    <div class="col-md-6 btn-group mb-1">
                                        <button type="submit" name="upd" class="btn btn-primary btn-md"><i class="fa fa-wrench" style="font-size: 1.1em" aria-hidden="true"></i> Update</button>
                                        <button type="submit" name="del" class="btn btn-primary btn-md"><i class="fa fa-trash-o" style="font-size: 1.1em" aria-hidden="true"></i> Delete</button>
                                        <button type="button" class="btn btn-primary btn-md" data-dismiss="modal"><i class="fa fa-times-circle"  style="font-size: 1.1em" aria-hidden="true"></i> Close</button>
                                    </div>
                                </div>
                            </div>  
                        </form>
                    </div>
                </div>
            </div>
        </c:forEach>
    </body>
</html> 
