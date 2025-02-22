<%@page import="com.thenurserysystem.bean.Service"%>
<%@page import="com.thenurserysystem.service.impl.ServiceImpl"%>
<%@page import="com.thenurserysystem.service.ServiceService"%>
<%@page import="com.thenurserysystem.bean.ServiceBooking"%>
<%@page import="com.thenurserysystem.util.ThreadEmail"%>
<%@page import="com.thenurserysystem.bean.SendEmail"%>
<%@page import="com.thenurserysystem.bean.Product"%>
<%@page import="com.thenurserysystem.bean.User"%>
<%@page import="com.thenurserysystem.service.impl.OrderServiceImpl"%>
<%@page import="com.thenurserysystem.service.OrderService"%>
<%@page import="com.thenurserysystem.bean.OrderDetails"%>
<%@page import="com.thenurserysystem.bean.Area"%>
<%@page import="com.thenurserysystem.util.PaytmConstants"%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" session="false"%>
<%@ page import="java.util.*,com.paytm.pg.merchant.CheckSumServiceHelper"%>
<%
Enumeration<String> paramNames = request.getParameterNames();

Map<String, String[]> mapData = request.getParameterMap();
TreeMap<String,String> parameters = new TreeMap<String,String>();
String paytmChecksum =  "";
while(paramNames.hasMoreElements()) {
	String paramName = (String)paramNames.nextElement();
	if(paramName.equals("CHECKSUMHASH")){
		paytmChecksum = mapData.get(paramName)[0];
	}else{
		parameters.put(paramName,mapData.get(paramName)[0]);
	}
}
boolean isValideChecksum = false;
String outputHTML="";
try{
	isValideChecksum = CheckSumServiceHelper.getCheckSumServiceHelper().verifycheckSum(PaytmConstants.MERCHANT_KEY,parameters,paytmChecksum);
	if(isValideChecksum && parameters.containsKey("RESPCODE")){
		if(parameters.get("RESPCODE").equals("01")){
			outputHTML = parameters.toString();
		}else{
			outputHTML="<b>Payment Failed.</b>";
		}
	}else{
		outputHTML="<b>Checksum mismatched.</b>";
	}
}catch(Exception e){
	outputHTML=e.toString();
}%>
<%int a=0; %>
<%
ServiceBooking sb1=new ServiceBooking();
String str=String.valueOf(parameters);
ServiceService ss=new ServiceImpl();
String s[]=str.split(",");

String msg=String.valueOf(parameters); 

String ss1[]=msg.split(",");

String orderid[]=ss1[5].split("=");
System.out.println(orderid[1]);

String totalamount[]=s[10].split("=");
System.out.println(totalamount[1]);

String date[]=ss1[11].split("=");
System.out.println(date[1]);

sb1.setPaymentstatus(1);
sb1.setBookingid(orderid[1]);
int ans=ss.updateServiePaymentStatus(sb1);
if(ans>0)
{
	a=1;
}
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html lang="en">
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Payment Sucess</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">
    <style type="text/css">
   
  .o-circle {
  display: flex;
  width: 10.555rem; height: 10.555rem;
  justify-content: center;
  align-items: flex-start;
  border-radius: 50%; 
  animation: circle-appearance .8s ease-in-out 1 forwards, set-overflow .1s 1.1s forwards;
}

.c-container__circle {
  margin: 0 auto 5.5rem;
}

/*=======================
    C-Circle Sign
=========================*/
      
.o-circle__sign {
  position: relative;
  opacity: 0;
  background: #fff;
  animation-duration: .8s;
  animation-delay: .2s;
  animation-timing-function: ease-in-out;
  animation-iteration-count: 1;
  animation-fill-mode: forwards;
}

.o-circle__sign::before, 
.o-circle__sign::after {
  content: "";
  position: absolute;
  background: inherit;
}

.o-circle__sign::after {
  left: 100%; top: 0%;
  width: 500%; height: 95%; 
  transform: translateY(4%) rotate(0deg);
  border-radius: 0;
  opacity: 0;
  animation: set-shaddow 0s 1.13s ease-in-out forwards;
  z-index: -1;
}


/*=======================
      Sign Success
=========================*/
 
.o-circle__sign--success { 
  background: rgb(56, 176, 131);
}

.o-circle__sign--success .o-circle__sign {
  width: 1rem; height: 6rem;
  border-radius: 50% 50% 50% 0% / 10%;
  transform: translateX(130%) translateY(35%) rotate(45deg) scale(.11);  
  animation-name: success-sign-appearance;
}

