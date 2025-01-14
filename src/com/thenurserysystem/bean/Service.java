package com.thenurserysystem.bean;

import java.io.InputStream;

public class Service {
	int serviceId;
	String serviceDetails;
	int serviceAmount;
	InputStream serviceImageStream;
	String serviceImageString;
	private String description;
	public int getServiceId() {
		return serviceId;
	}
	public void setServiceId(int serviceId) {
		this.serviceId = serviceId;
	}
	public String getServiceDetails() {
		return serviceDetails;
	}
	public void setServiceDetails(String serviceDetails) {
		this.serviceDetails = serviceDetails;
	}
	public int getServiceAmount() {
		return serviceAmount;
	}
	public void setServiceAmount(int serviceAmount) {
		this.serviceAmount = serviceAmount;
	}
	public InputStream getServiceImageStream() {
		return serviceImageStream;
	}
	public void setServiceImageStream(InputStream serviceImageStream) {
		this.serviceImageStream = serviceImageStream;
	}
	public String getServiceImageString() {
		return serviceImageString;
	}
	public void setServiceImageString(String serviceImageString) {
		this.serviceImageString = serviceImageString;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}

}
