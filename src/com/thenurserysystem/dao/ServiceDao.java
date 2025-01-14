package com.thenurserysystem.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.bean.ServiceDetails;

public interface ServiceDao {

	List<Service> selectServiceDetails(Connection connection) throws SQLException;

	int insertServiceDetails(Connection connection, Service s) throws SQLException;

	Service fetchServiceDetails(Connection connection, int serviceid)throws SQLException;

	int UpdateServiceDetails(Connection connection, Service service) throws SQLException;

	void deleteServiceDetails(Connection connection, int serviceid) throws SQLException;

	List<Service> selectedServiceDetails(Connection connection, int serviceId) throws SQLException;

	int insertServiceBookingDetails(Connection connection, ServiceBooking service) throws SQLException;

	ServiceBooking fetchbookedservicedetail(Connection connection, String serviceid)throws SQLException;

	List<ServiceBooking> selectBookedServicedetails(Connection connection)throws SQLException;

	int updateservicestatus(Connection connection, String sid)throws SQLException;

	int updateServicePaymentStatus(Connection connection, ServiceBooking sb) throws SQLException;

	int assignGardenerDetails(Connection connection, ServiceDetails servicedetails) throws SQLException;

	int deletefaildpaymentservicedetail(Connection connection, String serviceid)throws SQLException;

	List<ServiceDetails> fetchgardenerservicelist(Connection connection)throws SQLException;

	List<ServiceBooking> fetchRatioOfBookedService(Connection connection)throws SQLException;

	

	

}
