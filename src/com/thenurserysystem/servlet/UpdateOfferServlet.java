package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class UpdateOfferServlet
 */
public class UpdateOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ProductService ps=new ProductServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateOfferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int offer_id=Integer.parseInt(request.getParameter("offerid"));
		int discount=Integer.parseInt(request.getParameter("offerdiscount"));
		String details=request.getParameter("offerdetails");
		
		Offer offer=new Offer();
		offer.setOffer_id(offer_id);
		offer.setDiscount(discount);
		offer.setDetails(details);
		
		int val=ps.modifyOfferDetails(offer);
		
		System.out.println("After update offer :- "+val);
		
		if(val>0)
		{
			
			request.setAttribute("message", "Offer Update sucess...!");
			
			response.sendRedirect("OfferList.jsp");
		}
		
		
	}

}
