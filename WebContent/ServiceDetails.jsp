<%@page import="com.thenurserysystem.bean.Area"%>
<%@page import="com.thenurserysystem.bean.Service"%>
<%@page import="com.thenurserysystem.bean.Question"%>
<%@page import="com.thenurserysystem.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.*" %>  
<% Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000000); %>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Service Details</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">

</head>
<script src="js/jquery.min.js"></script>
<script>
$(document).ready(function(){
	var form = $('form[name="form1"]'),
    radio = $('input[name="choice"]'),
    choice = '';

radio.change(function(e) {
    choice = this.value;
	/*  alert(choice); */ 
    if (choice === 'yes') {
        form.attr('action', 'ServiceCODServlet');
    } else {
        form.attr('action', 'ServicepgRedirect.jsp');
    }
});
 $("#btn").click(function(){
	 
				var a=$("#areaname").val();
		var b=$("#add").val();
		 var d=$('#uid').val();
		 var e=$('#ORDER_ID').val();
		 var f=$('#tot').val();
		 var g=$('#sid').val();
		 if(b.length==0 || !(a))
			{
			 	event.preventDefault();
			
				if(b.length==0 && !(a))
					{
						$("#addresserror").html("Area name and Address required");
					}
				else if(!(a))
					{
						$("#addresserror").html("Area name required");
					}
				else
					{
						$("#addresserror").html("Address required");
					}
			}
		 else
			 {
				$.ajax({
			  		method: "Post",
			  		url: "UpdateServiceAddress",
			  		data: { areaname: a , address : b , userid : d , oderid:e , total:f , sid:g}
					})
			 }		
	});
});

