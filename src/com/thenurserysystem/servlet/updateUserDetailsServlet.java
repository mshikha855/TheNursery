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
 * Servlet implementation class updateUserDetailsServlet
 */
public class updateUserDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	public TheNurseryService ns=new TheNurseryServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public updateUserDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
			}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int userid=Integer.parseInt(request.getParameter("userid"));
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		int pincode=Integer.parseInt(request.getParameter("area"));
		String password=request.getParameter("password");
		String encryptedpassword;
		PasswordConvert p=new PasswordConvert();
		encryptedpassword=p.encrypt(password);
		
		String role=request.getParameter("role");
		
		User u=new User();
		u.setUserid(userid);
		u.setFname(fname);
		u.setLname(lname);
		u.setAddress(address);
		u.setEmail(email);
		u.setContactno(phoneno);
		u.setPincode(pincode);
		u.setPassword(encryptedpassword);
		u.setRole(role);
	
		
		int s=ns.updateUserDetail(u);
		
		if(s>0)
		{
			HttpSession httpsession=request.getSession(false);
			httpsession.setAttribute("loginDetails",u);
			request.setAttribute("message", "YOUR PROFILE IS CHANGED SUCCESSFUL");
			RequestDispatcher dispacher=request.getRequestDispatcher("EditProfileServlet");
			dispacher.forward(request, response);
		}
		
	}

}