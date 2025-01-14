package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Question;
import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.service.impl.QuestionServiceImpl;

/**
 * Servlet implementation class FetchAvailableQuestionDetails
 */
public class FetchAvailableQuestionDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	QuestionService qs=new QuestionServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchAvailableQuestionDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Question> questionlist=qs.fetchAvailableQuestionDetails();
		
		request.setAttribute("QuestionList", questionlist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
