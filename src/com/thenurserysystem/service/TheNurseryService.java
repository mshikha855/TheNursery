package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Area;
import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.User;

public interface TheNurseryService {

	public List<Area> fetchareadetails();
	
	public int SaveUserDetails(User u);
	
	public int Checkemaildetails(String email);
	
	public User CheckLoginDetails(User u);
	
	public User findpassword(String email);
	
	public String Findareaeditprofile(int pincode);
	
	public int updateUserDetail(User u);
	
	public List<User> selectUserDetails();
	
	public int deleteUserDetails(String userid);
	
	public int updatepassworddetails(String userid,String password);

	public List<User> selectGardenerDetails();
	
}
