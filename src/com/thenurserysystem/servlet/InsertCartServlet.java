package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.CartService;
import com.thenurserysystem.service.impl.CartServiceImpl;

public class InsertCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	CartService cs=new CartServiceImpl();
  
    public InsertCartServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("In cart Servlet");
		
		HttpSession httpsession=request.getSession(false);
		
		User u=(User)httpsession.getAttribute("loginDetails");
		
		int productId=Integer.parseInt(request.getParameter("productid"));
		
		System.out.println("product is in cart"+productId);
		System.out.println("user is in cart"+u.getUserid());
		int ans=cs.insertCartDetails(productId,u.getUserid());

		if(ans>0)
		{
			System.out.println("Insert Product in cart sucess");
			response.getWriter().append("true");
		}
		else
		{
			System.out.println("Insert product in cart failed");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		System.out.println("In do post");
	}

}
