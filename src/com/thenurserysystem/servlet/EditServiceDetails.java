package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.Service;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class EditServiceDetails
 */
public class EditServiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServiceService ss=new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditServiceDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		int serviceid=Integer.parseInt(request.getParameter("id"));
		
		Service s1=new Service();
		
		s1=ss.FindServiceDetail(serviceid);
		
		request.setAttribute("servicedetails", s1);
		
		RequestDispatcher dispacher=request.getRequestDispatcher("EditService.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
