<%@page import="com.thenurserysystem.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<!--[if lt IE 7]>      <html class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> 
<html class="no-js"> <!--<![endif]-->
<head>
  <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  <meta name="description" content="Aviato E-Commerce Template">
  
  <meta name="author" content="Themefisher.com">

  <title>OTP</title>

  <!-- Mobile Specific Meta-->
  <meta name="viewport" content="width=device-width, initial-scale=1">
  
  <!-- Favicon -->
  <link rel="shortcut icon" type="image/x-icon" href="images/favicon.png" />
  
  <!-- Themefisher Icon font -->
  <link rel="stylesheet" href="plugins/themefisher-font/style.css">
  <!-- bootstrap.min css -->
  <link rel="stylesheet" href="plugins/bootstrap/css/bootstrap.min.css">
  
  <!-- Revolution Slider -->
  <link rel="stylesheet" type="text/css" href="plugins/revolution-slider/revolution/fonts/pe-icon-7-stroke/css/pe-icon-7-stroke.css">
  <link rel="stylesheet" type="text/css" href="plugins/revolution-slider/revolution/fonts/font-awesome/css/font-awesome.css">

  <!-- REVOLUTION STYLE SHEETS -->
  <link rel="stylesheet" type="text/css" href="plugins/revolution-slider/revolution/css/settings.css">
  <link rel="stylesheet" type="text/css" href="plugins/revolution-slider/revolution/css/layers.css">
  <link rel="stylesheet" type="text/css" href="plugins/revolution-slider/revolution/css/navigation.css">
  
  <!-- Main Stylesheet -->
<link rel="stylesheet" href="css/style">
<head>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />

    <link rel="shortcut icon" href="/images/favicon.png" />

    <link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="css/style1.css" />

    <!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
        <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->

<script src="js/jquery.min.js" ></script>

<script>
		$(document).ready(function() {
			  $("#otp").keypress(function (e) {
				     if (e.which != 8 && e.which != 0 && (e.which < 48 || e.which > 57)) {       
				        $("#errmsg").html("Digits Only").show().fadeOut("slow");
				               return false;
				    }
				   });	
		});
</script>
  
</head>

<body style="background-image: url('img/bg-img/22.jpg');">
    <div class="container">
		<div class="back" style=" background-color: #e5e5e5; margin-top:150px; width:650px; padding: 40px; border-radius: 70px">
        <form class="form validity" method="post" action="GetRegistrationOtp">
    		
        <h1 style="font-weight:bold; font-size:50px; text-align: center; margin-bottom: 40px;">OTP</h1>
            <div class="form-group">
			<div class="form-group">
			<p>CHECK YOUR EMAIL AND ENTER CORRECT OTP</p><br>
			
			<%User u1=(User)request.getAttribute("userdetails"); %>
			<%String otp=(String)request.getAttribute("otp"); %>
				 
				<input type="hidden" name="fname" value="<%=u1.getFname() %>">
				<input type="hidden" name="lname" value="<%=u1.getLname() %>">
				<input type="hidden" name="address" value="<%=u1.getAddress() %>">
				<input type="hidden" name="email" value="<%=u1.getEmail() %>">
				<input type="hidden" name="phoneno" value="<%=u1.getContactno() %>">
				<input type="hidden" name="area" value="<%=u1.getPincode() %>">
				<input type="hidden" name="password" value="<%=u1.getPassword() %>">
				<input type="hidden" name="role" value="<%=u1.getRole() %>">
                <input type="hidden" name="originalotp" value="<%=otp %>"> 
               	
                <input name="otp" placeholder="Enter Your OTP" class="form-control" data-mismatch="Please enter OTP" type="text" id="otp" required>
                
                <span id="errmsg" style="color: red"> </span>
           
            </div>
            
            <div>
					<%String str=(String)request.getAttribute("message"); %>
				
					<%if(null!=str) {%>

						<h4 style=" font-weight:bold; font-size:20px; color:red; font-color:red; text-align: center"><%=str %></h4>
					<%} %>
				
				</div>
		</div>
			<p class="mt-20"><a href="signin.jsp">Back to Registration</a></p>
			<p class="mt-20"><a href="Index.jsp">Back to Home</a></p>		
            <button class="btn btn-block btn-primary" type="submit">Submit</button>
            
        
        </form>
	</div>
       

    </div>

	<script src="https://cdnjs.cloudflare.com/ajax/libs/jquery/3.4.1/jquery.min.js"></script>
	<script src="https://cdnjs.cloudflare.com/ajax/libs/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script src="js/jquery.validity.min.js"></script>
	<script src="js/script.js"></script>
	<script>
</script>
</body>
</html>