</script>
<body>
<jsp:include page="/FetchQuestionDetails"/>
<jsp:include page="/DisplayGardenerServlet"/>
<jsp:include page="/FindAreaDetailsServlet"/>
<jsp:include page="/SelectUserDetails"/>
	<%List<Service> ServiceList= (List)request.getAttribute("ServiceData"); 
	List<Question> questionList = (List) request.getAttribute("QuestionList"); 
	List<User> UserList = (List) request.getAttribute("UserData");
	List<Area> area = (List) request.getAttribute("areadetails");
	List<User> gardenerList = (List) request.getAttribute("GardenerData");
	%>
		
    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-circle"></div>
        <div class="preloader-img">
            <img src="img/core-img/leaf.png" alt="">
        </div>
    </div>

    <!-- ##### Header Area Start ##### -->
    	<%@include file="Header.jsp" %>
    <!-- ##### Header Area End ##### -->

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(img/bg-img/24.jpg);">
            <h2>Service DETAILS</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a href="#">Service</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Service Details</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area mb-50">
    <%for(Service s:ServiceList ) {%>
    		
    		<input type="hidden" value=<%=s.getServiceId()%> id="sid">
    		<input type="hidden" id="uid" value="<%=u.getUserid()%>">
        <div class="produts-details--content mb-50">
            <div class="container">
                <div class="row justify-content-between"> 

                    <div class="col-12 col-md-6 col-lg-5">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                   
                                   <div class="carousel-item active">
                                        <a class="product-img" href="data:image/png;base64,<%=s.getServiceImageString()%>"  title="Product Image" >
                                        <img class="d-block" src="data:image/png;base64,<%=s.getServiceImageString()%>"  alt="1" height="350px" width="350px">
                                    </a>
                                	</div>    
                                  
                                   
                                    <%-- <div class="carousel-item">
                                        <a class="product-img" href="data:image/png;base64,<%=p.getProduct_imgstring() %>"  title="Product Image">
                                        <img class="d-block w-100" src="data:image/png;base64,<%=p.getProduct_imgstring() %>"  alt="1">
                                    </a>
                                    </div>  --%>
                                    
                                    
                                
                                </div>
                               
                            </div>
                        </div>
                    </div>

					
                    <div class="col-12 col-md-6">
                        <div class="single_product_desc">
                            
                            <h4 class="title"><%=s.getServiceDetails() %></h4>
                            
                            <h4 class="price"><%=s.getServiceAmount() %> Rs</h4>
                            
                            <div class="cart--area d-flex flex-wrap align-items-center">
                                <!-- Add to Cart Form -->
                                	
                                	
                             <p><%=s.getDescription() %></p>
                                
                                <!-- Wishlist & Compare -->
                                <!-- <div class="wishlist-compare d-flex flex-wrap align-items-center">
                                    <a href="#" class="wishlist-btn ml-15"><i class="icon_heart_alt"></i></a>
                                    <a href="#" class="compare-btn ml-15"><i class="arrow_left-right_alt"></i></a>
                                </div> -->
                            </div>
                        </div>
                    </div>
                   
                   
                </div>
                <div class="col-120 col-lg-10">
                <div class="cart-totals-area mt-70">
                
                 <div class="shipping d-flex">
                            <h5>Shipping Address</h5>
                            <div class="shipping-address">
                                    <select class="custom-select" name="area" id="areaname" style=" font-size: 15px;" required>
                                   <option value="" disabled selected hidden">Select Area</option> 
							<%for (int i = 0; i < area.size(); i++) {%>
							<%
								Area a = area.get(i);
							%>
							<option value="<%=a.getAreaname()%>"> <%=a.getAreaname()%></option>
							<%
								}
							%>
                              <input type="hidden"  id="uid" name="userid" value=<%=u.getUserid() %>>
                                    </select>
                                    
                                    <textarea rows="4" cols="105" id="add" name="address" placeholder="Address" style=" font-size: 15px; border:0px solid #ebebeb; padding: 2px 10px; background-color: #f5f5f5; border-radius: 4px;"></textarea>
          
                                   <br><span id="addresserror" style="color:red;"></span>
                            </div>
                        </div>
                
                  
                  	<label style="margin-right: 50px; padding-top: 50px;">SELECT PAYMENT MODE</label>
                       	
                      	<input type="radio" name="choice" value="yes">
                      	<label style="margin-right:30px">  Case On Delivery</label>
                      	
                      	<input type="radio" name="choice" value="no" checked="checked">
                      	<label>  Online Payment</label>
                        
                  
    	<form method="post" name="form1" action="ServicepgRedirect.jsp">
                        
                        <input hidden="hidden" id="ORDER_ID" tabindex="1" maxlength="20" size="20" name="ORDER_ID" autocomplete="off" value="SERVICE_<%= randomInt %>">
                        
                        <input hidden="hidden" id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST001">
                        
                        <input hidden="hidden" id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12" size="12" name="INDUSTRY_TYPE_ID" autocomplete="off" value="Retail">
                        
                        <input hidden="hidden" id="CHANNEL_ID" tabindex="4" maxlength="12" size="12" name="CHANNEL_ID" autocomplete="off" value="<%=u.getUserid() %>">
                        
                        <div class="total d-flex justify-content-between">
                            
                           
                            
                         <input title="TXN_AMOUNT" readonly="readonly" tabindex="10" type="hidden" name="TXN_AMOUNT" id="tot" value="<%= s.getServiceAmount()%>" style="border: none; outline:none; text-align: right; background-color: white; ">  
                            
                        </div>
        
		<button id="btn" class="btn alazea-btn w-100" style="width: 20px;">CONFIRM BOOKING</button>
		</form>				
		
		
	</div>
			</div>	  
                   <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                       	<br><br><br>
                       	<h1 align="center">OUR TEAM</h1>
 						                     
                    </div>
                </div>
            </div>
                
                 <div class="single-widget-area">
                 <%for(User u1:gardenerList){%>
                 
                
                            <!-- Author Widget -->
                            <div class="author-widget">
                                <div class="author-thumb-name d-flex align-items-center">
                                    <div class="author-thumb">
                                        <img src="img/bg-img/29.jpg" alt="">
                                    </div>
                                    <div class="author-name">
                                        <h5><%=u1.getFname() %> <%=u1.getLname() %></h5>
                                        <p>Gardener</p>
                                    </div>
                                </div>
                                <p>I am the editor for houseplants  garden design articles on social, and I like to put each of those articles in the topic.</p>
                                <div class="social-info">
                                    <a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a>
                                    <a href="#"><i class="fa fa-instagram" aria-hidden="true"></i></a>
                                </div>
                            </div>
                  <br>
             		<%} %>
                  <%}%>
                   </div>
            </div>
        </div>

                
                   
                   
    </section>
    
    
    

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