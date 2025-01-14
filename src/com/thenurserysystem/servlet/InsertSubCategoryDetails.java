package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.SubCategoryServiceImpl;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class InsertSubCategoryDetails
 */
public class InsertSubCategoryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	SubCategoryService cs=new SubCategoryServiceImpl();
	
    public InsertSubCategoryDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String s=request.getParameter("subcatname");
		
		List<Category> cat=cs.selectSubcategory();
		
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

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int catid=Integer.parseInt(request.getParameter("categoryid"));
		String subcatname=request.getParameter("subcategoryname");
		
		int ans=cs.saveSubCategoryDetails(catid, subcatname);
		if(ans>0)
		{
			request.setAttribute("message","Sub Category Insert Successfull ");
			RequestDispatcher dispacher=request.getRequestDispatcher("InserSubCategory.jsp");
			dispacher.forward(request, response);
		}
		
		
	}

}
