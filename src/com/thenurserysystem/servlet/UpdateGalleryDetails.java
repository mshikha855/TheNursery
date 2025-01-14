package com.thenurserysystem.servlet;

import java.io.IOException;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;


public class UpdateGalleryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
      ProductService ps=new ProductServiceImpl();
   
    public UpdateGalleryDetails() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gallery gallery=new Gallery();
		String galleryId=request.getParameter("galleryid");
		String productId=request.getParameter("product");
		Part part=request.getPart("Gallery_image");
		if(null!=part && part.getSize()>0)
		{
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			gallery.setGallery_imgstream(part.getInputStream());
		}
		
		gallery.setGalleryId(Integer.parseInt(galleryId));
		gallery.setProductId(Integer.parseInt(productId));
		
		int ans=ps.modifyGalleryDetails(gallery);
		if(ans>0)
		{
			System.out.println("Gallery Update Sucess");
			response.sendRedirect("GalleryList.jsp");
		}
		else
		{
			System.out.println("Gallery Cannot update");
		}
		
		
	}
}
