package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;


/**
 * Servlet implementation class SelectUserDetails
 */
public class SelectUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TheNurseryService ns=new TheNurseryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<User>user=ns.selectUserDetails();
		
		request.setAttribute("UserData",user);
		
		System.out.println(user);
		
		/*RequestDispatcher dispatche=request.getRequestDispatcher("SelectData.jsp");
		
		dispatche.forward(request, response);*/
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
