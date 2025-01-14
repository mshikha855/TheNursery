package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.CategoryService;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.service.impl.CategoryServiceImpl;
import com.thenurserysystem.service.impl.ProductServiceImpl;
import com.thenurserysystem.service.impl.SubCategoryServiceImpl;

/**
 * Servlet implementation class SelectedProductDetails
 */
public class SelectedProductDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	ProductService ps=new ProductServiceImpl();
	CategoryService cs=new CategoryServiceImpl();
	SubCategoryService scs=new SubCategoryServiceImpl();
	
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SelectedProductDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String product_id=request.getParameter("id");
		
		System.out.println("Product id "+product_id);
		
		List<Product> productList=ps.fetchPerticularProductData(product_id);
		
		List<Category> cat=cs.selectCategoryDetails();
		
		List<Category> subcat=scs.selectSubcategory();
		
		request.setAttribute("ProductData", productList);
		request.setAttribute("CategoryList",cat);
		request.setAttribute("SubCategoryList", subcat);
		
		RequestDispatcher dispatcher=request.getRequestDispatcher("Shopdetails.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
