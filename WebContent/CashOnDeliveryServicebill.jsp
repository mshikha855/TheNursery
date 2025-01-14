<%@page import="com.thenurserysystem.bean.Service"%>
<%@page import="com.thenurserysystem.bean.ServiceBooking"%>
<%@page import="com.thenurserysystem.bean.CartProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Service Book</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">
    <style type="text/css">
   
   .check
   {
	   margin:0px auto;
	   width:50px;
	   height:50px;
	   border-radius:100%;
	   background:#fff;
	   text-align:center;
   }
   
   .check i
   {
	   vertical-align:middle;
	   line-height:50px;
	   font-size:30px;
   }

    .content 
    {
        text-align:center;
    }

    .content  h1
    {
        font-size:25px;
        padding-top:25px;
    }

    .content a
    {
        width:200px;
        height:35px;
        color:#fff;
        border-radius:30px;
        padding:5px 10px;
        background:rgba(255,102,0,1);
        transition:all ease-in-out 0.3s;
    }

    .content a:hover
    {
        text-decoration:none;
        background:#000;
    }
    .animation-ctn{
  text-align:center;
  margin-top:10px;
}

	@-webkit-keyframes checkmark {
    0% {
        stroke-dashoffset: 100px
    }

    100% {
        stroke-dashoffset: 200px
    }
}

@-ms-keyframes checkmark {
    0% {
        stroke-dashoffset: 100px
    }

    100% {
        stroke-dashoffset: 200px
    }
}

@keyframes checkmark {
    0% {
        stroke-dashoffset: 100px
    }

    100% {
        stroke-dashoffset: 0px
    }
}

@-webkit-keyframes checkmark-circle {
    0% {
        stroke-dashoffset: 480px
   	
    }

    100% {
        stroke-dashoffset: 960px;
      
    }
}

@-ms-keyframes checkmark-circle {
    0% {
        stroke-dashoffset: 240px
    }

    100% {
        stroke-dashoffset: 480px
    }
}

@keyframes checkmark-circle {
    0% {
        stroke-dashoffset: 480px 
    }

    100% {
        stroke-dashoffset: 960px
    }
}

@keyframes colored-circle { 
    0% {
        opacity:0
    }

    100% {
        opacity:100
    }
}

/* other styles */
/* .svg svg {
    display: none
}
 */
.inlinesvg .svg svg {
    display: inline
}

/* .svg img {
    display: none
} */

.icon--order-success svg polyline {
    -webkit-animation: checkmark 0.25s ease-in-out 0.7s backwards;
    animation: checkmark 0.25s ease-in-out 0.7s backwards
}

.icon--order-success svg circle {
    -webkit-animation: checkmark-circle 0.6s ease-in-out backwards;
    animation: checkmark-circle 0.6s ease-in-out backwards;
}
.icon--order-success svg circle#colored {
    -webkit-animation: colored-circle 0.6s ease-in-out 0.7s backwards;
    animation: colored-circle 0.6s ease-in-out 0.7s backwards;
} 
.height {
    min-height: 200px;
}

.icon {
    font-size: 47px;
    color: #5CB85C;
}

.iconbig {
    font-size: 77px;
    color: #5CB85C;
}

.table > tbody > tr > .emptyrow {
    border-top: none;
}

.table > thead > tr > .emptyrow {
    border-bottom: none;
}

.table > tbody > tr > .highrow {
    border-top: 3px solid;
}
.panel-default>.panel-heading {
    color: #333;
    background-color: #f5f5f5;
    border-color: #ddd;
}
.panel-heading {
    padding: 10px 15px;
    border-bottom: 1px solid transparent;
    border-top-left-radius: 3px;
    border-top-right-radius: 3px;
}
.panel {
    margin-bottom: 20px;
    background-color: #fff;
    border: 1px solid transparent;
    border-radius: 4px;
    -webkit-box-shadow: 0 1px 1px rgb(0 0 0 / 5%);
    box-shadow: 0 1px 1px rgb(0 0 0 / 5%);
}
.panel-default {
    border-color: #ddd;
}
</style>
</head>

