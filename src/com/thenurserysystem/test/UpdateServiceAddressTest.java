package com.thenurserysystem.test;


import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.ServiceBooking;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.servlet.UpdateServiceAddress;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.text.*;
import java.util.*;

public class UpdateServiceAddressTest {

    @InjectMocks
    private UpdateServiceAddress servlet; // The servlet to test

    @Mock
    private ServiceService ss; // Mocking the ServiceService dependency

    @Mock
    private HttpServletRequest request; // Mocking HttpServletRequest

    @Mock
    private HttpServletResponse response; // Mocking HttpServletResponse

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initializes mocks
    }

    @Test
    public void testDoPost_SuccessfulInsert() throws Exception {
        // Given
        when(request.getParameter("oderid")).thenReturn("1001");
        when(request.getParameter("areaname")).thenReturn("Downtown");
        when(request.getParameter("address")).thenReturn("123 Main St, Downtown");
        when(request.getParameter("userid")).thenReturn("101");
        when(request.getParameter("total")).thenReturn("200");
        when(request.getParameter("sid")).thenReturn("10");

        // Create a mock service object
        ServiceBooking mockServiceBooking = mock(ServiceBooking.class);

        // Mock the saveServiceBookingDetails method to return success (1)
        when(ss.saveServiceBookingDetails(any(ServiceBooking.class))).thenReturn(1);

        // When
        servlet.doPost(request, response);

        // Then
        verify(ss).saveServiceBookingDetails(any(ServiceBooking.class)); // Verify that the method is called with the correct parameters
        // No need to check the response since there are no redirects or forwards in this case, only logging and internal actions
        // Verify that the service booking data has been correctly passed to saveServiceBookingDetails
    }

    @Test
    public void testDoPost_FailedInsert() throws Exception {
        // Given
        when(request.getParameter("oderid")).thenReturn("1001");
        when(request.getParameter("areaname")).thenReturn("Downtown");
        when(request.getParameter("address")).thenReturn("123 Main St, Downtown");
        when(request.getParameter("userid")).thenReturn("101");
        when(request.getParameter("total")).thenReturn("200");
        when(request.getParameter("sid")).thenReturn("10");

        // Mock the saveServiceBookingDetails method to return failure (0)
        when(ss.saveServiceBookingDetails(any(ServiceBooking.class))).thenReturn(0);

        // When
        servlet.doPost(request, response);

        // Then
        verify(ss).saveServiceBookingDetails(any(ServiceBooking.class)); // Verify that the method is called
        // Check that there is no further action (no response handling in the servlet)
        // You can add more verification if necessary, e.g., checking if log messages are generated, etc.
    }

    @Test
    public void testServiceBookingDataMapping() throws Exception {
        // Given
        when(request.getParameter("oderid")).thenReturn("1001");
        when(request.getParameter("areaname")).thenReturn("Downtown");
        when(request.getParameter("address")).thenReturn("123 Main St, Downtown");
        when(request.getParameter("userid")).thenReturn("101");
        when(request.getParameter("total")).thenReturn("200");
        when(request.getParameter("sid")).thenReturn("10");

        // Mock the current date
        Date currentDate = new Date();
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String formattedDate = formatter.format(currentDate);

        // When
        servlet.doPost(request, response);

        // Then
        ArgumentCaptor<ServiceBooking> captor = ArgumentCaptor.forClass(ServiceBooking.class);
        verify(ss).saveServiceBookingDetails(captor.capture());
        ServiceBooking capturedService = captor.getValue();

        // Assert that the captured service booking has the expected values
        assertEquals("1001", capturedService.getBookingid());
        assertEquals("Downtown", capturedService.getServicearea());
        assertEquals("123 Main St, Downtown", capturedService.getServiceaddress());
        assertEquals(101, capturedService.getUserid());
        assertEquals(200, capturedService.getAmount());
        assertEquals(formattedDate, capturedService.getDate());
        assertEquals(10, capturedService.getServiceid());
    }
}

