package com.thenurserysystem.bean;

import java.util.Date;
import java.util.List;

public class OrderDetails {
	
	String  orderid;
	float totalamount;
	String deliveryaddress;
	String deliveryareaname;
	int uid;
	int orderstatus;
	String orderdate;
	int paymentstatus;
	private int order_details_id;
	private int product_id;
	private int amount;
	private int qty;
	private String DeliverStatus;
	
	List<CartProduct> productdetails;

	public List<CartProduct> getProductdetails() {
		return productdetails;
	}
	public void setProductdetails(List<CartProduct> productdetails) {
		this.productdetails = productdetails;
	}
	public String getOrderid() {
		return orderid;
	}
	public void setOrderid(String orderid) {
		this.orderid = orderid;
	}
	public float getTotalamount() {
		return totalamount;
	}
	public void setTotalamount(float totalamount) {
		this.totalamount = totalamount;
	}
	
	public String getDeliveryaddress() {
		return deliveryaddress;
	}
	public void setDeliveryaddress(String deliveryaddress) {
		this.deliveryaddress = deliveryaddress;
	}
	public String getDeliveryareaname() {
		return deliveryareaname;
	}
	public void setDeliveryareaname(String deliveryareaname) {
		this.deliveryareaname = deliveryareaname;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public int getOrderstatus() {
		return orderstatus;
	}
	public void setOrderstatus(int orderstatus) {
		this.orderstatus = orderstatus;
	}
	public String getOrderdate() {
		return orderdate;
	}
	public void setOrderdate(String orderdate) {
		this.orderdate = orderdate;
	}
	public int getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public int getOrder_details_id() {
		return order_details_id;
	}
	public void setOrder_details_id(int order_details_id) {
		this.order_details_id = order_details_id;
	}
	public int getProduct_id() {
		return product_id;
	}
	public void setProduct_id(int product_id) {
		this.product_id = product_id;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	@Override
	public String toString() {
		return "OrderDetails [orderid=" + orderid + ", totalamount=" + totalamount + ", deliveryaddress="
				+ deliveryaddress + ", deliveryareaname=" + deliveryareaname + ", uid=" + uid + ", orderstatus="
				+ orderstatus + ", orderdate=" + orderdate + ", paymentstatus=" + paymentstatus + ", order_details_id="
				+ order_details_id + ", product_id=" + product_id + ", amount=" + amount + ", qty=" + qty
				+ ", productdetails=" + productdetails + "]";
	}
	public String getDeliverStatus() {
		return DeliverStatus;
	}
	public void setDeliverStatus(String deliverStatus) {
		DeliverStatus = deliverStatus;
	}
	
}
