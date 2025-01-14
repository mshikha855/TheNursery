<%@page import="com.thenurserysystem.bean.Feedback"%>
<%@page import="com.thenurserysystem.bean.Gallery"%>
<%@page import="com.thenurserysystem.bean.Cart"%>
<%@page import="com.thenurserysystem.bean.Offer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.thenurserysystem.bean.Product"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Shop Details</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">

</head>
<script src="js/jquery.min.js"></script>
<script>
$(document).ready(function(){

	$("#cartbtn").click(function(){
		
		var a=$("#proid").val();
		
		$.get("InsertCartServlet", {
			productid : a
		}).done(function(data) {
				
			$("#cartbtn").attr('disabled', true);
		
			if(data="true")
				{
					$("#message").html("Added in Cart");
				}
		});
		
	});

	
	
	$("#submit").click(function(){
		
		var a=$("input[type='radio'][name='star']:checked").val();
		var b=$("#comments").val();
		var c=$("#prodid").val();
		 $.ajax({
			  method: "Post",
			  url: "Storefeedback",
			  data: { star: a , comment : b , pid : c }
			})
			  .done(function( msg ) {
				  
				  
			  }); 
	});
});

</script>
<style>
.badge--sale {
    color: #fff;
    background-color: #70c745;
}
.badge--soldout, .badge--sale {
    font-style: normal;
    font-weight: 700;
  	padding: 0.25rem 0.3125rem;
    text-decoration: none;
    vertical-align: middle;
}
.product--badge {
    display: inline-block;
    height: 100%;
    margin-right: 0.5rem;
    margin-bottom: 0.5rem;
    font-size: var(--font-size-body-smallest);
    white-space: nowrap;
}
</style>
<body>
	<jsp:include page="/FetchGalleryDetails"/>
	<jsp:include page="/DisplayCategoryServlet"/>
	<jsp:include page="/FetchCartDetails"/>
	<jsp:include page="/DisplayFeedback"/>
	<jsp:include page="/DisplayOfferServlet"/>
	<%List<Product> productList= (List)request.getAttribute("ProductData"); 
	  List<Gallery> galleryList=(List)request.getAttribute("GalleryList");
	  List<Category> catList=(List)request.getAttribute("CategoryData");
	  List<Cart> cartList=(List)request.getAttribute("CartData");
	  List<Feedback> fb=(List)request.getAttribute("feedbackdetails");
	  List<User> u2=(List)request.getAttribute("userlist");
	  List<Offer> offer=(List)request.getAttribute("OfferData");
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
            <h2>SHOP DETAILS</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="Index.jsp"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item"><a >Shop</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Shop Details</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Single Product Details Area Start ##### -->
    <section class="single_product_details_area mb-50">
    <%for(Product p:productList ) {%>
    		
    		<input type="hidden" value=<%=p.getId()%> id="proid">
    		
    		
        <div class="produts-details--content mb-50">
            <div class="container">
                <div class="row justify-content-between"> 

                    <div class="col-12 col-md-6 col-lg-5">
                        <div class="single_product_thumb">
                            <div id="product_details_slider" class="carousel slide" data-ride="carousel">
                                <div class="carousel-inner">
                                   
                                   <div class="carousel-item active">
                                        <a class="product-img" href="data:image/png;base64,<%=p.getProduct_imgstring()%>"  title="Product Image" >
                                        <img class="d-block w-100" src="data:image/png;base64,<%=p.getProduct_imgstring()%>"  alt="1">
                                    </a>
                                	</div>    
                                   <%for(Gallery g:galleryList){ %> 
                                   
                                   <%if(p.getId()==g.getProductId()) {%>
                                  
									<div class="carousel-item">
                                	   
                                        <a class="product-img"href="data:image/png;base64,<%=g.getGallery_imgString() %>"  title="Product Image">
                                        <img class="d-block w-100" src="data:image/png;base64,<%=g.getGallery_imgString() %>"  alt="1">
                                     </a>	
                                     </div> 
                                     <%}%>
                                    
                                    <%} %>
                                     
                                   
                                    <%-- <div class="carousel-item">
                                        <a class="product-img" href="data:image/png;base64,<%=p.getProduct_imgstring() %>"  title="Product Image">
                                        <img class="d-block w-100" src="data:image/png;base64,<%=p.getProduct_imgstring() %>"  alt="1">
                                    </a>
                                    </div>  --%>
                                    
                                    
                                
                                </div>
                               
                                   
                                <ol class="carousel-indicators">
                                  <li class="active" data-target="#product_details_slider" data-slide-to="0"  style="background-image: url(data:image/png;base64,<%=p.getProduct_imgstring()%>);">
                                    </li>
                                 
                                <%for(Gallery g:galleryList){ %>    
                                 
                                  <%if(p.getId()==g.getProductId()){ %>
                                 	
                                 	 <li data-target="#product_details_slider" data-slide-to="1"  style="background-image: url(data:image/png;base64,<%=g.getGallery_imgString()%>);"></li>
                                    <%--<li data-target="#product_details_slider" data-slide-to="2" style="background-image: url(data:image/png;base64,<%=g.getGallery_imgString()%>);">
                                    </li> --%>
                                    <%} %>
                                 
                                    
                                    <%} %>
                                </ol>
                            </div>
                        </div>
                    </div>

					
                    <div class="col-12 col-md-6">
                        <div class="single_product_desc">
                            <h4 class="title"><%=p.getProduct_name() %></h4>
                           
                            			<%for(Offer f : offer){ %>
                                    	<%if(p.getOffer_id()==f.getOffer_id() && 0!=f.getDiscount()) {%>
                                        <span class="product--badge badge--sale" data-badge-sales="">
      										Save <span data-price-percent-saved=""><%=f.getDiscount() %></span>%
      										
  										</span>
  										
  										<span><%=f.getDetails() %></span>
  										
  										<br><br>
  										<%} }%>
                            
                            <div class="form-inline">
                            <div class="form-control" style="border: none;">
                            <%int discount=0; %>
                            <%for(Offer f : offer){ %>
                            	<%if(p.getOffer_id()==f.getOffer_id()){ 
                            	     discount=f.getDiscount();
                            	     %>
                            <%}} %>
                            	<%if(p.getOffer_id()!=0 && discount!=0){ %>
                            	<h4 style="color: #949494"><del><i class="fa fa-inr"></i>&nbsp<%=p.getPrice() %></del></h4>
                            	<%}else{ %>
                            	<h4 class="price"><i class="fa fa-inr"></i>&nbsp<%=p.getPrice() %></h4>
                            	<%} %>
                            </div>
                            <div class="form-control"  style="border: none;">
                            <%if(p.getPrice()!=p.getAfterofferprice()) {%>
                            <%int a=p.getPrice()-p.getAfterofferprice(); %>
                            <h4 class="price"><i class="fa fa-inr"></i>&nbsp<%=p.getAfterofferprice() %></h4>
                            <%} %>
                            
                            </div>
                            
                            </div>
                            
                            <br></br>
                            <%--<div class="short_overview">
                                <p>Lorem ipsum dolor sit amet, consectetur adipiscing elit. Phasellus pellem malesuada in nibh selama euismod. Curabitur a rhoncus dui. Nunc lobortis cursus magna utrum faucibus. Vivamus justo nibh, pharetra non risus accumsan, tincidunt suscipit leo.</p>
                            </div> --%>

                            <div class="cart--area d-flex flex-wrap align-items-center">
                                <!-- Add to Cart Form -->
                               <!--  <form class="cart clearfix d-flex align-items-center">
                                    <div class="quantity">
                                        <span class="qty-minus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty ) &amp;&amp; qty &gt; 1 ) effect.value--;return false;"><i class="fa fa-minus" aria-hidden="true"></i></span>
                                        <input type="number" class="qty-text" id="qty" step="1" min="1" max="12" name="quantity" value="1">
                                        <span class="qty-plus" onclick="var effect = document.getElementById('qty'); var qty = effect.value; if( !isNaN( qty )) effect.value++;return false;"><i class="fa fa-plus" aria-hidden="true"></i></span>
                                    </div>
                                  <button type="submit" name="addtocart" value="5"  id="cartbtn" class="btn alazea-btn ml-15">Add to cart</button> 
                                </form>
                                --> 
                               <%if(u!=null){ %>
                                <%int flag=1; %>
                                
                                <%for(Cart c:cartList) {%>
                                	
                                	<%if(p.getId()==c.getProductID() && u.getUserid()==c.getUserId()) {%>
                                		<a href="DeleteCartDetails?id=<%=c.getCartId()	%>"><button type="submit" name="deletecart" value="5"  id="delcartbtn" class="btn alazea-btn ml-15">Remove From Cart</button></a>
                                		<%flag=0; %>
                                	<%} %>
                                	
                                <%} %>
                                <%if(flag==1){ %>
                                	<%if(u!=null){ %>
                                		<button type="submit" name="addtocart" value="5"  id="cartbtn" class="btn alazea-btn ml-15">Add to cart</button>
                                	<%}else{%>
                                			<a href="Login.jsp"><button class="btn alazea-btn ml-15">Login First</button></a>
                                	<%} %>
                                <%}}else{ %>
                               			<a href="Login.jsp"><button class="btn alazea-btn ml-15">Login First</button></a>
                               		<%} %>
                               		<span id="message" style="color: green; font-size: 25px; margin-left: 20px;"></span>
                                
                                
                                <!-- Wishlist & Compare -->
                                <!-- <div class="wishlist-compare d-flex flex-wrap align-items-center">
                                    <a href="#" class="wishlist-btn ml-15"><i class="icon_heart_alt"></i></a>
                                    <a href="#" class="compare-btn ml-15"><i class="arrow_left-right_alt"></i></a>
                                </div> -->
                            </div>

                            <div class="products--meta">
                                <p><span>Maintanance</span> <span><%=p.getMaintenance() %></span></p>
                                <p><span>Watering</span> <span><%=p.getWatering() %></span></p>
                                <p><span>Sunlight</span> <span><%=p.getSunlight() %></span></p>
                                <%for(Category c:catList){ %>
                                <%if(p.getCat_id()==c.getCat_id()){ %>
                                <p><span>Category:</span> <span><%=c.getCat_name()%></span></p>
                                <%} %>
                                <%} %>
                            </div>

                        </div>
                    </div>
                   
                </div>
            </div>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="product_details_tab clearfix">
                        <!-- Tabs -->
                        <ul class="nav nav-tabs" role="tablist" id="product-details-tab">
                            <li class="nav-item">
                                <a href="#description" class="nav-link active" data-toggle="tab" role="tab">Description</a>
                            </li>
                          <!--   <li class="nav-item">
                                <a href="#addi-info" class="nav-link" data-toggle="tab" role="tab">Additional Information</a>
                            </li> -->
                            <li class="nav-item">
                                <a href="#reviews" class="nav-link" data-toggle="tab" role="tab">Reviews <span class="text-muted"></span></a>
                            </li>
                        </ul>
                        <!-- Tab Content -->
                        <div class="tab-content">
                            <div role="tabpanel" class="tab-pane fade show active" id="description">
                                <div class="description_area">
									<%=p.getDesc() %>
                                </div>
                            </div>
                            <!-- <div role="tabpanel" class="tab-pane fade" id="addi-info">
                                <div class="additional_info_area">
                                    <p>What should I do if I receive a damaged parcel?
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Reprehenderit impedit similique qui, itaque delectus labore.</span></p>
                                    <p>I have received my order but the wrong item was delivered to me.
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Facilis quam voluptatum beatae harum tempore, ab?</span></p>
                                    <p>Product Receipt and Acceptance Confirmation Process
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Dolorum ducimus, temporibus soluta impedit minus rerum?</span></p>
                                    <p>How do I cancel my order?
                                        <br> <span>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Nostrum eius eum, minima!</span></p>
                                </div>
                            </div> -->
                            <div role="tabpanel" class="tab-pane fade" id="reviews">
                                <div class="reviews_area">
                                    <ul>
                                        <li>
                                        <%for(Feedback f: fb){ %>
                                        <%if(p.getId()==f.getPid()){ %>
                                            <div class="single_user_review mb-15">
                                                <div class="review-rating">
                                                <% for(int i=0;i<f.getStar();i++) {%>
                                                    <i class="fa fa-star" aria-hidden="true"></i>
                                                    <%} %>
                                                   
                                                </div>
                                                 <%for(User u1: u2){ %>
                                                <div class="review-details">
                                              
                                               		<%if(u1.getUserid()==f.getUid()){ %>
                                                    <p>by <a><%=u1.getFname() %><%=u1.getLname() %></a>
                                                    <p>Description :  <%=f.getComment() %>   </p>
                                                	<%} %>
                                                </div>
                                                <%} %>
                                           </div>
                                            <%} }%>
                                         </div>
                                        </li>
                                    </ul>
                                
								<%if(u!=null){ %>
                                <div class="submit_a_review_area mt-50">
                                    <h4>Submit A Review</h4>
                                    <form action="#" method="post">
                                        <div class="row">
                                            <div class="col-12">
                                                <div class="form-group d-flex align-items-center">
                                                    <span class="mr-15">Your Ratings:</span>
                                                    <div class="stars">
                                                        <input type="radio" name="star" class="star-1"  id="star-1" value="1">
                                                        <label class="star-1" for="star-1">1</label>
                                                        <input type="radio" name="star" class="star-2"  id="star-2" value="2">
                                                        <label class="star-2" for="star-2">2</label>
                                                        <input type="radio" name="star" class="star-3"  id="star-3" value="3">
                                                        <label class="star-3" for="star-3">3</label>
                                                        <input type="radio" name="star" class="star-4"  id="star-4" value="4">
                                                        <label class="star-4" for="star-4">4</label>
                                                        <input type="radio" name="star" class="star-5"  id="star-5" value="5">
                                                        <label class="star-5" for="star-5">5</label>
                                                        <span></span>
                                                    </div>
                                                </div>
                                            </div>
                                        
                                            <input type="hidden" id="prodid" name="pid" value="<%=p.getId() %>" >
                                            <div class="col-12">
                                                <div class="form-group">
                                                    <label for="comments">Comments</label>
                                                    <textarea class="form-control" name="comment" id="comments" rows="5" data-max-length="150" required="required"></textarea>
                                                </div>
                                            </div>
                                            <div class="col-12">
                                                <button type="submit" id="submit" class="btn alazea-btn">Submit Your Review</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                                
                                <%} %>
                                </div>
                            </div>

                        </div>
                    </div>
                </div>
            </div>
        </div>
         <%} %>
    </section>
    <!-- ##### Single Product Details Area End ##### -->

    <!-- ##### Related Product Area Start ##### -->
   <%--<div class="related-products-area">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                        <h2>Related Products</h2>
                    </div>
                </div>
            </div>

            <div class="row">

                <!-- Single Product Area -->
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img">
                            <a href="shop-details.html"><img src="img/bg-img/40.png" alt=""></a>
                            <!-- Product Tag -->
                            <div class="product-tag">
                                <a href="#">Hot</a>
                            </div>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>

                <!-- Single Product Area -->
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img">
                            <a href="shop-details.html"><img src="img/bg-img/41.png" alt=""></a>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>

                <!-- Single Product Area -->
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img">
                            <a href="shop-details.html"><img src="img/bg-img/42.png" alt=""></a>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>

                <!-- Single Product Area -->
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-100">
                        <!-- Product Image -->
                        <div class="product-img">
                            <a href="shop-details.html"><img src="img/bg-img/43.png" alt=""></a>
                            <!-- Product Tag -->
                            <div class="product-tag sale-tag">
                                <a href="#">Hot</a>
                            </div>
                            <div class="product-meta d-flex">
                                <a href="#" class="wishlist-btn"><i class="icon_heart_alt"></i></a>
                                <a href="cart.html" class="add-to-cart-btn">Add to cart</a>
                                <a href="#" class="compare-btn"><i class="arrow_left-right_alt"></i></a>
                            </div>
                        </div>
                        <!-- Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="shop-details.html">
                                <p>Cactus Flower</p>
                            </a>
                            <h6>$10.99</h6>
                        </div>
                    </div>
                </div>

            </div>
        </div>
    </div> --%>
    <!-- ##### Related Product Area End ##### -->

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