<%@page import="com.thenurserysystem.bean.OrderDetails"%>
<%@page import="com.thenurserysystem.bean.Service"%>
<%@page import="com.thenurserysystem.bean.ServiceBooking"%>
<%@page import="com.thenurserysystem.bean.Offer"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="descrip tion" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>The Nursery</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">
    
   <script src = "http://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
      <script src = "http://ajax.googleapis.com/ajax/libs/jqueryui/1.12.1/jquery-ui.min.js"></script>
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
</style>

<body>
    <!-- Preloader -->
    <jsp:include page="/DisplayProductServlet"/>
    <jsp:include page="/FetchTrendingProduct"/>
    <jsp:include page="/DisplayOfferServlet"/>
    <jsp:include page="/BookedPlantsRatio"/>
    <jsp:include page="/ServiceRatioServlet"/>
    <jsp:include page="/DisplayServiceDetails"/>
    <jsp:include page="/SelectUserDetails"/>
    <jsp:include page="/DisplayOrderDetails"/>
    
   <%
   List<Product> productList= (List)request.getAttribute("ProductData"); 
   List<Product> trendingproduct= (List)request.getAttribute("TrendingProduct");
   List<Offer> offer=(List)request.getAttribute("OfferData");
   List<Product> productratio= (List)request.getAttribute("ProductRatio");
   List<ServiceBooking> serviceRatio=(List)request.getAttribute("ServiceRatio");    
   List<Service> serviceList=(List)request.getAttribute("ServiceData"); 
   List<User> UserList = (List) request.getAttribute("UserData");
   List<OrderDetails> orderList=(List)request.getAttribute("OrderList");
   %>
    <div class="preloader d-flex align-items-center justify-content-center">
        <div class="preloader-circle"></div>
        <div class="preloader-img">
            <img src="img/core-img/leaf.png" alt="">
        </div>
    </div>

   

        <!-- ***** Top Header Area ***** -->
        <%@include file="Header.jsp" %>
        
       <!--  ***** End Header Area ***** -->

    <!-- ##### Hero Area Start ##### -->
    
    <section class="hero-area">
        <div class="hero-post-slides owl-carousel">

            <!-- Single Hero Post -->
            <div class="single-hero-post bg-overlay">
                <!-- Post Image -->
                <div class="slide-img bg-img" style="background-image: url(img/bg-img/1.jpg);"></div>
                <div class="container h-100">
                    <div class="row h-100 align-items-center">
                        <div class="col-12">
                            <!-- Post Content -->
                            <div class="hero-slides-content text-center">
                                <h2>Plants exist in the weather and light rays that surround them</h2>                            
                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>

            <!-- Single Hero Post -->
            <div class="single-hero-post bg-overlay">
                <!-- Post Image -->
                <div class="slide-img bg-img" style="background-image: url(img/bg-img/2.jpg);"></div>
                <div class="container h-100">
                    <div class="row h-100 align-items-center">
                        <div class="col-12">
                            <!-- Post Content -->
                            <div class="hero-slides-content text-center">
                                <h2>Plants exist in the weather and light rays that surround them</h2>
                               
                            </div>
                        </div>
                    </div>
                </div>
            </div>

        </div>
    </section>
    <!-- ##### Hero Area End ##### -->
    
     <!-- Visitor Link Start -->
     <%if(u==null){ %>
        <section class="new-arrivals-products-area bg-gray section-padding-100">
        <div class="container" style="padding:40px;">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                        <h2>Trending Products</h2>
                        <p>We have the latest products, it must be exciting for you</p>
                    </div>
                </div>
            </div>

            <div class="row">


                <%for(Product t:trendingproduct){ %>
            
                <%for(Product p: productList){ %>
                <%if(t.getId()==p.getId()) {%>               
                            
                <div class="col-12 col-sm-6 col-lg-3">
                   <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms">
                     <!--    Product Image -->
                        <div>
                        <p>user is null</p>  
                          <a href="SelectedProductDetails?id=<%=p.getId()%>" target="blank"> <img src="data:image/jpg;base64,<%=p.getProduct_imgstring() %>" style="width: 270px;height: 320px;" >
                            <div class="form-control" style="border: none; background-color: transparent;"  >
                                        <%for(Offer f : offer){ %>
                                        <%if(p.getOffer_id()==f.getOffer_id() && 0!=f.getDiscount()) {%>
                                        <span class="product--badge badge--sale" data-badge-sales="">
                                            Save <span data-price-percent-saved=""><%=f.getDiscount() %></span>%
                                        </span>
                                        <%} }%>
                                        </div>            
                          <!--   Product Tag -->
                          </a>
                        </div>
                      <!--   Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="SelectedProductDetails?id=<%=p.getId()%>">
                                <p><%=p.getProduct_name() %></p>
                            </a>
                            <h6><%=p.getPrice() %></h6>
                        </div>
                    </div>
                </div>
                            
                           
                            <%}}} %>
                
            </div>
        </div>
    </section>
    <%} %>
     <!-- Visitor Link End -->
    
    
     <!-- ##### Product Area Start ##### -->
     <!-- User Link Start -->
       <%if(u!=null && "User".equalsIgnoreCase(u.getRole())){ %>
    <section class="new-arrivals-products-area bg-gray section-padding-100">
        <div class="container" style="padding:40px;">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                        <h2>Trending Products</h2>
                        <p>We have the latest products, it must be exciting for you</p>
                    </div>
                </div>
            </div>

            <div class="row">


                <%for(Product t:trendingproduct){ %>
            
                <%for(Product p: productList){ %>
                <%if(t.getId()==p.getId()) {%>               
                 <p>user is not null and role is user</p>   
                <div class="col-12 col-sm-6 col-lg-3">
                   <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms">
                     <!--    Product Image -->
                        <div>
                          <a href="SelectedProductDetails?id=<%=p.getId()%>" target="blank"> <img src="data:image/jpg;base64,<%=p.getProduct_imgstring() %>" style="width: 270px;height: 320px;" >
                            <div class="form-control" style="border: none; background-color: transparent;"  >
                                        <%for(Offer f : offer){ %>
                                        <%if(p.getOffer_id()==f.getOffer_id() && 0!=f.getDiscount()) {%>
                                        <span class="product--badge badge--sale" data-badge-sales="">
                                            Save <span data-price-percent-saved=""><%=f.getDiscount() %></span>%
                                        </span>
                                        <%} }%>
                                        </div>            
                          <!--   Product Tag -->
                          </a>
                        </div>
                      <!--   Product Info -->
                        <div class="product-info mt-15 text-center">
                            <a href="SelectedProductDetails?id=<%=p.getId()%>">
                                <p><%=p.getProduct_name() %></p>
                            </a>
                            <h6><%=p.getPrice() %></h6>
                        </div>
                    </div>
                </div>
                            
                           
                            <%}}} %>
                
            </div>
        </div>
    </section>
    <!-- User Link End -->
    <%} %>
    
    <%int totalproduct=0; 
    int bookedproduct=0;
    int pratio=0;
    int totalService=0;
    int bookedservice=0;
    int sratio=0;
    int totaluser=0;
    int totalorder=0;
    %>
    <%for(Product p1:productList){ %>
        <%totalproduct++; %>
    <%} %>
    <%for(Product p2:productratio){ %>
        <% bookedproduct++;%>
    <%} %>
     <%for(Service s1:serviceList){ %>
        <%totalService++; %>
     <%} %>
     <%for(ServiceBooking s2:serviceRatio){ %>
        <%bookedservice++; %>
     <%} %>
     <%for(User user:UserList){ %>
        <%totaluser++; %>
     <%} %>
     <%for(OrderDetails od:orderList){ %>
        <%totalorder++; %>
     <%} %>
     
     <%if(u!=null && "Admin".equalsIgnoreCase(u.getRole())){ %>
    <section class="cool-facts-area bg-img section-padding-100-0" style="padding-top: 80px; background-image: url(img/bg-img/cool.jpg); ">
        <div class="container">
            <div class="row">
                
                 <div class="col-12 col-sm-6 col-md-3" style="padding-bottom: 30px;">
                 
                    <div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
                        <div class="cf-icon">
                            <img src="img/core-img/cf3.png" alt="">
                        </div>
                        <div class="cf-content">
                            <h2><span class="counter"><%=totaluser-1 %></span>+</h2>
                            <h6>TOTAL CLIENTS</h6>
                        </div>
                    </div>
                </div>
                <!-- Single Cool Facts Area -->
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
                        <div class="cf-icon">
                            <img src="img/core-img/cf1.png" alt="">
                        </div>
                        <div class="cf-content">
                            <h2><span class="counter"><%=totalproduct %></span></h2>
                            <h6>PRODUCT</h6>
                        </div>
                    </div>
                </div>

                <!-- Single Cool Facts Area -->
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
                        <div class="cf-icon">
                            <img src="img/core-img/cf2.png" alt="">
                        </div>
                        <div class="cf-content">
                            <h2><span class="counter"><%=totalService %></span></h2>
                            <h6>SERVICES</h6>
                        </div>
                    </div>
                </div>

                <!-- Single Cool Facts Area -->
               

                <!-- Single Cool Facts Area -->
                <div class="col-12 col-sm-6 col-md-3">
                    <div class="single-cool-fact d-flex align-items-center justify-content-center mb-100">
                        <div class="cf-icon">
                            <img src="img/core-img/cf4.png" alt="">
                        </div>
                        <div class="cf-content">
                            <h2><span class="counter"><%=totalorder %></span></h2>
                            <h6>OREDERS</h6>
                        </div>
                    </div>
                </div>

            </div>
        </div>

        <!-- Side Image -->
        <div class="side-img wow fadeInUp" data-wow-delay="500ms">
            <img src="img/core-img/pot.png" alt="">
        </div>
    </section>
    <%} %>
    <!-- ##### Cool Facts Area End ##### -->
    
    
    <!-- ##### Product Area End ##### -->

    <!-- ##### Service Area Start ##### -->
        <!-- ##### Service Area End ##### -->
   

    <!-- ##### About Area Start ##### -->
    <section class="about-us-area section-padding-100-0">
        <div class="container"  style="padding:40px;">
            <div class="row justify-content-between">
                <div class="col-12 col-lg-5">
                    <!-- Section Heading -->
                    <div class="section-heading">
                        <h2>ABOUT US</h2>
                        <p>We are leading in the plants service fields.</p>
                    </div>
                    <p>The Nursery can be designed for a wide variety of usesand can be used by individuals, organization and anyone.Using this web application user can
