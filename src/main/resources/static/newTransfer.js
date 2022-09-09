/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



$(document).ready(function () {
    $("#btn").click(function () {
        var account = sessionStorage["accountNum"];
        var password = sessionStorage["password"];

        var transfer = {};



        transfer.accountNumFrom = account;

        transfer.accountNumTo = $("#accountToTransfer").val();


        transfer.sum = $("#sum").val();


        $.ajax({
            type: "POST",
            url: 'http://localhost:8080/banktransfers?password=' + sessionStorage["password"],
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data: JSON.stringify(transfer),
            success: function (data) {

                if (data.status!=200)
                {
                    $("#results").html("לא ניתן לבצע את ההעברה כעת")
                    console.log("error:" + data.status + " " + data.statusInfo)
                }
                else
                    $("#results").html("ההעברה בוצעה בהצלחה")
            },
            error: function (obj) {
                $("#results").html("לא ניתן לבצע את ההעברה כעת")
            }
        });
    });
});