package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class Searchproductdetails
 */
public class Searchproductdetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       ProductService ps=new ProductServiceImpl();
    public Searchproductdetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String productname=request.getParameter("proname");
		
		System.out.println("Product name" +productname);
		
		List<Product> searchList=ps.fetchSearchProduct(productname);
		
		request.setAttribute("ProductData",searchList);
		
		System.out.println("Servlet :-"+searchList);
		
		System.out.println("End of servlet");
	
		RequestDispatcher dispatcher=request.getRequestDispatcher("Shopdetails.jsp");
		dispatcher.forward(request, response);
		  
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
