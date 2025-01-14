package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Category;

public interface CategoryService {
	
	public List<Category> selectCategoryDetails();

	public int deleteCategory(String catid);

	public int saveCategoryDetails(Category cat);

	public Category fetchCategoryDetails(String cat_Id);

	public int modifyCategoryDetails(Category category);


}
