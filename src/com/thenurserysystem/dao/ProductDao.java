package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.Product;

public interface ProductDao {
	
	public List<Product> selectProductDetails(Connection connection) throws SQLException;

	public int deleteProductDetails(Connection connection, int product_id) throws SQLException;

	public int insertProductDetails(Connection connection, Product product) throws SQLException;

	public List<Offer> selectOfferDetails(Connection connection) throws SQLException;

	public int deleteOfferDetails(Connection connection, int offerid) throws SQLException;

	public int insertOfferDetails(Connection connection, Offer o) throws SQLException;

	public Offer printOfferDetails(Connection connection, String offer_Id);

	public int updateOfferDetails(Connection connection, Offer offer) throws SQLException;

	public List<Offer> SelectOfferDetails(Connection connection) throws SQLException;
	
	public Product Fetchproductdetail(Connection connection,int productid)throws SQLException;
	
	public int updateproductdetail(Connection connection,Product p)throws SQLException;

	public List<Product> fetchProductData(Connection connection, int subcat) throws SQLException;

	public List<Product> fetchPerticularProductData(Connection connection, int product_id) throws SQLException;

	public List<Gallery> selectGalleryDetails(Connection connection) throws SQLException;

	public int insertGalleryDetails(Connection connection, Gallery gallery) throws SQLException;

	public Gallery printGalleryDetails(Connection connection, int galleryid) throws SQLException;

	public int updateGalleryDetails(Connection connection, Gallery gallery) throws SQLException;

	public int deleteGalleryDetails(Connection connection, int galleryid) throws SQLException;

	public int insertfeedbackdetails(Connection connection, Feedback fb)throws SQLException;

	public List<Feedback> selectfeedbackdetail(Connection connection)throws SQLException;

	public int deleteFeedbackdetails(Connection connection, int pid)throws SQLException;

	public List<Product> displayTrendingProduct(Connection connection)throws SQLException;

	public List<Product> getBookedProductRatio(Connection connection)throws SQLException;

	public List<Product> fetchsearchProduct(Connection connection, String productname)throws SQLException;
	
	
}
