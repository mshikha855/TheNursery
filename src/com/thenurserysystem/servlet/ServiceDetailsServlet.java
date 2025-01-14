package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
//import javax.xml.ws.Dispatch;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class ServiceDetailsServlet
 */
public class ServiceDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServiceService ss=new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServiceDetailsServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String service_id=request.getParameter("id");
		
		List<Service> serviceList=ss.fetchSelectedServiceDetails(Integer.parseInt(service_id));
		
		request.setAttribute("ServiceData", serviceList);
		
		RequestDispatcher requestDispatcher=request.getRequestDispatcher("ServiceDetails.jsp");
		
		requestDispatcher.forward(request, response);
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
