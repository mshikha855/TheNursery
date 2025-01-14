<%@page import="com.thenurserysystem.bean.Offer"%>
<%@page import="com.thenurserysystem.bean.Product"%>
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

<title>Update Product</title>


<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet" href="css/style1.css" />

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js/jquery.min .js"></script>
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


	 <jsp:include page="/CategoryandSubcategoryDisplay"/>
	 
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
							<li class="breadcrumb-item active" aria-current="page">Update Product</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<%
		List<Category> categoeyList = (List) request.getAttribute("CategoryList");
		List<Category> subcategoeyList = (List) request.getAttribute("SubCategoryList");
		List<Offer> offerlist=(List)request.getAttribute("OfferList");
		Product p1=(Product)request.getAttribute("productdetail");
	%>

	<div class="container">

		<div class="back"
			style="background-color: white; margin-top: auto; width: 650px; padding: auto; border-radius: 70px; margin-left: 200px;">

			<form class="form validity" action="UpdateProductServlet" method="post"  enctype="multipart/form-data" >
				
				<h1 style="font-weight: bold; font-size: 30px; text-align: center; margin-bottom: 30px;">Update Product</h1>
					
					<input type="hidden" name="productid" value=<%=p1.getId() %>>
				<div class="form-inline">
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">Category</label> 
						
						
						<select required   id="id" class="form-control" name="category"  style="width:280px;">
								
					<% for (Category cat : categoeyList) {%>
					
						<%if(cat.getCat_id()==p1.getCat_id()){ %>
						
						<option value="<%=p1.getCat_id()%>"><%=cat.getCat_name()%></option>
						
					<%} %>
							<option value="<%=cat.getCat_id() %>" ><%=cat.getCat_name() %></option>
					<%}%>
						</select>
						
					</div>
					
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">SubCategory</label> 
						 
						
						<select required class="form-control" name="subcategory" style="width:280px;">
						<% for (Category s : subcategoeyList) { %>
							
						<%if(s.getCat_id()==p1.getCat_id()) {%>
						
						<%if(s.getSubcat_id()==p1.getSub_catid()){ %>
						
						<option value="<%=s.getSubcat_id() %>"><%=s.getCat_name() %></option>
						
						<%}}} %>		
						<% for (Category s : subcategoeyList) { %>
						<%if(s.getCat_id()==p1.getCat_id()) {%>	
						<%if(s.getSubcat_id()!=p1.getSub_catid()){ %>	
						<option value="<%=s.getSubcat_id() %>"><%=s.getCat_name() %></option>
						
						<%}}}%>
						</select>
						
					</div>
					
				</div>
				
				
				</div>
				
				
				<div class="form-inline">
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 270px; padding: 2px;">Product Name</label> 
						
						<input id="name2" name="product_name" value="<%=p1.getProduct_name() %>" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" required style="width: 360px;">
				
					</div>
				</div>
				
				<div class="form-group" style="width:20px;">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-left:20px; padding: 2px;">Price</label> 
						
						<input id="name2" name="product_price" value="<%=p1.getPrice() %>" class="form-control input-group-lg reg_name" data-missing="This field is required" type="number" required style="width: 150px;">
				
					</div>
					
				</div>
				</div>

				<div class="form-inline">
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 170px; padding: 2px;  width: 100px;">Maintenance</label> 
						
						<input id="name2" name="product_main"  value="<%=p1.getMaintenance() %>" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" required style="width: 280px;">
				
					</div>
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 210px; padding: 2px;">Sunlight</label> 
						
						<input id="name2" name="product_sunlight" value="<%=p1.getSunlight() %>" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" required style="width: 280px;">
				
					</div>
					
				</div>
				</div>
				
				<div class="form-inline">
				
				<div class="form-group">

					<div class="col-12 mb-4">

						<label   style="font-size: 20px; margin-right: 200px; padding: 2px;">Watering</label> 
						
						<input id="name2" name="product_watering" value="<%=p1.Watering %>" class="form-control input-group-lg reg_name"	data-missing="This field is required"  type="text" required style="width: 280px;">
					
					</div>
				</div>
				
				<div class="form-group">

					<div class="col-12 mb-4">

						<label   style="font-size: 20px; margin-right: 200px; padding: 2px;">Offer(%)</label> 
						<select required class="form-control" name="product_offer"  style="width:280px; ">
							
						<%if(p1.getOffer_id()!=0){ %>	
						<% for (Offer o : offerlist) {%>
						
							<%if(o.getOffer_id()==p1.getOffer_id()) {%>
							
							<option value="<%=o.getOffer_id() %>" selected="selected" style="display: none;"><%=o.getDetails()%>/<%=o.getDiscount() %></option>
							
							<%} else{ %>
						
							<option value="<%=o.getOffer_id() %>" ><%=o.getDetails()%>/<%=o.getDiscount() %></option>
							
								<%} %>
						
						<%}%>
						<%}else{ %>
						<option value="" disabled selected hidden">Select Area</option>
						<% for (Offer o : offerlist) {%>
						<option value="<%=o.getOffer_id() %>" ><%=o.getDetails()%>/<%=o.getDiscount() %></option>
						<%}} %>
						</select>
				
					</div>
				</div>
				</div>
				
				
				<div class="form-inline">
				
				
				<div class="form-group">

					<div class="col-12 mb-4">

						<label   style="font-size: 20px; margin-right: 200px; padding: 2px;">Descripiton</label> 
						
						<textarea rows="" cols="" id="name2" name="product_desc" class="form-control input-group-lg reg_name"	data-missing="This field is required"  required style="width: 270px;"><%=p1.getDesc() %></textarea>
						
						
					</div>
				</div>
				
	 			<div class="form-group">

					<div class="col-12 mb-4">
						<td><img height="150px" width="150px" src="data:image/png;base64,<%=p1.getProduct_imgstring() %>"></td>
				
						<label  style="font-size: 20px; margin-right: 240px; padding: 2px;">Image</label> 
						
						<input id="file" name="product_image" type="file" value="<%=p1.getProduct_imgstring() %>" onchange="Filevalidation()" style="width: 285px; background-color: white"  >
						
					</div>
					<span id="size" style="margin-right: 10px; color: red; font-weight: bold;"> </span>		
					
				</div> 
				
				</div>
				
				

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
					<button class="btn alazea-btn w-100" style="width: 20px;"> Update Product</button>
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
		
	</script>
</body>

</html>