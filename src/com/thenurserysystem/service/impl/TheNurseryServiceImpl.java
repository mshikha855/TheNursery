package com.thenurserysystem.service.impl;

import java.sql.Connection;



import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Area;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.dao.TheNurseryDao;
import com.thenurserysystem.dao.impl.TheNurseryDaoImpl;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.util.ThreadEmail;

public class TheNurseryServiceImpl implements TheNurseryService {
	TheNurseryDao d = new TheNurseryDaoImpl();

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurseryschema?autoReconnect=true&useSSL=false", "root",
					"root@12345");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Area> fetchareadetails() {
		List<Area> area = new ArrayList<>();
		try (Connection connection = getConnection()) {
			area = d.fetchareadetails(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return area;
	}

	@Override
	public int SaveUserDetails(User u) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			ans = d.InsertUserDetails(connection, u);
			System.out.println(ans);
			if (ans== 1) {
				
				/*SendEmail s = new SendEmail();
				String msg = "<h1>Dear, " + u.getFname() + "</h1>";
				msg+="\n<font color=green size=5>Your Registration Success!</font>\n\n<h3>Thank You for Register</h3>";
				String mail = u.getEmail();
				s.sendmail(mail, msg);*/
				String msg = "<h1>Dear, " + u.getFname() + "</h1>";
				msg+="\n<font color=green size=5>Your Registration Success!</font>\n\n<h3>Thank You for Register</h3>";
				ThreadEmail threadEmail = new ThreadEmail();
				threadEmail.Send(u.getEmail(),msg);
				Thread t1 = new Thread(threadEmail);
				t1.start();
				
				
				/*Thread t1=new Thread(threadEmail);
				t1.start();
				t1.run();
				try
				{
					t1.sleep(5000);
				}
				catch (Exception e) {
					// TODO: handle exception
				}*/
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int Checkemaildetails(String email) {
		int ans = 0;
		try (Connection connection = getConnection()) {
			ans = d.Checkemail(connection, email);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public User CheckLoginDetails(User u) {
		User u1 = new User();
		try (Connection connection = getConnection()) {
			u1 = d.CheckLoginData(connection, u);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return u1;
	}

	@Override
	public User findpassword(String email) {
		User u = new User();
		try (Connection connection = getConnection()) {

			u = d.forgetpassword(connection, email);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public String Findareaeditprofile(int pincode) {
		String s = null;
		try (Connection connection = getConnection()) {

			s = d.editProfileAreaName(connection, pincode);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return s;
	}

	@Override
	public int updateUserDetail(User u) {
		int ans = 0;
		try (Connection connection = getConnection()) {

			ans = d.UpdateUserDetails(connection, u);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<User> selectUserDetails() {
		List<User> u = new ArrayList<>();
		try (Connection connection = getConnection()) {

			u = d.SelectUserDetails(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

	@Override
	public int deleteUserDetails(String userid) {
		int ans = 0;
		try (Connection connection = getConnection()) {

			ans=d.deleteUserDetails(connection, Integer.parseInt(userid));
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int updatepassworddetails(String userid, String password) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=d.updatepassword(connection, userid, password);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<User> selectGardenerDetails() {
		List<User> u = new ArrayList<>();
		try (Connection connection = getConnection()) {

			u = d.SelectGardenerDetails(connection);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

		
}