package com.thenurserysystem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.dao.CategoryDao;
import com.thenurserysystem.dao.impl.CategoryDaoImpl;
import com.thenurserysystem.service.CategoryService;

public class CategoryServiceImpl implements CategoryService {
	
	CategoryDao d=new CategoryDaoImpl();
	
	public Connection getConnection() {
		System.out.println("Insidedddddd....");
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurseryschema?autoReconnect=true&useSSL=false", "root",
					"root@12345");
			
			System.out.println("Insidedddddd...."+connection);
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	
	@Override
	public List<Category> selectCategoryDetails() {
		
		List<Category> cat = new ArrayList<>();
		try (Connection connection = getConnection()) {

			cat = d.SelectCategoryDetails(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return cat;

		
	}

	@Override
	public int deleteCategory(String catid) {
		int ans = 0;
		try (Connection connection = getConnection()) {

			ans=d.deleteCategoryDetails(connection, Integer.parseInt(catid));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
		
	}

	@Override
	public int saveCategoryDetails(Category cat) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			
			ans = d.insertCategoryDetails(connection, cat);
			
			System.out.println(ans);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public Category fetchCategoryDetails(String cat_Id) {

		Category category =new Category();
		try (Connection connection = getConnection()) {
			
			category = d.printCategoryDetails(connection, cat_Id);
			
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return category;
		
	}

	@Override
	public int modifyCategoryDetails(Category category) {
		
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.updateCategory(connection, category);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}


}
