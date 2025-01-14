package com.thenurserysystem.bean;

public class Offer {
	
	public Offer() {}
	
	public Offer(int orderId, String orderDetails, int orderDiscount) {
		this.offer_id = orderId;
		this.Details = orderDetails;
		this.Discount = orderDiscount;
	}
	
	int offer_id;
	int Discount;
	String Details;
	int status;
	
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public int getDiscount() {
		return Discount;
	}
	public void setDiscount(int discount) {
		Discount = discount;
	}
	public String getDetails() {
		return Details;
	}
	public void setDetails(String details) {
		Details = details;
	}
	public int getStatus() {
		return status;
	}
	public void setStatus(int status) {
		this.status = status;
	}

}
