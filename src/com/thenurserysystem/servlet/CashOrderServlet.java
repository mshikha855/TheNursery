package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.OrderServiceImpl;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

public class CashOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService os = new OrderServiceImpl();
	TheNurseryService ns = new TheNurseryServiceImpl();

	public CashOrderServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		 
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		System.out.println("in cash order servlet");
        
		try        
		{
		    Thread.sleep(1000);
		} 
		catch(InterruptedException ex) 
		{
		    Thread.currentThread().interrupt();
		}
		String orderid = request.getParameter("ORDER_ID");
		System.out.println("Order id:"+orderid);

		OrderDetails order = new OrderDetails();

		order = os.fetchOrderDetailsData(orderid);
		System.out.println("Order id = "+order.getOrderid());
		request.setAttribute("CashOrder", order);

		 RequestDispatcher dispatcher=request.getRequestDispatcher("CashOnDeliveryDetails.jsp");
		 dispatcher.forward(request, response);
		 System.out.println("Cash order servlet complete");
		 
	}

}
