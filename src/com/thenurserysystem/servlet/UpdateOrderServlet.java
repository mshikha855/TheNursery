package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class UpdateOrderServlet
 */
public class UpdateOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService od=new OrderServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderid=request.getParameter("id");
		
		int ans=od.updateOrderDetails(orderid);
		
		if(ans>0)
		{
			System.out.println("Update Order Sucess ");
			response.sendRedirect("OrderList.jsp");
		}
		else
		{
			System.out.println("Update Order Falied");
		}

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
