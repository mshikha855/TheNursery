package com.thenurserysystem.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.bean.Service;
import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.bean.ServiceDetails;
import com.thenurserysystem.dao.ServiceDao;

public class ServiceDaoImpl implements ServiceDao {

	@Override
	public List<Service> selectServiceDetails(Connection connection) throws SQLException {
		List<Service> service=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from service");
				ResultSet resultset=ps.executeQuery()){
			
			while(resultset.next())
			{
					Service s=new Service();
					s.setServiceId(resultset.getInt("service_id"));
					s.setServiceDetails(resultset.getString("service_details"));
					s.setServiceAmount(resultset.getInt("service_amount"));
					s.setDescription(resultset.getString("description"));
					byte[] imagedata=resultset.getBytes("service_image");
					if(null!=imagedata && imagedata.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imagedata);
						s.setServiceImageString(imgstring);
					}
					service.add(s);
			}
		}

		return service;
	}

	@Override
	public int insertServiceDetails(Connection connection, Service s) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into service(service_details,service_amount,service_image,description) values(?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setString(1, s.getServiceDetails());
			ps.setInt(2, s.getServiceAmount());
			ps.setBlob(3, s.getServiceImageStream());
			ps.setString(4,s.getDescription());
			
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public Service fetchServiceDetails(Connection connection, int serviceid)throws SQLException {
		Service service=new Service();
		try(PreparedStatement preparedStatement=connection.prepareStatement("select * from service where service_id = ?"))
		{
		
			preparedStatement.setInt(1, serviceid);
			
			ResultSet resultset=preparedStatement.executeQuery();
		
			while(resultset.next())
			{
					service.setServiceId(resultset.getInt("service_id"));
					service.setServiceAmount(resultset.getInt("service_amount"));
					service.setServiceDetails(resultset.getString("service_details"));
					byte[] imagedata=resultset.getBytes("service_image");
					if(null!=imagedata && imagedata.length>0)
					{
						String imgstring=Base64.getEncoder().encodeToString(imagedata);
						service.setServiceImageString(imgstring);
					}				
					service.setDescription(resultset.getString("description"));
			}
		}
		return service;
	}

	@Override
	public int UpdateServiceDetails(Connection connection, Service service) throws SQLException {
		int ans = 0;
		String insertQuery = "update service set service_details=?,service_amount=?,service_image=COALESCE(?,service_image),description=? where service_id=?";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setString(1, service.getServiceDetails());
			ps.setInt(2, service.getServiceAmount());
			ps.setBlob(3, service.getServiceImageStream());
			ps.setString(4, service.getDescription());
			ps.setInt(5, service.getServiceId());
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public void deleteServiceDetails(Connection connection, int serviceid) throws SQLException {
		String insertQuery = "delete from service where service_id=?";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setInt(1,serviceid);
			ps.executeUpdate();
		}
		
	}

	@Override
	public List<Service> selectedServiceDetails(Connection connection, int serviceId) throws SQLException {
		List<Service> serviceList=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from service where service_id = ?"))
		{
				ps.setInt(1, serviceId);
				try(ResultSet resultset=ps.executeQuery())
				{
					while(resultset.next())
					{
							Service s=new Service();
							s.setServiceId(resultset.getInt("service_id"));
							s.setServiceDetails(resultset.getString("service_details"));
							s.setServiceAmount(resultset.getInt("service_amount"));
							byte[] imagedata=resultset.getBytes("service_image");
							if(null!=imagedata && imagedata.length>0)
							{
								String imgstring=Base64.getEncoder().encodeToString(imagedata);
								s.setServiceImageString(imgstring);
							}
							s.setDescription(resultset.getString("description"));
							serviceList.add(s);
					}
				}
		}

		return serviceList;
	}

	@Override
	public int insertServiceBookingDetails(Connection connection, ServiceBooking service) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into service_booking(booking_id, booking_date, amount, gardener_id, user_id, service_area, service_address,service_id) values(?,?,?,?,?,?,?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			ps.setString(1,service.getBookingid());
			ps.setString(2, service.getDate());
			ps.setInt(3, service.getAmount());
			ps.setInt(4, 0);
			ps.setInt(5, service.getUserid());
			ps.setString(6, service.getServicearea());
			ps.setString(7,service.getServiceaddress());
			ps.setInt(8, service.getServiceid());
			ans = ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public ServiceBooking fetchbookedservicedetail(Connection connection, String serviceid) throws SQLException {
		ServiceBooking sb=new ServiceBooking();
		
		try(PreparedStatement ps=connection.prepareStatement("select * from service_booking where booking_id=?"))
		{
			ps.setString(1, serviceid);
			
			try(ResultSet rs=ps.executeQuery())
			{
				while(rs.next())
				{
					sb.setBookingid(rs.getString(1));
					sb.setBookingstatus(rs.getInt(2));
					sb.setPaymentstatus(rs.getInt(3));
					sb.setDate(rs.getString(4));
					sb.setDescription(rs.getString(5));
					sb.setAmount(Integer.parseInt(rs.getString(6)));
					sb.setGardenerid(rs.getInt(7));
					sb.setUserid(rs.getInt(8));
					sb.setServicearea(rs.getString(9));
					sb.setServiceaddress(rs.getString(10));
					sb.setServiceid(rs.getInt(11));
				}
			}
		}
		return sb;
	}

	@Override
	public List<ServiceBooking> selectBookedServicedetails(Connection connection) throws SQLException {
		List<ServiceBooking> sb=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from service_booking"); 
			ResultSet rs=ps.executeQuery())
			{
				while(rs.next())
				{
					ServiceBooking s=new ServiceBooking();
					s.setBookingid(rs.getString(1));
					s.setBookingstatus(rs.getInt(2));
					s.setPaymentstatus(rs.getInt(3));
					s.setDate(rs.getString(4));
					s.setDescription(rs.getString(5));
					s.setAmount(Integer.parseInt(rs.getString(6)));
					s.setGardenerid(rs.getInt(7));
					s.setUserid(rs.getInt(8));
					s.setServicearea(rs.getString(9));
					s.setServiceaddress(rs.getString(10));
					s.setServiceid(rs.getInt(11));
					sb.add(s);
				}
			}
		return sb;
	}

	@Override
	public int updateservicestatus(Connection connection, String sid) throws SQLException {
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("update service_booking set booking_status=? where booking_id=?"))
		{
			ps.setInt(1, 1);
			ps.setString(2,sid);
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public int updateServicePaymentStatus(Connection connection, ServiceBooking sb) throws SQLException {
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("update service_booking set payment_status=? where booking_id=?"))
		{
			ps.setInt(1, 1);
			ps.setString(2,sb.getBookingid());
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public int assignGardenerDetails(Connection connection, ServiceDetails servicedetails) throws SQLException {
		int ans = 0;
		String insertQuery = "insert into service_details(service_id,gardener_id) values(?,?)";
		try (PreparedStatement ps = connection.prepareStatement(insertQuery)) {
			
			ps.setInt(1, servicedetails.getServiceId());
			ps.setInt(2, servicedetails.getGardenerId());
			ans = ps.executeUpdate();
			
		}
	
		if(ans>0)
		{
			try (PreparedStatement ps = connection.prepareStatement("update service_booking set gardener_id=? where booking_id=?")) {
				
				ps.setInt(1, servicedetails.getGardenerId());
				ps.setString(2, servicedetails.getBookingId());
				ans = ps.executeUpdate();
				
			}
		
		}
		return ans;
	}

	@Override
	public int deletefaildpaymentservicedetail(Connection connection, String serviceid) throws SQLException {
		int ans=0;
		try(PreparedStatement ps=connection.prepareStatement("delete from service_booking where booking_id=?"))
		{
			ps.setString(1, serviceid);
			
			ans=ps.executeUpdate();
		}
		return ans;
	}

	@Override
	public List<ServiceDetails> fetchgardenerservicelist(Connection connection) throws SQLException {
		List<ServiceDetails> sd=new ArrayList<>();
		try(PreparedStatement ps=connection.prepareStatement("select * from service_details");
			ResultSet rs=ps.executeQuery();	)
		{
			while(rs.next())
			{
				ServiceDetails sd1=new ServiceDetails();
				sd1.setServiceDetailsId(rs.getInt(1));
				sd1.setServiceId(rs.getInt(2));
				sd1.setGardenerId(rs.getInt(3));
				sd.add(sd1);
			}
		}
		return sd;
	}

	@Override
	public List<ServiceBooking> fetchRatioOfBookedService(Connection connection)throws SQLException {

		List<ServiceBooking> sd=new ArrayList<>();
		
		try(PreparedStatement ps=connection.prepareStatement("SELECT distinct service_id \r\n" + 
				"from service_booking"))
		{	
			try(ResultSet rs=ps.executeQuery())
			{
				while(rs.next())
				{
					ServiceBooking s=new ServiceBooking();
					s.setServiceid(rs.getInt("service_id"));
					sd.add(s);
				}
			}
		}
		return sd;
	}
}
