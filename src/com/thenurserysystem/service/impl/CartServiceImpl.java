package com.thenurserysystem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.dao.CartDao;
import com.thenurserysystem.dao.impl.CartDaoImpl;
import com.thenurserysystem.service.CartService;

public class CartServiceImpl implements CartService {

	CartDao cd=new CartDaoImpl();
	
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
	public int insertCartDetails(int productId, int userid) {
		
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = cd.insertCartDetails(connection, productId,userid);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	
	}


	@Override
	public List<Cart> fetchCartDetails() {
		List<Cart> cartList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			cartList=cd.selectCartDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cartList;
	}


	@Override
	public int deleteCartDetails(int cartid) {
		// TODO Auto-generated method stub
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = cd.deleteCartDetails(connection, cartid);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;

	}


	@Override
	public int modifyShippingaddress(User u) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = cd.updateShippingaddress(u,connection);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

}
