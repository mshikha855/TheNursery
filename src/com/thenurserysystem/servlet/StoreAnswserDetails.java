package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.Question;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.service.impl.QuestionServiceImpl;

/**
 * Servlet implementation class StoreAnswserDetails
 */
public class StoreAnswserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	QuestionService qs=new QuestionServiceImpl();
	
	
    public StoreAnswserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		HttpSession httpSession=request.getSession(false);
		
		User u1=(User) httpSession.getAttribute("loginDetails");
		
		String questionid=request.getParameter("questionid");
		
		String answer=request.getParameter("answer");
	
		System.out.println("Answer"+answer);
	
		Question q=new Question();
	
		q.setAnswer(answer);
		
		q.setGardenerId(u1.getUserid());
	
		System.out.println(u1.getUserid());
		
		int ans=qs.saveAnswerDetails(questionid,q);
		
		if(ans>0)
		{
			System.out.println("Answer store sucessfully");
			response.sendRedirect("ReplyQuestions.jsp");
		}
		else
		{
			System.out.println("Anser Cannot store");
		}
		
		}
		
		
	}

