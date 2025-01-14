<%@page import="com.thenurserysystem.bean.PasswordConvert"%>
<%@page import="com.thenurserysystem.bean.User"%>
<%@page import="com.thenurserysystem.bean.Area"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Update Password </title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/images/favicon.png" />

<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style1.css" />

<meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Change Password</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="js/jquery.min .js" ></script>
<script>
function checkPasswordMatch() {
    var password = $("#txtNewPassword").val();
    var confirmPassword = $("#txtConfirmPassword").val();
    if (password != confirmPassword)
    	{
        	$("#CheckPasswordMatch").html("Passwords does not match!");
        	$('input[type="submit"]').attr('disabled' , true);
    	}
    else
    	{
        	$("#CheckPasswordMatch").html("Passwords match.");
        	$('input[type="submit"]').attr('disabled' , false);
    	}
}
$(document).ready(function() {
	 $("#txtConfirmPassword").keyup(checkPasswordMatch);
	 
	$("#txtCurrentPassword").blur(function() {
			var str = $("#txtCurrentPassword").val();
			$.get("updatepassword", {
				currentpassword : str
			}).done(function(data) {
				if (data == 'false') 
					{
						 $("#emailerror").html("Current Password is Wrong");
						$("#txtCurrentPassword").val('').focus();
					}
			})
	});
	//$("#txtConfirmPassword").keyup(checkPasswordMatch);
});
</script>
</head>

<body style="background-image: url('img/bg-img/back.jpg');">

	<div class="container">

		<div class="back"
			style="background-color: #e5e5e5; margin-top: 70px; width: 650px; padding: 40px; border-radius: 70px">

			<form class="form validity" action="ChangepasswordServlet" method="post">
				<h1
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">Change Password</h1>
								
				
				<%HttpSession httpsession=request.getSession(false); %>			
			
				<% 
					User u=(User)httpsession.getAttribute("loginDetails");  
				
				%>
				<input type="hidden" name="userid" value="<%=u.getUserid() %>">
			<%String msg=(String)request.getAttribute("msg"); %>
				<%if(msg!=null){ %> <h4 style="color:green; font-size:20px; text-align: center; font-weight:  bold;"><%=msg %></h4> <%} %>
				
				<div class="form-group simple">

					<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
					<br><lable style="font-size:20px;">Enter Current Password </lable><br>
					<input type="password" class="form-control" name="currentpassword" id="txtCurrentPassword" placeholder="Enter password" data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>
					<span id="emailerror" style="color: red; font-weight: bold;"></span><br>
					<input type="checkbox" onclick="myFunctionCurrent()"> Show Password	
					
				</div>				
				
				<div class="form-group simple">

					<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
					<lable style="font-size:20px;">Enter New Password </lable><br>
					<input type="password" class="form-control" name="password" id="txtNewPassword" placeholder="Enter password" data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>
						
				</div>
				<div class="form-group simple">
					<lable style="font-size:20px;">Enter Confirm Password </lable><br>
					<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
					
					
					<input type="password" class="form-control" name="password1" id="txtConfirmPassword" placeholder="Enter password" data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also" pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>
					
				
					<input type="checkbox" onclick="myFunction()" style="padding:5px; font-size: 15px;"> Show Password
				<div class="registrationFormAlert" style="color:green; font-weight: bold;" id="CheckPasswordMatch"></div><br>				
				</div>
				
								
				<input class="btn btn-block btn-primary" type="submit" value="Submit">
				<br>
				<a href="Forgetpassword.jsp">Forgot your password?</a><br>
				<a href="Index.jsp">Back to Home</a>
				
								
			</form>
		</div>
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/jquery.validity.min.js"></script>
	<script src="js/script.js"></script>
	<script>
	function myFunction() {
		var x = document.getElementById("txtNewPassword");
		var y = document.getElementById("txtConfirmPassword");
		if (x.type === "password" && y.type === "password") {
			x.type = "text";
			y.type = "text";
		} 
		else
		{
			x.type = "password";
			y.type = "password";
		}
	}
	function myFunctionCurrent() {
		var x = document.getElementById("txtCurrentPassword");
		if (x.type === "password") {
			x.type = "text";

		} else {
			x.type = "password";
		}
	}
	
</script>
</body>
</html>