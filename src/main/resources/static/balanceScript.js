/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
$(document).ready(function () {

    $.ajax({
        url: 'http://localhost:8080/users?email=' + sessionStorage["account"] + "&password=" + sessionStorage["password"],
        dataType: 'json',
        success: function (data) {

            if (data.status!=200)
            {
                $("#results").html("שגיאה בהצגת היתרה");
                console.log("error:" + data.status + " " + data.statusInfo);
            }
            else
                $("#results").html(data.balance);

        },
        error: function () {
            $("#results").html("שגיאה בהצגת היתרה");
        }
    });
});


