package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Category;

public interface CategoryDao {

	public List<Category> SelectCategoryDetails(Connection connection) throws SQLException;

	public int deleteCategoryDetails(Connection connection, int catid) throws SQLException;

	public int insertCategoryDetails(Connection connection, Category cat) throws SQLException;

	public Category printCategoryDetails(Connection connection, String cat_Id) throws SQLException;

	public int updateCategory(Connection connection, Category category) throws SQLException;

}
