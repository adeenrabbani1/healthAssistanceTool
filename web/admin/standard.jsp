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
                <div class="col m-3" id="add">
                    <div class="card text-white bg-primary border-primary" style="box-shadow: 0 4px 8px 4px rgba(0, 0, 0, 0.4); border-radius: 5px">
                        <!--<img src="https://pngimage.net/wp-content/uploads/2018/06/standard-png-5.png" class="card-img" alt="...">-->
                        <form action="../adminController" method="post">
                            <div class="card-header">

                                <button type="button" class="close text-white" id="addbtn">
                                    <i class="fa fa-window-maximize" aria-hidden="true"></i>
                                </button>

                                <h1 class="text-center mt-2 text-white"><i class="fa fa-plus" aria-hidden="true"></i> Add Standard</h1>
                            </div>
                            <div class="card-body">
                                <p class="card-text">
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="title">Title</label>
                                        <input type="text" class="form-control" id="title" name="title" placeholder="eg Waste management" required>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="code">Code</label>
                                        <input type="text" class="form-control" id="code" name="code" placeholder="eg E.1.2.1">
                                    </div>
                                </div>
                                <div class="form-group">
                                    <label for="des">Description</label>
                                    <input type="text" class="form-control" id="des" name="des" placeholder="eg All hospital staff are provided with a patient safety..." required>
                                </div>
                                <div class="form-row">
                                    <div class="form-group col-md-6">
                                        <label for="category">Category</label>
                                        <select id="category" class="form-control" name="category" required>
                                            <option selected hidden>Choose...</option>
                                            <option>Critical</option>
                                            <option>Core</option>
                                            <option>Development</option>
                                        </select>
                                    </div>
                                    <div class="form-group col-md-6">
                                        <label for="domain">Domain</label>
                                        <select id="domain" class="form-control" name="domain" required>
                                            <option selected hidden>Choose...</option>
                                            <option value="leadership Management">leadership Management</option>
                                            <option value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option value="Safe Environment">Safe Environment</option>
                                            <option value="Life Long Learning">Life Long Learning</option>
                                        </select>
                                    </div>
                                </div>
                                </p>
                            </div>
                            <div class="card-footer">
                                <button type="submit" name="command" value="addStand" class="btn btn-warning">Add Standard</button> 
                            </div>
                        </form>
                    </div>
                </div>


                <div class="col m-3" id="list">
                    <div class="card text-white bg-primary border-primary" style="box-shadow: 0 4px 8px 4px rgba(0, 0, 0, 0.4); border-radius: 5px;">
                        <!--<img src="https://pngimage.net/wp-content/uploads/2018/06/standard-png-5.png" class="card-img" alt="...">-->
                        <div class="card-header">
                            <button type="button" class="close text-white" id="listbtn">
                                <i class="fa fa-window-maximize" aria-hidden="true"></i>
                            </button>

                            <h1 class="text-center mt-2 text-white"><i class="fa fa-list" aria-hidden="true"></i> List Standard</h1>
                        </div>
                        <div class="card-body">
                            <table class="table table-hover">
                                <thead>
                                    <tr class="text-info text-center">
                                        <th scope="col">Code</th>
                                        <th scope="col">Domain</th>
                                        <th scope="col">Category</th>
                                        <th scope="col">Title</th>
                                        <th scope="col">Description</th>
                                    </tr>
                                </thead>
                                <tbody>
                                    <c:forEach items="${standards}" var="festival">
                                        <tr class="text-warning" data-toggle="modal" data-target="#model${festival.getId()}">
                                            <td>${festival.getCode()}</td>
                                            <td>${festival.getDomain()}</td>
                                            <td>${festival.getCategory()}</td>
                                            <td>${festival.getTitle()}</td>
                                            <td>${festival.getDescription()}</td>
                                        </tr>
                                    </c:forEach>
                                </tbody>
                            </table> 
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html> 


