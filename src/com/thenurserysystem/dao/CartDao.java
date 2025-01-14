package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.bean.User;

public interface CartDao {

	int insertCartDetails(Connection connection, int productId, int userid) throws SQLException;

	List<Cart> selectCartDetails(Connection connection) throws SQLException;

	int deleteCartDetails(Connection connection, int cartid) throws SQLException;

	int updateShippingaddress(User u,Connection connection) throws SQLException;

}
