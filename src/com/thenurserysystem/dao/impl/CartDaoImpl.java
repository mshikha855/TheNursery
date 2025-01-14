package com.thenurserysystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.dao.CartDao;

public class CartDaoImpl implements CartDao {

	@Override
	public int insertCartDetails(Connection connection, int productId, int userid) throws SQLException {
		
		int ans = 0;
		String insertQuery = "insert into cart(product_id,user_id) values(?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setInt(1, productId);
			ps.setInt(2, userid);
			
			ans = ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public List<Cart> selectCartDetails(Connection connection) throws SQLException {
		List<Cart> cart=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from cart");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Cart c=new Cart();
					c.setCartId(resultset.getInt("cart_id"));
					c.setUserId(resultset.getInt("user_id"));
					c.setProductID(resultset.getInt("product_id"));
					cart.add(c);
			}
		}
		return cart;
	}

	@Override
	public int deleteCartDetails(Connection connection, int cartid) throws SQLException {
		int ans = 0;
		String insertQuery = "delete from cart where cart_id = ?";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setInt(1, cartid);
			
			
			ans = ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public int updateShippingaddress(User u,Connection connection) throws SQLException {
		int ans=0;
		String updateQuery="update user set address=?,pincode=? where user_id=? ";
		try(PreparedStatement ps=connection.prepareStatement(updateQuery)){
			
			
			ps.setString(1, u.getAddress());
			ps.setInt(2, u.getPincode());
			ps.setInt(3, u.getUserid());
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

}
