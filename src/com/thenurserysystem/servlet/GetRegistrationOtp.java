package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class GetRegistrationOtp
 */
public class GetRegistrationOtp extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetRegistrationOtp() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	public TheNurseryService ns=new TheNurseryServiceImpl();

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
		
		String fname=request.getParameter("fname");
		String lname=request.getParameter("lname");
		String address=request.getParameter("address");
		String email=request.getParameter("email");
		String phoneno=request.getParameter("phoneno");
		int pincode=Integer.parseInt(request.getParameter("area"));
		String password=request.getParameter("password");
		String role=request.getParameter("role");
		
		PasswordConvert p=new PasswordConvert();
		
		
		User u=new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setAddress(address);
		u.setEmail(email);
		u.setContactno(phoneno);
		u.setPincode(pincode);
		u.setPassword(password);
		u.setRole(role);
		
		String originalotp=request.getParameter("originalotp");
		String userotp=request.getParameter("otp");
		
		String dycriptotp=p.decrypt(originalotp);
		if(userotp.equals(dycriptotp))
		{
			int ans=ns.SaveUserDetails(u);
			
			
			if(ans>0)
			{
				System.out.println("User insert successfull");
				
				request.setAttribute("msg", "Your Registration Sucess..!!!");
				if(u.getRole().equalsIgnoreCase("Gardener"))
				{
					RequestDispatcher dispacher=request.getRequestDispatcher("Index.jsp");
					dispacher.forward(request, response);
				}
				else
				{
					RequestDispatcher dispacher=request.getRequestDispatcher("Login.jsp");
					dispacher.forward(request, response);
				}
			}
			else
			{
				System.out.println("User insert not successfull");
			}
		}
		else
		{
			request.setAttribute("message", "Your Otp is Invalid please Enter valid otp!!!");
			request.setAttribute("userdetails", u);
			request.setAttribute("otp",originalotp);
			RequestDispatcher dispacher=request.getRequestDispatcher("RegistrationOTPform.jsp");
			dispacher.forward(request, response);
		}
	}

}
