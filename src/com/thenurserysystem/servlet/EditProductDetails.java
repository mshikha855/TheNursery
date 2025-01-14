package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class EditProductDetails
 */
public class EditProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductService ps=new ProductServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int productid=Integer.parseInt(request.getParameter("id"));
		
		Product p1=new Product();
		
		p1=ps.FindProductDetail(productid);
		
		request.setAttribute("productdetail", p1);
		
		RequestDispatcher dispacher=request.getRequestDispatcher("EditProduct.jsp");
		dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
