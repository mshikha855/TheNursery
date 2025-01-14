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

<title>Profile Page</title>


<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet" href="css/style1.css" />

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js/jquery.min .js"></script>
</head>

<body>
	<%-- <%
		HttpSession httpsession = request.getSession(false);
	User user = null;
	if (null != httpsession) {
		user = (User) httpsession.getAttribute("loginDetails");
	}
	%> --%>
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
							<li class="breadcrumb-item active" aria-current="page">Profile
								Page</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>


	<div class="container">

		<div class="back"
			style="background-color: white; margin-top: auto; width: 650px; padding: auto; border-radius: 70px; margin-left: 200px;">

			<form class="form validity" action="updateUserDetailsServlet" method="post">
				<input type="hidden" name="userid" value="<%=u.getUserid()%>">
				<h1 style="font-weight: bold; font-size: 30px; text-align: center; margin-bottom: 30px;">Edit Profile</h1>
				
				<div class="form-inline">
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">First Name</label> 
						
						<input id="name2" name="fname" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" value="<%=u.getFname()%>" required style="width: 270px;">
				
					</div>
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">

						<label   style="font-size: 20px; margin-right: 200px; padding: 2px;">Last Name</label> 
						
						<input id="name2" name="lname" class="form-control input-group-lg reg_name"	data-missing="This field is required" value="<%=u.getLname()%>" type="text" required style="width: 270px;">
					</div>
				</div>
				</div>

				<div class="form-group">

					<div class="col-12 mb-4">
						<label for="company" style="font-size: 20px;">Residental
							Address</label>
						<!--         <input id="name2" name="name" class="form-control" data-missing="This field is required" type="text" required> -->
						<textarea rows="2" cols="40" class="form-control" name="address"
							id="name2" data-missing="This field is required" required
							style="width: 600px;"><%=u.getAddress()%></textarea>
					</div>
				</div>

		  		<div class="form-group">
					<div class="col-12 mb-4">
						<label for="company" style="font-size: 20px;">Email Id</label> <input
							id="mail" name="email" class="form-control"
							value="<%=u.getEmail()%>"
							data-mismatch="Please include a valid email" type="email"
							required style="width: 600px;" readonly="readonly">
					</div>
				</div> 
	
				<div class="form-inline">
				
				<div class="form-group simple">
					<div class="col-12 mb-4">
						<label for="company" style="font-size: 20px; margin-right: 200px; padding: 2px;">Contact No</label> <input
							id="phone2" name="phoneno" class="form-control"
							pattern="[6789][0-9]{9}" value="<%=u.getContactno()%>"
							data-mismatch="Enter 10 digit only" type="tel" required
							style="width: 270px;">
					</div>
				</div>

				<div class="form-group">

					<div class="col-12 mb-4">
						<label for="company" style="font-size: 20px; margin-right: 230px; padding: 2px;">Area</label>
						<%
							List<Area> area = (List) request.getAttribute("areadetails");
						%>
						<select required class="form-control" name="area" style="width:270px;">

							<option value="<%=u.getPincode()%>"><%=u.getAreaname()%></option>
							<%
								for (int i = 0; i < area.size(); i++) {
							%>
							<%
								Area a = area.get(i);
							%>
							<option value="<%=a.getPincode()%>">
								<%=a.getAreaname()%>
							</option>
							<%
								}
							%>

						</select>
					</div>
					
				</div>
				</div>
				
				<div class="form-inline">
					
					<div class="form-group">
					
					<div class="col-12 mb-4">
						<label for="company" style="font-size: 20px; margin-right: 280px; padding: 2px;">Password</label>
						<!--        <input id="phone2" name="phone" class="form-control" pattern="\d{3}[\-]\d{3}[\-]\d{4}" data-mismatch="Please match the requested format" type="tel" required> -->
						<input type="password" class="form-control" name="password"
							<%PasswordConvert pc = new PasswordConvert();

							String password = pc.decrypt(u.getPassword());%>
						
							value="<%=password%>" id="myInput"
							data-mismatch="Password Contail atleast 1 special character and 1 digit and Uppercase also"
							pattern="(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}" required
							style="width: 350px;" readonly="readonly"> 
					</div>
					</div>
					<input type="hidden" name="role" value="<%=u.getRole()%>">
					
					<i class="fa fa-key" aria-hidden="true" style="font-size: 20px;  margin-left: 40px; color:blue; ">
							<a href="ExistingPassword.jsp" style="font-size: 20px; color:blue;">Change Password</a>
					</i>
					</div>
					<!-- An element to toggle between password visibility -->
					
						<%--<div class="col-12 mb-4" style="font-size: 20px;">

						<input type="checkbox" onclick="myFunction()"
							style="height: 20px;"> Show Password
					</div> --%>
				

				<div>
					<%
						String s = (String) request.getAttribute("message");
					if (null != s) {
					%>
					<h4
						style="font-weight: bold; font-size: 20px; color: green; font-color: green; text-align: center"><%=s%></h4>
					<%
						}
					%>
				</div>

				<div class="checkout-btn mt-30">
					<button class="btn alazea-btn w-100" style="width: 20px;">Save Changes</button>
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