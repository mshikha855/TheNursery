<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.thenurserysystem.bean.Question"%>
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta name="description" content="">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <!-- The above 4 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    

    <!-- Title -->
    <title>Ask-Question</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="style.css">
    
  
  

</head>

<body>
<jsp:include page="/FetchQuestionDetails"/>
<jsp:include page="/SelectUserDetails"/>
<jsp:include page="/DisplayGardenerServlet"/>
<%List<Question> questionList = (List) request.getAttribute("QuestionList"); 
List<User> UserList = (List) request.getAttribute("UserData");
List<User> GardenerList = (List) request.getAttribute("GardenerData");

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
        <div class="top-breadcrumb-area bg-img bg-overlay d-flex align-items-center justify-content-center " style="background-image: url(img/bg-img/24.jpg);">
           <h2>Questions</h2>
        </div>

        <div class="container">
            <div class="row">
                <div class="col-12">
                    <nav aria-label="breadcrumb">
                        <ol class="breadcrumb">
                            <li class="breadcrumb-item"><a href="#"><i class="fa fa-home"></i> Home</a></li>
                            <li class="breadcrumb-item active" aria-current="page">Ask-Questions</li>
                        </ol>
                    </nav>
                </div>
            </div>
        </div>
    </div>
    	<%int cnt=0; %>
     			<div style="padding: 0px 200px 50px 200px;">
    						<div class="comment_area clearfix">
    						<%for(Question q:questionList){ %>
                              <%cnt++; %>
                       
							 <%} %>
                       			 <h4 class="headline"><%=cnt%> Comments</h4>     
                                   <ol>
                                <%for(Question q:questionList){ %>
                              
                                <li class="single_comment_area">
                                    <div class="comment-wrapper d-flex">
                                        <!-- Comment Meta -->
                                        <div class="comment-author">
                                            <img src="img/bg-img/question.jpg" alt="">
                                          		 
                                        </div>
                                        <!-- Comment Content -->
                                        <div class="comment-content">	
                                            <div class="d-flex align-items-center justify-content-between">
                                           <h5>
                                            <%for(User u1:UserList){ %>
                               					
                               					<%if(u1.getUserid()==q.getUserId()){ %>
                                                
                                                	<%=u1.getFname()%> <%=u1.getLname() %>
                               						
                               						
                               						<% if(u.getUserid()==q.getUserId()){ %>
                               							
                               						<a href="DeleteQuestionDetails?id=<%=q.getQuestionId()%>">	<i class="fa fa-trash" style="color: red; font-size:20px; padding-left: 100px;"></i>&nbsp&nbsp&nbspDelete</a>
                               						
                               						<%} %>
                               					
                               					<%} %>
                               					
                               					
                               				
                               				<%} %>
                               				
                               				
                               				</h5> 
                               				         
                               					<%-- <h5><%=q.getUserId()%></h5> --%>
                               					  
                                                <span class="comment-date"></span>
                                                
                                            </div>
                                            <p><%=q.getQuestionDetails() %></p>
                                           <!--  <a class="active" href="#">Reply</a> -->
                                        </div>
                                    </div>
                                    	<%if(q.getAnswer()!=null) {%>
                                    <ol class="children">
                                        <li class="single_comment_area">
                                            <div class="comment-wrapper d-flex">
                                                <!-- Comment Meta -->
                                                <div class="comment-author">
                                                    <img src="img/bg-img/Answer.jpg" alt="">
                                                </div>
                                                <!-- Comment Content -->
                                                <div class="comment-content">
                                                    <div class="d-flex align-items-center justify-content-between">
                                                       <%for(User g1:GardenerList){ %>
                                                        <%if(q.getGardenerId()==g1.getUserid()){%>
                                                        	<h5><%=g1.getFname() %>&nbsp<%=g1.getLname() %>&nbsp&nbsp&nbsp<sup style="color: green;">(Gardener)</sup></h5>
                                                        <%}}%>
                                                        
                                                        <span class="comment-date"></span>
                                                    </div>
                                                    <!-- <p style="display: flex; border: 1px solid Green;"><input type="text" style="border: 0em;"><i class='fas fa-caret-square-right' style='font-size:36px'></i></p> -->
                                               	
                                               
                                               		<p><%=q.getAnswer() %></p>
                                               
                                                </div>
                                            </div>
                                        </li>
                                    </ol>
                                    <%}%>
                                    
                                </li>
                               
                                           <%} %>
                             
                              </ol>
                        </div>

                        <!-- Leave A Comment -->
                        <div class="leave-comment-area clearfix">
                            <div class="comment-form">
                                <h4 class="headline">Leave A Comment</h4>

                                <div class="contact-form-area">
                                    <!-- Comment Form -->
                                    <form action="StoreQuestionDetails" method="post">
                                        <div class="row">
                                            <!-- <div class="col-12 col-md-6">
                                                <div class="form-group">
                                                    <input type="text" class="form-control" id="contact-name" placeholder="Name">
                                                </div>
                                            </div>
                                            <div class="col-12 col-md-6">
                                                <div class="form-group">
                                                    <input type="email" class="form-control" id="contact-email" placeholder="Email">
                                                </div>
                                            </div>
 -->                                            <div class="col-7">
                                                <div class="form-group">
                                                    <textarea class="form-control" name="message"  data-missing="This field is required" id="message" cols="15" rows="5" placeholder="Comment" required></textarea>
                                                </div>
                                            </div>
                                            
                                            <input type="hidden" value="<%= (new java.util.Date()).toLocaleString()%>" name="time">
                                            <div class="col-12">
                                                <button type="submit" class="btn alazea-btn">Post Comment</button>
                                            </div>
                                        </div>
                                    </form>
                                </div>
                            </div>
                        </div>
                        </div>
     
    
    
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
    <script src="js/jquery.validity.min.js"></script>
	<script src="js/script.js"></script>
    
</body>

</html>