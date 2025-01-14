package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.Area;
import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class EditOfferServlet
 */
public class EditOfferServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	ProductService ps=new ProductServiceImpl();
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EditOfferServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		String offer_Id=request.getParameter("id");
		
		System.out.println(offer_Id);
		
		Offer offer=ps.fetchOfferDetails(offer_Id);
	
		request.setAttribute("offerdetails",offer);
		
		RequestDispatcher dispatche=request.getRequestDispatcher("EditOffer.jsp");
		
		dispatche.forward(request, response);	

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
