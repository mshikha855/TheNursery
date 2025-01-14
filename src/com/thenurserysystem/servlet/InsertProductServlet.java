package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.mail.MessagingException;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class InsertProductServlet
 */
public class InsertProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
   ProductService ps=new ProductServiceImpl();    
   
    public InsertProductServlet() {
        super();
       
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product=new Product();
		String cat=request.getParameter("category");
		String subcat=request.getParameter("subcategory");
		String productname=request.getParameter("product_name");
		String price=request.getParameter("product_price");
		String maintenance=request.getParameter("product_main");
		String sunlight=request.getParameter("product_sunlight");
		String watering=request.getParameter("product_watering");
		String offer=request.getParameter("product_offer");
		String desc=request.getParameter("product_desc");
		Part part= request.getPart("product_image");
		if(null!=part)
		{
				System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			product.setProduct_img(part.getInputStream());
		}
		
		
		
		
		int a=Integer.parseInt(cat);
		int b=Integer.parseInt(subcat);
		
		
		product.setCat_id(a);
		product.setSub_catid(b);
		product.setProduct_name(productname);
		product.setPrice(Integer.parseInt(price));
		product.setMaintenance(maintenance);
		product.setSunlight(sunlight);
		product.setWatering(watering);
		product.setOffer_id(Integer.parseInt(offer));
		product.setDesc(desc);
		
		int ans=ps.saveProductDetails(product);
		
		if(ans>0)
		{
			System.out.println("Offer insert successfull");
			
			request.setAttribute("message", "Product Insert Sucess..!!!");
			RequestDispatcher dispacher=request.getRequestDispatcher("InsertProduct.jsp");
			dispacher.forward(request, response);
		}
		else
		{
			System.out.println("Product insert not successfull");
		}
		
	}

}
