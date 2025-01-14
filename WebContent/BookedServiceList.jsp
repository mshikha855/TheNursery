<%@page import="com.thenurserysystem.bean.Service"%>
<%@page import="com.thenurserysystem.bean.ServiceBooking"%>
<%@page import="java.util.List"%>
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
<title>Display All Booked Services</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Stylesheet -->
<link rel="stylesheet" href="style.css">

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
	

<script type="text/javascript"></script>
<script>
$(document).ready(function() {
	var table = $('#example').DataTable({
		responsive : true
	}); 
	
	 $(".gardenerid").change(function(){
		/*document.getElementById("garid").setAttribute("data-toggle","modal");
		 document.getElementById("garid").setAttribute("data-target","dhruv");
		  */
		 	$('#dhruv').modal('show');
		
		}); 
});

function getuserid(userid,serviceid,bookingid){
	
	var uid=userid;
	var strLink="AssignGardenerServlet?gardenerid="+userid+"&serviceid="+serviceid+"&bookingid="+bookingid;
	document.getElementById("acceptid").setAttribute("href",strLink);
} 

</script>
</head>

<body>
<jsp:include page="/SelectBookedServiceDetails"/>
<jsp:include page="/SelectUserDetails"/>
<jsp:include page="/DisplayServiceDetails"/>
<jsp:include page="/DisplayGardenerServlet"/>
	
	<%
	List<ServiceBooking> serviceList = (List) request.getAttribute("BookedServiceList");
	List<User> UserList = (List) request.getAttribute("UserData");
	List<Service> serlist = (List) request.getAttribute("ServiceData");
	List<User> GardenerList=(List)request.getAttribute("GardenerData");
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
			<h2>Booked Service Details</h2>
		</div>

		<div class="container" style="margin-left: 12px;">
			<div class="row">
				<div class="col-12">
					<nav aria-label="breadcrumb">
						<ol class="breadcrumb">
							<li class="breadcrumb-item"><a href="Index.jsp"><i
									class="fa fa-home"></i> Home</a></li>
							<li class="breadcrumb-item active" aria-current="page">Booked Service
								Details</li>
						</ol>
					</nav>
				</div>
			</div>
		</div>
	</div>
	<button id="btnExport" class="btn alazea-btn w-30" style="margin-left: 1200px;">Download List</button>
	<div style="padding: 20px;">

		<table id="example" class="table table-striped table-bordered nowrap" style="width: 100%; padding: 5px;">
			<thead>
				<tr>
					<th>Index</th>
					<th>Service Id</th>
					<th>Service Name</th>
					<th>User Name</th>
					<th>Booking Date</th>
					<th>Service Status</th>
					<th>Total Amount</th>
					<th>Payment Status</th>
					<th>Gardener</th>		
					<th>Bill</th>
					
				</tr>
			</thead>
						<%int cnt=0; %>	
					
			<tbody>
				<%
					for (ServiceBooking s : serviceList) {
					cnt++;	
				%>
				<tr>
					<td><%=cnt %></td>
					<td><%=s.getBookingid() %></td>
					<%for(Service s1:serlist){ %>
						<%if(s.getServiceid()==s1.getServiceId()) {%>						
						<td><%=s1.getServiceDetails()%></td>
					
					<%}} %>
					<%for(User uu:UserList){ %>
					<%if(s.getUserid()==uu.getUserid()){ %>
						<td><%=uu.getFname() %><%=uu.getLname() %></td>
					<%} %>
					<%} %>
					<td><%=s.getDate() %></td>
					
					<%if(s.getBookingstatus()==0) {%>
						<td>Service Remaining</td>
					<%}else{ %>
						<td>Service Complete</td>
					<%} %>
					<td><%=s.getAmount() %></td>
					
					<%if(s.getPaymentstatus()==0){ %>
						<td>Cash On Delivery</td>
					<%}else{ %>
						<td>Paytm</td>
					<%} %>
					
					<%int garid; %>
					<td>
					<%if(s.getGardenerid()==0) {%> 
					<div class="dropdown">
  						<button class="btn btn-default dropdown-toggle" type="button" id="dropdownMenu1" data-toggle="dropdown" aria-haspopup="true" aria-expanded="true" style="font-size: 15px; background-color: #70c745; color:white;">Assign Gardener</button>
  						<ul class="dropdown-menu" aria-labelledby="dropdownMenu1">
    						<%for(User g1:GardenerList){ %>
    							<li><a href="#" data-toggle="modal" data-target="#dhruv" onclick="getuserid(<%=g1.getUserid()%>,<%=s.getServiceid() %>,'<%=s.getBookingid() %>');" style="font-size: 15px;"><%=g1.getFname() %><%=g1.getLname() %></a></li>
    						<%} %>
  						</ul>
					</div>
	
					<%}else{ %>
 							<%for(User gardener:GardenerList){ %>
 							<%if(s.getGardenerid()==gardener.getUserid()) {%>
 								<%=gardener.getFname() %><%=gardener.getLname() %>
 							<%} }%>
 							
 					<%} %>
					</td>
					<td><a href="ServiceCODServlet?ORDER_ID=<%=s.getBookingid() %>" style="color: blue;">View</a></td>
					
			 <div class="modal fade" id="dhruv" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">Assign Gardener</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Are you sure want to assign?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" style="color:white; height: 30px; width: 40px; font-size: 15px;">No</button>
							
							
						<button   type="button" class="btn btn-primary">
						<a style="color:white; height: 30px; width: 50px; font-size: 15px;" id="acceptid" >Yes</a>
						</button>
					</div>
				</div>
			</div>
		</div>  
			
		
							
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
					                    pdfMake.createPdf(docDefinition).download("BookedServiceList.pdf");
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