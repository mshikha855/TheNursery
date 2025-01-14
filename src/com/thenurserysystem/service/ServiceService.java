package com.thenurserysystem.service;

import java.util.List;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.bean.ServiceDetails;

public interface ServiceService {

	List<Service> fetchServiceDetails();

	int saveServiceDetails(Service s);

	Service FindServiceDetail(int serviceid);

	int modifyServiceDetails(Service service);

	void deleteServiceDetails(int parseInt);

	List<Service> fetchSelectedServiceDetails(int service_id);

	int saveServiceBookingDetails(ServiceBooking service);

	ServiceBooking fetchbookedservicedetail(String serviceid);

	List<ServiceBooking> selectBookedServicedetails();

	int updateservicestatus(String sid);
	
	int updateServiePaymentStatus(ServiceBooking sb);

	int assignGardenerDetails(ServiceDetails sd);
	
	int deletefaildpaymentbookingdata(String serviceid);

	List<ServiceDetails> selectgardenerservicedetails();

	List<ServiceBooking> FetchServiceRatio();

}
