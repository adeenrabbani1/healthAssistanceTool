/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

function showNotification(message) {

    $.notify({
        icon: "add_alert",
        message: message

    }, {
        type: 'warning',
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

