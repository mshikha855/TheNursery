<%@page import="com.thenurserysystem.bean.PasswordConvert"%>
<%@page import="java.util.List"%>
<%@page import="com.thenurserysystem.bean.Area"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>


<meta charset="UTF-8">
<meta name="description" content="">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

<!-- Title -->

<title>Insert Offer</title>


<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet" href="css/style1.css" />

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js/jquery.min .js"></script>
</head>

<body>
	
	<!-- Preloader -->
	<div class="preloader d-flex align-items-center justify-content-center">
		<div class="preloader-circle"></div>
		<div class="preloader-img">
			<img src="img/core-img/leaf.png" alt="">
		</div>
	</div>

	<!-- ##### Header Area Start ##### -->
	<%@include file="Header.jsp"%>
	<!-- ##### Header Area End ##### -->

	<!-- ##### Breadcrumb Area Start ##### -->
	<div class="breadcrumb-area">
		<!-- Top Breadcrumb Area -->
		<div
			class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center "
			style="background-image: url(img/bg-img/24.jpg);"></div>

		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home"></i> Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Insert Offer</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>


	<div class="container">

		<div class="back"
			style="background-color: white; margin-top: auto; width: 650px; padding: auto; border-radius: 70px; margin-left: 200px;">

			<form class="form validity" action="InsertOfferServlet" method="post">
				
				<h1 style="font-weight: bold; font-size: 30px; text-align: center; margin-bottom: 30px;">Insert Offer</h1>
				
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">Enter Offer Discount[%]</label> 
						
						<input id="name2" name="offerdiscount" class="form-control input-group-lg reg_name" data-missing="This field is required" type="number" required style="width: 500px;">
				
					</div>
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">Enter Offer Details</label> 
						
						<input id="name2" name="offerdetails" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" required style="width: 500px;">
				
					</div>
				</div>
				
				
					<%
						String s = (String) request.getAttribute("message");
					if (null != s) {
					%>
					<h4
						style="font-weight: bold; font-size: 20px; color: green; font-color: green; margin-left: 150px;"><%=s%></h4>
					<%
						}
					%>
				</div>

				<div class="checkout-btn mt-30">
					<button class="btn alazea-btn" style="margin-left: 300px;">Insert Offer</button>
					<a href="OfferList.jsp" type="button" class="btn alazea-btn" style="margin-left: 20px;">Back</a>
				</div>

			</form>
		</div>
	</div>



	<!-- ##### Breadcrumb Area End ##### -->

	<!-- ##### About Area Start ##### -->

	<!-- ##### About Area End ##### -->

	<!-- ##### Service Area Start ##### -->

	<!-- ##### Service Area End ##### -->

	<!-- ##### Testimonial Area Start ##### -->
	<section class="testimonial-area section-padding-100">
		<div class="container">
			<div class="row">
				<div class="col-12">
					<div class="testimonials-slides owl-carousel"></div>
				</div>
			</div>
		</div>
	</section>
	<!-- ##### Testimonial Area End ##### -->

	<!-- ##### Cool Facts Area Start ##### -->
	<!-- ##### Cool Facts Area End ##### -->

	<!-- ##### Team Area Start ##### -->

	<!-- ##### Team Area End ##### -->


	<!-- ##### Footer Area Start ##### -->
	<%@include file="Footer.jsp"%>
	<!-- ##### Footer Area End ##### -->

	<!-- ##### All Javascript Files ##### -->
	<!-- jQuery-2.2.4 js -->
	<script src="js/jquery/jquery-2.2.4.min.js"></script>
	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="js/bootstrap/bootstrap.min.js"></script>
	<!-- All Plugins js -->
	<script src="js/plugins/plugins.js"></script>
	<!-- Active js -->
	<script src="js/active.js"></script>
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