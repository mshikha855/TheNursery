package com.thenurserysystem.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.dao.ServiceDao;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.service.impl.ServiceImpl;

/**
 * Servlet implementation class UpdateServiceAddress
 */
public class UpdateServiceAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public ServiceService ss=new ServiceImpl();
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UpdateServiceAddress() {
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
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Update service servlet called");
		
		String orderid=request.getParameter("oderid");
		
		String areaname=request.getParameter("areaname");
		
		String address=request.getParameter("address");
		
		String userid=request.getParameter("userid");
		
		String amount=request.getParameter("total");
		
		int sid=Integer.parseInt(request.getParameter("sid"));
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date(); 
		 String s=formatter.format(date);
		 
		ServiceBooking service=new ServiceBooking();
		service.setBookingid(orderid);
		service.setServicearea(areaname);
		service.setServiceaddress(address);
		service.setUserid(Integer.parseInt(userid));
		service.setAmount(Integer.parseInt(amount));
		service.setDate(s);
		service.setServiceid(sid);
		
		int ans=ss.saveServiceBookingDetails(service);
		
		if(ans>0)
		{
			System.out.println("insert sucess");
		}
		else
		{
			System.out.println("Insert failed");
		}
		
	}

}
