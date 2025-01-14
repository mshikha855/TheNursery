package com.thenurserysystem.servlet;

import java.awt.print.Book;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.ServiceDetails;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class AssignGardenerServlet
 */
public class AssignGardenerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServiceService ss=new ServiceImpl();	//changed from private to public
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AssignGardenerServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	//protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int serviceId=Integer.parseInt(request.getParameter("serviceid"));
		int gardenerId=Integer.parseInt(request.getParameter("gardenerid"));
		String bookingId=request.getParameter("bookingid");
		System.out.println("Service id:"+serviceId);
		System.out.println("Gardener id:"+gardenerId);
		
		ServiceDetails sd=new ServiceDetails();
		sd.setGardenerId(gardenerId);
		sd.setServiceId(serviceId);
		sd.setBookingId(bookingId);
		
		int ans=ss.assignGardenerDetails(sd);
		
		if(ans>0)
		{
			System.out.println("Assign Gardener Sucess");
			response.sendRedirect("BookedServiceList.jsp");
		}
		else
		{
			System.out.println("Assign Gardener Failed");
		}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
