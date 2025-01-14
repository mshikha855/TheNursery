<%@page import="com.thenurserysystem.bean.Cart"%>
<%@page import="com.thenurserysystem.bean.Area"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@page import="java.util.*" %>  
 <% Random randomGenerator = new Random();
	int randomInt = randomGenerator.nextInt(1000000); %>
<!DOCTYPE html>
<html lang="en">

<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<meta name="GENERATOR" content="Evrsoft First Page">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Cart - The Nursery</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">
    <script src="js/jquery.min.js"></script>
<script>

	$(document).ready(function(){
			
		$(".qty-plus").click(function(){	
			 
			 qty=$(this).attr('id');//1
			
			  var a=$("#q"+qty).val();
			  
			  var b=$("#price"+qty).val();
			  	
			  var c=a*b;
			  	  
			  $("#total"+qty).html(c);
			  
			  var total=$('#subtot').val();
			  
			  var ans=parseInt(total)+parseInt(b);
			  
			//  $('#subtot').val(ans);
			  
			  calcgranttotal();
			  
			});
		
			
		$(".qty-minus").click(function(){
			
			qty=$(this).attr('id');
			
			  var a=$("#q"+qty).val();
			 
			  var b=$("#price"+qty).val();
			  	
			  var c=a*b; 
			 
			  
			  $("#total"+qty).html(c);	
			  
			 // alert(a);
			
			  var total=$('#subtot').val();
				  
			  var ans=total-b;
			  
			 // $('#subtot').val(ans); 
			  
			  calcgranttotal();
			  
			});
		
		
		function calcgranttotal()
		{
			var total=0;
			$('.total_price').each(function(i, obj) {
			   total+=parseInt($(this).find('span').html());
			   
			});
			 $('#subtot').val(total);
			 $('#tot').val(total);
		}
		
		/* function quantity()
		{
			
			});
			return qt;
		} */
		
		$("#btn").click(function(){
			
			var a=$("#areaname").val();
			var b=$("#add").val();
			 var d=$('#uid').val();
			 var e=$('#ORDER_ID').val();
			 var f=$('#tot').val();
			var c=0;
			var qt;
			
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
					$(".qty-text").each(function(i, obj) {
					if(c==0)
					{
						qt=parseInt($(this).val())+" ";
						c++;
					}
					else
					{
						qt=qt+parseInt($(this).val())+" ";	
					}
				});
				
	 			$.ajax({
					  method: "Post",
					  url: "UpdateShippingAddress",
					  data: { areaname: a , address : b , quantity : qt , userid : d , oderid:e , total:f}
					})
					  .done(function( msg ) {
						  
						  
					  });
				}
		});
		
		 var form = $('form[name="form1"]'),
	        radio = $('input[name="choice"]'),
	        choice = '';

	    radio.change(function(e) {
	        choice = this.value;
			/* alert(choice); */
	        if (choice === 'yes') {
	            form.attr('action', 'CashOrderServlet');
	        } else {
	            form.attr('action', 'pgRedirect.jsp');
	        }
	    });
	});
	
</script>
	
</head>

<body>
<jsp:include page="/FetchCartDetails"/>
<jsp:include page="/DisplayProductServlet"/>
<jsp:include page="/FindAreaDetailsServlet"/>

