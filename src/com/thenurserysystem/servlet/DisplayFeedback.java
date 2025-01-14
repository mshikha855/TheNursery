package com.thenurserysystem.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.ProductServiceImpl;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class DisplayFeedback
 */
public class DisplayFeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	
	ProductService ps=new ProductServiceImpl();
	TheNurseryService ns=new TheNurseryServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public DisplayFeedback() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		List<Feedback> fb=new ArrayList<>();
		
		fb=ps.DisplayFeedbackdetails();
		List<Product> product=ps.selectProductDetails();
		List<User> u=ns.selectUserDetails();
		request.setAttribute("feedbackdetails", fb);
		request.setAttribute("userlist", u);
		request.setAttribute("productlist", product);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
