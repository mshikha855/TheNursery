package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.impl.OrderServiceImpl;

/**
 * Servlet implementation class DeleteOrderServlet
 */
public class DeleteOrderServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	OrderService os=new OrderServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DeleteOrderServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String orderId=request.getParameter("id");
		System.out.println(orderId);
		
		int ans=os.deleteOrderDetails(orderId);
		
		if(ans>0)
		{
			System.out.println("Order Delete Sucess");
			response.sendRedirect("OrderList.jsp");
		}
		else
		{
			System.out.println("Order Cannot delete sucess ");
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
