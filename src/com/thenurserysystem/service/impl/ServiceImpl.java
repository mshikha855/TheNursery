package com.thenurserysystem.service.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.bean.Service;
import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.bean.ServiceDetails;
import com.thenurserysystem.dao.ServiceDao;
import com.thenurserysystem.dao.impl.ServiceDaoImpl;
import com.thenurserysystem.service.ServiceService;

public class ServiceImpl implements ServiceService {
	
	ServiceDao sd=new ServiceDaoImpl();

	public Connection getConnection() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		try {
			Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/nurseryschema?autoReconnect=true&useSSL=false", "root","root@12345");
			return connection;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;

	}

	@Override
	public List<Service> fetchServiceDetails() {
		
		List<Service> serviceList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			serviceList=sd.selectServiceDetails(connection);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return serviceList;
	}

	@Override
	public int saveServiceDetails(Service s) {

		int ans=0;
		try(Connection connection=getConnection();)
		{
			ans=sd.insertServiceDetails(connection,s);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public Service FindServiceDetail(int serviceid) {
		Service service=new Service();
		try(Connection connection=getConnection();)
		{
			service=sd.fetchServiceDetails(connection,serviceid);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
		return service;
	}

	@Override
	public int modifyServiceDetails(Service service) {
		int ans=0;
		try(Connection connection=getConnection();)
		{
			ans=sd.UpdateServiceDetails(connection,service);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public void deleteServiceDetails(int serviceid) {
		try(Connection connection=getConnection();)
		{
			sd.deleteServiceDetails(connection,serviceid);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		
	}

	@Override
	public List<Service> fetchSelectedServiceDetails(int serviceId) {
		List<Service> serviceList=new ArrayList<>();
		
		try(Connection connection=getConnection();)
		{
			serviceList=sd.selectedServiceDetails(connection,serviceId);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return serviceList;
	}

	@Override
	public int saveServiceBookingDetails(ServiceBooking service) {
		int ans=0;
		try(Connection connection=getConnection();)
		{
			ans=sd.insertServiceBookingDetails(connection,service);
		}
		catch(SQLException e)
		{
			e.printStackTrace();
		}
		return ans;
	
	}

	@Override
	public ServiceBooking fetchbookedservicedetail(String serviceid) {
		ServiceBooking sb=new ServiceBooking();
		try(Connection connection=getConnection())
		{
			sb=sd.fetchbookedservicedetail(connection,serviceid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

	@Override
	public List<ServiceBooking> selectBookedServicedetails() {
		List<ServiceBooking> sb=new ArrayList<>();
		try(Connection connection=getConnection())
		{
			sb=sd.selectBookedServicedetails(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

	@Override
	public int updateservicestatus(String sid) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=sd.updateservicestatus(connection,sid);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	

	@Override
	public int updateServiePaymentStatus(ServiceBooking sb) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=sd.updateServicePaymentStatus(connection,sb);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public int assignGardenerDetails(ServiceDetails servicedetails) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=sd.assignGardenerDetails(connection,servicedetails);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return ans;
	}

	@Override
	public int deletefaildpaymentbookingdata(String serviceid) {
		int ans=0;
		try(Connection connection=getConnection())
		{
			ans=sd.deletefaildpaymentservicedetail(connection,serviceid);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ans;
	}

	@Override
	public List<ServiceDetails> selectgardenerservicedetails() {
		List<ServiceDetails> sd1=new ArrayList<>();
		try(Connection connection=getConnection())
		{
			sd1=sd.fetchgardenerservicelist(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sd1;
	}

	@Override
	public List<ServiceBooking> FetchServiceRatio() {
		List<ServiceBooking> sb=new ArrayList<>();
		try(Connection connection=getConnection())
		{
			sb=sd.fetchRatioOfBookedService(connection);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return sb;
	}

}
