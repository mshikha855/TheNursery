package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.dao.impl.ServiceDaoImpl;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class DisplayServiceDetails
 */
public class DisplayServiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ServiceService s=new ServiceImpl(); 
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayServiceDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		List<Service> serviceList=s.fetchServiceDetails();
		
		request.setAttribute("ServiceData", serviceList);
		System.out.println(serviceList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
