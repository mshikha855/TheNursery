package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.PasswordConvert;

/**
 * Servlet implementation class GetOtpServlet
 */
public class GetOtpServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public PasswordConvert pc =new PasswordConvert();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GetOtpServlet() {
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
		
		String originalotp=request.getParameter("originalotp");
		int userotp=Integer.parseInt(request.getParameter("otp"));
		String userid=request.getParameter("userid");
		//PasswordConvert pc=new PasswordConvert();
		int otp=Integer.parseInt(pc.decrypt(originalotp));
		if(otp==userotp)
		{
			RequestDispatcher dispacher=request.getRequestDispatcher("updatepassword.jsp");
			dispacher.forward(request, response);
		}
		else
		{
			request.setAttribute("message","Sorry!!.... This otp is Invalid or Expired");
			RequestDispatcher dispacher=request.getRequestDispatcher("Otpform.jsp");
			dispacher.forward(request, response);
		}
	}

}
