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
 * Servlet implementation class LoginDetailsServlet
 */
public class LoginDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	TheNurseryService ns=new TheNurseryServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginDetailsServlet() {
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
		
		
		String email=request.getParameter("email");
		String password=request.getParameter("password");
		PasswordConvert p=new PasswordConvert();
		String encryptedpassword=p.encrypt(password);
		User u=new User();
		u.setEmail(email);
		u.setPassword(encryptedpassword);
		
		User u1=ns.CheckLoginDetails(u);
		
		if(u1.getEmail()!=null && u1.getPassword()!=null  && u1.getStatus()==1)
		{
			
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("loginDetails", u1);
			RequestDispatcher dispacher=request.getRequestDispatcher("Index.jsp");
			dispacher.forward(request, response);
		}
		/*else if(u1.getRole()=="Admin")
		{
			HttpSession httpSession=request.getSession();
			httpSession.setAttribute("Adminlogin", u1);
			RequestDispatcher dispacher=request.getRequestDispatcher("Index.jsp");
			dispacher.forward(request, response);
		}*/
		else
		{
			request.setAttribute("message", "Please Enter Valid Email Or Password!!!try again");
			RequestDispatcher dispacher=request.getRequestDispatcher("Login.jsp");
			dispacher.forward(request, response);
		}
	}

}
