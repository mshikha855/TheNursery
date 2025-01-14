package com.thenurserysystem.service;

import java.util.List;


import com.thenurserysystem.bean.OrderDetails;

public interface OrderService {

	int saveOrderDetails(OrderDetails od);
	
	int updateOrderdata(OrderDetails od);

	List<OrderDetails> fetchOrderDetails();

	List<OrderDetails> fetchOrderDetailsData();

	OrderDetails fetchOrderDetailsData(String orderid);

	int deleteOrderDetails(String orderId);

	int updateOrderDetails(String orderid);
	
	int deletecartdetails(String userid);

}
