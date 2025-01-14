<%@page import="com.thenurserysystem.bean.Offer"%>
<%@page import="com.thenurserysystem.bean.Product"%>
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
<title>Display All Product</title>

<!-- Favicon -->
<link rel="icon" href="img/core-img/favicon.ico">

<!-- Core Stylesheet -->

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
		
		$('#pic1').click(function(){
			
			var x=$(this).attr("src");
			$("#img1").attr("src",x);
			
			$("#img1").toggle("slow");
		});

	});
	
	
</script>
<script type="text/javascript">
	
	function getid(catid){
		
		var cid=catid;
		var strLink="DeleteProductServlet?id="+cid;
		document.getElementById("acceptid").setAttribute("href",strLink);
	}

	
</script>



<link rel="stylesheet" href="style.css">
</head>

<body>
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
	<jsp:include page="/DisplayOfferServlet"/>
	<%
		List<Product> productList = (List) request.getAttribute("ProductData");
		List<Category> cat=(List)request.getAttribute("CategoryList");
		List<Category> subcategory=(List)request.getAttribute("SubCategoryList");
		List<Offer> OfferList = (List) request.getAttribute("OfferData");
	%>

	<!-- Preloader -->

	

	<!-- ##### Breadcrumb Area Start ##### -->
	<div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(img/bg-img/24.jpg);">
           <h2>Product List</h2>
        </div>

        <div class="container"  style="margin-left: 12px;">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Product List</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
   
    
		<div style="margin-left: 100px;">
		<a href="InsertProduct.jsp" id="#btn"><button style="width:200px;" class="btn alazea-btn"><i class="fa fa-plus-circle" aria-hidden="true">Add Product</i></button></a>
	<button id="btnExport" class="btn alazea-btn w-30" style="margin-left: 900px;">Download List</button>
		</div>
		 
	<div style="padding: 50px 15px 10px 10px;">
	
		<table id="example" class="table table-striped table-bordered nowrap" style=" padding: 0px;">
			<thead>
				<tr>
					<th>Index</th>
					<th>Product Name</th>
					<th>Category</th>
					<th>SubCategory</th>
					<th>Image</th>
					<th>Price</th>
					<!-- <th>Maintenance</th> -->
					<th>Sunlight</th>
					<th>Watering</th>
					<th>Offer</th>
					<th>New Price</th>
					<th>Edit</th>
					<th>Change Status</th>
				</tr>
			</thead>
					<%int cnt=1; %>	
					
			<tbody>
				<%
					for (Product p : productList) {
				%>
				<tr>
					<td><%=cnt%><%cnt++; %></td>
					<td><%=p.getProduct_name() %></td>
					<td><%for(Category c: cat){%>
						
						<%if(c.getCat_id()==p.getCat_id())
						{%>
								<%=c.getCat_name() %>
						<%}}%></td>
					<td><%for(Category sc: subcategory){%>
						
						<%if(sc.getSubcat_id()==p.getSub_catid())
						{%>
								<%=sc.getCat_name() %>
						<%}}%></td>
					<td><img id="pic1" height="70px" width="70px" src="data:image/png;base64,<%=p.getProduct_imgstring() %>">	
					
					</td>
						
					<td><%=p.getPrice() %></td>
					<%-- <td><%=p.getMaintenance() %></td> --%>
					<td><%=p.getSunlight() %></td>
					<td><%=p.getWatering() %></td>
					<%for(Offer offer:OfferList){ %>
						<%if(p.getOffer_id()==offer.getOffer_id()){ %>
						<td><%=offer.getDiscount() %>%</td>
						<%} %>
					<%} %>
					<td><%=p.getAfterofferprice() %></td>
			<%-- 		<td><%=p.getStatus() %></td> --%>
					
					<td><a type="button" href="EditProductDetails?id=<%=p.getId()  %>"><i class="fa fa-edit" aria-hidden="true" style="color:green; cursor: pointer; font-size: 25px;"></i></a></td>
					<%if(p.getStatus()==true){ %>
			<td>	<a type="button" data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=p.getId() %>);"><button class="btn btn-success" style="width: 100px; height: 30px; background-color:#70c745;">InActive</button></a></td>
					<%}else{ int i=0;%>
					
					<%for(Category cat2 : subcategory){ %>
				<%if( cat2.getSubcat_id()==p.getSub_catid() && cat2.getStatus()!=0 && i==0)  { %>
			<td>	<a type="button" data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=p.getId() %>);"><button class="btn btn-success" style="width: 100px; height: 30px; background-color:#70c745;">Active</button></a></td>
							<%i++; %>		
			<%}else if(cat2.getSubcat_id()==p.getSub_catid()){ if(i==0){%>
			<td>	<a type="button" data-toggle="modal" data-target="#exampleModalCenter" onclick="getid(<%=p.getId() %>);"><button  disabled="disabled" class="btn btn-success" style="width: 100px; height: 30px; background-color:#ff0000;">Active</button></a></td>
							<%i++; %>
			<%}}}%>
			<%}%>		
		<div class="modal fade" id="exampleModalCenter" tabindex="-1" role="dialog" aria-labelledby="exampleModalCenterTitle" aria-hidden="true">
			<div class="modal-dialog modal-dialog-centered" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<h5 class="modal-title" id="exampleModalLongTitle">ARE YOU SURE YOU WANT TO CHANGE STATUS ??</h5>
						<button type="button" class="close" data-dismiss="modal"
							aria-label="Close">
							<span aria-hidden="true">&times;</span>
						</button>
					</div>
					<div class="modal-body">Change Status?</div>
					<div class="modal-footer">
						<button type="button" class="btn btn-secondary"
							data-dismiss="modal" style="color:white; height: 30px; width: 50px; font-size: 15px;">Close</button>
							
							
						<button   type="button" class="btn btn-primary">
						<a style=" color: white; " id="acceptid">Change</a>
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
					                    pdfMake.createPdf(docDefinition).download("ProductList.pdf");
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
	<%--<script src="js/jquery/jquery-2.2.4.min.js"></script> --%>
	<!-- Popper js -->
	<script src="js/bootstrap/popper.min.js"></script>
	<!-- Bootstrap js -->
	<script src="js/bootstrap/bootstrap.min.js"></script> 
	<!-- All Plugins js -->
	<script src="js/plugins/plugins.js"></script>
	<!-- Active js -->
	<script src="js/active.js"></script>
</body>

</html>