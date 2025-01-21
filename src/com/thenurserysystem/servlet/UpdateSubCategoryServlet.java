package com.thenurserysystem.servlet;

import java.io.IOException;
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
 * Servlet implementation class UpdateSubCategoryServlet
 */
public class UpdateSubCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	public SubCategoryService cs=new SubCategoryServiceImpl();
    public UpdateSubCategoryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int id=Integer.parseInt(request.getParameter("subcategoryid"));
		String subCatName=request.getParameter("subcategoryname");
		
		int categoryid=Integer.parseInt(request.getParameter("categoryid"));
		
		Category cat=new Category();
		
		cat.setSubcat_id(id);
		cat.setCat_name(subCatName);
		cat.setCat_id(categoryid);
		
		int ans=cs.updateSubcategory(cat);
		
		if(ans>0)
		{
			response.sendRedirect("SubCategoryList.jsp");
		}
		
	}

}
