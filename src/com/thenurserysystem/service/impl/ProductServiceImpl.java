package com.thenurserysystem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.dao.ProductDao;
import com.thenurserysystem.dao.impl.ProductDaoImpl;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.util.ThreadEmail;

public class ProductServiceImpl implements ProductService {
	
	ProductDao d = new ProductDaoImpl();
	
	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurseryschema?autoReconnect=true&useSSL=false", "root",
					"root@12345");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}
	
	@Override
	public List<Product> selectProductDetails() {
		
		List<Product> productList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			productList=d.selectProductDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public int deleteProductDetails(String product_id) {
		int ans = 0;
		try (Connection connection = getConnection()) {

			ans=d.deleteProductDetails(connection, Integer.parseInt(product_id));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int saveProductDetails(Product product) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			List<Offer> of=selectOfferDetails();
			for(Offer o : of)
			{
				if(o.getOffer_id()==product.getOffer_id() )
				{
					if(o.getDiscount()!=0)
					{
						int val=o.getDiscount();
						int discount=(product.getPrice()*val)/100;
						int afterofferprice=product.getPrice()-discount;
						product.setAfterofferprice(afterofferprice);
					}
					else
					{
						product.setAfterofferprice(product.getPrice());
					}
					
				}
			}
			ans = d.insertProductDetails(connection, product);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Offer> selectOfferDetails() {

		List<Offer> offerList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			offerList=d.selectOfferDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return offerList;
	}

	@Override
	public int deleteOfferDetails(int id) {
		int ans = 0;
		try (Connection connection = getConnection()) {

			ans=d.deleteOfferDetails(connection, id);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int saveOfferDetails(Offer o) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = d.insertOfferDetails(connection, o);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public Offer fetchOfferDetails(String offer_Id) {
			
		Offer offer=new Offer();
		try (Connection connection = getConnection()) {
			
			offer = d.printOfferDetails(connection, offer_Id);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offer;
	}

	@Override
	public int modifyOfferDetails(Offer offer) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.updateOfferDetails(connection, offer);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Offer> fetchOfferDetails() {
		
		List<Offer> offer = new ArrayList<>();
		try (Connection connection = getConnection()) {

			offer = d.SelectOfferDetails(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return offer;

	}

	@Override
	public Product FindProductDetail(int productid) {
		
		Product p=new Product();
		
		try(Connection connection=getConnection())
		{
			p=d.Fetchproductdetail(connection, productid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return p;
	}

	@Override
	public int UpdateProductDetail(Product p1) {
		int ans=0;
		
		try(Connection connection=getConnection())
		{
			List<Offer> of=selectOfferDetails();
			for(Offer o : of)
			{
				if(o.getOffer_id()==p1.getOffer_id() )
				{
					if(o.getDiscount()!=0)
					{
						int val=o.getDiscount();
						int discount=(p1.getPrice()*val)/100;
						int afterofferprice=p1.getPrice()-discount;
						p1.setAfterofferprice(afterofferprice);
					}
					else
					{
						p1.setAfterofferprice(p1.getPrice());
					}
				}
			}
			
			ans=d.updateproductdetail(connection, p1);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public List<Product> fetchProductData(String subcat) {
	List<Product> productList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			productList=d.fetchProductData(connection,Integer.parseInt(subcat));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<Product> fetchPerticularProductData(String product_id) {
		
		List<Product> productList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			productList=d.fetchPerticularProductData(connection,Integer.parseInt(product_id));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<Gallery> selectGalleryDetails() {
		List<Gallery> galleryList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			galleryList=d.selectGalleryDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return galleryList;
	}

	@Override
	public int saveGalleryDetails(Gallery gallery) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = d.insertGalleryDetails(connection, gallery);
			
			System.out.println(ans);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public Gallery fetchGalleryDetails(int galleryid) {
		Gallery gallery=new Gallery();
		try (Connection connection = getConnection()) {
			
			gallery = d.printGalleryDetails(connection, galleryid);
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return gallery;
	}

	@Override
	public int modifyGalleryDetails(Gallery gallery) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.updateGalleryDetails(connection, gallery);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int deleteGalleryDetails(int galleryid) {
		int ans = 0;
		try (Connection connection = getConnection()) {

			ans=d.deleteGalleryDetails(connection, galleryid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Gallery> fetchGalleryDetails() {
		List<Gallery> galleryList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			galleryList=d.selectGalleryDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return galleryList;

	}

	@Override
	public int savefeedbackdetails(Feedback fb) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.insertfeedbackdetails(connection,fb);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Feedback> DisplayFeedbackdetails() {
		List<Feedback> fb1=new ArrayList<>();
		
		try(Connection connection=getConnection())
		{
			fb1=d.selectfeedbackdetail(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return fb1;
	}

	@Override
	public int deleteFeedback(int pid) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.deleteFeedbackdetails(connection,pid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<Product> fetchTrendingProduct() {
		List<Product> productList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			productList=d.displayTrendingProduct(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<Product> selectOrderProductRatio() {
		List<Product> productList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			productList=d.getBookedProductRatio(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return productList;
	}

	@Override
	public List<Product> fetchSearchProduct(String Productname) {
		List<Product> productList=new ArrayList<>();
		System.out.println("in service");
		try(Connection connection=getConnection();)
		{
			productList=d.fetchsearchProduct(connection,Productname);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(productList);
		return productList;
	}

	
}