.o-circle__sign--success .o-circle__sign::before {
   bottom: -17%;
   width: 100%; height: 50%; 
   transform: translateX(-130%) rotate(90deg);
   border-radius: 50% 50% 50% 50% / 20%;

}

/*--shadow--*/
.o-circle__sign--success .o-circle__sign::after {
   background: rgb(40, 128, 96);
}
 

/*=======================
      Sign Failure
=========================*/

.o-circle__sign--failure {
  background: rgb(236, 78, 75);
}

.o-circle__sign--failure .o-circle__sign {
  width: 1rem; height: 7rem;
  transform: translateY(25%) rotate(45deg) scale(.1);
  border-radius: 50% 50% 50% 50% / 10%;
  animation-name: failure-sign-appearance;
}

.o-circle__sign--failure .o-circle__sign::before {
   top: 50%;
   width: 100%; height: 100%; 
   transform: translateY(-50%) rotate(90deg);
   border-radius: inherit;
} 

/*--shadow--*/
.o-circle__sign--failure .o-circle__sign::after {
   background: rgba(175, 57, 55, .8);
}


/*-----------------------
      @Keyframes
--------------------------*/
 
/*CIRCLE*/
@keyframes circle-appearance {
  0% { transform: scale(0); }
  
  50% { transform: scale(1.5); }
          
  60% { transform: scale(1); }
  
  100% { transform: scale(1); }
}

/*SIGN*/
@keyframes failure-sign-appearance {         
  50% { opacity: 1;  transform: translateY(25%) rotate(45deg) scale(1.7); }
    
  100% { opacity: 1; transform: translateY(25%) rotate(45deg) scale(1); }
}

@keyframes success-sign-appearance {      
  50% { opacity: 1;  transform: translateX(130%) translateY(35%) rotate(45deg) scale(1.7); }
    
  100% { opacity: 1; transform: translateX(130%) translateY(35%) rotate(45deg) scale(1); }
}
 

@keyframes set-shaddow {
  to { opacity: 1; }
}

