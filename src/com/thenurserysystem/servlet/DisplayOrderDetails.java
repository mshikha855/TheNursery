package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class DisplayOrderDetails
 */
public class DisplayOrderDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    OrderService os=new  OrderServiceImpl();  
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayOrderDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<OrderDetails>orderList=os.fetchOrderDetails();
		
		request.setAttribute("OrderList", orderList);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
