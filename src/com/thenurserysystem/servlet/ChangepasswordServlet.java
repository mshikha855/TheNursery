package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class ChangepasswordServlet
 */
public class ChangepasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public TheNurseryService ns=new TheNurseryServiceImpl();
	
    public ChangepasswordServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
	
		System.out.println("User id= "+ userid);
		System.out.println("password ="+password);
		
		PasswordConvert pc=new PasswordConvert();
		String encryptedpassword=pc.encrypt(password);
		int ans=ns.updatepassworddetails(userid, encryptedpassword);
		
		System.out.println("ans1 = "+ans);
			
			if(ans>0)
			{
				request.setAttribute("msg","Password change successful!!!");
			
				RequestDispatcher dispacher=request.getRequestDispatcher("ExistingPassword.jsp");
				dispacher.forward(request, response);
			}
		
	}

}
