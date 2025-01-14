package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.service.CartService;
import com.thenurserysystem.service.impl.CartServiceImpl;

/**
 * Servlet implementation class FetchCartDetails
 */
public class FetchCartDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	CartService cs=new CartServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchCartDetails() {
        super();
       
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Cart> cartlist=cs.fetchCartDetails();
		
		request.setAttribute("CartData", cartlist);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
