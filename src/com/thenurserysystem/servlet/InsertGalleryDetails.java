package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class InsertGalleryDetails
 */
public class InsertGalleryDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	 ProductService ps=new ProductServiceImpl();    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertGalleryDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Gallery gallery=new Gallery();
		String cat=request.getParameter("product");
		Part part= request.getPart("Gallery_image");
		if(null!=part)
		{
				System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			gallery.setGallery_imgstream(part.getInputStream());
		}
		gallery.setProductId(Integer.parseInt(cat));
		
		int ans=ps.saveGalleryDetails(gallery);
		
		if(ans>0)
		{
			System.out.println("Gallery successfull");
			
//			request.setAttribute("message", "Product Insert Sucess..!!!");
//			RequestDispatcher dispacher=request.getRequestDispatcher("InsertProduct.jsp");
//			dispacher.forward(request, response);
			response.sendRedirect("GalleryList.jsp");
		}
		else
		{
			System.out.println("Gallery insert not successfull");
		}
	}

}
