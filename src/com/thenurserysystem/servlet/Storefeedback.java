package com.thenurserysystem.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.impl.ProductServiceImpl;

/**
 * Servlet implementation class Storefeedback
 */
public class Storefeedback extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	ProductService ps=new ProductServiceImpl();
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Storefeedback() {
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
		
		Feedback fb=new Feedback();
		
		String star=request.getParameter("star");
		String comment=request.getParameter("comment");
		String pid=request.getParameter("pid");
		
		HttpSession httpsession=request.getSession(false);
		User u=(User)httpsession.getAttribute("loginDetails");
		
		int uid=u.getUserid();
		
		fb.setPid(Integer.parseInt(pid));
		fb.setUid(uid);
		fb.setStar(Integer.parseInt(star));
		fb.setComment(comment);
		
		int ans=ps.savefeedbackdetails(fb);
	}

}
