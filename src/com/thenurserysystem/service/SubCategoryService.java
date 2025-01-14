package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Category;

public interface SubCategoryService {
	
public int saveSubCategoryDetails(int catid,String subcatname);
	
	public List<Category> selectSubcategory();
	
	public int deleteSubCategory(int subCatID);
	
	public Category findsubcategory(int subCatId);
	
	public int updateSubcategory(Category cat);

	public List<Category> fetchsubcategoeyList(String catid);

	public List<Category> selectSubcategoryDetails();


}
