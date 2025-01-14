package com.thenurserysystem.bean;

import java.io.InputStream;
public class Product {

	public Product(String productName, int productId) {
		this.id = productId;
		this.product_name = productName;
	}
	
	public Product() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", product_name=" + product_name + ", cat_id=" + cat_id + ", sub_catid="
				+ sub_catid + ", product_imgstream=" + product_imgstream + ", Product_imgstring=" + Product_imgstring
				+ ", price=" + price + ", desc=" + desc + ", Maintenance=" + Maintenance + ", Sunlight=" + Sunlight
				+ ", Watering=" + Watering + ", offer_id=" + offer_id + ", status=" + status + "]";
	}
	public int id;
	public String product_name;
	public int cat_id;
	public int sub_catid;
	public InputStream product_imgstream;
	private String Product_imgstring;
	public int price;
	public String desc;
	public String Maintenance;
	public String Sunlight;
	public String Watering;
	public int offer_id;
	public boolean status;
	public int afterofferprice;
	
	public int getAfterofferprice() {
		return afterofferprice;
	}
	public void setAfterofferprice(int afterofferprice) {
		this.afterofferprice = afterofferprice;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getProduct_name() {
		return product_name;
	}
	public void setProduct_name(String product_name) {
		this.product_name = product_name;
	}
	public int getCat_id() {
		return cat_id;
	}
	public void setCat_id(int cat_id) {
		this.cat_id = cat_id;
	}
	public int getSub_catid() {
		return sub_catid;
	}
	public void setSub_catid(int sub_catid) {
		this.sub_catid = sub_catid;
	}
	public InputStream getProduct_img() {
		return product_imgstream;
	}
	public void setProduct_img(InputStream product_img) {
		this.product_imgstream = product_img;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getDesc() {
		return desc;
	}
	public void setDesc(String desc) {
		this.desc = desc;
	}
	public String getMaintenance() {
		return Maintenance;
	}
	public void setMaintenance(String maintenance) {
		Maintenance = maintenance;
	}
	public String getSunlight() {
		return Sunlight;
	}
	public void setSunlight(String sunlight) {
		Sunlight = sunlight;
	}
	public String getWatering() {
		return Watering;
	}
	public void setWatering(String watering) {
		Watering = watering;
	}
	public int getOffer_id() {
		return offer_id;
	}
	public void setOffer_id(int offer_id) {
		this.offer_id = offer_id;
	}
	public boolean getStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public String getProduct_imgstring() {
		return Product_imgstring;
	}
	public void setProduct_imgstring(String product_imgstring) {
		Product_imgstring = product_imgstring;
	}
	
	
}
