/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showNotification1(message,type1) {
    console.log("the value is ", type1)
    $.notify({
        icon: "add_alert",
        message: message

    }, {
        type: 'success' ,
        timer: 30,
        placement: {
            from: 'top',
            align: 'right'
        }
    });
}

$(document).ready(function () {
    $("#addbtn").click(function () {
        $("#list").toggle("slow");
    });
    
    $("#listbtn").click(function () {
        $("#add").toggle("slow");
    });
});

