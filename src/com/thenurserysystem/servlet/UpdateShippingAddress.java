package com.thenurserysystem.servlet;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.bean.CartProduct;
import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.CartService;
import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.service.impl.CartServiceImpl;
import com.thenurserysystem.service.impl.OrderServiceImpl;
import com.thenurserysystem.service.impl.ProductServiceImpl;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;

public class UpdateShippingAddress extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	TheNurseryService ns=new TheNurseryServiceImpl();
	CartService c=new CartServiceImpl();
    ProductService ps=new ProductServiceImpl();
    OrderService os=new OrderServiceImpl();
    
    public UpdateShippingAddress() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("Servlet called Update shipping");
		String areaname=request.getParameter("areaname");
		String address=request.getParameter("address");
		String quantity=request.getParameter("quantity");
		int uid=Integer.parseInt(request.getParameter("userid"));
		String oderid=request.getParameter("oderid");
		String total=request.getParameter("total");
		String qty[]=quantity.split(" ");
		List<Cart> cartproduct=c.fetchCartDetails();
		List<Product> product=ps.selectProductDetails();
		List<CartProduct> cartp=new ArrayList<>();
	
		int cnt=0;
		for(Cart c:cartproduct)
		{
			CartProduct cp=new CartProduct();
			if(uid==c.getUserId())
			{
				for(Product p : product)
				{
					if(p.getId()==c.getProductID())
					{
						cp.setProductid(c.getProductID());
						cp.setAmount(p.getAfterofferprice());
						cp.setQuantity(Integer.parseInt(qty[cnt]));
						cnt++;
						cartp.add(cp);
					}
				}
					
			}
		}
		OrderDetails od=new OrderDetails();
		
		od.setDeliveryareaname(areaname);
		od.setDeliveryaddress(address);
		od.setProductdetails(cartp);
		od.setOrderid(oderid);
		od.setUid(uid);	
		od.setTotalamount(Float.parseFloat(total));
		
		 SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
		 Date date = new Date(); 
		 String s=formatter.format(date);
		 od.setOrderdate(s);
		 od.setPaymentstatus(0);
		int ans=os.saveOrderDetails(od);
		
		System.out.println("Update Shipping Complete");
	}

}
