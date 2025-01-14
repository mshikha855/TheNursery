package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.thenurserysystem.bean.Category;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.service.impl.SubCategoryServiceImpl;



/**
 * Servlet implementation class FetchSubcategoryServlet
 */
public class FetchSubcategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    SubCategoryService sc=new SubCategoryServiceImpl();  
    
    public FetchSubcategoryServlet() {
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
		// TODO Auto-generated method stub
			String catid=request.getParameter("name");
		
		System.out.println("Selected category id is :"+catid);
	
		List<Category> subcatList=sc.fetchsubcategoeyList(catid);
	
	
		String json=new Gson().toJson(subcatList);
		
		System.out.println("json value = "+json);
		
		response.getWriter().append(json);
		
	}

}
