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
 * Servlet implementation class DisplayCategoryDetails
 */
public class DisplayCategoryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService ns=new CategoryServiceImpl();
	SubCategoryService ns1=new SubCategoryServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayCategoryDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		List<Category>category=ns.selectCategoryDetails();
		List<Category>subcategory=ns1.selectSubcategory();
		request.setAttribute("CategoryData", category);
		request.setAttribute("Subcategorydata", subcategory);
		
	//	RequestDispatcher dispatche=request.getRequestDispatcher("CategoryList.jsp");
		
	//	dispatche.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
