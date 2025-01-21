package com.thenurserysystem.test;


import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.servlet.ServiceCODServlet;

public class ServiceCODServletTest {

	@InjectMocks
    private ServiceCODServlet servlet;

    @Mock
    private ServiceService serviceService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private ServiceBooking serviceBooking;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void testDoGet_SuccessfulForward() throws Exception {
        // Arrange
        String orderId = "12345";
        when(request.getParameter("ORDER_ID")).thenReturn(orderId);
        when(serviceService.fetchbookedservicedetail(orderId)).thenReturn(serviceBooking);

        // Act
        servlet.doGet(request, response);

        // Assert
        verify(serviceService).fetchbookedservicedetail(orderId);  // Ensure service method was called
        verify(request).setAttribute("CashService", serviceBooking);  // Ensure the correct attribute is set
        verify(requestDispatcher).forward(request, response);  // Ensure the request is forwarded to the correct JSP
    }

    @Test
    public void testDoPost_SuccessfulForward() throws Exception {
        // Arrange
        String orderId = "12345";
        when(request.getParameter("ORDER_ID")).thenReturn(orderId);
        when(serviceService.fetchbookedservicedetail(orderId)).thenReturn(serviceBooking);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(serviceService).fetchbookedservicedetail(orderId);  // Ensure service method was called
        verify(request).setAttribute("CashService", serviceBooking);  // Ensure the correct attribute is set
        verify(requestDispatcher).forward(request, response);  // Ensure the request is forwarded to the correct JSP
    }

    @Test
    public void testDoGet_ServiceNotFound() throws Exception {
        // Arrange
        String orderId = "12345";
        when(request.getParameter("ORDER_ID")).thenReturn(orderId);
        when(serviceService.fetchbookedservicedetail(orderId)).thenReturn(null);

        // Act
        servlet.doGet(request, response);

        // Assert
        verify(serviceService).fetchbookedservicedetail(orderId);  // Ensure service method was called
        verify(request).setAttribute(eq("CashService"), isNull());  // Ensure the attribute is set to null
        verify(requestDispatcher).forward(request, response);  // Ensure the request is forwarded
    }

    @Test
    public void testDoPost_ServiceNotFound() throws Exception {
        // Arrange
        String orderId = "12345";
        when(request.getParameter("ORDER_ID")).thenReturn(orderId);
        when(serviceService.fetchbookedservicedetail(orderId)).thenReturn(null);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(serviceService).fetchbookedservicedetail(orderId);  // Ensure service method was called
        verify(request).setAttribute(eq("CashService"), isNull());  // Ensure the attribute is set to null
        verify(requestDispatcher).forward(request, response);  // Ensure the request is forwarded
    }

}