@keyframes set-overflow {
  to { overflow: hidden; }
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
   
	<jsp:include page="/SelectBookedServiceDetails"/>
	<jsp:include page="/DisplayProductServlet"/>
	<jsp:include page="/SelectUserDetails"/>
	<jsp:include page="/FindAreaDetailsServlet"/>
	<jsp:include page="/DisplayServiceDetails"/>
	
	
	<%
	List<Product> productList= (List)request.getAttribute("ProductData"); 
	List<User> UserList = (List) request.getAttribute("UserData");
	List<Area> areaList=(List) request.getAttribute("areadetails");
	List<ServiceBooking> bookingList=(List)request.getAttribute("BookedServiceList");
	List<Service> serviceList = (List) request.getAttribute("ServiceData");
	
	%>
	
	<%if(!outputHTML.equalsIgnoreCase("<b>Checksum mismatched.</b>")){ %>
	 <%String email=null;
	String fname=null; %>
	<%if(a==1){ 
		int uid=0;
		
	for(ServiceBooking od1 : bookingList)
	{
		if(sb1.getBookingid().equals(od1.getBookingid()))
		{
			uid=od1.getUserid();	
		}
	}
	for(User ul : UserList)
	{
		if(ul.getUserid()==uid)
		{
			email=ul.getEmail();
			fname=ul.getFname();
		}
	}
	SendEmail obj = new SendEmail();
	/* String msg = "<h1>Dear, "+fname+"</h1>\n\n\n<font color=red,size=12px>Your Order Book Sucessfully</font>"; 
	msg+="\n\n<h3>YOUR Order Id  ::  "+ s1[1] + "</h3> ";
	msg+="\n\n<h3>Amount :: "+s3[1]+"</h3>";
	msg+="\n\n<h3>We Will Deliver Your Order within two Days</h3>";
	msg+="\n\n<h4>Thank You</h4>"; */
	
	String message = "<h1>Dear, " +fname + "</h1>";
	message+="\n<font color=green size=5>Service Booked Sucessfull ! </font>\n\n<h3>Service ID  ::  "+sb1.getBookingid() + "</h3>\n<h3> Total Amount "+totalamount[1]+" </h3>\n<h3>We will get back to you soon ,\n Thank You</h3>";
	
	ThreadEmail threadEmail = new ThreadEmail();
	threadEmail.Send(email,message);
	Thread t1 = new Thread(threadEmail);
	t1.start();
	} %>
 	 
	<div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-circle"></div>
        <div class="preloader-img">
            <img src="img/core-img/leaf.png" alt="">
        </div>
    </div>
    

    <!-- ##### Breadcrumb Area Start ##### -->
     <div class="breadcrumb-area" style="background-color: white;"> 
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(img/bg-img/24.jpg);">
            <h2>Payment Page</h2>
        </div>

         <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Payment Sucess</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
        </div>


<!-- 
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
				<h1>Payment Success !</h1>
				<p>Thanks for booking... Please check your email</p>
				
			</div>
		</div>
	</div>
 -->	
 
 <div class="animation-ctn">
		<div class="icon icon--order-success svg" ">
			<div class="o-circle c-container__circle o-circle__sign--success">
    			<div class="o-circle__sign"></div>  
  			</div>
			<div class="content" align="center" style="margin-top: 20px;">
				<h1>Payment Sucess..!!!</h1>
				<p>Thanks for ordering... Please check your email</p>
			</div>
			
		</div>
	</div> 
	
	
	<div class="row" style="width:100%; padding:50px;" >
	
	<div class="col-md-9">
            <div class="panel panel-default">
                <div class="panel-heading">
                    <h3 class="text-center"><strong>Service summary</strong></h3>
                    
                    <h5 align="center">Service Id : <%= orderid[1]%> </h5>
                    
                    <h5 align="center">Booking Date : <%= date[1]%> </h5>
                </div>
                <div class="panel-body">
                    <div class="table-responsive">
                        <table class="table table-condensed" id="tblCustomers" style="padding: 50px; margin-right: 100px;">
                            <thead>
                                <tr>
                                	
                                    <td><strong>Service Name</strong></td>
                                    
                                    <td class="text-center"><strong>Service Price</strong></td>
                                   
                                    <td class="text-center"><strong>Service Total</strong></td>
                                   
                                </tr>
                            </thead>
                            <tbody>
                          
                            
                            	
                               
                                <%for(ServiceBooking sb:bookingList){ %>
                                 <tr>
                                <%if(orderid[1].equalsIgnoreCase(sb.getBookingid())) {%>
                               
                                <%for(Service service:serviceList){ %>
                                	
                                	<%if(sb.getServiceid()==service.getServiceId()) {%>
                                		
                                    <td class="text-left"><img height="50px" width="50px" src="data:image/png;base64,<%=service.getServiceImageString()%>" alt="Product">&nbsp&nbsp&nbsp&nbsp&nbsp<%=service.getServiceDetails()%></td>
                                   	
                                   <%}} %>
                                   
                                    <td class="text-center"><%=totalamount[1] %></td>
                                    
                                    <td class="text-center"><%=totalamount[1] %></td>
                                   
                                   <%}}%>
                                </tr>
                              
                             
                                <tr>
                                    <td class="highrow"></td>
                                    <td class="highrow"></td>
                                    <td class="highrow text-center"><strong>Sub Total</strong></td>
                                    <td class="highrow text-center"><%=totalamount[1] %></td>
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
                                    <td class="emptyrow text-center"><strong>Final	 Total</strong></td>
                                    <td class="emptyrow text-center"><%=totalamount[1] %></td>
                                </tr>
                            </tbody>
                            
                        </table>
                        
                      
                    </div>
                    
                   
                </div>
                 
            </div>
       
        <div class="checkout-btn ">
					<a href="Index.jsp" style="background-color: transparent;"><button
							class="btn alazea-btn w-100">Go to Home</button></a>
				</div>
			 </div>	
				
         		<div class="col-md-3">
                    <div class="panel panel-default height">
                        <div class="panel-heading">
                    			<h3 class="text-center"><strong>Shipping Address</strong></h3>
                   				<h5 align="center">We will Service in 2 or 3 working Days</h5>
               			 </div>
               			  <%for(ServiceBooking sb2:bookingList){ %>
               			  <%if(sb2.getBookingid().equalsIgnoreCase(orderid[1])){ %>
                        <div class="panel-body" style="padding:20px;">
                             <%for(User user:UserList){ %>
                            <%if(user.getUserid()==sb2.getUserid()) {%>
                             <strong>Name : </strong><%=user.getFname() %><%=user.getLname()%><br>
                           	<%}} %> 
                           <br>
                           	<strong>Address : </strong><%=sb2.getServiceaddress() %><br>
                            <Strong>Area Name : </Strong><%=sb2.getServicearea() %><br>
                            <br>
                            
                        </div>
                       <%}} %>
                    </div>
                </div>
             </div> 
       <%}else{ %>
       <%int a1=ss.deletefaildpaymentbookingdata(sb1.getBookingid()); %>
       <%response.sendRedirect("PaymentFailed.jsp"); %>
       
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