package com.thenurserysystem.servlet;

import java.io.IOException;

import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.service.CategoryService;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.service.impl.CategoryServiceImpl;
import com.thenurserysystem.service.impl.ProductServiceImpl;
import com.thenurserysystem.service.impl.SubCategoryServiceImpl;

/**
 * Servlet implementation class CategoryandSubcategoryDisplay
 */
public class CategoryandSubcategoryDisplay extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CategoryService ns=new CategoryServiceImpl();
	SubCategoryService cs=new SubCategoryServiceImpl();
	ProductService ps=new ProductServiceImpl();
	
	
    public CategoryandSubcategoryDisplay() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Category> cat=ns.selectCategoryDetails();
		
		List<Category> subcat=cs.selectSubcategory();
		System.out.println(cat);
		List<Offer> offer=ps.fetchOfferDetails();
		request.setAttribute("OfferList", offer);
 		request.setAttribute("CategoryList", cat);
		request.setAttribute("SubCategoryList", subcat);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
