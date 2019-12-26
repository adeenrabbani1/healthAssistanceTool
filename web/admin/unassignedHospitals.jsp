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
            <div class="mt-5 mb-3 text-center">
                <!--<h1><small>Hello</small> ${user.getName()}</h1>-->
                <h4><i class="fa fa-calendar-minus-o" style="font-size:24px"></i> unassigned hospitals</h4>
                <br>
                <jsp:include page="../common/errorFlash.jsp"/>
            </div>
            <div class="row mt-3 mb-3 justify-content-center">

                <c:forEach items="${hospitals}" var="festival">
                    <c:choose>
                        <c:when test="${festival.getSurID() > 0}">
                        </c:when>    
                        <c:otherwise>
                            <div class="card text-white bg-primary border-primary m-3" style="max-width: 20rem; box-shadow: 0 4px 8px 4px rgba(0, 0, 0, 0.4); border-radius: 5px">
                                <img style="height: 150px; width: 100%; display: block;" src="../img/hos.png" alt="Card image">
                                <div class="card-body">
                                    <h4 class="card-title">${festival.getName()}, ${festival.getCountry()}</h4>
                                    <p class="card-text">${festival.getAddress()}, ${festival.getPhone()}, ${festival.getLicenseNum()}</p>
                                </div>

                                <div class="card-footer">
                                    <button type="button" class="btn btn-info col-md-12" style="background-color: #136384" data-toggle="modal" data-target="#model${festival.getHospitalId()}">
                                        <i class="fa fa-info-circle" style="font-size: 1.1em" aria-hidden="true"></i> More Info
                                    </button>
                                </div>
                            </div>
                        </c:otherwise>
                    </c:choose>
                </c:forEach>
            </div>
        </div>


        <c:forEach items="${hospitals}" var="festival">
            <c:choose>
                <c:when test="${festival.getSurID() > 0}">
                </c:when>    
                <c:otherwise>
                    <div class="modal fade" id="model${festival.getHospitalId()}">
                        <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
                            <div class="modal-content border-danger" style="background-color: #000005; border-radius: 15px">
                                <div class="modal-header">
                                    <h4 class="modal-title text-white pl-4">Hospital Name: ${festival.getName()}</h4>
                                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                                        <span aria-hidden="true">&times;</span>
                                    </button>
                                </div>
                                <form action="../adminController" method="post">
                                    <input name="id" hidden value="${festival.getHospitalId()}">
                                    <div class="modal-body row pl-5 pr-5" style="font-weight: bold">
                                        <div class="col-md-4 text-info">
                                            <h3 class="text-white">Hospital Details</h3>
                                            <p>
                                            <div class="form-group">
                                                <label class="col-form-label col-form-label-sm" for="inputDefault">Number Of Out Patient:</label>
                                                <input type="number" class="form-control form-control-sm" value="${festival.getNumOfOutPatient()}" 
                                                       placeholder="Number Of Out Patient" id="inputDefault" name="outPatient">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault1">Number Of In Patient:</label>
                                                <input type="number" class="form-control form-control-sm" value="${festival.getNumOfInPatient()}" 
                                                       placeholder="Number Of In Patient" id="inputDefault1" name="inPatient">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault2">Number Of Patient:</label>
                                                <input type="number" class="form-control form-control-sm" value="${festival.getNumOfPatients()}" 
                                                       placeholder="Number Of Patient" id="inputDefault2" name="patient">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault3">Number Of Beds:</label>
                                                <input type="number" class="form-control form-control-sm" value="${festival.getNumOfBeds()}" 
                                                       placeholder="Number Of Beds" id="inputDefault3" name="beds">
                                            </div>
                                            </p>
                                        </div>
                                        <div class="col-md-4 text-info">
                                            <h3 class="text-white">Director Details</h3>
                                            <p>
                                            <div class="form-group">
                                                <label class="col-form-label col-form-label-sm" for="inputDefault4">Director Email:</label>
                                                <input type="email" class="form-control form-control-sm" value="${festival.getDirectorEmail()}" 
                                                       placeholder="Director Email" id="inputDefault4" name="dirEmail">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault5">Director Name:</label>
                                                <input type="text" class="form-control form-control-sm" value="${festival.getDirectorName()}" 
                                                       placeholder="Director Name" id="inputDefault5" name="dirName">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault6">Director Phone:</label>
                                                <input type="tel" class="form-control form-control-sm" value="${festival.getDirectorPhone()}" 
                                                       placeholder="Director Phone" id="inputDefault6" name="dirPhone">
                                            </div>
                                            </p>
                                        </div>
                                        <div class="col-md-4 text-info">
                                            <h3 class="text-white">Contact Details</h3>
                                            <p>
                                            <div class="form-group">
                                                <label class="col-form-label col-form-label-sm" for="inputDefault7">License Number:</label>
                                                <input type="text" class="form-control form-control-sm" value="${festival.getLicenseNum()}" 
                                                       placeholder="License Number" id="inputDefault7" name="license">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault8">Phone:</label>
                                                <input type="tel" class="form-control form-control-sm" value="${festival.getPhone()}" 
                                                       placeholder="Phone" id="inputDefault8" name="phone">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault9">Address:</label>
                                                <input type="text" class="form-control form-control-sm" value="${festival.getAddress()}" 
                                                       placeholder="Address" id="inputDefault9" name="address">

                                                <label class="col-form-label col-form-label-sm" for="inputDefault10">Country:</label>
                                                <input type="text" class="form-control form-control-sm" value="${festival.getCountry()}" 
                                                       placeholder="Country" id="inputDefault10" name="country">
                                            </div>
                                            </p>
                                        </div>
                                    </div>

                                    <c:choose>
                                        <c:when test="${festival.getSurID() > 0}">
                                        </c:when>    
                                        <c:otherwise>
                                            <div class="modal-footer">
                                                <div class="row w-100">
                                                    <div class="col-md-6 btn-group mb-1">
                                                        <select class="custom-select text-white h-100" name="sur" style="background-color: #136384">
                                                            <option selected="" class="bg-secondary text-dark">Choose Surveyor</option>
                                                            <c:forEach items="${surveyors}" var="sur">
                                                                <option class="bg-secondary text-dark" value="${sur.getSurv_id()}">${sur.getName()}</option>
                                                            </c:forEach>
                                                        </select>
                                                        <button type="submit" name="command" value="assign" class="btn btn-primary btn-md col-md-4"><i class="fa fa-code-fork" style="font-size: 1.1em" aria-hidden="true"></i> Assign</button>
                                                    </div>
                                                    <div class="col-md-6 btn-group mb-1">
                                                        <button type="submit" name="command" value="update" class="btn btn-primary btn-md"><i class="fa fa-wrench" style="font-size: 1.1em" aria-hidden="true"></i> Update</button>
                                                        <button type="submit" name="command" value="delete" class="btn btn-primary btn-md"><i class="fa fa-trash-o" style="font-size: 1.1em" aria-hidden="true"></i> Delete</button>
                                                        <button type="button" class="btn btn-primary btn-md" data-dismiss="modal"><i class="fa fa-times-circle"  style="font-size: 1.1em" aria-hidden="true"></i> Close</button>
                                                    </div>
                                                </div>
                                            </div>
                                        </c:otherwise>
                                    </c:choose>

                                </form>
                            </div>
                        </div>
                    </div>
                </c:otherwise>
            </c:choose>
        </c:forEach>
    </body>
</html> 
