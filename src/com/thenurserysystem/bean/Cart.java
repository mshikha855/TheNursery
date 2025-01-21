package com.thenurserysystem.bean;

public class Cart {

	private int cartId;
	private int productID;
	private int userId;

	public Cart(int cartId, int productId, int userId) {
		this.cartId = cartId;
		this.productID = productId;
		this.userId = userId;
	}

	public Cart() {
	}

	public int getCartId() {
		return cartId;
	}

	public void setCartId(int cartId) {
		this.cartId = cartId;
	}

	public int getProductID() {
		return productID;
	}

	public void setProductID(int productID) {
		this.productID = productID;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}
}
