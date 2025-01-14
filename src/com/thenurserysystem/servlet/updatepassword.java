package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class updatepassword
 */
public class updatepassword extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TheNurseryService ns = new TheNurseryServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updatepassword() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		String password=request.getParameter("currentpassword");
		HttpSession httpsession=request.getSession(false);  
		User u=(User) httpsession.getAttribute("loginDetails");  
		PasswordConvert pc=new PasswordConvert();
		String oldpassword=pc.decrypt(u.getPassword());
		System.out.println(oldpassword);
		System.out.println(password);
		if(oldpassword.equals(password))
		{
			response.getWriter().append("true");
		}
		else
		{
			response.getWriter().append("false");
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String userid=request.getParameter("userid");
		String password=request.getParameter("password");
		
	
		System.out.println("User id= "+ userid);
		System.out.println("password ="+password);
		
		PasswordConvert pc=new PasswordConvert();
		String encryptedpassword=pc.encrypt(password);
		int ans=ns.updatepassworddetails(userid, encryptedpassword);
		
		System.out.println("ans = "+ans);
			
			if(ans>0)
			{
				request.setAttribute("msg","Password change successfully..");
			
				RequestDispatcher dispacher=request.getRequestDispatcher("updatepassword.jsp");
				dispacher.forward(request, response);
			}
	}

}
