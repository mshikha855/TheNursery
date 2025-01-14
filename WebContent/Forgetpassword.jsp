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

  <title>Forget password</title>

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
     <script src="js/jquery.min .js"></script>
<script>
	$(document).ready(function(){
		$("input[type=email]").blur(function(){
			var str=$("#mail").val();
					$.get("ForgetpasswordServlet",{email : str})
					.done(function(data){
						
						if(data=='true')
						{
								//alert("THIS EMAIL ID IS NOT EXISTS");
								$('#email-error').html("This email id not exist");
								$(document).ready(function(){
									$("input[type=email]").val('').focus();
								});
								
						}
					});
		});
	});
</script>
</head>

<body style="background-image: url('img/bg-img/back.jpg');">
    <div class="container">
		<div class="back" style=" background-color: #e5e5e5; margin-top:150px; width:650px; padding: 40px; border-radius: 70px">
        <form class="form validity" method="post" action="ForgetpasswordServlet">
        <h1 style="font-weight:bold; font-size:50px; text-align: center; margin-bottom: 40px;">Forget password</h1>
            <div class="form-group">
						
			<div class="form-group">
			<p>Please enter the email address for your account. A verification code will be sent to you. Once you have received the verification code, you will be able to choose a new password for your account.</p><br>
               
                <input id="mail"  name="email" placeholder="Enter Email" class="form-control" data-mismatch="Please include a valid email" type="email" required>
            <span id="email-error" style="color: red; font-weight: bold; font-size: 12px;"></span>
            </div>
            
		</div>
			<p class="mt-20"><a href="Login.jsp">Back to log in</a></p>		
            <button class="btn btn-block btn-primary" type="submit">Request password reset</button>
        
        <%String msg=(String)request.getAttribute("message"); %>
        <%if(null!=msg){ %>
        <h4><%=msg %></h4>
        <%} %>
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
