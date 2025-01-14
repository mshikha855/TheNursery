<%@page import="com.thenurserysystem.bean.Category"%>
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

<title>Insert Gallery</title>


<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">
<link rel="dns-prefetch" href="//cdnjs.cloudflare.com">

<link rel="stylesheet" href="css/style1.css" />

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js/jquery.min .js"></script>
<script>


$(document).ready(function(){
	
	$("#id-cat").change(function(){
		
		var a=$("#id-cat").val();
		
		$.ajax({
			  method: "Post",
			  url: "FetchSubcategoryServlet",
			  data: { name: a }
			})
			  .done(function( msg ) {
			    	
				 
				  $("#sub").children().remove();
				  var obj=jQuery.parseJSON(msg);
				  $('#sub').append($("<option></option>").attr("value", '-1').text('Please Select Subcategory'));
				 
				  $.each(obj,function(key,value){
					  
					
					$("#sub").append('<option value='+value.subcat_id+'>'+value.cat_name+'</option>');  
				  });
				  
			  });
	});
	
	$("#sub").change(function(){
		
		var a=$("#sub").val();
		
		$.ajax({
			  method: "Post",
			  url: "FetchProductServlet",
			  data: { name: a }
			})
			  .done(function( msg ) {
			    
				  $("#pro").children().remove();
				  var obj=jQuery.parseJSON(msg);
				 
				  $.each(obj,function(key,value){		
					
					$("#pro").append('<option value='+value.id+'>'+value.product_name+'</option>');  
				  });
				
				  
			  });
	});
});

</script>
</head>

<body>

	 <jsp:include page="/DisplayCategoryServlet"/> 
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
							<li class="breadcrumb-item active" aria-current="page">Insert Gallery</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>

	<%
		List<Category> categoeyList = (List) request.getAttribute("CategoryData");
	%>

	<div class="container">

		<div class="back"
			style="background-color: white; margin-top: auto; width: 650px; padding: auto; border-radius: 70px; margin-left: 200px;">

			<form class="form validity" action="InsertGalleryDetails" method="post"  enctype="multipart/form-data">
				
				<h1 style="font-weight: bold; font-size: 30px; text-align: center; margin-bottom: 30px;">Insert Gallery</h1>
				<div class="form-inline">
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">Category</label> 
						
						
						<select required   id="id-cat" class="form-control" name="category"  style="width:280px;">
								<option value="" disabled selected hidden">Select Category</option>
					<% for (Category cat : categoeyList) {%>
							<option value="<%=cat.getCat_id() %>" ><%=cat.getCat_name() %></option>
					<%}%>
						</select>
						
					</div>
					
				</div>
				<%--<input type="text" id="abc" name="xyz"> --%>
				
				<div class="form-group" >

					<div class="col-12 mb-4">
						
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">SubCategory</label> 
						 
						
						<select required class="form-control" id="sub" name="subcategory" style="width:280px;">
								
						</select>
						
					</div>
				</div> 
				</div>
				<div class="form-group" >

					<div class="col-12 mb-4">
						
						
						<label  style="font-size: 20px; margin-right: 200px; padding: 2px;">Product</label> 
						 
						
						<select required class="form-control" id="pro" name="product" style="width:480px;">
					
			
						</select>
						
					</div>
				</div> 
				
				<div class="form-group">

					<div class="col-12 mb-4">
						
						<label  style="font-size: 20px; margin-right: 100px; padding: 2px;">Image</label> 
						
						<input id="name2" name="Gallery_image"  data-missing="This field is required" type="file" required style="width: 285px; background-color: white"  >
						
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
					<button class="btn alazea-btn" style="margin-left: 300px;">Insert Gallery</button>
					<a href="GalleryList.jsp" type="button" class="btn alazea-btn" style="margin-left: 20px;">Back</a>
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


	
</body>

</html>