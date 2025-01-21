package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;

import com.thenurserysystem.bean.ServiceDetails;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.servlet.AssignGardenerServlet;

import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class AssignGardenerServletTest {
	
	@Mock
    private ServiceService mockServiceService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    private AssignGardenerServlet servlet;
    
    @Before
    public void setUp() throws Exception {
        servlet = new AssignGardenerServlet();
        servlet.ss = mockServiceService; // Inject mock service into servlet
    }

    @Test
    public void testDoGet_Success() throws ServletException, IOException {
        // Arrange
        int serviceId = 1;
        int gardenerId = 101;
        String bookingId = "B123";

        when(mockRequest.getParameter("serviceid")).thenReturn(String.valueOf(serviceId));
        when(mockRequest.getParameter("gardenerid")).thenReturn(String.valueOf(gardenerId));
        when(mockRequest.getParameter("bookingid")).thenReturn(bookingId);
        when(mockServiceService.assignGardenerDetails(any(ServiceDetails.class))).thenReturn(1); // Success

        // Act
        servlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockServiceService).assignGardenerDetails(any(ServiceDetails.class));
        verify(mockResponse).sendRedirect("BookedServiceList.jsp");
    }

    @Test
    public void testDoGet_Failure() throws ServletException, IOException {
        // Arrange
        int serviceId = 1;
        int gardenerId = 101;
        String bookingId = "B123";

        when(mockRequest.getParameter("serviceid")).thenReturn(String.valueOf(serviceId));
        when(mockRequest.getParameter("gardenerid")).thenReturn(String.valueOf(gardenerId));
        when(mockRequest.getParameter("bookingid")).thenReturn(bookingId);
        when(mockServiceService.assignGardenerDetails(any(ServiceDetails.class))).thenReturn(0); // Failure

        // Act
        servlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockServiceService).assignGardenerDetails(any(ServiceDetails.class));
        // Verify no redirect happens
        verify(mockResponse, never()).sendRedirect("BookedServiceList.jsp");
    }
}
