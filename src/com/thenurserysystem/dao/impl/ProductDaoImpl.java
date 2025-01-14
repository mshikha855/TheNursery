package com.thenurserysystem.dao.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.Gallery;
import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.dao.ProductDao;

public class ProductDaoImpl implements ProductDao {

	@Override
	public List<Product> selectProductDetails(Connection connection) throws SQLException {
		List<Product> product=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from product "
				+ "");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Product p=new Product();
					p.setId(resultset.getInt("product_id"));
					p.setProduct_name(resultset.getString("product_name"));
					p.setCat_id(resultset.getInt("cat_id"));
					p.setSub_catid(resultset.getInt("sub_cat_id"));
					//p.setProduct_img(resultset.getBlob("product_image"));
					//byte[] imagedata=resultset.getBytes("product_image");
					Blob blob = resultset.getBlob("product_image");
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
					if(null!=imageBytes && imageBytes.length>0)
					{ 
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					inputStream.close();
	                outputStream.close();
	                
					if(null!=imageBytes && imageBytes.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					p.setPrice(resultset.getInt("product_price"));
					p.setDesc(resultset.getString("product_desc"));
					p.setMaintenance(resultset.getString("maintenance"));
					p.setSunlight(resultset.getString("sunlight"));
					p.setWatering(resultset.getString("watering"));
					p.setOffer_id(resultset.getInt("offer_id"));
					p.setStatus(resultset.getBoolean("status"));
					p.setAfterofferprice(resultset.getInt("afteroffer_price"));
					product.add(p);
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}

	@Override
	public int deleteProductDetails(Connection connection, int product_id) throws SQLException {

		int ans3=0;
		int prostatus=0;
		try(PreparedStatement ps3=connection.prepareStatement("select * from product where product_id=?"))
		{
			ps3.setInt(1, product_id);
			try(ResultSet rs3=ps3.executeQuery())
			{
				while(rs3.next())
				{
					prostatus=rs3.getInt("status");
					if(prostatus==0)
					{
						prostatus=1;
					}
					else
					{
						prostatus=0;
					}
					
					try(PreparedStatement ps=connection.prepareStatement("update product set status=? where product_id=?" )){	
						ps.setInt(1, prostatus);	
						ps.setInt(2, product_id);
						
							ans3=ps.executeUpdate();
					}
				}
			}
		}
		return ans3;
	}

	@Override
	public int insertProductDetails(Connection connection, Product product) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into product(product_name,cat_id,sub_cat_id,product_image,product_price,product_desc,maintenance,sunlight,watering,offer_id,afteroffer_price) values(?,?,?,?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setString(1, product.getProduct_name());
			ps.setInt(2, product.getCat_id());
			ps.setInt(3, product.getSub_catid());
			ps.setBlob(4, product.getProduct_img());
			ps.setInt(5, product.getPrice());
			ps.setString(6, product.getDesc());
			ps.setString(7, product.getMaintenance());
			ps.setString(8, product.getSunlight());
			ps.setString(9, product.getWatering());
			ps.setInt(10, product.getOffer_id());
			ps.setInt(11, product.getAfterofferprice());
			
			ans = ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public List<Offer> selectOfferDetails(Connection connection) throws SQLException {
			List<Offer> offer=new ArrayList<>();
			try(PreparedStatement ps=connection.prepareStatement("select * from offer where status=1");
					ResultSet resultset=ps.executeQuery()){
				
				while(resultset.next())
				{
						Offer o=new Offer();
						o.setOffer_id(resultset.getInt("offer_id"));
						o.setDiscount(resultset.getInt("discount"));
						o.setDetails(resultset.getString("details"));
						offer.add(o);
				}
			}
			return offer;
	}

	@Override
	public int deleteOfferDetails(Connection connection, int offerid) throws SQLException {
			
		int ans=0,a[];
		
		try(PreparedStatement ps=connection.prepareStatement("update offer set status=0 where offer_id=?" )){
			
			ps.setInt(1, offerid);
			
			ans=ps.executeUpdate();
		}
		if(ans>0)
		{
			List<Product> p=selectProductDetails(connection);
			try(PreparedStatement ps1=connection.prepareStatement("update product set afteroffer_price=?,offer_id=? where product_id=?"))
			{
				for(Product p1 : p)
				{
					if(p1.getOffer_id()==offerid)
					{
						ps1.setInt(1, p1.getPrice());
						ps1.setInt(2, 0);
						ps1.setInt(3, p1.getId());
						ps1.addBatch();
					}
				}
				a=ps1.executeBatch();
			}
		}
		
		return ans;

	}

	@Override
	public int insertOfferDetails(Connection connection, Offer o) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into offer(discount,details) values(?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setInt(1, o.getDiscount());
			ps.setString(2,o.getDetails());
			
			ans = ps.executeUpdate();
		}
		
		return ans;

	}

	@Override
	public Offer printOfferDetails(Connection connection, String offer_Id) {
		
		Offer o=new Offer();
		try(PreparedStatement preparedStatement=connection.prepareStatement("select * from offer where offer_id = ?"))
		{
		
			preparedStatement.setString(1, offer_Id);
			
			ResultSet resultset=preparedStatement.executeQuery();
		
			while(resultset.next())
			{
					o.setOffer_id(resultset.getInt("offer_id"));
					o.setDiscount(resultset.getInt("discount"));
					o.setDetails(resultset.getString("details"));
			}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		
		return o;
	}

	@Override
	public int updateOfferDetails(Connection connection, Offer offer) throws SQLException {
		int ans=0;
		String updateQuery="update offer set discount=?,details=? where offer_id= ? ";
		try(PreparedStatement ps=connection.prepareStatement(updateQuery)){
			
			ps.setInt(1, offer.getDiscount());
			ps.setString(2, offer.getDetails());
			ps.setInt(3, offer.getOffer_id());
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<Offer> SelectOfferDetails(Connection connection) throws SQLException {
		List<Offer> offer=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from offer where status=1");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Offer o=new Offer();
					o.setOffer_id(resultset.getInt("offer_id"));
					o.setDiscount(resultset.getInt("discount"));
					o.setDetails(resultset.getString("details"));
					o.setStatus(resultset.getInt("status"));
					offer.add(o);
			}
			
		}
		return offer;
	}

	@Override
	public Product Fetchproductdetail(Connection connection, int productid) throws SQLException {
		Product p=new Product();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from product where product_id=?"))
		{
			ps.setInt(1, productid);
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					p.setId(resultset.getInt("product_id"));
					p.setProduct_name(resultset.getString("product_name"));
					p.setCat_id(resultset.getInt("cat_id"));
					p.setSub_catid(resultset.getInt("sub_cat_id"));
					//p.setProduct_img((resultset.getBlob("product_image"));
					//byte[] imagedata=resultset.getBytes("product_image");
					Blob blob = resultset.getBlob("product_image");
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
					if(null!=imageBytes && imageBytes.length>0)
					{ 
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					inputStream.close();
	                outputStream.close();
	                
					if(null!=imageBytes && imageBytes.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					p.setPrice(resultset.getInt("product_price"));
					p.setDesc(resultset.getString("product_desc"));
					p.setMaintenance(resultset.getString("maintenance"));
					p.setSunlight(resultset.getString("sunlight"));
					p.setWatering(resultset.getString("watering"));
					p.setOffer_id(resultset.getInt("offer_id"));
					p.setStatus(resultset.getBoolean("status"));
					p.setAfterofferprice(resultset.getInt("afteroffer_price"));
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return p;
	}

	@Override
	public int updateproductdetail(Connection connection, Product p) throws SQLException {
		int ans=0;
		
		try(PreparedStatement ps=connection.prepareStatement("update product set product_name=?,cat_id=?,sub_cat_id=?,product_image=COALESCE(?,product_image),product_price=?,product_desc=?,maintenance=?,sunlight=?,watering=?,offer_id=?,afteroffer_price=? where product_id=?"))
		{
			ps.setString(1, p.getProduct_name());
			ps.setInt(2, p.getCat_id());
			ps.setInt(3, p.getSub_catid());
			ps.setBlob(4, p.getProduct_img());
			ps.setInt(5, p.getPrice());
			ps.setString(6, p.getDesc());
			ps.setString(7, p.getMaintenance());
			ps.setString(8, p.getSunlight());
			ps.setString(9, p.getWatering());
			ps.setInt(10, p.getOffer_id());
			ps.setInt(11, p.getAfterofferprice());
			ps.setInt(12, p.getId());
			ans=ps.executeUpdate();
			
			System.out.println("Product image "+p.getProduct_img());
		}
		return ans;
	}

	@Override
	public List<Product> fetchProductData(Connection connection, int subcat) throws SQLException {
		List<Product> product=new ArrayList<>();
		
		
		try(PreparedStatement ps=connection.prepareStatement("select * from product where sub_cat_id=? and status=?"))
		{
			ps.setInt(1, subcat);
			ps.setInt(2, 1);
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					Product p=new Product();
					p.setId(resultset.getInt("product_id"));
					p.setProduct_name(resultset.getString("product_name"));
					p.setCat_id(resultset.getInt("cat_id"));
					p.setSub_catid(resultset.getInt("sub_cat_id"));
					//p.setProduct_img((resultset.getBlob("product_image"));
					//byte[] imagedata=resultset.getBytes("product_image");
					Blob blob = resultset.getBlob("product_image");
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
					if(null!=imageBytes && imageBytes.length>0)
					{ 
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					inputStream.close();
	                outputStream.close();
					if(null!=imageBytes && imageBytes.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					p.setPrice(resultset.getInt("product_price"));
					p.setDesc(resultset.getString("product_desc"));
					p.setMaintenance(resultset.getString("maintenance"));
					p.setSunlight(resultset.getString("sunlight"));
					p.setWatering(resultset.getString("watering"));
					p.setOffer_id(resultset.getInt("offer_id"));
					p.setStatus(resultset.getBoolean("status"));
					p.setAfterofferprice(resultset.getInt("afteroffer_price"));
					product.add(p);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return product;

	}

	@Override
	public List<Product> fetchPerticularProductData(Connection connection, int product_id) throws SQLException {
		
		List<Product> product=new ArrayList<>();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from product where product_id=?"))
		{
			ps.setInt(1, product_id);
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					Product p=new Product();
					p.setId(resultset.getInt("product_id"));
					p.setProduct_name(resultset.getString("product_name"));
					p.setCat_id(resultset.getInt("cat_id"));
					p.setSub_catid(resultset.getInt("sub_cat_id"));
					//p.setProduct_img((resultset.getBlob("product_image"));
					//byte[] imagedata=resultset.getBytes("product_image");
					Blob blob = resultset.getBlob("product_image");
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
					if(null!=imageBytes && imageBytes.length>0)
					{ 
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					inputStream.close();
	                outputStream.close();
					if(null!=imageBytes && imageBytes.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					p.setPrice(resultset.getInt("product_price"));
					p.setDesc(resultset.getString("product_desc"));
					p.setMaintenance(resultset.getString("maintenance"));
					p.setSunlight(resultset.getString("sunlight"));
					p.setWatering(resultset.getString("watering"));
					p.setOffer_id(resultset.getInt("offer_id"));
					p.setStatus(resultset.getBoolean("status"));
					p.setAfterofferprice(resultset.getInt("afteroffer_price"));
					product.add(p);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return product;


	}

	@Override
	public List<Gallery> selectGalleryDetails(Connection connection) throws SQLException {
		List<Gallery> gallery=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from gallery");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Gallery g=new Gallery();
					g.setGalleryId(resultset.getInt("gallery_id"));
					
					g.setProductId(resultset.getInt("product_id"));
					
					byte[] imagedata=resultset.getBytes("product_images");
					if(null!=imagedata && imagedata.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imagedata);
						g.setGallery_imgString(imgstring);
					}
				
					gallery.add(g);
			}
			
		}
		return gallery;
	}

	@Override
	public int insertGalleryDetails(Connection connection, Gallery gallery) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into gallery(product_id,product_images) values(?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
		
			ps.setInt(1, gallery.getProductId());
			ps.setBlob(2, gallery.getGallery_imgstream());
			ans = ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public Gallery printGalleryDetails(Connection connection, int galleryid) throws SQLException {
		Gallery g=new Gallery();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from gallery where gallery_id=?"))
		{
			ps.setInt(1, galleryid);
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					g.setGalleryId(resultset.getInt("gallery_id"));
					g.setProductId(resultset.getInt("product_id"));
				
					byte[] imagedata=resultset.getBytes("product_images");
					if(null!=imagedata && imagedata.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imagedata);
						g.setGallery_imgString(imgstring);
					}
					
					
				}
			}
			
		}
		
		return g;

	}

	@Override
	public int updateGalleryDetails(Connection connection, Gallery gallery) throws SQLException {
		int ans=0;
		String updateQuery="update gallery set product_id=?,product_images=COALESCE(?,product_images) where gallery_id= ? ";
		try(PreparedStatement ps=connection.prepareStatement(updateQuery)){
			
			ps.setInt(1, gallery.getProductId());
			ps.setBlob(2, gallery.getGallery_imgstream());
			ps.setInt(3, gallery.getGalleryId());
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public int deleteGalleryDetails(Connection connection, int galleryid) throws SQLException {
		int ans=0;
		
		try(PreparedStatement ps=connection.prepareStatement("delete from gallery where gallery_id=?" )){
			
			ps.setInt(1, galleryid);
			
			ans=ps.executeUpdate();
		}
		return ans;	}

	@Override
	public int insertfeedbackdetails(Connection connection, Feedback fb) throws SQLException {
		int ans=0;
		
		try(PreparedStatement ps=connection.prepareStatement("insert into feedback(product_id, feedback_details, feedback_rate, user_id) values(?,?,?,?)"))
		{
			ps.setInt(1, fb.getPid());
			ps.setString(2,fb.getComment());
			ps.setInt(3, fb.getStar());
			ps.setInt(4, fb.getUid());
			
			ans=ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public List<Feedback> selectfeedbackdetail(Connection connection) throws SQLException {
		List<Feedback> fb=new ArrayList<>();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from feedback"); ResultSet rs=ps.executeQuery())
		{
			while(rs.next())
			{
				Feedback f=new Feedback();  
				f.setFid(rs.getInt(1));
				f.setPid(rs.getInt(2));
				f.setComment(rs.getString(3));
				f.setStar(rs.getInt(4));
				f.setUid(rs.getInt(5));
				fb.add(f);
			}
			
		}
		return fb;
	}

	@Override
	public int deleteFeedbackdetails(Connection connection, int pid) throws SQLException {
		int ans=0;
		
		try(PreparedStatement ps=connection.prepareStatement("delete from feedback where feedback_id=?"))
		{
			ps.setInt(1, pid);
			ans=ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public List<Product> displayTrendingProduct(Connection connection)throws SQLException {
		List<Product> product=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("SELECT product_id, SUM(quantity) as TotalQuantity\r\n" + 
				"FROM order_details\r\n" + 
				"GROUP BY product_id\r\n" + 
				"ORDER BY SUM(quantity) DESC\r\n" + 
				"LIMIT 4;\r\n" + 
				"");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Product p=new Product();
					p.setId(resultset.getInt("product_id"));
					product.add(p);
			}
			
		}
		return product;
	}

	@Override
	public List<Product> getBookedProductRatio(Connection connection) throws SQLException {
		List<Product> product=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("SELECT distinct product_id \r\n" + 
				"from order_details");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Product p=new Product();
					p.setId(resultset.getInt("product_id"));
					product.add(p);
			}
			
		}
		return product;
	}

	@Override
	public List<Product> fetchsearchProduct(Connection connection, String productname) throws SQLException {
		List<Product> product=new ArrayList<>();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from product where product_name=?"))
		{
			System.out.println("product name in dao :"+productname);
			ps.setString(1, productname);
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					Product p=new Product();
					p.setId(resultset.getInt("product_id"));
					p.setProduct_name(resultset.getString("product_name"));
					p.setCat_id(resultset.getInt("cat_id"));
					p.setSub_catid(resultset.getInt("sub_cat_id"));
					//p.setProduct_img((resultset.getBlob("product_image"));
					//byte[] imagedata=resultset.getBytes("product_image");
	                Blob blob = resultset.getBlob("product_image");
	                 
	                InputStream inputStream = blob.getBinaryStream();
	                ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
	                byte[] buffer = new byte[4096];
	                int bytesRead = -1;
	                 
	                while ((bytesRead = inputStream.read(buffer)) != -1) {
	                    outputStream.write(buffer, 0, bytesRead);                  
	                }
	                 
	                byte[] imageBytes = outputStream.toByteArray();
					if(null!=imageBytes && imageBytes.length>0)
					{ 
						String imgstring=Base64.getEncoder().encodeToString(imageBytes);
						p.setProduct_imgstring(imgstring);
					}
					
					inputStream.close();
	                outputStream.close();
					
					p.setPrice(resultset.getInt("product_price"));
					p.setDesc(resultset.getString("product_desc"));
					p.setMaintenance(resultset.getString("maintenance"));
					p.setSunlight(resultset.getString("sunlight"));
					p.setWatering(resultset.getString("watering"));
					p.setOffer_id(resultset.getInt("offer_id"));
					p.setStatus(resultset.getBoolean("status"));
					p.setAfterofferprice(resultset.getInt("afteroffer_price"));
					product.add(p);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return product;

	}
}
