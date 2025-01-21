package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.servlet.Updateservicestatus;

public class UpdateservicestatusTest {

	private Updateservicestatus servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private ServiceService serviceService;

    @Before
    public void setUp() {
        // Initialize servlet and mock dependencies
        servlet = new Updateservicestatus();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        serviceService = mock(ServiceService.class);

        // Inject mock into servlet
        servlet.ss = serviceService;
    }

    @Test
    public void testDoGet_SuccessfulUpdate() throws Exception {
        // Mock request parameters
        when(request.getParameter("id")).thenReturn("service1");

        // Mock service method
        when(serviceService.updateservicestatus("service1")).thenReturn(1);

        // Execute the servlet's doGet method
        servlet.doGet(request, response);

        // Verify that service method was called
        verify(serviceService).updateservicestatus("service1");

        // Verify redirect
        verify(response).sendRedirect("ServiceListofGardener.jsp");
    }

    @Test
    public void testDoGet_FailedUpdate() throws Exception {
        // Mock request parameters
        when(request.getParameter("id")).thenReturn("service1");

        // Mock service method to return failure
        when(serviceService.updateservicestatus("service1")).thenReturn(0);

        // Execute the servlet's doGet method
        servlet.doGet(request, response);

        // Verify that service method was called
        verify(serviceService).updateservicestatus("service1");

        // Verify no redirect occurs if service update fails
        verify(response, never()).sendRedirect("ServiceListofGardener.jsp");
    }

    @Test
    public void testDoPost() throws Exception {
    	// Test that doPost works correctly
        when(request.getParameter("id")).thenReturn("service1");

        // Mock service method to return success
        when(serviceService.updateservicestatus("service1")).thenReturn(1);

        // Execute the servlet's doPost method
        servlet.doPost(request, response);

        // Verify that service method was called
        verify(serviceService).updateservicestatus("service1");

        // Verify redirect
        verify(response).sendRedirect("ServiceListofGardener.jsp");
    }

}
