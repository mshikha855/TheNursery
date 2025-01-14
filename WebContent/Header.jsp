<%@page import="java.util.List"%>
<%@page import="com.thenurserysystem.bean.Category"%>
<%@page import="com.thenurserysystem.bean.Product"%>
<%@page import="com.thenurserysystem.bean.User"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<script>
   
</script>

  
</head>
<body>

	<jsp:include page="/CategoryandSubcategoryDisplay"/>
	
	<%List<Category> category= (List)request.getAttribute("CategoryList"); %>
	<%List<Category> subcat= (List)request.getAttribute("SubCategoryList"); %>

 <!-- ##### Header Area Start ##### -->
 <header class="header-area">
 <div class="top-header-area">
            <div class="container">
                <div class="row">
                    <div class="col-12">
                        <div class="top-header-content d-flex align-items-center justify-content-between">
                            <!-- Top Header Content -->
                            <div class="top-header-meta">
                                <a href="https://mail.google.com/mail/u/0/#inbox?compose=GTvVlcSKjRLNLjDMxVjRKFcjdWSSVkfdbWDpvDCxGHDkjJkDPdkCsCfTSbmJNqdGmdgVnsFZmslCV" data-toggle="tooltip" data-placement="bottom" target="_blank" title="infothenursery01@gmail.com"><i class="fa fa-envelope-o" aria-hidden="true"></i> <span>Email: infothenursery01@gmail.com</span></a>
                            </div>

                            <!-- Top Header Content -->
                            <div class="top-header-meta d-flex">
                                <!-- Language Dropdown -->
                                
                                <%HttpSession httpSession=request.getSession(false);
                                User u=(User) httpSession.getAttribute("loginDetails");
                                %>	
                                <%if(null!=u && "User".equalsIgnoreCase(u.getRole())){%>  
                               	
                                <!-- Cart -->
                                <div class="cart">
                                    <a href="Cart.jsp"><i class="fa fa-shopping-cart" aria-hidden="true"></i> <span>Cart <span class="cart-quantity"></span></span></a>
                                </div>
                                <%} %>
                                <!-- Edit Profile -->
                                
                                 <%if(null!=httpSession.getAttribute("loginDetails")){%>
                                 <div class="cart" style="margin-left: 30px;">
                                		 <a href="EditProfileServlet?id=<%=u.getUserid()%>"><i class="fa fa-edit" aria-hidden="true"></i> <span>Profile</span></a>
                                </div>
                                <%} %>  
                                
                                
                                 <!-- Login -->
                               
                                <%if(null==httpSession.getAttribute("loginDetails")){%>
                                <div class="cart" style="margin-left: 30px;">
                                    
                                    <a href="Login.jsp"><i class="fa fa-sign-in" aria-hidden="true"></i> <span>Login</span></a>
                                    
  
                                </div>
                               
                                <%}else{ %>
                                <div class="cart" style="margin-left: 30px;">
                                    <a href="LogoutServlet"><i class="fa fa-sign-out" aria-hidden="true"></i> <span>Logout</span></a>
                                    
                                </div>
                                
                                <div class="cart" style="margin-left: 30px;">
                                    
                                  <a herf="#"> <i class="fa fa-user-circle" aria-hidden="true" ></i><span>      Welcome, <%=u.getFname()%> <%=u.getLname() %></span> </a>
                                    
                                </div>
                                <%} %>  
                                      
                                                
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>

        <!-- ***** Navbar Area ***** -->
        <div class="alazea-main-menu">
            <div class="classy-nav-container breakpoint-off">
                <div class="container">
                    <!-- Menu -->
                    <nav class="classy-navbar justify-content-between" id="alazeaNav">

                        <!-- Nav Brand -->
                        <a href="Index.jsp" class="nav-brand"><img src="img/core-img/Logo.png" alt=""></a>

                        <!-- Navbar Toggler -->
                        <div class="classy-navbar-toggler">
                            <span class="navbarToggler"><span></span><span></span><span></span></span>
                        </div>

                        <!-- Menu -->
                        <div class="classy-menu">

                            <!-- Close Button -->
                            <div class="classycloseIcon">
                                <div class="cross-wrap"><span class="top"></span><span class="bottom"></span></div>
                            </div>

                            <!-- Navbar Start -->
                            <div class="classynav">
                                <ul>
                                    <li><a href="Index.jsp" >Home</a></li>
                                 
                                   <% if(null!=u && !("Admin".equalsIgnoreCase(u.getRole()) || "Gardener".equalsIgnoreCase(u.getRole()))) {%>   
                                  <li>   
                                    <a>Shop</a>
                                    
                                    <ul class="dropdown">
                             		<%for(Category cate : category){ 
                             		 if(cate.getStatus()!=0){ %>       
                                    <li><a><%=cate.getCat_name() %></a>
                                    <ul class="dropdown">
                                    
                                    
                                    <%for(Category subcategory : subcat){ %>
                                    <%if(cate.getCat_id()==subcategory.getCat_id() && subcategory.getStatus()!=0){ %>
                                    <li><a href="FetchProductDetails?id=<%=subcategory.getSubcat_id()%>" target="blank"><%=subcategory.getCat_name() %></a></li>
                                    <%} %>
                                    <%} %>
                                    </ul>
                                    </li>
                                    <%}} %>
                                    </ul>    
                                    
                                    
                                     <%}%>
                                   
                                    
                                  
                                   <%if(null!=u && "User".equalsIgnoreCase(u.getRole())){%>
                                    	<li><a href="Service.jsp">Service</a></li>
                                    
                                    	 <li><a href="Question.jsp" target="blank">Ask-Question</a></li>
                                    	 <li><a>View Order</a>
                                    	 <ul class="dropdown">
                                    	  <li><a href="ViewUserOrder.jsp" target="blank">Product Order </a></li>
                                    	  <li><a href="BookedServiceDetails.jsp" target="blank">Service Order </a></li>
                                    	  </ul>
                                    	  </li>
                                     <li><a href="Contact.jsp">Contact</a></li>
                                   
                                   
                                   <%}%>
                                    <%if(null==u){%> 
                                    
                                    <li><a>Shop</a>
                                    
                                    <ul class="dropdown">
                             		<%for(Category cate : category){ %>       
                                    <li><a><%=cate.getCat_name() %></a>
                                    <ul class="dropdown">
                                    
                                    
                                    <%for(Category subcategory : subcat){ %>
                                    <%if(cate.getCat_id()==subcategory.getCat_id()){ %>
                                    <li><a href="FetchProductDetails?id=<%=subcategory.getSubcat_id()%>" target="blank"><%=subcategory.getCat_name() %></a></li>
                                    <%} %>
                                    <%} %>
                                    </ul>
                                    </li>
                                    <%} %>
                                    </ul>    
                                    
                                   
                                    <li><a href="ViewQuestion.jsp" target="blank">View-Question</a></li>
                                   
                                   
                                     <li><a href="Contact.jsp">Contact</a></li>
                                   
                                   
                                   <%} %>
                                    <%if(null!=u && "Admin".equalsIgnoreCase(u.getRole())){%> 
                                     	
                                     	<li><a href="#">Lists</a>
                                                 <ul class="dropdown">
                                     
                                                   <li><a href="SelectData.jsp">User List</a></li>
                                     	
			                                     	<li><a href="CategoryList.jsp">Category List</a></li>
			                                     	
			                                   		<li><a href="SubCategoryList.jsp">SubCategory List</a></li>
			                                    	
			                                    	<li><a href="ProductList.jsp">Product List</a></li>
			                              	
			                                    	<li><a href="GalleryList.jsp">Gallery List</a></li> 
			                                    	
                                    	 			<li><a href="OfferList.jsp">Offer List</a></li>
                                    	 			
                                    	 			<li><a href="ServiceList.jsp">Service List</a></li>
                                    	 			
                                    	 			<li><a href="OrderList.jsp">Order List</a></li>
                                    	 			
                                    	 			<li><a href="BookedServiceList.jsp">Booked Service List</a></li>
                                    	 			
                                    	 			<li><a href="FeedbackList.jsp">Rating List</a></li>
                                    	 		</ul>
                                    	 		</li>
                                    	 		
                                    	 		
                                    	 	<li><a href="#">Gardener</a>
                                                 <ul class="dropdown">
                                     
                                                   <li><a href="RegisterGardener.jsp" target="blank">Register Gardener</a></li>
			                              
                                    	 		</ul>
                                    	 		</li>
                                    	 			
                                    	 	
                                    	
                                      <%} %>
                                      
                                      
                                      <%if(null!=u && "Gardener".equalsIgnoreCase(u.getRole())){ %>	
                                     
                                     	<li><a href="ReplyQuestions.jsp" target="blank">Reply Question</a></li>
                                     	<li><a href="ServiceListofGardener.jsp">Show your Assigned Services</a>
                                     <%} %>
                                     
                               
 								</ul>
                                
                                <!-- <div id="searchIcon">
                                    <i class="fa fa-search" aria-hidden="true"></i>
                                </div> 
                                  -->

                            </div>
                            <!-- Navbar End -->
                        </div>
                    </nav>

                     <!-- Search Form -->
                     
                    <!-- <div class="search-form">
                         <form style="padding: 0px;">
                            <input type="search" id="automplete-1" placeholder="Type keywords &amp; press enter..." style="height: 50px;"  >    
                           
                        </form>
                        
                         
                    </div> -->
                 
                </div>
            </div>
        </div>
    </header>
</body>
</html>