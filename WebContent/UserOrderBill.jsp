<%@page import="com.thenurserysystem.bean.CartProduct"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.thenurserysystem.bean.Product"%>
<%@page import="com.thenurserysystem.bean.User"%>
<%@page import="com.thenurserysystem.service.impl.OrderServiceImpl"%>
<%@page import="com.thenurserysystem.service.OrderService"%>
<%@page import="com.thenurserysystem.bean.OrderDetails"%>
<%@page import="com.thenurserysystem.bean.Area"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>User Bill</title>

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
   
	<jsp:include page="/DisplayOrderDetails"/>
	<jsp:include page="/DisplayOrderServlet"/>
	<jsp:include page="/DisplayProductServlet"/>
	<jsp:include page="/SelectUserDetails"/>
	<jsp:include page="/FindAreaDetailsServlet"/>
	
	
	<%List<Product> productList= (List)request.getAttribute("ProductData"); 
	List<User> UserList = (List) request.getAttribute("UserData");
	OrderDetails order=(OrderDetails)request.getAttribute("UserOrder");
	List<CartProduct> cp=order.getProductdetails();
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
                            <li class="breadcrumb-item active" aria-current="page">User Bill</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        </div>
	
		
        
	<div class="row" style="width:100%; padding:50px;" >
	
	<div class="col-md-9">
	

            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="text-center"><strong>Order summary</strong></h3>
                    
                     
                   <h5 align="center">Order Id :<%=order.getOrderid() %> &nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp Order Date :<%=order.getOrderdate() %></h5>
                
              
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed" style="padding: 50px; margin-right: 100px;">
                            <thead>
                                <tr>
                                	
                                    <td><strong>Product</strong></td>
                                    
                                    <td class="text-center"><strong>Item Price</strong></td>
                                    <td class="text-center"><strong>Item Quantity</strong></td>
                                    <td class="text-center"><strong>Item Total</strong></td>
                                   
                                </tr>
                            </thead>
                            <tbody>
                                  <%for(CartProduct c:cp){ %>	
                                <tr>
                                  	
                                   	<%for(Product p:productList) {%>
                                   	
                                   	<%if(c.getProductid()==p.getId()){ %>
											
										
                                  		<td class="text-left"><img height="50px" width="50px" src="data:image/png;base64,<%=p.getProduct_imgstring()%>" alt="Product">&nbsp&nbsp&nbsp&nbsp&nbsp<%=p.getProduct_name()%></td>
                                   	
                                   	
                                   	<%}}%>
                                   
                                    <td class="text-center"><%=c.getAmount() %></td>
                                    
                                    <td class="text-center"><%=c.getQuantity() %></td>
                                   
                                   <td class="text-center"><%=c.getAmount() * c.getQuantity()%>  </td>
                                   
                                </tr>
                                 <%} %>
                        	
                                <!-- <tr>
                                    <td>Samsung Galaxy S5 Extra Battery</td>
                                    <td class="text-center">$30.00</td>
                                    <td class="text-center">1</td>
                                    <td class="text-right">$30.00</td>
                                </tr>
                                <tr>
                                    <td>Screen protector</td>
                                    <td class="text-center">$7</td>
                                    <td class="text-center">4</td>
                                    <td class="text-right">$28</td>
                                </tr> -->
                                
                                <tr>
                                    <td class="highrow"></td>
                                    <td class="highrow"></td>
                                    <td class="highrow text-center"><strong>Sub Total</strong></td>
                                    <td class="highrow text-center"><%=order.getTotalamount()%></td>
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
                                    <td class="emptyrow text-center"><strong>Finale Total</strong></td>
                                    <td class="emptyrow text-center"><%=order.getTotalamount()%></td>
                                </tr>
                                <tr>
                                    <td class=""></td>
                                    <td class=""></td>
                                    <td class="text-center"><strong >Payment Mode</strong></td>
                                	<%if(order.getPaymentstatus()==0) {%>    
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
                    			<h3 class="text-center"><strong>Shipping Address</strong></h3>
                   				<h5 align="center">We will deliver soon</h5>
               			 </div>
               			
                            	<%-- <%if(orderid[1].equalsIgnoreCase(o1.getOrderid())){ %> --%>
                        <div class="panel-body" style="padding:20px;">
                             <%-- <strong><%=u.getFname() %></strong><br> --%>
                            
                            <Strong>Address : </Strong><%=order.getDeliveryaddress() %><br><br>
                            <Strong>Area Name : </Strong><%=order.getDeliveryareaname() %><br>
                            <br>
                            
                        </div>
                        
                    </div>
                </div>
            </div>
            
             
             
            <div class="checkout-btn " style="padding:0px 800px 0px 600px ; ">
					<a href="OrderList.jsp" style="background-color: transparent;"><button
							class="btn alazea-btn w-100" >Back</button></a>
				</div>
  	
            
             
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