package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.Question;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.service.impl.QuestionServiceImpl;

public class StoreQuestionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuestionService qs=new QuestionServiceImpl();
   
    public StoreQuestionDetails() {
        super();
        
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession httpSession=request.getSession(false);
		
		//code added to handle null pointer exception on 21-01-2025
		if (httpSession == null) {
	        // Handle missing session (e.g., redirect to login or error page)
	        response.sendRedirect("login.jsp");
	        return;
	    }
		
		User u1=(User) httpSession.getAttribute("loginDetails");
		
		//code added to handle null pointer exception on 21-01-2025
		if (u1 == null) {
	        // Handle missing user details in the session
	        response.sendRedirect("login.jsp");
	        return;
	    }
		
		String question=request.getParameter("message");
		
		String time=request.getParameter("time");
		
		System.out.println(time);
		
		int userid=u1.getUserid();
		
		Question q=new Question();
		
		q.setQuestionDetails(question);
		
		q.setUserId(userid);

	
		int ans=qs.saveQuestionDetails(q);
		
		if(ans>0)
		{
			
			System.out.println("Question store");
		}
		else
		{
			System.out.println("Question cannto store");
		}
	
		response.sendRedirect("Question.jsp");
	}

}
