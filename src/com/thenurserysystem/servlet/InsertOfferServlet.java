package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class InsertOfferServlet
 */
public class InsertOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps=new ProductServiceImpl();    
	    
    /**
     * @see HttpServlet#HttpServlet()
     */
    public InsertOfferServlet() {
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
		int offer=Integer.parseInt(request.getParameter("offerdiscount"));
		String details=request.getParameter("offerdetails");
		
		Offer o=new Offer();
		o.setDiscount(offer);
		o.setDetails(details);
		
		int ans=ps.saveOfferDetails(o);
		
		if(ans>0)
		{
			System.out.println("offer insert successfull");
			
			request.setAttribute("message", "Offer Insert Sucess..!!!");
			RequestDispatcher dispacher=request.getRequestDispatcher("InsertOffer.jsp");
			dispacher.forward(request, response);
		}
		else
		{
			System.out.println("offer insert not successfull");
			request.setAttribute("message", "Offer Insert Failed..!!!");
			RequestDispatcher dispacher=request.getRequestDispatcher("InsertOffer.jsp");
			dispacher.forward(request, response);

		}	
	}
}
