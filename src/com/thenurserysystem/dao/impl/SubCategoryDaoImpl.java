package com.thenurserysystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.dao.SubCategoryDao;

public class SubCategoryDaoImpl implements SubCategoryDao {
	

	@Override
	public int insertSubCategoryDetails(Connection connection, int catid, String subcatname) throws SQLException {
		int a=0;
		try(PreparedStatement ps=connection.prepareStatement("insert into subcategory(cat_id, sub_cat_name) values(?,?)");)
		{
			ps.setInt(1, catid);
			ps.setString(2, subcatname);
			
			a=ps.executeUpdate();
		}
		return a;
	}

	@Override
	public List<Category> selectSubCategoryDetails(Connection connection) throws SQLException {
		List<Category> cat=new ArrayList<>();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from subcategory"))
		{
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					Category c1=new Category();
					c1.setSubcat_id(resultset.getInt(1));
					c1.setCat_id(resultset.getInt(2));
					c1.setCat_name(resultset.getString(3));
					c1.setStatus(resultset.getInt(4));
					cat.add(c1);
					
				}
			}
		}
		
		return cat;
	}

	@Override
	public int deleteSubCategory(Connection connection, int subCatId) throws SQLException {
		int subcatstatus=0;
		int ans2=0;
		try(PreparedStatement ps2=connection.prepareStatement("select * from subcategory where sub_cat_id=?"))
		{
			ps2.setInt(1, subCatId);
			System.out.println("inside dio impl "+subCatId);
			try(ResultSet rs2=ps2.executeQuery())
			{
				while(rs2.next())
				{
					subcatstatus=rs2.getInt("status");
					if(subcatstatus==0)
					{
						subcatstatus=1;
					}
					else
					{
						subcatstatus=0;
					}
					
					try(PreparedStatement ps=connection.prepareStatement("update subcategory set status=? where sub_cat_id=?" )){	
						ps.setInt(1, subcatstatus);	
						ps.setInt(2, subCatId);
						
							ans2=ps.executeUpdate();
							System.out.println("ans2 = "+ans2);
					}
				}
			}
		}
		try(PreparedStatement ps=connection.prepareStatement("update product set status=? where sub_cat_id=?" )){	
				ps.setInt(1, subcatstatus);	
				ps.setInt(2, subCatId);
						
							ans2=ps.executeUpdate();
		}
		return ans2;
	}

	@Override
	public Category printSubCategory(Connection connection, int subCatId) throws SQLException {
		Category cat=new Category();
		try(PreparedStatement ps=connection.prepareStatement("select * from subcategory where sub_cat_id=?"))
		{
			ps.setInt(1, subCatId);
			
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					cat.setSubcat_id(resultset.getInt(1));
					cat.setCat_id(resultset.getInt(2));
					cat.setCat_name(resultset.getString(3));
				}
			}
		}
		return cat;
	}

	@Override
	public int updateSubCategory(Connection connection, Category cat) throws SQLException {
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("update subcategory set sub_cat_name=?,cat_id=? where sub_cat_id=?"))
		{
		
			ps.setString(1, cat.getCat_name());
			ps.setInt(2, cat.getCat_id());
			ps.setInt(3, cat.getSubcat_id());
			
			ans=ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public List<Category> fetchSubCategoryDetails(Connection connection, int catid) throws SQLException {
		
		List<Category> cat=new ArrayList<>();

		System.out.println("in dao");
		try(PreparedStatement ps=connection.prepareStatement("select * from subcategory where cat_id = ?"))
		{
			ps.setInt(1, catid);
			try(ResultSet resultset=ps.executeQuery())
			{
				
				while(resultset.next())
				{
					Category c1=new Category();
					c1.setSubcat_id(resultset.getInt(1));
					c1.setCat_name(resultset.getString(3));
					c1.setStatus(resultset.getInt(4));
					cat.add(c1);
				
				}
			}
			System.out.println("before return");
		}
		return cat;
	
	}


}
