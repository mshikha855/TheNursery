package com.thenurserysystem.bean;

public class ServiceDetails {
	
	private int serviceDetailsId;
	private int serviceId;
	private int gardenerId;
	private String bookingId;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public int getServiceDetailsId() {
		return serviceDetailsId;
	}
	public void setServiceDetailsId(int serviceDetailsId) {
		this.serviceDetailsId = serviceDetailsId;
	}
	public int getGardenerId() {
		return gardenerId;
	}
	public void setGardenerId(int gardenerId) {
		this.gardenerId = gardenerId;
	}
	public String getBookingId() {
		return bookingId;
	}
	public void setBookingId(String bookingId) {
		this.bookingId = bookingId;
	}
	

}
