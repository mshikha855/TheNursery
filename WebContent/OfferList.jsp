<%@page import="java.util.List"%>
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
<title>Display All Offers</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">
<script src="js/jquery.min .js"></script>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
<script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
<link rel="stylesheet" type="text/css"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/1.10.22/css/dataTables.bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/fixedheader/3.1.7/css/fixedHeader.bootstrap.min.css" />
<link rel="stylesheet" type="text/css"
	href="https://cdn.datatables.net/responsive/2.2.6/css/responsive.bootstrap.min.css" />




<link rel="stylesheet" href="style.css">

<style type="text/css" class="init">
</style>

<script type="text/javascript" lang="javascript"
	src="https://code.jquery.com/jquery-3.5.1.js"></script>
	<script src="js/jquery/jquery-2.2.4.min.js"></script> 
 	<script src="js/plugins/plugins.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/1.10.22/js/jquery.dataTables.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/1.10.22/js/dataTables.bootstrap.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/fixedheader/3.1.7/js/dataTables.fixedHeader.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/responsive/2.2.6/js/dataTables.responsive.min.js"></script>
<script type="text/javascript" lang="javascript"
	src="https://cdn.datatables.net/responsive/2.2.6/js/responsive.bootstrap.min.js"></script>

<script type="text/javascript" class="init">
	$(document).ready(function() {
		var table = $('#example').DataTable({
			responsive : true
		});

	});
	
	
</script>
<script type="text/javascript">
	
	function getid(userid){
		
		var uid=userid;
		var strLink="DeleteOfferServlet?id="+uid;
		document.getElementById("acceptid").setAttribute("href",strLink);
	}

</script>

</head>

<body>

	<jsp:include page="/DisplayOfferServlet"/>
	<%
		List<Offer> OfferList = (List) request.getAttribute("OfferData");
	%>

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
			style="background-image: url(img/bg-img/24.jpg);">
			<h2>Offer Details</h2>
		</div>

		<div class="container">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home"></i> Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Offer
								Details</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	
	<div style="margin-left: 100px;">
		<a href="InsertOffer.jsp" id="#btn"><button style="width:200px; " class="btn alazea-btn"><i class="fa fa-plus-circle" aria-hidden="true">   Add Offer</i></button></a>
		</div>
	
	<div style="padding: 20px;">

		<table id="example" class="table table-striped table-bordered nowrap" style="width: 115%; padding: 10px;  margin-right: 150px;">
			<thead>
				<tr>
					<th>Offer id</th>
					<th>Offer Discount</th>
					<th>Offer Details</th>
					<th>Edit</th>
					<th>Delete</th>
				</tr>
			</thead>
						<%int  cnt=0; %>
			<tbody>
				<%
					for (Offer offer : OfferList) {
				%>
				<tr><%cnt=cnt+1; %>
					<td><%=cnt%></td>
					<td><%=offer.getDiscount()%>%</td>
					<td><%=offer.getDetails()%></td>
					
					<%-- <td class="action"><a href="DeleteUserDetails?id=<%=user.getUserid() %>"><i class="fa fa-trash" data-toggle="modal" data-target="#exampleModalCenter" aria-hidden="true"></i></a></td>--%>
					<%--<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">Launch demo modal</button></td>
                    <td><a href="DeleteUserDetails?id=<%=user.getUserid() %>"><button type="button" class="class="btn btn-primary"" id="btnDelete" data-toggle="modal" data-target="#exampleModalCenter"> Delete</button></a></td>--%>
					<td><a type="button" href="EditOfferServlet?id=<%= offer.getOffer_id() %>"><i class="fa fa-edit" aria-hidden="true" style="color:green; cursor: pointer; font-size: 25px;"></i></a></td>			
				<td><a type="button" data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=offer.getOffer_id() %>);"  ><i class="fa fa-trash" aria-hidden="true" style="color:red; cursor: pointer; font-size: 25px;"></i></a></td>
		
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">ARE YOU SURE YOU WANT TO DELETE??</h5>
						<button type="button" class="close" data-dismis	s="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Delete This Offer in All Products ?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" style="color:white; height: 30px; width: 50px; font-size: 15px;">Close</button>
							
							
						<button   type="button" class="btn btn-primary">
						<a style=" color: white; " id="acceptid">Delete</a>
						</button>
					</div>
				</div>
			</div>
		</div>
		<%--<td><button type="button" class="btn btn-primary" data-toggle="modal" data-target="#exampleModalCenter">DELETE</button></td> --%>
		<%--<td><button type="button" class="fa fa-trash" data-toggle="modal" data-target="#exampleModalCenter" aria-hidden="true" ></button></td> --%>
	 <%-- 	<td class="action"><i class="fa fa-trash" data-toggle="modal" data-target="#exampleModalCenter" aria-hidden="true" style="color:red;cursor: pointer; font-size: 25px;"></i></td> --%>
									
	</tr>
		<%}%>
			</tbody>
		</table>
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
	<%--<script src="js/jquery/jquery-2.2.4.min.js"></script>--%>
	<!-- Popper js -->
	<%-- <script src="js/bootstrap/popper.min.js"></script>--%>
	<!-- Bootstrap js -->
	<%--<script src="js/bootstrap/bootstrap.min.js"></script> --%>
	<!-- All Plugins js -->
	<%-- <script src="js/plugins/plugins.js"></script>--%>
	<!-- Active js -->
	<script src="js/active.js"></script>
</body>

</html>