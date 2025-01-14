<%@page import="java.util.List"%>
<%@page import="com.thenurserysystem.bean.OrderDetails"%>
<%@page import="com.thenurserysystem.bean.Product"%>
<%@page import="com.thenurserysystem.bean.User"%>
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
<title>Display All Order</title>

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

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.8.3/jquery.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/pdfmake/0.1.22/pdfmake.min.js"></script>
<script type="text/javascript" src="https://cdnjs.cloudflare.com/ajax/libs/html2canvas/0.4.1/html2canvas.min.js"></script>

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
	
	/* function getid(userid){
		var uid=userid;
		var strLink="DeleteUserDetails?id="+uid;
		document.getElementById("acceptid").setAttribute("href",strLink);
	} */

	function getorderid(orderid){
		var oid=orderid;
		var link="UpdateOrderServlet?id="+oid;
		document.getElementById("accept").setAttribute("href",link);
	}
</script>

</head>

<body>
<jsp:include page="/SelectUserDetails"/>
	<%
		List<User> UserList = (List) request.getAttribute("UserData");
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
	<jsp:include page="/DisplayProductServlet"/>
	<jsp:include page="/DisplayOrderDetails"/>
	<jsp:include page="/DisplayOrderServlet"/>
	<jsp:include page="/SelectUserDetails"/>
	<%
		List<Product> productList = (List) request.getAttribute("ProductData");
		List<Category> cat=(List)request.getAttribute("CategoryList");
		List<Category> subcategory=(List)request.getAttribute("SubCategoryList");
		List<OrderDetails> orderList=(List)request.getAttribute("OrderList");
		List<OrderDetails> orderDetailsList=(List) request.getAttribute("OrderDetailsList");
	%>
	<!-- ##### Breadcrumb Area Start ##### -->
	<div class="breadcrumb-area">
		<!-- Top Breadcrumb Area -->
		<div
			class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center "
			style="background-image: url(img/bg-img/24.jpg);">
			<h2>Order List</h2>
		</div>

		<div class="container" style="margin-left: 12px;">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="#"><i
									class="fa fa-home"></i> Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Order
								Details</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<button id="btnExport" class="btn alazea-btn w-30" style="margin-left: 1200px;">Download List</button>
	<div style="padding: 50px;">

		<table id="example" class="table table-striped table-bordered nowrap" style="width: 100px; padding: 10px;">
			<thead>
				<tr>
					<th>Index</th>
					<th>Order Id</th>
					<th>User Name</th>
					<th>Order Date</th>
					<th>Order Status</th>
					<th>Total Amount</th>
					<th>Payment Status</th>
					<th>Delivery Address</th>
					<th>Delivery Area</th>		
					<th>Bill</th>
					
				</tr>
			</thead>
						<%int cnt=0; %>	
					
			<tbody>
				<%
					for (OrderDetails o : orderList) {
					cnt++;
				%>
				<tr>
					<td><%=cnt %></td>
					<td><%=o.getOrderid() %></td>
					<%for(User uu:UserList){ %>
					<%if(o.getUid()==uu.getUserid()){ %>
						<td><%=uu.getFname() %><%=uu.getLname() %></td>
					<%} %>
					<%} %>
					<td><%=o.getOrderdate() %></td>
					
					<%if(o.getDeliverStatus().equals("Not Deliver")) {%>
						<td><a type="button" data-toggle="modal" data-target="#exampleModal" onclick="getorderid('<%=o.getOrderid()%>');"><button class="btn btn-success" style="width: 100px; height: 30px; background-color:#70c745;">Change</button></td>
					<%}else{ %>
						<td>Delivered</td>
					<%} %>
					<td><%=o.getTotalamount() %></td>
					
					<%if(o.getPaymentstatus()==0){ %>
						<td>Cash On Delivery</td>
					<%}else{ %>
						<td>Paytm</td>
					<%} %>
					<td><%=o.getDeliveryaddress() %></td>
					<td><%=o.getDeliveryareaname() %></td>
					<td><a href="FetchOrderDetailsServlet?id=<%=o.getOrderid() %>" style="color: blue;">View</a></td>
					
			<div class="modal fade" id="exampleModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Change Order Status?</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Make it Deliver?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" style="color:white; height: 30px; width: 50px; font-size: 15px;">Close</button>
							
							
						<button   type="button" class="btn btn-primary">
						<a style=" color: white;" id="accept">Change</a>
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
		
		<script type="text/javascript">
					        $("body").on("click", "#btnExport", function () {
					            html2canvas($('#example')[0], {
					                onrendered: function (canvas) {
					                    var data = canvas.toDataURL();
					                    var docDefinition = {
					                        content: [{
					                            image: data,
					                            width: 500
					                        }]
					                    };
					                    pdfMake.createPdf(docDefinition).download("OrderList.pdf");
					                }
					            });
					        });
					    </script>
		
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