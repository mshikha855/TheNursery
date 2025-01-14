package com.thenurserysystem.dao.impl;

import java.sql.Connection;



import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.thenurserysystem.bean.Area;
import com.thenurserysystem.bean.Category;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.dao.TheNurseryDao;


public class TheNurseryDaoImpl implements TheNurseryDao {

	@Override
	public List<Area> fetchareadetails(Connection connection) throws SQLException {
		List<Area> area = new ArrayList<>();
		try (PreparedStatement ps = connection.prepareStatement("select * from area");
				ResultSet resultset = ps.executeQuery();) {

			while (resultset.next()) {
				Area a = new Area();
				a.setPincode(resultset.getInt(1));
				a.setAreaname(resultset.getString(2));
				area.add(a);
			}
		}
		return area;
	}

	@Override
	public int InsertUserDetails(Connection connection, User u) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into user(user_fname,user_lname,email,password,contactno,address,role,pincode) values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getContactno());
			ps.setString(6, u.getAddress());
			ps.setString(7, u.getRole());
			ps.setInt(8, u.getPincode());
			ans = ps.executeUpdate();
		}
		
		return ans;
	}

	@Override
	public int Checkemail(Connection connection, String email) throws SQLException {
		int ans = 0;
		try (PreparedStatement ps = connection.prepareStatement("select * from user");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				if (email.equals(resultset.getString("email")) && resultset.getInt("status")==1) {
					ans = 1;
					break;
				}
			}

		}
		return ans;
	}

	@Override
	public User CheckLoginData(Connection connection, User u) throws SQLException {
		User u1 = new User();
		try (PreparedStatement ps = connection.prepareStatement("select * from user");
				ResultSet resultset = ps.executeQuery()) {
			while (resultset.next()) {
				String email = resultset.getString("email");
				String password = resultset.getString("password");
				if (email.equalsIgnoreCase(u.getEmail()) && password.equals(u.getPassword())) {
					u1.setUserid(resultset.getInt(1));
					u1.setFname(resultset.getString(2));
					u1.setLname(resultset.getString(3));
					u1.setEmail(email);
					u1.setPassword(password);
					u1.setContactno(resultset.getString(6));
					u1.setAddress(resultset.getString(7));
					u1.setRole(resultset.getString(8));
					u1.setPincode(resultset.getInt(9));
					u1.setStatus(resultset.getInt(10));
				}
			}
		}
		return u1;
	}

	@Override
	public User forgetpassword(Connection connection, String email) throws SQLException {
		User u = new User();
		try (PreparedStatement ps = connection.prepareStatement("Select * from user")) {
			try (ResultSet resultset = ps.executeQuery()) {
				while (resultset.next()) {
					if (email.equals(resultset.getString("email"))) {
						u.setUserid(resultset.getInt(1));
						u.setFname(resultset.getString(2));
						u.setLname(resultset.getString(3));
						u.setEmail(resultset.getString(4));
						u.setPassword(resultset.getString(5));
						u.setContactno(resultset.getString(6));
						u.setAddress(resultset.getString(7));
						u.setRole(resultset.getString(8));
						u.setPincode(resultset.getInt(9));
						u.setStatus(resultset.getInt(10));
					}
				}
			}
		}
		return u;
	}

	@Override
	public String editProfileAreaName(Connection connection, int pincode) throws SQLException {
		String s1=null;
		try(PreparedStatement ps=connection.prepareStatement("select * from area where pincode=?")){
			
			ps.setInt(1, pincode);
			
			try(ResultSet resultset=ps.executeQuery())
			{
				while(resultset.next())
				{
					s1=resultset.getString(2);
				}
			}
		}
		return s1;
	}

	@Override
	public int UpdateUserDetails(Connection connection, User u) throws SQLException {
		int ans=0;
		String updateQuery="update user set user_fname=?,user_lname=?,email=?,password=?,contactno=?,address=?,pincode=? where user_id=? ";
		try(PreparedStatement ps=connection.prepareStatement(updateQuery)){
			
			ps.setString(1, u.getFname());
			ps.setString(2, u.getLname());
			ps.setString(3, u.getEmail());
			ps.setString(4, u.getPassword());
			ps.setString(5, u.getContactno());
			ps.setString(6, u.getAddress());
			ps.setInt(7, u.getPincode());
			ps.setInt(8, u.getUserid());
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<User> SelectUserDetails(Connection connection) throws SQLException {
		List<User> user=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from user where role='User'"); ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
				if(resultset.getInt(10)==1)
				{
					User u=new User();
					u.setUserid(resultset.getInt(1));
					u.setFname(resultset.getString(2));
					u.setLname(resultset.getString(3));
					u.setEmail(resultset.getString(4));
					u.setPassword(resultset.getString(5));
					u.setContactno(resultset.getString(6));
					u.setAddress(resultset.getString(7));
					u.setRole(resultset.getString(8));
					u.setPincode(resultset.getInt(9));
					u.setStatus(resultset.getInt(10));
					user.add(u);
				}
			}
			
		}
		return user;
	}

	@Override
	public int deleteUserDetails(Connection connection, int userid) throws SQLException {
			int ans=0;
		
			try(PreparedStatement ps=connection.prepareStatement("update user set status=0 where user_id=?" )){
				
				ps.setInt(1, userid);
				
				ans=ps.executeUpdate();
			}
		return ans;
	}

	@Override
	public int updatepassword(Connection connection, String userid, String password) throws SQLException {
		int ans=0;
		
		try(PreparedStatement ps=connection.prepareStatement("update user set password=? where user_id=?"))
		{
			ps.setString(1, password);
			ps.setString(2,userid);
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<User> SelectGardenerDetails(Connection connection) throws SQLException {
		List<User> user=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from user where role='Gardener'"); ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
				if(resultset.getInt(10)==1)
				{
					User u=new User();
					u.setUserid(resultset.getInt(1));
					u.setFname(resultset.getString(2));
					u.setLname(resultset.getString(3));
					u.setEmail(resultset.getString(4));
					u.setPassword(resultset.getString(5));
					u.setContactno(resultset.getString(6));
					u.setAddress(resultset.getString(7));
					u.setRole(resultset.getString(8));
					u.setPincode(resultset.getInt(9));
					u.setStatus(resultset.getInt(10));
					user.add(u);
				}
			}
			
		}
		return user;
	}
	
	}
