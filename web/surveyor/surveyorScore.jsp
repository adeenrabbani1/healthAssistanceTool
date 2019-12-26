<%-- 
    Document   : surveyorScore.jsp
    Created on : Dec 4, 2019, 6:25:12 PM
    Author     : adeen
--%>



<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <jsp:include page="../common/header.html"/>
    </head>

    <style type="text/css"> 
        input[type="radio"]{margin: 10px 0}; 
    </style>
    <body >

        <h1 class="text-center" style="margin-top: 1%" >Hospital Score Board</h1>  <br>
        <p class="text-center" style="color:crimson;">Please score the standards of the Hospital below and save accordingly!</p>

        <form action="surveyorController" method="post">
           <input type="hidden" name="command" value="SUBMIT-SCORE" />
            <div class="cl">
                <c:forEach items="${values}" var="value">

                    <div id="${value.id}" class="cl card text-center  " style="margin-top: 2%" >

                        <div class="card-body cards " style="background-color: whitesmoke" >
                            <h1 class="card-title" style="text-decoration: underline">${value.getCode()} - ${value.getTitle()}</h1>
                            <c:if test="${value.getCategory() =='Critical'}">
                                <div class="mt-auto text-center"><span class="badge badge-pill badge-danger text-center">${value.getCategory()}</span></div>  
                                </c:if>
                                <c:if test="${value.getCategory() =='Development'}">
                                <div class="mt-auto text-center"><span class="badge badge-pill  badge-primary text-center" style="background-color: blue">${value.getCategory()}</span></div>  
                                </c:if>
                                <c:if test="${value.getCategory() =='Core'}">
                                <div class="mt-auto text-center"><span class="badge badge-pill  badge-primary text-center" style="background-color: slateblue">${value.getCategory()}</span></div>  
                                </c:if>
                            <p style="font-size: 20px" class="card-text text-left" >${value.getDescription()}.</p>
                            <h4>Score</h4>
                            <label class="radio-inline"><input style="margin-right: 20px" type="radio" name="${value.getTitle()}" value="0" checked>0%</label>
                            <label class="radio-inline"><input style="margin-right: 20px"  type="radio" name="${value.getTitle()}" value="25">25%</label>
                            <label class="radio-inline"><input style="margin-right: 20px"  type="radio" name="${value.getTitle()}" value="50">50%</label>
                            <label class="radio-inline"><input style="margin-right: 20px"  type="radio" name="${value.getTitle()}" value="75">75%</label>
                            <label class="radio-inline"><input type="radio" name="${value.getTitle()}" value="100">100</label>
                            <button type="button" id="${value.id}" onclick="loadPrev(this.id)" class="btn btn-warning float-left" >Previous</button>
                            <button type="button" id="${value.id}" onclick="loadNext(this.id)" class="btn btn-success float-right" >Next</button> <br> <br>
                            <input style="margin-top: 3px;background-color: whitesmoke; border: 1px solid black; text-align: center"  class="form-control" placeholder="Please Add your Comments Here.." name="${value.getTitle()}com" id="message-text">
                        </div>
                    </div>

                </c:forEach>
                 
                <button type="submit" style="margin-top: 15px"  class="text-center btn btn-success float-right" >Save Draft</button>

            </div>
            
        </form>
    </body>

    <script type="text/javascript">

        $(document).ready(function () {
            var elem = document.getElementsByClassName('cl');
            console.log("", elem)
            for (var i = 2; i < elem.length; i++) {
                $(elem[i]).hide();
            }
        })
        function loadNext(val, e) {
            var elem = document.getElementsByClassName('cl');
            console.log("looking for me", elem)
            //console.log($(elem[parseInt(val)]).next())
            if ($(elem[parseInt(val)]).next().length) {
                $(elem[parseInt(val)]).hide("fast");
                $(elem[parseInt(val)]).next().show("fast");
            } else {
                 
                alert("This was the last standard to Score! Enough already surveyor. GO SLEEP ");
                e.preventDefault();
            }

        }
        function loadPrev(val, e) {
            var elem = document.getElementsByClassName('cl');
            if ($(elem[parseInt(val)]).prev().length) {
                $(elem[parseInt(val)]).hide('fast');
                $(elem[parseInt(val)]).prev().show('fast');
            } else {
                alert("No more Elements! ");
                e.preventDefault();
            }
        }

    </script>

</html>
