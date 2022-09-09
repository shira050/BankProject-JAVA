/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


var balance;
var account;
    $(document).ready(function() {
        
        $.ajax({
            url: 'http://localhost:8080/users?email=' + sessionStorage["account"] + "&password=" + sessionStorage["password"],
            dataType: 'json',
       
            success: function(data) {
            account=data.accountNumber;
                   $("#accountNum").append(data.accountNumber);
                $("#tzNum").append(data.tz);
                $("#txtName").val(data.accountOwnerName);
                $("#txtEmail").val(data.email);
             $("#txtTelephone").val(data.tellephone);
                 $("#txtCellephone").val(data.cellephone);
                balance=data.balance;
            },
             error: function() {
              alert("error");         }
        });
    $("#btn").click(function() {
       
 
        var password=sessionStorage["password"];
        
        var user={};
        user["accountNumber"]=account;
        user["tz"]=$('#tzNum').text().toString();
        user["password"]=password;
        user["balance"]=balance;
        user["accountOwnerName"]=$("#txtName").val();
         user["email"]=$("#txtEmail").val();
         user["telephone"]=$("#txtTelephone").val();
            user["cellphone"]=$("#txtCellephone").val();
        
      
        $.ajax({
            type:"PUT",
            url: 'http://localhost:8080/users/',
            dataType: 'json',
            contentType: "application/json; charset=utf-8",
            data:JSON.stringify(user),
            success: function(data) {
               
                    $("#results").html("הפרטים עודכנו בהצלחה")
             
            },
             error: function(data) {
              $("#results").html("שגיאה בעידכון הנתונים");
             }
        });
    });
});
   