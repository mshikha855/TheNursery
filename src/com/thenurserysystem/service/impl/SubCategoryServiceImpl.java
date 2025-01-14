package com.thenurserysystem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.dao.SubCategoryDao;
import com.thenurserysystem.dao.TheNurseryDao;
import com.thenurserysystem.dao.impl.SubCategoryDaoImpl;
import com.thenurserysystem.dao.impl.TheNurseryDaoImpl;
import com.thenurserysystem.service.SubCategoryService;

public class SubCategoryServiceImpl implements SubCategoryService {
	
	SubCategoryDao d = new SubCategoryDaoImpl();

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
	public int saveSubCategoryDetails(int catid, String subcatname)  {
		int a=0;
		try(Connection connection=getConnection())
		{
			a=d.insertSubCategoryDetails(connection, catid, subcatname);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return a;
	}

	@Override
	public List<Category> selectSubcategory() {
		List<Category> cat=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			cat=d.selectSubCategoryDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat;
	}

	@Override
	public int deleteSubCategory(int subCatID) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.deleteSubCategory(connection, subCatID);	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public Category findsubcategory(int subCatId) {
		Category cat=new Category();
		
		try(Connection connection=getConnection())
		{
			cat=d.printSubCategory(connection, subCatId);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return cat;
	}

	@Override
	public int updateSubcategory(Category cat) {
		int ans=0;
		
		try(Connection connection=getConnection()){
			
			ans=d.updateSubCategory(connection, cat);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public List<Category> fetchsubcategoeyList(String catid) {
		
		List<Category> cat=new ArrayList<>();
		System.out.println("in service");
		try(Connection connection=getConnection();)
		{
			cat=d.fetchSubCategoryDetails(connection,Integer.parseInt(catid));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("In service:"+cat);
		return cat;

	}

	@Override
	public List<Category> selectSubcategoryDetails() {
		List<Category> cat=new ArrayList<>();
	
		try(Connection connection=getConnection();)
		{
			cat=d.selectSubCategoryDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		return cat;

	}

}
