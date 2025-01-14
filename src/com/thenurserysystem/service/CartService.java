package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.bean.User;

public interface CartService {

	int insertCartDetails(int productId, int userid);

	List<Cart> fetchCartDetails();

	int deleteCartDetails(int cartid);

	int modifyShippingaddress(User u);

}
