package com.thenurserysystem.service.impl;

import java.sql.Connection;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

//import javax.servlet.http.HttpSession;

import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.bean.SendEmail;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.dao.OrderDao;
import com.thenurserysystem.dao.ProductDao;
import com.thenurserysystem.dao.impl.OrderDaoImpl;
import com.thenurserysystem.dao.impl.ProductDaoImpl;
import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.util.ThreadEmail;

public class OrderServiceImpl implements OrderService {

	OrderDao d = new OrderDaoImpl();
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurseryschema?autoReconnect=true&useSSL=false", "root",
					"root@12345");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public int saveOrderDetails(OrderDetails od) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.insertorderdetails(od,connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public int updateOrderdata(OrderDetails od) {
		int ans=0;
		
		try(Connection connection=getConnection())
		{
			ans=d.updateorderdetail(od, connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public List<OrderDetails> fetchOrderDetails() {
		
		List<OrderDetails> orderdetails=new ArrayList<>();
		try(Connection connection=getConnection())
		{
			orderdetails=d.displayOrderList(connection);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderdetails;
	}

	@Override
	public List<OrderDetails> fetchOrderDetailsData() {
		List<OrderDetails> orderdetails=new ArrayList<>();
		try(Connection connection=getConnection())
		{
			orderdetails=d.displayOrderListData(connection);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderdetails;
	}

	@Override
	public OrderDetails fetchOrderDetailsData(String orderid) {
		OrderDetails orderdetails=new OrderDetails();
		try(Connection connection=getConnection())
		{
			orderdetails=d.FetchOrderListData(connection,orderid);
			
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return orderdetails;

	}

	@Override
	public int deleteOrderDetails(String orderId) {
		int ans=0;
		
		try(Connection connection=getConnection())
		{
			ans=d.Deleteorderdetail(orderId, connection);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public int updateOrderDetails(String orderid) {
		int ans=0;
		
		try(Connection connection=getConnection())
		{
			ans=d.UpdateDeliveryStatus(orderid, connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public int deletecartdetails(String userid) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.deletecartdetails(connection,userid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	
}














