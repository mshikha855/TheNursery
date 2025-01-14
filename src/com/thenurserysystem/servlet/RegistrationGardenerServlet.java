package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Generatotp;
import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;
import com.thenurserysystem.util.ThreadEmail;

/**
 * Servlet implementation class RegistrationGardenerServlet
 */
public class RegistrationGardenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TheNurseryService ns=new TheNurseryServiceImpl();
    public RegistrationGardenerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String email=request.getParameter("email");
		
		int ans=ns.Checkemaildetails(email);
		if(ans==0)
		{
			response.getWriter().append("false");
		}
		else
		{
			response.getWriter().append("true");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		
		User u=new User();
		u.setFname(fname);
		u.setLname(lname);
		u.setAddress(address);
		u.setEmail(email);
		u.setContactno(phoneno);
		u.setPincode(pincode);
		u.setPassword(encryptedpassword);
		u.setRole("Gardener");
		Generatotp gotp=new Generatotp();
		String otp=gotp.random(6);
		String msg = "<h1>Dear, " + u.getFname() + "</h1>";
		msg+="\n<font color=green size=5>Your Registration OTP ! </font>\n\n<h3>YOUR OTP IS  ::  "+ otp + "</h3>";
		ThreadEmail threadEmail = new ThreadEmail();
		threadEmail.Send(u.getEmail(),msg);
		Thread t1 = new Thread(threadEmail);
		t1.start();
		
		String encryptotp=p.encrypt(otp);
		
		request.setAttribute("otp", encryptotp);
		request.setAttribute("userdetails", u);
		RequestDispatcher dispacher=request.getRequestDispatcher("RegistrationOTPform.jsp");
		dispacher.forward(request, response);

	}

}