search for any indoor, outdoor, and decorated plants, fertilizers,pots and seeds </p>
                   
                        <%
                        //System.out.println("Total product :- "+totalproduct);
                        //System.out.println("Booked Product :- "+bookedproduct);
                        int ans=bookedproduct*100;
                        if(totalproduct>0)
                        {
                            pratio=ans/totalproduct;
                            //System.out.println("Ratio :- "+pratio);
                        }
                        %>
                         <!-- Progress Bar Content Area -->
                    <div class="alazea-progress-bar mb-50">
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar">
                           
                            <div id="bar1" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="<%=pratio%>"></span>
                                
                            </div>
                             <p>Plants</p>
                        </div>
                        
                       
                        <%
                        //System.out.println("Total Service :- "+totalService);
                        //System.out.println("Booked Service :- "+bookedservice);
                        int ans1=bookedservice*100;
                        if(totalService>0){
                        sratio=ans1/totalService;
                        //System.out.println("Servce Ratio :- "+sratio);
                        }%>
                        <!-- Single Progress Bar -->
                        <div class="single_progress_bar">
                            
                            <div id="bar3" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="<%=sratio%>"></span>
                            </div>
                            <p>Services</p>
                        </div>

                        <!-- Single Progress Bar -->
                        <!-- <div class="single_progress_bar">
                            <p>FAQs</p>
                            <div id="bar4" class="barfiller">
                                <div class="tipWrap">
                                    <span class="tip"></span>
                                </div>
                                <span class="fill" data-percentage="65"></span>
                            </div>
                        </div> -->
                    </div>
                </div>

                <div class="col-12 col-lg-6">
                    <div class="alazea-benefits-area">
                        <div class="row">
                            <!-- Single Benefits Area -->
                            <div class="col-12 col-sm-6">
                                <div class="single-benefits-area">
                                    <img src="img/core-img/b1.png" alt="">
                                    <h5>Quality Products</h5>
                                </div>
                            </div>

                            <!-- Single Benefits Area -->
                            <div class="col-12 col-sm-6">
                                <div class="single-benefits-area">
                                    <img src="img/core-img/b2.png" alt="">
                                    <h5>Perfect Service</h5>
                                </div>
                            </div>

                            <!-- Single Benefits Area -->
                            <div class="col-12 col-sm-6">
                                <div class="single-benefits-area">
                                    <img src="img/core-img/b3.png" alt="">
                                    <h5>100% Natural</h5>
                                </div>
                            </div>

                            <!-- Single Benefits Area -->
                            <div class="col-12 col-sm-6">
                                <div class="single-benefits-area">
                                    <img src="img/core-img/b4.png" alt="">
                                    <h5>Environmentally friendly</h5>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        
    </section>
   

    <!-- ##### Subscribe Area Start ##### -->

        
       
    </section>
    <!-- ##### Subscribe Area End ##### -->

   
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
