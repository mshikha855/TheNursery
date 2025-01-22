package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.Generatotp;
import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.SendEmail;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;
import com.thenurserysystem.util.ThreadEmail;

/**
 * Servlet implementation class ForgetpasswordServlet
 */
public class ForgetpasswordServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	TheNurseryService ns = new TheNurseryServiceImpl();
	
	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public ForgetpasswordServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String email = request.getParameter("email");

		int n = ns.Checkemaildetails(email);

		if (n == 0) {
			response.getWriter().append("true");
		} else {
			response.getWriter().append("false");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		Generatotp gotp=new Generatotp();
		String email = request.getParameter("email");
		int n = ns.Checkemaildetails(email);
		if (n == 0) {
			response.sendRedirect("Forgetpassword.jsp");
		} else {
			PasswordConvert pc = new PasswordConvert();
			SendEmail s = new SendEmail();
			User u1 = ns.findpassword(email);
			String DecryptedPassword = pc.decrypt(u1.getPassword());
			String otp=gotp.random(6);
			System.out.println(otp);
			
			String msg = "<h1>Dear, " + u1.getFname() + "</h1>";
			msg+="\n<font color=red size=5>YOUR PASSWORD REQUEST ACCEPTED</font>\n\n<h3>YOUR OTP IS  ::  "+ otp + "</h3>";

			ThreadEmail threadEmail = new ThreadEmail();
			threadEmail.Send(email,msg);
			Thread t1 = new Thread(threadEmail);
			t1.start();
			String encryptotp=pc.encrypt(otp);
			u1.setOtp(encryptotp);
			HttpSession session=request.getSession(false);
			session.setAttribute("User", u1);
			RequestDispatcher dispacher=request.getRequestDispatcher("Otpform.jsp");
			dispacher.forward(request, response);
		}

	}

}