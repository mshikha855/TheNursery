<%@page import="com.thenurserysystem.bean.Offer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@page import="java.util.List"%>
<%@page import="com.thenurserysystem.bean.Product"%>
<!DOCTYPE html>
<html lang="en">
<%List<Product> productList= (List)request.getAttribute("ProductData"); %>
<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>The Nursery Products</title>
  
    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
   
   
    <link rel="stylesheet" href="style.css">
	<link rel="stylesheet" href="css/SearchBox.css">
	
  	<link href = "https://code.jquery.com/ui/1.10.4/themes/ui-lightness/jquery-ui.css" rel = "stylesheet"> 
    <link href="https://fonts.googleapis.com/css2?family=Pangolin&display=swap" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css2?family=Lato:wght@700&display=swap" rel="stylesheet">
      
     <script src = "https://code.jquery.com/jquery-1.10.2.js"></script>
      <script src = "https://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
         
<script>
         $(function() {
        	
            var availableTutorials  =  [
            	<%for(Product product: productList){%>
            	
               		"<%=product.getProduct_name()%>",
            	
            	<%}%>
            ];
            $( "#search" ).autocomplete({
               source: availableTutorials
              
            });
          
         }); 
         $(document).ready(function() {
			$('#abc').click(function(){
				var x=$('#search').val();
				
					  if(x!="")
						  {
						  
        							$('#search-id').attr("href","Searchproductdetails?proname="+x+"");		   
						  }
					  else
						  {
						  	$("#search-error").html("Input something..");
						  }
			});
			
			
     	});
     	
     	
         
      </script>
  </head>
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
 button {
  float: right;
  padding: 6px 10px;
  margin-top: 2px;
  margin-right: 16px;
  background: #ddd;
  font-size: 17px;
  border: none;
  cursor: pointer;
}
</style>
 
<body>

<jsp:include page="/DisplayOfferServlet"/>
		
		
		<%List<Offer> offer=(List)request.getAttribute("OfferData"); %>
    
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
            <h2>Shop</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Shop</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

    <!-- ##### Shop Area Start ##### -->
    <section class="shop-page section-padding-0-100">
        <div class="container">
            <div class="row">
                <!-- Shop Sorting Data -->
                <div class="col-12">
                    <div class="shop-sorting-data d-flex flex-wrap align-items-center justify-content-between">
                    
                   	  
      					<div class="form-outline" > 
  						<div class="form-inline" style="margin-left:630px;">
  							<input type="search" id="search" class="form-control" placeholder="Search Product" aria-label="Search" style="width:250px;  border-radius: 0px" />
  						
  							<a id="search-id">&nbsp<button type="submit" id="abc"><i class="fa fa-search"></i></button></a>
  							<span id="search-error" style="color:red;"></span>
  							
						</div>	
  						
						</div>
						
      					 
      					 

      					<!-- Search Product Area End -->
      					
                        <!-- Search by Terms -->
                       <!--  <div class="search_by_terms">
                            <form action="#" method="post" class="form-inline">
                                <select class="custom-select widget-title">
                                  <option selected>Short by Popularity</option>
                                  <option value="1">Short by Newest</option>
                                  <option value="2">Short by Sales</option>
                                  <option value="3">Short by Ratings</option>
                                </select>
                                <select class="custom-select widget-title">
                                  <option selected>Show: 9</option>
                                  <option value="1">12</option>
                                  <option value="2">18</option>
                                  <option value="3">24</option>
                                </select>
                            </form>
                        </div>
                          -->
						
                </div>
            </div>

          
                               <!-- All Products Area -->
               
              
                    <div class="shop-products-area" style="width:1000px;">
                    
                        <div class="row">
							<%int cnt=0; %>
                            <!-- Single Product Area -->
                            <%for(Product p: productList){ %>
                           
                        	<%cnt++; %>
                            <div class="col-12 col-sm-6 col-lg-4">  
                                <div class="single-product-area mb-50">
                                    <!-- Product Image -->
                                    
                                        <a href="SelectedProductDetails?id=<%=p.getId()%>" target="blank"> <img src="data:image/png;base64,<%=p.getProduct_imgstring() %>" style="width: 270px;height: 320px;" >
                                        
                                        <div class="form-control" style="border: none;" >
                                        <%for(Offer f : offer){ %>
                                    	<%if(p.getOffer_id()==f.getOffer_id() && 0!=f.getDiscount()) {%>
                                        <span class="product--badge badge--sale" data-badge-sales="">
      										Save <span data-price-percent-saved=""><%=f.getDiscount() %></span>%
  										</span>
  										<%} }%>
  										</div>
  					
                                         </a>
                                 
                                    <div class="product-info text-center" style="padding:0px;">
                                    	                                    
                                        <a href="SelectedProductDetails?id=<%=p.getId()%>" target="blank" style="width: 270px;height: 320px;">
                                            <p><%=p.getProduct_name()%></p>
                                        </a>
                                        
                                        <h6><%=p.getPrice()%> Rs</h6>
                                         
                                    </div>
                                </div>                             
                            </div>
                            <%} %>

                        </div>
						  <%int n=cnt/6; %>
						  <%int mod=cnt%6; %>
						  <%if(mod!=0){ %>
						 	<%n=n+1;%>
						  <%} %>
                        <!-- Pagination -->
                        <%-- <nav aria-label="Page navigation">
                            <ul class="pagination">
                            <%for(int i=0;i<n;i++){ %>
                                <!-- <li class="page-item"><a class="page-link" href="#">1</a></li>
                                <li class="page-item"><a class="page-link" href="#">2</a></li> -->
                                <li class="page-item"><a class="page-link" href="#"><%=i+1 %></a></li>
                               <%} %> 
                                <li class="page-item"><a class="page-link" href="#"><i class="fa fa-angle-right"></i></a></li>
                            </ul>
                        </nav> --%>
                    </div>
                </div>
              
           
        </div>
    </section>
    <!-- ##### Shop Area End ##### -->

	 

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