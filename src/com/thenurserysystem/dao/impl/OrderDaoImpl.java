package com.thenurserysystem.dao.impl;

import java.sql.Connection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

//import org.eclipse.jdt.internal.compiler.ast.ReturnStatement;

import com.thenurserysystem.bean.CartProduct;
import com.thenurserysystem.bean.OrderDetails;

import com.thenurserysystem.dao.OrderDao;

public class OrderDaoImpl implements OrderDao {

	@Override
	public int insertorderdetails(OrderDetails od,Connection connection) throws SQLException {
		int[] ans;
		int a;		
		String query="insert into order_table(order_id,order_date,tot_amount,payment_status,delivery_status,user_id,delivery_address,delivery_area) values(?,?,?,?,?,?,?,?)";
		try(PreparedStatement ps=connection.prepareStatement(query))
		{
			ps.setString(1, od.getOrderid());
			ps.setString(2, od.getOrderdate());
			ps.setFloat(3, od.getTotalamount());
			ps.setInt(4, od.getPaymentstatus());
			ps.setString(5,"Not Deliver");
			ps.setInt(6,od.getUid());
			ps.setString(7, od.getDeliveryaddress());
			ps.setString(8,od.getDeliveryareaname());
			
			a=ps.executeUpdate();
			//System.out.println("a = "+a);
		}
	
		if(a>0)
		{
			
			try(PreparedStatement ps1=connection.prepareStatement("insert into order_details(order_id,product_id,amount,quantity,user_id) values(?,?,?,?,?)"))
			{
				List<CartProduct> cp=od.getProductdetails();
				
				for(CartProduct c : cp)
				{
					ps1.setString(1, od.getOrderid());
					ps1.setInt(2,c.getProductid());
					ps1.setInt(3, c.getAmount());
					ps1.setInt(4, c.getQuantity());
					ps1.setInt(5,od.getUid() );
					ps1.addBatch();
				}
				ans= ps1.executeBatch();
			}
		}
		
		return a;
	}

	@Override
	public int updateorderdetail(OrderDetails od, Connection connection) throws SQLException {
		int ans=0;
		
		try(PreparedStatement ps=connection.prepareStatement("update order_table set payment_status=? where order_id=?"))
		{
			
			ps.setInt(1, od.getPaymentstatus());
			ps.setString(2,od.getOrderid());
			
			ans=ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public List<OrderDetails> displayOrderList(Connection connection) throws SQLException {
		List<OrderDetails> order=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from order_table order by order_date desc");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					OrderDetails o=new OrderDetails();
					o.setOrderid(resultset.getString("order_id"));
					o.setOrderdate(resultset.getString("order_date"));
					o.setOrderstatus(resultset.getInt("order_status"));
					o.setTotalamount(resultset.getFloat("tot_amount"));
					o.setPaymentstatus(resultset.getInt("payment_status"));
					o.setUid(resultset.getInt("user_id"));
					o.setDeliverStatus(resultset.getString("delivery_status"));
					o.setDeliveryaddress(resultset.getString("delivery_address"));
					o.setDeliveryareaname(resultset.getString("delivery_area"));
					order.add(o);
			}	
		}
		return order;
	}

	@Override
	public List<OrderDetails> displayOrderListData(Connection connection) throws SQLException {
		List<OrderDetails> order=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from order_details");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					OrderDetails o=new OrderDetails();
					o.setOrder_details_id(resultset.getInt("order_details_id"));
					o.setOrderid(resultset.getString("order_id"));
					o.setProduct_id(resultset.getInt("product_id"));
					o.setAmount(resultset.getInt("amount"));
					o.setQty(resultset.getInt("quantity"));
					o.setUid(resultset.getInt("user_id"));
					order.add(o);
			}	
		}
		return order;
	}

	@Override
	public OrderDetails FetchOrderListData(Connection connection, String orderid) throws SQLException {
		OrderDetails o=new OrderDetails();
		List<CartProduct> cart=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from order_details where order_id=?"))
		{
				ps.setString(1, orderid);
				
				try	(ResultSet resultset=ps.executeQuery())
				{
					while(resultset.next())
					{
							CartProduct cartproduct=new CartProduct();
							cartproduct.setAmount(resultset.getInt("amount"));
							cartproduct.setProductid(resultset.getInt("product_id"));
							cartproduct.setQuantity(resultset.getInt("quantity"));
							cart.add(cartproduct);
					}
				}
				o.setProductdetails(cart);
		}
		
		try(PreparedStatement ps=connection.prepareStatement("select * from order_table where order_id=?"))
		{
				ps.setString(1, orderid);
				
				try	(ResultSet resultset=ps.executeQuery())
				{
					while(resultset.next())
					{
						
						o.setOrderid(resultset.getString("order_id"));
						o.setOrderdate(resultset.getString("order_date"));
						o.setOrderstatus(resultset.getInt("order_status"));
						o.setTotalamount(resultset.getFloat("tot_amount"));
						o.setPaymentstatus(resultset.getInt("payment_status"));
						o.setUid(resultset.getInt("user_id"));
						o.setDeliveryaddress(resultset.getString("delivery_address"));
						o.setDeliveryareaname(resultset.getString("delivery_area"));
					}
				}	
		}
		
		return o;
	
	}

	@Override
	public int Deleteorderdetail(String orderId, Connection connection) throws SQLException {
		int a1;
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("delete from order_table where order_id=?")){
			
			ps.setString(1, orderId);
			
			ans=ps.executeUpdate();
			System.out.println("in order table"+ans);
		}
		if(ans>0)
		{
			try(PreparedStatement ps1=connection.prepareStatement("delete from order_details where order_id=?")){
				
				ps1.setString(1, orderId);
				
				a1=ps1.executeUpdate();
			}
		}
		return ans;
	}

	public int UpdateDeliveryStatus(String orderid, Connection connection) throws SQLException {
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("update order_table set delivery_status=?  where order_id=?")){
			
			ps.setString(1, "Deliver");
			
			ps.setString(2, orderid);
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public int deletecartdetails(Connection connection, String userid) throws SQLException {
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("delete from cart where user_id=?"))
		{
			ps.setInt(1, Integer.parseInt(userid));
			ans=ps.executeUpdate();
		}
		return ans;
	}

	
}