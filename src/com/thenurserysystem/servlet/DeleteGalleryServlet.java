package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class DeleteGalleryServlet
 */
public class DeleteGalleryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ProductService ps=new ProductServiceImpl();
	
    public DeleteGalleryServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int galleryid=Integer.parseInt(request.getParameter("id"));
		
		int ans=ps.deleteGalleryDetails(galleryid);
		if(ans>0)
		{
			response.sendRedirect("GalleryList.jsp");
		}
		
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
