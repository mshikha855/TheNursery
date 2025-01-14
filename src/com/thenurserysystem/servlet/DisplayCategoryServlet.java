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
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.CategoryServiceImpl;
import com.thenurserysystem.service.impl.SubCategoryServiceImpl;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class DisplayCategoryServlet
 */
public class DisplayCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	CategoryService ns=new CategoryServiceImpl();
	SubCategoryService sc=new SubCategoryServiceImpl();
	
	
    public DisplayCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category>category=ns.selectCategoryDetails();
		
		List<Category>subcategory=sc.selectSubcategoryDetails();
		
		request.setAttribute("CategoryData", category);
		request.setAttribute("SubCategoryData", subcategory);
		
		
	//	RequestDispatcher dispacher=request.getRequestDispatcher("InserSubCategory.jsp");
	//	dispacher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
