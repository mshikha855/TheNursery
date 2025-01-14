package com.thenurserysystem.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

public class UpdateServiceDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;
    ServiceService ss=new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServiceDetails() {
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
		
	
		String serviceid=request.getParameter("serviceid");
		String servicedetails=request.getParameter("Service_details");		
		String serviceamount=request.getParameter("Service_amount");
		String description=request.getParameter("service_desc");
		Part part= request.getPart("Service_image");
		Service service=new Service();
		if(null!=part && part.getSize()>0)
		{
			System.out.println(part.getSubmittedFileName());
			System.out.println(part.getSize());
			service.setServiceImageStream(part.getInputStream());
		}
		
		service.setServiceId(Integer.parseInt(serviceid));
		service.setServiceDetails(servicedetails);
		service.setServiceAmount(Integer.parseInt(serviceamount));
		service.setDescription(description);
		
		int ans=ss.modifyServiceDetails(service);
		if(ans>0)
		{
			System.out.println("Update service details");
			request.setAttribute("message", "Service Update Sucess..!!!");
			RequestDispatcher dispacher=request.getRequestDispatcher("ServiceList.jsp");
			dispacher.forward(request, response);
		}
		else
		{
			System.out.println("can not update service details");
		}
	}

}
