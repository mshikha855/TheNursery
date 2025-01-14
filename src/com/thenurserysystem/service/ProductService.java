package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.Product;

public interface ProductService {
	

	public List<Product> selectProductDetails();

	public int deleteProductDetails(String product_id);

	public int saveProductDetails(Product product);

	public List<Offer> selectOfferDetails();

	public int deleteOfferDetails(int id);

	public int saveOfferDetails(Offer o);

	public Offer fetchOfferDetails(String offer_Id);

	public int modifyOfferDetails(Offer offer);

	public List<Offer> fetchOfferDetails();
	
	public Product FindProductDetail(int productid);

	public int UpdateProductDetail(Product p1);

	public List<Product> fetchProductData(String subcat);

	public List<Product> fetchPerticularProductData(String product_id);

	public List<Gallery> selectGalleryDetails();

	public int saveGalleryDetails(Gallery gallery);

	public Gallery fetchGalleryDetails(int galleryid);

	public int modifyGalleryDetails(Gallery gallery);

	public int deleteGalleryDetails(int galleryid);

	public List<Gallery> fetchGalleryDetails();

	public int savefeedbackdetails(Feedback fb);

	public List<Feedback> DisplayFeedbackdetails();

	public int deleteFeedback(int pid);

	public List<Product> fetchTrendingProduct();

	public List<Product> selectOrderProductRatio();

	public List<Product> fetchSearchProduct(String Poductname);

	
}