<body>
    <!-- Preloader -->
   
	<jsp:include page="/DisplayServiceDetails"/>
	<jsp:include page="/SelectUserDetails"/>
	<%
		List<Service> serviceList = (List) request.getAttribute("ServiceData");
		List<User> UserList = (List) request.getAttribute("UserData");
	%>
	
	
	<%
		ServiceBooking sb=(ServiceBooking)request.getAttribute("CashService");
	%>
    <!-- ##### Header Area Start ##### -->
    		 <%@include file="Header.jsp" %> 
        <!-- ##### Header Area End ##### -->

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area" style="background-color: white;">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center " style="background-image: url(img/bg-img/24.jpg);">
          
        </div>

        <div class="container" style="margin-left: 12px;">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Index.jsp"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Service Booking</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        </div>
        <%if(u.getRole().equalsIgnoreCase("User")) {%>
        <div class="animation-ctn">
		<div class="icon icon--order-success svg" ">
			<svg xmlns="http://www.w3.org/2000/svg" width="154px" height="154px">
			<g fill="none" stroke="#22AE73" stroke-width="2"> <circle cx="77"
				cy="77" r="72"
				style="stroke-dasharray:480px, 480px; stroke-dashoffset: 960px;"></circle>
			<circle id="colored" fill="#22AE73" cx="77" cy="77" r="72"
				style="stroke-dasharray:480px, 480px; stroke-dashoffset: 960px;"></circle>
			<polyline class="st0" stroke="#fff" stroke-width="10"
				points="43.5,77.8 63.7,97.9 112.2,49.4 "
				style="stroke-dasharray:100px, 100px; stroke-dashoffset: 200px;" />
			</g> </svg>

			<div class="content">
				<h1>Service Booked !</h1>
				<p>Thanks for Service Booking... Please check your email</p>
				
			</div>
		</div>
	</div>
	<%} %>
	
		
        
	<div class="row" style="width:100%; padding:50px;" >
	
	<div class="col-md-9">
	

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="text-center"><strong>Book Details summary</strong></h3>
                    
                     
                   <h5 align="center">Service Id :<%=sb.getBookingid() %> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Booking Date :<%=sb.getDate() %></h5>
                
              
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed" id="tblCustomers" style="padding: 50px; margin-right: 100px;">
                            <thead>
                                <tr>
                                	
                                    <td><strong>Service</strong></td>
                                    
                                    <td class="text-center"><strong>Service Price</strong></td>
                                    <td class="text-center"></td> 
                                    <td class="text-center"><strong>Service Total</strong></td>
                                   
                                </tr>
                            </thead>
                            <tbody>	
                                <tr>
                                  	
                                   	<%for(Service s:serviceList) {%>
                                   	
                                   	<%if(s.getServiceId()==sb.getServiceid()){ %>
											
										
                                  		<td class="text-left"><img height="50px" width="50px" src="data:image/png;base64,<%=s.getServiceImageString() %>" alt="Product">&nbsp&nbsp&nbsp&nbsp&nbsp<%=s.getServiceDetails() %></td>
                                   	
                                   	
                                   	<%}}%>
                                   
                                    <td class="text-center"><%=sb.getAmount() %></td>
                          			<td class="text-center"></td>         
                                   <td class="text-center"><%=sb.getAmount() %>  </td>
                                   
                                </tr>
                                
                                <tr>
                                    <td class="highrow"></td>
                                    <td class="highrow"></td>
                                    <td class="highrow text-center"><strong>Sub Total</strong></td>
                                    <td class="highrow text-center"><%=sb.getAmount() %></td>
                                </tr>
                                <!-- <tr>
                                    <td class="emptyrow"></td>
                                    <td class="emptyrow"></td>
                                    <td class="emptyrow text-center"><strong>Shipping</strong></td>
                                    <td class="emptyrow text-right">$20</td>
                                </tr> -->
                                <tr>
                                    <td class="emptyrow"><i class="fa fa-barcode iconbig"></i></td>
                                    <td class="emptyrow"></td>
                                    <td class="emptyrow text-center"><strong>Final Total</strong></td>
                                    <td class="emptyrow text-center"><%=sb.getAmount() %></td>
                                </tr>
                                <tr>
                                    <td class=""></td>
                                    <td class=""></td>
                                    <td class="text-center"><strong >Payment Mode</strong></td>
                                	<%if(sb.getPaymentstatus()==0) {%>    
                                    <td class=text-center">Cash On Delivery</td>
                                	<%}else{ %>
                                	
                                	
                                	<td class="text-center" style="padding:10px;"><img height="20px" width="60px;" src="img/bg-img/Paytm.png"></td>
                                	<%} %>
                                </tr>
                            </tbody>
                            
                        </table>
    
                    </div>
                    
                   
                </div>
                
            </div>
       
       
			 </div>	
				
         		<div class="col-md-3">
                    <div class="panel panel-default height">
                        <div class="panel-heading">
                    			<h3 class="text-center"><strong>Service Address</strong></h3>
                   				<h5 align="center">We will Good Service very soon</h5>
               			 </div>
               			
                            	<%-- <%if(orderid[1].equalsIgnoreCase(o1.getOrderid())){ %> --%>
                        <div class="panel-body" style="padding:20px;">
                             <%-- <strong><%=u.getFname() %></strong><br> --%>

                             <% for(User u1 : UserList){
                             if(u1.getUserid()==sb.getUserid()){%>
                            <Strong>Name : </Strong><%=u1.getFname() %><%=u1.getLname() %><br><br>
                            <%} }%>
                            <Strong>Address : </Strong><%=sb.getServiceaddress() %><br><br>
                            <Strong>Area Name : </Strong><%=sb.getServicearea() %><br>
                            <br>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            
             
             <%if(u.getRole().equalsIgnoreCase("User")) {%>
            <div class="checkout-btn " style="padding:0px 800px 0px 600px ; ">
					<a href="Index.jsp" style="background-color: transparent;"><button
							class="btn alazea-btn w-100" >Go to Home</button></a>
				</div>
				<%}else if(u.getRole().equalsIgnoreCase("Admin")){ %>

				<div class="checkout-btn " style="padding:0px 800px 0px 600px ; ">
					<a href="BookedServiceList.jsp" style="background-color: transparent;"><button
							class="btn alazea-btn w-100" >Back</button></a>
				</div>
				<%}else{ %>
				
				<div class="checkout-btn " style="padding:0px 800px 0px 600px ; ">
					<a href="ServiceListofGardener.jsp" style="background-color: transparent;"><button
							class="btn alazea-btn w-100" >Back</button></a>
				</div>
				<%} %>
  	
            
             
    <!-- ##### Testimonial Area Start ##### -->
    
    <!-- ##### Footer Area Start ##### -->
    		<%@include file="Footer.jsp" %>
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
</body>

</html>