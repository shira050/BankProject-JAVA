/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

$(document).ready(function () {

    $.ajax({
        url: 'http://localhost:8080/banktransfers?email=' + sessionStorage["account"] + "&password=" + sessionStorage["password"],
        dataType: 'json',
        success: function (data) {
            if (data.status!=200)
            {
                $("#errorDiv").html("שגיאה בהצגת הדף");
                console.log("error:" + data.status + " " + data.statuseInfo);
            }
            else {

                var results = data;
                for (var i = 0; i < results.length; i++)
                {
                    var newT = '<tr><td>' + results[i].sum + '</td><td>' + results[i].accountNumFrom + '</td><td>' + results[i].accountNumTo + '</td><td>' + new Date(results[i].dateOfTransfer).toDateString() + " " + new Date(results[i].dateOfTransfer).toTimeString().substring(0, 8) + "</td></tr>";
                    $("#tbl").append(newT);
                }
            }

        },
        error: function () {
            $("#errorDiv").html("שגיאה בהצגת הדף");
        }
    });
});
