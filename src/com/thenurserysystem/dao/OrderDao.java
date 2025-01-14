package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.OrderDetails;

public interface OrderDao {

	int insertorderdetails(OrderDetails od, Connection connection)throws SQLException;

	int updateorderdetail(OrderDetails od, Connection connection)throws SQLException;

	List<OrderDetails> displayOrderList(Connection connection) throws SQLException;

	List<OrderDetails> displayOrderListData(Connection connection) throws SQLException;

	OrderDetails FetchOrderListData(Connection connection, String orderid) throws SQLException;

	int Deleteorderdetail(String orderId, Connection connection) throws SQLException;

	int UpdateDeliveryStatus(String orderid, Connection connection) throws SQLException;

	int deletecartdetails(Connection connection, String userid)throws SQLException;


}
