package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Category;

public interface SubCategoryDao {
	
	
	public int insertSubCategoryDetails(Connection connection,int catid,String subcatname)throws SQLException;
	
	public List<Category> selectSubCategoryDetails(Connection connection)throws SQLException;
	
	public int deleteSubCategory(Connection connection , int subCatId)throws SQLException;
	
	public Category printSubCategory(Connection connection ,int subCatId)throws SQLException;
	
	public int updateSubCategory(Connection connection,Category cat)throws SQLException;

	public List<Category> fetchSubCategoryDetails(Connection connection, int catid) throws SQLException;


}
