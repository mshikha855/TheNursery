package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class ServiceCODServlet
 */
public class ServiceCODServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	ServiceService ss=new ServiceImpl();
	
    public ServiceCODServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try        
		{
		    Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
		String serviceid = request.getParameter("ORDER_ID");
		
		ServiceBooking sb=new ServiceBooking();
		
		sb=ss.fetchbookedservicedetail(serviceid);
		
		request.setAttribute("CashService", sb);

		 RequestDispatcher dispatcher=request.getRequestDispatcher("CashOnDeliveryServicebill.jsp");
		 dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try        
		{
		    Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
		String serviceid = request.getParameter("ORDER_ID");
		
		ServiceBooking sb=new ServiceBooking();
		
		sb=ss.fetchbookedservicedetail(serviceid);
		
		request.setAttribute("CashService", sb);

		 RequestDispatcher dispatcher=request.getRequestDispatcher("CashOnDeliveryServicebill.jsp");
		 dispatcher.forward(request, response);

	}

}
