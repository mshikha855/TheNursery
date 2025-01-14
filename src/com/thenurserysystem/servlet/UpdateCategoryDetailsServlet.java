package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.thenurserysystem.bean.Category;
import com.thenurserysystem.service.CategoryService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.CategoryServiceImpl;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class UpdateCategoryDetailsServlet
 */
public class UpdateCategoryDetailsServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService ns=new CategoryServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateCategoryDetailsServlet() {
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
		
		int cat_id=Integer.parseInt(request.getParameter("categoryid"));
		String cat_name=request.getParameter("categoryname");
		
		Category category=new Category();
		category.setCat_id(cat_id);
		category.setCat_name(cat_name);
		
		int val=ns.modifyCategoryDetails(category);
		
		System.out.println("After update category :- "+val);
		
		if(val>0)
		{
			
			request.setAttribute("message", "Category Update Sucessfully...!");
			
			response.sendRedirect("CategoryList.jsp");
		}
		
	}

}
