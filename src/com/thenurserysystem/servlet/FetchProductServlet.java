package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class FetchProductServlet
 */
public class FetchProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProductService ps=new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FetchProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String subcatid=request.getParameter("name");
		
		System.out.println("Selected for json Subcategory id is :"+subcatid);
	
		List<Product> productList=ps.fetchProductData(subcatid);
	
	
		String json=new Gson().toJson(productList);
		
		System.out.println("json value = "+json);
		
		response.getWriter().append(json);
	}

}
