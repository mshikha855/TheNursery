package com.thenurserysystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.dao.CategoryDao;

public class CategoryDaoImpl implements CategoryDao {
	
	@Override
	public List<Category> SelectCategoryDetails(Connection connection) throws SQLException {
		List<Category> cat=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from category");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Category c=new Category();
					c.setCat_id(resultset.getInt("cat_id"));
					c.setCat_name(resultset.getString("cat_name"));
					c.setStatus(resultset.getInt("status"));
					cat.add(c);
			}
			
		}
		return cat;
	}

	@Override
	public int deleteCategoryDetails(Connection connection, int catid) throws SQLException {
		int status=0;
		int ans2=0;
		try(PreparedStatement ps1=connection.prepareStatement("select * from category where cat_id=?"))
		{
			ps1.setInt(1, catid);
			try(ResultSet rs=ps1.executeQuery())
			{
				while(rs.next())
				{
					status=rs.getInt("status");
				}
			}
		}
		if(status==0)
		{
			status=1;
		}
		else
		{
			status=0;
		}
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("update category set status=? where cat_id=?" )){	
			ps.setInt(1, status);	
			ps.setInt(2, catid);
			
				ans=ps.executeUpdate();
		}
		
		try(PreparedStatement ps=connection.prepareStatement("update subcategory set status=? where cat_id=?" )){	
						ps.setInt(1, status);	
						ps.setInt(2, catid);
						
							ans2=ps.executeUpdate();
			}
		
		try(PreparedStatement ps=connection.prepareStatement("update product set status=? where cat_id=?" )){	
						ps.setInt(1, status);	
						ps.setInt(2, catid);
						
							ans2=ps.executeUpdate();
			}
		
	return ans;
		
	}

	@Override
	public int insertCategoryDetails(Connection connection, Category cat) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into category(cat_name) values(?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setString(1,cat.getCat_name());
			
			ans = ps.executeUpdate();
		}
		
		return ans;
		
	}

	@Override
	public Category printCategoryDetails(Connection connection, String cat_Id) throws SQLException {
		Category c=new Category();
			try(PreparedStatement preparedStatement=connection.prepareStatement("select * from category where cat_id = ?"))
			{
			
				preparedStatement.setString(1, cat_Id);
				
				ResultSet resultset=preparedStatement.executeQuery();
			
				while(resultset.next())
				{
						c.setCat_id(resultset.getInt("cat_id"));
						c.setCat_name(resultset.getString("cat_name"));		
				}
			}
			catch(Exception e)
			{
				e.printStackTrace();
			}
		return c;
	}

	@Override
	public int updateCategory(Connection connection, Category category) throws SQLException {
		int ans=0;
		String updateQuery="update category set cat_name=? where cat_id= ? ";
		try(PreparedStatement ps=connection.prepareStatement(updateQuery)){
			
			ps.setString(1, category.getCat_name());
			ps.setInt(2, category.getCat_id());
			
			ans=ps.executeUpdate();
		}
		return ans;
	}


}
