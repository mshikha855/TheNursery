<%@page import="com.thenurserysystem.bean.Area"%>
<%@page import="java.util.List"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<head>
<title>Gardener-Signin Page </title>
<meta charset="utf-8">

<meta name="viewport" content="width=device-width, initial-scale=1.0" />

<link rel="shortcut icon" href="/images/favicon.png" />

<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet"
	href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" href="css/style1.css" />
  <script src = "http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src = "http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>

<meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Registration</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
<script src="js/jquery.min .js"></script>
<script>
	$(document).ready(function() {
		$("#contact").keypress(function (e) {
		     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {   
		    	  $("#errmsg").html("  Enter Digits Only").show().fadeOut("slow");
		               return false;
		    }
		   });
		$("input[type=email]").blur(function() {
			var str = $("#mail").val();
			$.get("RegistrationServlet", {
				email : str
			}).done(function(data) {

				if (data == 'true') {
					$('#email-error').html("This Email Id Already Exist");
					$(document).ready(function() {
						$("input[type=email]").val('').focus();
					});
				}
			});
		});
			
	});
</script>

<script type="text/javascript">
	function prevetBack(){
		window.history.forward();
	}
	setTimeout("preventBack()",0);
	window.onunload=function(){null};
	
	window.onbeforeunload=function(){
		return "You can not go back";
	}
</script>

</head>

<body style="background-image: url('img/bg-img/back.jpg');">

<jsp:include page="/FindAreaDetailsServlet"/>
	<div class="container">

		<div class="back"
			style="background-color: #e5e5e5; margin-top: 40px; width: 650px; padding: 40px; border-radius: 70px">

			<form class="form validity" action="RegistrationGardenerServlet" method="post">
				<h1
					style="font-weight: bold; font-size: 50px; margin-top: 0px; text-align: center; margin-bottom: 30px;">Sign
					Up</h1>
				<div class="form-group">

					<input id="name2" name="fname" class="form-control"
						placeholder="Enter Firstname"
						data-missing="This field is required" type="text" required>
				</div>
				<div class="form-group">

					<input id="name2" name="lname" class="form-control"
						placeholder="Enter Lastname" data-missing="This field is required"
						type="text" required>
				</div>

				<div class="form-group">

					<!--         <input id="name2" name="name" class="form-control" data-missing="This field is required" type="text" required> -->
					<textarea rows="2" cols="40" class="form-control"
						placeholder="Enter Address" name="address" id="name2"
						data-missing="This field is required" required></textarea>
				</div>

				<div class="form-group">
					<input id="mail" name="email" class="form-control"
						placeholder="Enter Emailid" 
						data-mismatch="Please include a valid email" pattern="^(?![\.\-_])((?![\-\._][\-\._])[a-z0-9\-\._]){0,63}[a-z0-9]@(?![\-])((?!--)[a-z0-9\-]){0,63}[a-z0-9]\.(|((?![\-])((?!--)[a-z0-9\-]){0,63}[a-z0-9]\.))(|([a-z]{2,14}\.))[a-z]{2,14}$" class="form-control" type="email" required>
				<span id="email-error" style="color: red; font-weight: bold; font-size: 12px;"></span>
				</div>

				<div class="form-group simple">

					<input id="contact" name="phoneno" class="form-control"	placeholder="Enter Phoneno" pattern="[6789][0-9]{9}" data-mismatch="Enter 10 digit only" type="text" maxlength="10"  required>
				</div>
				<span id="errmsg" style="color: red; font-weight: bold; font-size: 12px" > </span>

				<div class="form-group">

					<% List<Area> area = (List) request.getAttribute("areadetails");%>
					
					<select required class="form-control" name="area">
						<option value="" disabled selected hidden">Select Area</option>
						<%
							for (int i = 0; i < area.size(); i++) {
						%>
						<%
							Area a = area.get(i);
						%>
						<option value="<%=a.getPincode()%>"> <%=a.getAreaname()%></option>
						<%
							}
						%>
					</select>
					
					</element>
					
				</div>

				<div class="form-group simple">

					<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
					<input type="password" class="form-control" name="password" id="myInput" placeholder="Enter password" data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also"
						pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required><br>
						
					
					<!-- An element to toggle between password visibility --> 
					<input type="checkbox" onclick="myFunction()"> Show
					Password
					<label style="margin-left: 330px; font-weight: normal; ">Back to login     <a href="Login.jsp">Login</a></label>
				</div>
				
				
				<button class="btn btn-primary" type="submit">Submit</button>
				<button class="btn btn-primary" type="reset">Reset</button>
				<div>
					<%String str=(String)request.getAttribute("message"); %>
				
					<%if(null!=str) {%>
						<h4 style=" font-weight:bold; font-size:20px; color:green; font-color:green; text-align: center"><%=str %></h4>
						
					<%} %>
				
				</div>
				
			</form>
			
		</div>
	</div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/jquery.validity.min.js"></script>
	<script src="js/script.js"></script>
	<script>
		function myFunction() {
			var x = document.getElementById("myInput");
			if (x.type === "password") {
				x.type = "text";
			} else {
				x.type = "password";
			}
		}
	</script>
</body>
</html>
