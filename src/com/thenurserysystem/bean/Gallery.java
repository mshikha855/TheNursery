package com.thenurserysystem.bean;

import java.io.InputStream;

public class Gallery {
	private int galleryId;
	private int productId;
	private InputStream gallery_imgstream;
	private String gallery_imgString;
	public int getGalleryId() {
		return galleryId;
	}
	public void setGalleryId(int galleryId) {
		this.galleryId = galleryId;
	}
	public int getProductId() {
		return productId;
	}
	public void setProductId(int productId) {
		this.productId = productId;
	}
	public InputStream getGallery_imgstream() {
		return gallery_imgstream;
	}
	public void setGallery_imgstream(InputStream gallery_imgstream) {
		this.gallery_imgstream = gallery_imgstream;
	}
	public String getGallery_imgString() {
		return gallery_imgString;
	}
	public void setGallery_imgString(String gallery_imgString) {
		this.gallery_imgString = gallery_imgString;
	}
}
