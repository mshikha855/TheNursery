
package com.thenurserysystem.bean;

public class ServiceBooking {
	
	String bookingid;
	int bookingstatus;
	int paymentstatus;
	String date;
	String description;
	int amount;
	int gardenerid;
	int userid;
	String servicearea;
	String serviceaddress;
	int serviceid;
	
	public int getServiceid() {
		return serviceid;
	}
	public void setServiceid(int serviceid) {
		this.serviceid = serviceid;
	}
	public String getBookingid() {
		return bookingid;
	}
	public void setBookingid(String bookingid) {
		this.bookingid = bookingid;
	}
	public int getBookingstatus() {
		return bookingstatus;
	}
	public void setBookingstatus(int bookingstatus) {
		this.bookingstatus = bookingstatus;
	}
	public int getPaymentstatus() {
		return paymentstatus;
	}
	public void setPaymentstatus(int paymentstatus) {
		this.paymentstatus = paymentstatus;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	public int getGardenerid() {
		return gardenerid;
	}
	public void setGardenerid(int gardenerid) {
		this.gardenerid = gardenerid;
	}
	public int getUserid() {
		return userid;
	}
	public void setUserid(int userid) {
		this.userid = userid;
	}
	public String getServicearea() {
		return servicearea;
	}
	public void setServicearea(String servicearea) {
		this.servicearea = servicearea;
	}
	public String getServiceaddress() {
		return serviceaddress;
	}
	public void setServiceaddress(String serviceaddress) {
		this.serviceaddress = serviceaddress;
	}

}
