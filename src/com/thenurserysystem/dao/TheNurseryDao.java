package com.thenurserysystem.dao;

import java.sql.Connection;

import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Area;
import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.User;

public interface TheNurseryDao {

	public List<Area> fetchareadetails(Connection connection) throws SQLException;
	
	public int InsertUserDetails(Connection connection,User u)throws SQLException;

	public int Checkemail(Connection connection,String email)throws SQLException;
	
	public User CheckLoginData(Connection connection,User u)throws SQLException;
	
	public User forgetpassword(Connection connection,String email)throws SQLException;
	
	public String editProfileAreaName(Connection connection,int pincode)throws SQLException;
	
	public int UpdateUserDetails(Connection connection,User u)throws SQLException;
	
	public List<User> SelectUserDetails(Connection connection)throws SQLException;
	
	public int deleteUserDetails(Connection connection,int userid)throws SQLException;
	
	public int updatepassword(Connection connection,String userid,String password)throws SQLException;

	public List<User> SelectGardenerDetails(Connection connection) throws SQLException;

	
}
