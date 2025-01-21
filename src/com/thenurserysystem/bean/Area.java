package com.thenurserysystem.bean;

public class Area {

	int pincode;
	String areaname;
	
	public Area() {}
	public Area(int pincode, String areaname) {
		this.pincode = pincode;
		this.areaname = areaname;
	}
	public int getPincode() {
		return pincode;
	}
	public void setPincode(int pincode) {
		this.pincode = pincode;
	}
	public String getAreaname() {
		return areaname;
	}
	public void setAreaname(String areaname) {
		this.areaname = areaname;
	}
}
