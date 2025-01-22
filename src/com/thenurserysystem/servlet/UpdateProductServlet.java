package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class UpdateProductServlet
 */
public class UpdateProductServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
	
	ProductService ps=new ProductServiceImpl();
	
    public UpdateProductServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		Product product=new Product();
		String id=request.getParameter("productid");
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
		if(null!=part && part.getSize()>0)
		{
				System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			product.setProduct_img(part.getInputStream());
		}
		
		product.setId(Integer.parseInt(id));
		product.setCat_id(Integer.parseInt(cat));
		product.setSub_catid(Integer.parseInt(subcat));
		product.setProduct_name(productname);	
		product.setPrice(Integer.parseInt(price));
		product.setMaintenance(maintenance);
		product.setSunlight(sunlight);
		product.setWatering(watering);
		product.setOffer_id(Integer.parseInt(offer));
		product.setDesc(desc);
	
		int ans=ps.UpdateProductDetail(product);
		
		if(ans>0)
		{
			response.sendRedirect("ProductList.jsp");
		}
	
	}

}
