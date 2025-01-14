package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

/**
 * Servlet implementation class DeleteUserDetails
 */
public class DeleteUserDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
	TheNurseryService ns=new TheNurseryServiceImpl();   
   
    public DeleteUserDetails() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println(ns.deleteUserDetails(request.getParameter("id")));
		
		response.sendRedirect("SelectData.jsp");
	
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		doGet(request, response);
	}

}
