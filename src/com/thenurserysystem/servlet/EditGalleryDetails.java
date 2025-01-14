package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class EditGalleryDetails
 */
public class EditGalleryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps=new ProductServiceImpl();
    public EditGalleryDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		int galleryid=Integer.parseInt(request.getParameter("id"));
		
		Gallery gallery=new Gallery();
		
		gallery=ps.fetchGalleryDetails(galleryid);
		
		request.setAttribute("galleryDetails", gallery);
		
		RequestDispatcher dispacher=request.getRequestDispatcher("EditGallery.jsp");
		dispacher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
