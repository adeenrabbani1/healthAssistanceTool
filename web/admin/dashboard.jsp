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
    <body>
        <div class="container-fluid">
            <div class="row mt-3 mb-3 justify-content-center">
                <c:forEach items="${hospitals}" var="festival">
                    <div class="card text-dark bg-secondary m-3 border-primary" style="width: 20rem;">
                        <div class="card-header bg-primary text-white">${festival.getName()}</div>
                        <div class="card-body">
                            <h4 class="card-title">${festival.getCountry()}</h4>
                            <p class="card-text">${festival.getAddress()}, ${festival.getPhone()}, ${festival.getLicenseNum()}</p>
                            
                        </div>
                        <div class="form-group">
                            <select class="custom-select col-12 bg-warning text-white">
                                <option selected="">Select Surveyor</option>
                                <c:forEach items="${surveyors}" var="sur">
                                    <option value="1">${sur.getName()}</option>
                                </c:forEach>
                            </select>
                        </div>
                    </div>
                </c:forEach>
            </div>
        </div>
    </body>
</html> 
