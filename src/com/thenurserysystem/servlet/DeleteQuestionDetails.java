package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.service.impl.QuestionServiceImpl;

/**
 * Servlet implementation class DeleteQuestionDetails
 */
public class DeleteQuestionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionService qs=new QuestionServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteQuestionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String queid=request.getParameter("id");
		
		int ans=qs.deleteQuestionDetails(queid);
		
		if(ans>0)
		{
			System.out.println("Delete question Sucess");
			response.sendRedirect("Question.jsp");
		}
		else
		{
			System.out.println("Question cannot delete");
		}
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
