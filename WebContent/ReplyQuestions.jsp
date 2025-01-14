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
    <title>Reply Question</title>

    <!-- Favicon -->
    <link rel="icon" href="img/core-img/favicon.ico">

    <!-- Core Stylesheet -->
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
    <link rel="stylesheet" href="style.css">
    <script src='https://kit.fontawesome.com/a076d05399.js' crossorigin='anonymous'></script>
    

</head>

<body>
<jsp:include page="/FetchAvailableQuestionDetails"/>
<jsp:include page="/SelectUserDetails"/>

<%List<Question> questionList = (List) request.getAttribute("QuestionList"); 
List<User> UserList = (List) request.getAttribute("UserData");



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
                            <li class="breadcrumb-item active" aria-current="page">Reply-Questions</li>
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
                                                        <h5><%=u.getFname()%></h5>	
                                                        <span class="comment-date"></span>
                                                    </div>
                                                    <!-- <p style="display: flex; border: 1px solid Green;"><input type="text" style="border: 0em;"><i class='fas fa-caret-square-right' style='font-size:36px'></i></p> -->
                                               
                                                <form action="StoreAnswserDetails" method="post">
                                                
                                                <input type="hidden" name="questionid" value="<%=q.getQuestionId()%>">
                                                   
                                                   <p style="display: flex; ">
                                                  
                                                  
                                                   <input id="name2" name="answer" class="form-control input-group-lg reg_name" data-missing="This field is required" type="text" required style="width: 200px; "> 
                                                   
                                                   <button type="submit" style="border: 0px; cursor:pointer; background-color: white; color: green;">
                                                   
                                                   		<!-- <i class='fa fa-paper-plane'  style='font-size:25px; padding: 0px 0px 0px 10px; '></i>
                                                   		 -->
                                                   		 <i class='fa fa-reply'  style='font-size:25px; padding: 0px 0px 0px 10px; '></i>
                                                   		
                                                   </button>
                                                   
                                                   </p>
                                               
                                                </form> 
                                                
                                                </div>
                                            </div>
                                        </li>
                                    </ol>
                                </li>
                               
                               
                           
                             <%} %>
                              </ol>
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
</body>

</html>