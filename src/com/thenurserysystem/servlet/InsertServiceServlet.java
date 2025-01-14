package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class InsertServiceServlet
 */
public class InsertServiceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ServiceService ss=new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertServiceServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Service s=new Service();
		
		String servicedetails=request.getParameter("Service_details");
		String serviceamount=request.getParameter("Service_amount");
		String description=request.getParameter("service_desc");
		Part part= request.getPart("Service_image");
		if(null!=part)
		{
				System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			s.setServiceImageStream(part.getInputStream());
		}
		
		
		s.setServiceDetails(servicedetails);
		s.setServiceAmount(Integer.parseInt(serviceamount));
		s.setDescription(description);
		
		int ans=ss.saveServiceDetails(s);
		
		if(ans>0)
		{
			System.out.println("Service insert sucess");
			request.setAttribute("message", "Service Insert Sucess..!!!");
			RequestDispatcher dispacher=request.getRequestDispatcher("InsertService.jsp");
			dispacher.forward(request, response);
		}
		else
		{
			System.out.println("Service can not insert");
		}
		
	}
}
