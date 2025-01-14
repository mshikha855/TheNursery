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

public class FetchProductDetails extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
    
	ProductService ps=new ProductServiceImpl();
	
    public FetchProductDetails() {
        super();
    }
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String subcat=request.getParameter("id");
		
		System.out.println("Subcategory is "+subcat);
		
		List<Product> productList=ps.fetchProductData(subcat);
		
		request.setAttribute("ProductData", productList);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Shop.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		
	}

}
