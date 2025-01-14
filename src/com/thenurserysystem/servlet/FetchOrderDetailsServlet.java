
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
import com.thenurserysystem.service.impl.OrderServiceImpl;

public class FetchOrderDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 OrderService os=new  OrderServiceImpl();  
       
    public FetchOrderDetailsServlet() {
        super();
       
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("in servlet");
		
		String orderid=request.getParameter("id");
		
		System.out.println(orderid);
		
		OrderDetails order=new OrderDetails();
		
		order=os.fetchOrderDetailsData(orderid);
		
		request.setAttribute("UserOrder", order);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("UserOrderBill.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