<c:forEach items="${standards}" var="festival">
    <div class="modal fade" id="model${festival.getId()}">
        <div class="modal-dialog modal-dialog-centered modal-xl" role="document">
            <div class="modal-content border-danger" style="background-color: #000005; border-radius: 15px">
                <div class="modal-header">
                    <h4 class="modal-title text-white pl-4">Standard Code: ${festival.getCode()}</h4>
                    <button type="button" class="close" data-dismiss="modal" aria-label="Close">
                        <span aria-hidden="true">&times;</span>
                    </button>
                </div>
                <form action="../adminController" method="post">
                    <input name="id" hidden value="${festival.getId()}">
                    <div class="modal-body row pl-5 pr-5" style="font-weight: bold">
                        <div class="col-md-12 text-info">
                            <h3 class="text-white">Standard Details</h3>
                            <p>
                            <div class="form-group">
                                <label class="col-form-label col-form-label-sm" for="inputDefault">Standard Code:</label>
                                <input type="text" class="form-control form-control-sm" value="${festival.getCode()}" 
                                       placeholder="Standard Code" id="inputDefault" name="code" required>

                                <label class="col-form-label col-form-label-sm" for="inputDefault1">Standard Type:</label>
                                <select id="domain" class="form-control" name="domain" required>
                                    <option selected hidden>Choose...</option>
                                    <c:choose>
                                        <c:when test = "${festival.getDomain() == 'leadership Management'}">
                                            <option selected value="leadership Management">leadership Management</option>
                                            <option value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option value="Safe Environment">Safe Environment</option>
                                            <option value="Life Long Learning">Life Long Learning</option>
                                        </c:when>
                                        <c:when test = "${festival.getDomain() == 'Patient Public Involvement'}">
                                            <option value="leadership Management">leadership Management</option>
                                            <option selected value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option value="Safe Environment">Safe Environment</option>
                                            <option value="Life Long Learning">Life Long Learning</option>
                                        </c:when>
                                        <c:when test = "${festival.getDomain() == 'Safe Evidence Based Practice'}">
                                            <option value="leadership Management">leadership Management</option>
                                            <option value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option selected value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option value="Safe Environment">Safe Environment</option>
                                            <option value="Life Long Learning">Life Long Learning</option>
                                        </c:when>
                                        <c:when test = "${festival.getDomain() == 'Safe Environment'}">
                                            <option value="leadership Management">leadership Management</option>
                                            <option value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option selected value="Safe Environment">Safe Environment</option>
                                            <option value="Life Long Learning">Life Long Learning</option>
                                        </c:when>
                                        <c:when test = "${festival.getDomain() == 'Life Long Learning'}">
                                            <option value="leadership Management">leadership Management</option>
                                            <option value="Patient Public Involvement">Patient Public Involvement</option>
                                            <option value="Safe Evidence Based Practice">Safe Evidence Based Practice</option>
                                            <option value="Safe Environment">Safe Environment</option>
                                            <option selected value="Life Long Learning">Life Long Learning</option>
                                        </c:when>
                                    </c:choose>
                                </select>

                                <label class="col-form-label col-form-label-sm" for="inputDefault2">Standard Category:</label>
                                <select id="category" class="form-control" name="category" required>
                                    <option selected hidden>Choose...</option>
                                    <c:choose>
                                        <c:when test = "${festival.getCategory() == 'Critical'}">
                                            <option selected>Critical</option>
                                            <option>Core</option>
                                            <option>Development</option>
                                        </c:when>
                                        <c:when test = "${festival.getCategory() == 'Core'}">
                                            <option>Critical</option>
                                            <option selected>Core</option>
                                            <option>Development</option>
                                        </c:when>
                                        <c:when test = "${festival.getCategory() == 'Development'}">
                                            <option>Critical</option>
                                            <option>Core</option>
                                            <option selected>Development</option>
                                        </c:when>
                                    </c:choose>
                                </select>

                                <label class="col-form-label col-form-label-sm" for="inputDefault3">Standard Title:</label>
                                <input type="text" class="form-control form-control-sm" value="${festival.getTitle()}" 
                                       placeholder="Standard Title" id="inputDefault3" name="title" required>

                                <label class="col-form-label col-form-label-sm" for="inputDefault3">Standard Description:</label>
                                <input type="text" class="form-control form-control-sm" value="${festival.getDescription()}" 
                                       placeholder="Standard Description" id="inputDefault3" name="des" required>
                            </div>
                            </p>
                        </div>
                    </div>
                    <div class="modal-footer">
                        <div class="row w-100">
                            <div class="col-md-6 btn-group mb-1">
                                <button type="submit" name="command" value="updateStand" class="btn btn-primary btn-md"><i class="fa fa-wrench" style="font-size: 1.1em" aria-hidden="true"></i> Update</button>
                                <button type="submit" name="command" value="deleteStand" class="btn btn-primary btn-md"><i class="fa fa-trash-o" style="font-size: 1.1em" aria-hidden="true"></i> Delete</button>
                            </div>
                            <div class="col-md-6 btn-group mb-1">
                                <button type="button" class="btn btn-primary btn-md" data-dismiss="modal"><i class="fa fa-times-circle"  style="font-size: 1.1em" aria-hidden="true"></i> Close</button>
                            </div>
                        </div>
                    </div>  
                </form>
            </div>
        </div>
    </div>
</c:forEach>