<%	List<Cart>cartList=(List)request.getAttribute("CartData");
List<Product> productList= (List)request.getAttribute("ProductData"); 
List<Area> area = (List) request.getAttribute("areadetails");
int total=0;
%>

    <!-- Preloader -->
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-circle"></div>
        <div class="preloader-img">
            <img src="img/core-img/leaf.png" alt="">
        </div>
    </div>

   <%@include file="Header.jsp" %>

    <!-- ##### Breadcrumb Area Start ##### -->
    <div class="breadcrumb-area">
        <!-- Top Breadcrumb Area -->
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center" style="background-image: url(img/bg-img/24.jpg);">
            <h2>Cart</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Cart</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->
 
    <!-- ##### Cart Area Start ##### -->
    <div class="cart-area section-padding-0-100 clearfix">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="cart-table clearfix">
                        <table class="table table-responsive">
                            <thead>
                                <tr>
                                    <th>Products</th>
                                    <th>Quantity</th>
                                    <th>Price</th>
                                    <th>TOTAL</th>
                                    <th></th>
                                </tr>
                            </thead>
                             <tbody>
                             <%int val=0; %>
                             <%for(Cart c:cartList){ %>
                            <%for(Product p:productList){ %>
                               	
                            	
                            	<%if(p.getId()==c.getProductID() && u.getUserid()==c.getUserId()){%>
													<%val++; %>                               
                                <tr>
                                    <td class="cart_product_img">
                                        <a><img src="data:image/png;base64,<%=p.getProduct_imgstring()%>" alt="Product"></a>
                                        <h5><%=p.getProduct_name() %></h5>
                                    </td>
                                    <td class="qty">
                                        <div class="quantity">
											                                           
                                            <span class="qty-minus" class="minus"  id="<%=c.getCartId()%>" onclick="var effect = document.getElementById('q<%=c.getCartId() %>'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                            
                       					 <input type="number"  disabled="disabled" readonly="readonly"  class="qty-text" id="q<%=c.getCartId()%>" value="1" step="1" min="1" max="99" name="quantity">
                                           
                                            <span class="qty-plus" class="plus" id="<%=c.getCartId()%>" onclick="var effect = document.getElementById('q<%=c.getCartId() %>'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &lt; 5 ) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                      		
                                        </div>
                                    </td>
                                      <input type="hidden" id="price<%=c.getCartId()%>" value="<%=p.getAfterofferprice() %>" name="priceid"> 
                                       
                                     <td class="price"><span><%=p.getAfterofferprice() %> Rs</span></td> 
                                    
                                    <td class="total_price"><span id="total<%=c.getCartId()%>"><%=p.getAfterofferprice() %></span></td>
                                    
                                   
                                    
                                    
                                    <td class="action"><a href="DeleteCartDetails?id=<%=c.getCartId()%>"><i class="icon_close"></i></a></td>
                                    
                                </tr>
                                 <input type="hidden" val=<%=total+=p.getAfterofferprice() %> /> 
                                <%} %>
                                
                                <%} %>
                               
                                <%} %>
                                                                       		
                             </tbody>
                        </table>
                    </div>
                </div>
            </div>

            <div class="row">

                <!-- Coupon Discount -->
                <!-- <div class="col-12 col-lg-6">
                    <div class="coupon-discount mt-70">
                        <h5>COUPON DISCOUNT</h5>
                        <p>Coupons can be applied in the cart prior to checkout. Add an eligible item from the booth of the seller that created the coupon code to your cart. Click the green "Apply code" button to add the coupon to your order. The order total will update to indicate the savings specific to the coupon code entered.</p>
                        <form action="#" method="post">
                            <input type="text" name="coupon-code" placeholder="Enter your coupon code">
                            <button type="submit">APPLY COUPON</button>
                        </form>
                    </div>
                </div> -->
                <!-- Cart Totals -->
                <div class="col-120 col-lg-10">
                    <div class="cart-totals-area mt-70">
                        <h5 class="title--">Cart Total</h5>
                        <div class="subtotal d-flex justify-content-between">
                            <h5>SUBTOTAL</h5>
                            <h5>
                             <%--  <%for(Cart c1:cartList){ %>
                            	<h5 id="subtot<%=c1.getCartId()%>"><%=total %> Rs</h5>
                           <%} %>   --%>
                            <input id="subtot" readonly="readonly" value="<%=total%>" tabindex="10" type="text" min="1" value="100" style="border: none; outline:none; text-align: right; background-color: white; font-weight: bold; ">  RS
                            </h5>
                            
                           <%--  <input id="subtot" readonly="readonly" value="<%=total %>" tabindex="10" type="text" min="1" value="100" style="border: none; outline:none; text-align: right; background-color: white; ">
 --%>                       	
                        </div>
                        
                        <div class="shipping d-flex justify-content-between">
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
                                    
                                    <textarea rows="4" cols="80" id="add" name="address" placeholder="Address" style=" font-size: 15px; border:0px solid #ebebeb; padding: 2px 10px; background-color: #f5f5f5; border-radius: 4px;"></textarea>
          							<br><span id="addresserror" style="color:red;"></span>      
                            </div>
                        </div>
                        
                                                
                       
                       	<label style="margin-right: 50px;">SELECT PAYMENT MODE</label>
                       	
                      	<input type="radio" name="choice" value="yes">
                      	<label style="margin-right:30px">  Case On Delivery</label>
                      	
                      	<input type="radio" name="choice" value="no" checked="checked">
                      	<label>  Online Payment</label>
                      	
                      	<div class="checkout-btn mt-30">
						
                        
                        <form method="post" name="form1" action="pgRedirect.jsp">
                        
                        <input hidden="hidden" id="ORDER_ID" tabindex="1" maxlength="20" size="20" name="ORDER_ID" autocomplete="off" value="ORDS_<%= randomInt %>">
                        
                        <input hidden="hidden" id="CUST_ID" tabindex="2" maxlength="30" size="12" name="CUST_ID" autocomplete="off" value="CUST001">
                        
                        <input hidden="hidden" id="INDUSTRY_TYPE_ID" tabindex="4" maxlength="12" size="12" name="INDUSTRY_TYPE_ID" autocomplete="off" value="Retail">
                        
                        <input hidden="hidden" id="CHANNEL_ID" tabindex="4" maxlength="12" size="12" name="CHANNEL_ID" autocomplete="off" value="<%=u.getUserid() %>">
                        
                        <div class="total d-flex justify-content-between">
                            
                            <h5>Total</h5>
                            
                            <h5> <input title="TXN_AMOUNT" readonly="readonly" tabindex="10" type="text" name="TXN_AMOUNT" id="tot" value="<%=total %>" style="border: none; outline:none; text-align: right; background-color: white; ">  Rs </h5>
                            
                        </div>
                        
                        
                      	<%if(val!=0){ %>
                        	<button id="btn" class="btn alazea-btn w-100" style="width: 20px;">PROCCED TO CHECKOUT</button>
						<%}else{ %> 
						                        	
						<button id="btn" class="btn alazea-btn w-100" style="width: 20px;" disabled="disabled" >PROCCED TO CHECKOUT</button>
						
						<%} %> 
						
						</div>
                        </form>
                    </div>
                </div>
            </div>

        </div>
    </div>
    <!-- ##### Cart Area End ##### -->
	
   	<%@include file="Footer.jsp" %>
   
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