<%@page import="com.thenurserysystem.bean.PasswordConvert"%>
<%@page import="java.util.List"%>
<%@page import="com.thenurserysystem.bean.Area"%>
<%@page import="com.thenurserysystem.bean.Offer"%>
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

<title>Insert Service</title>


<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet" href="css/style1.css" />

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js/jquery.min.js"></script>
<script>
function Filevalidation () {
    const fi = document.getElementById('file');
    // Check if any file is selected.
    if (fi.files.length > 0) {
        for (const i = 0; i <= fi.files.length - 1; i++) {

            const fsize = fi.files.item(i).size;
            const file = Math.round((fsize / 1024));
            
            if (file >= 2048) {
                
                document.getElementById('size').innerHTML = '<b>File Must be less than 2MB </b> ';
            }
        }
    }
}
</script>
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
							<li class="breadcrumb-item active" aria-current="page">Insert Product</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<%
		
	%>

	<div class="container">

		<div class="back"
			style="background-color: white; margin-top: auto; width: 650px; padding: auto; border-radius: 70px; margin-left: 200px;">

			<form class="form validity" action="InsertServiceServlet" method="post"  enctype="multipart/form-data">
				
				<div>
					<%
						String s = (String) request.getAttribute("message");
					if (null != s) {
					%>
					<h4 style="font-weight: bold; font-size: 20px; color: green; font-color: green; text-align: center"><%=s%></h4>
					
				<% } %>			
				</div>
				
				
				<h1 style="font-weight: bold; font-size: 30px; text-align: center; margin-bottom: 30px;">Insert New Service</h1>
					
				
			
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 100px; padding: 2px;">Service Details</label> 
						
						<input id="name2" name="Service_details" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" required style="width: 360px;">
				
					</div>
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">

						<label   style="font-size: 20px; margin-right: 200px; padding: 2px;">Descripiton</label> 
						
						<textarea rows="" cols="" id="name2" name="service_desc" class="form-control input-group-lg reg_name"	data-missing="This field is required"  required style="width: 360px;"></textarea>
						
						
					</div>
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px;  padding: 2px;">Service Amount</label> 
						
						<input id="name2" name="Service_amount" class="form-control input-group-lg reg_name" data-missing="This field is required" type="number" required style="width: 360px;">
				
					</div>
					
				</div>
		

				
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 100px; padding: 2px;">Image</label> 
						
						<input id="file" name="Service_image"  data-missing="This field is required" type="file" onchange="Filevalidation()" required style="width: 285px; background-color: white"  >
					
					</div>
					<span id="size" style="margin-right: 10px; color: red; font-weight: bold;"> </span>		
				
				</div>
				
				</div> 
				<div class="checkout-btn mt-30">
					<button class="btn alazea-btn" style="margin-left: 300px;">Insert Service</button>
					<a href="OfferList.jsp" type="button" class="btn alazea-btn" style="margin-left: 20px;">Back</a>
				</div>

			</form>
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
		function MyFun(){

	
			}
	</script>
</body>

</html>