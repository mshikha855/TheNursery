<%@page import="com.thenurserysystem.bean.Service"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <!-- Title -->
    <title>Service</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">
    
<style>
img:hover {
  /* Start the shake animation and make the animation last for 0.5 seconds */
  animation: shake 0.5s;

  /* When the animation is finished, start again */
  animation-iteration-count: infinite;
}

@keyframes shake {
  0% { transform: translate(1px, 1px) rotate(0deg); }
  10% { transform: translate(-1px, -2px) rotate(-1deg); }
  20% { transform: translate(-3px, 0px) rotate(1deg); }
  30% { transform: translate(3px, 2px) rotate(0deg); }
  40% { transform: translate(1px, -1px) rotate(1deg); }
  50% { transform: translate(-1px, 2px) rotate(-1deg); }
  60% { transform: translate(-3px, 1px) rotate(0deg); }
  70% { transform: translate(3px, 1px) rotate(-1deg); }
  80% { transform: translate(-1px, -1px) rotate(1deg); }
  90% { transform: translate(1px, 2px) rotate(0deg); }
  100% { transform: translate(1px, -2px) rotate(-1deg); }
}
</style>
    
   

</head>

<body>
<jsp:include page="/DisplayServiceDetails"/>
<%
		List<Service> serviceList = (List) request.getAttribute("ServiceData");
		
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
           <h2>Service</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Services</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    <!-- ##### Breadcrumb Area End ##### -->

	
	<section class="new-arrivals-products-area bg-gray section-padding-100" style="background-color:white; ">
        <div class="container" style="padding:60px;">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                        <h2>OUR SERVICES</h2>
                        <p>We Provide a best services for you</p>
                    </div>
                </div>
            </div>

            <div class="row" >
			
			<%for(Service s:serviceList){ %>
			<div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms" style="">
                   
                        <div class="">
                            <a><img src="data:image/png;base64,<%=s.getServiceImageString()%>" alt="" style="width: 320px; height: 200px;"></a>
                            <div class="product-meta d-flex">
                            
                            </div>
                        </div>
                      
                        <div class="product-info mt-15 text-center">
                            <a>
                                <p><%=s.getServiceDetails() %></p>
                            </a>
                            <h6><%=s.getServiceAmount() %> Rs</h6>
                        </div>
                        <div class="checkout-btn mt-30">
                            <a href="ServiceDetailsServlet?id=<%=s.getServiceId()%>"><button class="btn alazea-btn w-100">Book Service</button></a>
                        </div>
                    </div>
                </div>
			
			<%} %>
                <!-- Single Product Area -->
              <!--   <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms" style="">
                        Product Image
                        <div class="product-img">
                            <a><img src="img/bg-img/9.jpg" alt=""></a>
                            <div class="product-meta d-flex">
                            
                            </div>
                        </div>
                        Product Info
                        <div class="product-info mt-15 text-center">
                            <a>
                                <p>Nursery Plant Service</p>
                            </a>
                            <h6>200 Rs</h6>
                        </div>
                        <div class="checkout-btn mt-30">
                            <button class="btn alazea-btn w-100">Book Service</button>
                        </div>
                    </div>
                </div>

				
                <!--<div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms">
                        Product Image
                        <div class="product-img">
                            <a><img src="img/bg-img/9.jpg" alt=""></a>
                            <div class="product-meta d-flex">
                            
                            </div>
                        </div>
                        Product Info
                        <div class="product-info mt-15 text-center">
                            <a>
                                <p>Home Decoration</p>
                            </a>
                            <h6>200 Rs</h6>
                        </div>
                        <div class="checkout-btn mt-30">
                            <button class="btn alazea-btn w-100">Book Service</button>
                        </div>
                    </div>
                </div>
				
				
				Single Product Area
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms">
                        Product Image
                        <div class="product-img">
                            <a><img src="img/bg-img/9.jpg" alt=""></a>
                            <div class="product-meta d-flex">
                            
                            </div>
                        </div>
                        Product Info
                        <div class="product-info mt-15 text-center">
                            <a>
                                <p>Gardens Service</p>
                            </a>
                            <h6>200 Rs</h6>
                        </div>
                        <div class="checkout-btn mt-30">
                            <button class="btn alazea-btn w-100">Book Service</button>
                        </div>
                    </div>
                </div>
				
				
				Single Product Area
                <div class="col-12 col-sm-6 col-lg-3">
                    <div class="single-product-area mb-50 wow fadeInUp" data-wow-delay="100ms">
                        Product Image
                        <div class="product-img">
                            <a><img src="img/bg-img/9.jpg" alt=""></a>
                            <div class="product-meta d-flex">
                            
                            </div>
                        </div>
                        Product Info
                        <div class="product-info mt-15 text-center">
                            <a>
                                <p>Home Plants Service</p>
                            </a>
                            <h6>200 Rs</h6>
                        </div>
                        <div class="checkout-btn mt-30">
                            <button class="btn alazea-btn w-100">Book Service</button>
                        </div>
                    </div>
                </div>
            </div> -->
            
            <div class="container">
            <div class="row">
                <div class="col-12">
                    <!-- Section Heading -->
                    <div class="section-heading text-center">
                       	<br><br><br>
                       	<h1>SERVICE INFO</h1>
 						<br><br><br>                       
                    </div>
                </div>
            </div>

            <div class="row justify-content-between">
                <div class="col-12 col-lg-5">
                    <div class="alazea-service-area mb-100">

                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center wow fadeInUp" data-wow-delay="100ms">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="img/core-img/s1.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                <h5>Plants Care</h5>
                                <p>There are plenty of ways to care for your plant. With the help of our plant experts, we have weeded out the Top Ten Tips for healthy, happy plants..</p> </div>
                        </div>

                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center wow fadeInUp" data-wow-delay="300ms">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="img/core-img/s2.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                <h5>Pressure Washing</h5>
                                <p> While you should still protect your plants, the harsher the cleaning process and chemicals, the more protection you should have in place..</p>  </div>
                        </div>

                        <!-- Single Service Area -->
                        <div class="single-service-area d-flex align-items-center wow fadeInUp" data-wow-delay="500ms">
                            <!-- Icon -->
                            <div class="service-icon mr-30">
                                <img src="img/core-img/s3.png" alt="">
                            </div>
                            <!-- Content -->
                            <div class="service-content">
                                 <h5>Plant Service &amp; Trimming</h5>
                                <p>Plant Service is the most important aspect for your garden and plant.</p>
                             </div>
                        </div>

                    </div>
                </div>

                <div class="col-12 col-lg-6">
                    <div class="alazea-video-area bg-overlay mb-100">
                    <iframe width="560" height="315" src="https://www.youtube.com/embed/i2luQk0IYAg" frameborder="0" allow="accelerometer; autoplay; clipboard-write; encrypted-media; gyroscope; picture-in-picture" allowfullscreen></iframe>                       
                    
                                            </div>
                </div>
            </div>
        </div>
        
        </div>
    </section>
	
	
	
	
    <!-- ##### About Area Start ##### -->
    <section class="about-us-area">
        <div class="container">
            <div class="row justify-content-between">
                <div class="col-12 col-lg-5">
        </div>
	</div>
      </div>
    </section>
    <!-- ##### About Area End ##### -->

    <!-- ##### Service Area Start ##### -->
   
    <!-- ##### Service Area End ##### -->

    <!-- ##### Testimonial Area Start ##### -->
    <section class="testimonial-area section-padding-100">
        <div class="container">
            <div class="row">
                <div class="col-12">
                    <div class="testimonials-slides owl-carousel">

                        
                        
                        
                    </div>
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