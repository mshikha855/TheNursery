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
 * Servlet implementation class InsertCategoryServlet
 */
public class InsertCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService ns=new CategoryServiceImpl();
	 
    
    public InsertCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s=request.getParameter("catname");
		
		List<Category> cat=ns.selectCategoryDetails();
		
		int flag=0;
		for(Category c1 : cat)
		{
			if(c1.getCat_name().equalsIgnoreCase(s))
			{
				flag=1;
				break;
			}
		}
		if(flag==1)
		{
			response.getWriter().append("true");
		}
		else
		{
			response.getWriter().append("false");
		}
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String cat_name=request.getParameter("categoryname");
		
		Category cat=new Category();
		cat.setCat_name(cat_name);
		
		int message=ns.saveCategoryDetails(cat);
		
		System.out.println("Message :- "+message);
		
		if(message>0)
		{
			System.out.println("Category added successfully");
			request.setAttribute("message", "Category Added Sucessfully....!!");
		}
		else
		{
			System.out.println("Category added not successfully");
		}
		RequestDispatcher dispacher=request.getRequestDispatcher("InsertCategory.jsp");
		dispacher.forward(request, response);
	}

}
