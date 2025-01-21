package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.Service;
import com.thenurserysystem.service.ServiceService;
import com.thenurserysystem.servlet.UpdateServiceDetails;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;
import java.util.*;


public class UpdateServiceDetailsTest {


    @InjectMocks
    private UpdateServiceDetails servlet; // The servlet to test

    @Mock
    private ServiceService ss; // Mocking the ServiceService dependency

    @Mock
    private HttpServletRequest request; // Mocking HttpServletRequest

    @Mock
    private HttpServletResponse response; // Mocking HttpServletResponse

    @Mock
    private RequestDispatcher dispatcher; // Mocking RequestDispatcher

    @Mock
    private Part part; // Mocking the Part object for file upload

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    public void testDoPost_SuccessfulUpdate() throws Exception {
        // Given
        when(request.getParameter("serviceid")).thenReturn("101");
        when(request.getParameter("Service_details")).thenReturn("Service Description");
        when(request.getParameter("Service_amount")).thenReturn("500");
        when(request.getParameter("service_desc")).thenReturn("Detailed Service Description");
        when(request.getPart("Service_image")).thenReturn(part);
        when(part.getSize()).thenReturn(100L);
        when(part.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[0])); // Mock file stream

        Service mockService = mock(Service.class);
        when(ss.modifyServiceDetails(any(Service.class))).thenReturn(1); // Mocking the service update to return success

        // Mocking the RequestDispatcher
        when(request.getRequestDispatcher("ServiceList.jsp")).thenReturn(dispatcher);

        // When
        servlet.doPost(request, response);

        // Then
        verify(ss).modifyServiceDetails(any(Service.class)); // Verify service update method is called
        verify(request).setAttribute("message", "Service Update Sucess..!!!"); // Verify the success message
        verify(dispatcher).forward(request, response); // Verify the dispatcher is forwarded to ServiceList.jsp
    }

    @Test
    public void testDoPost_FailedUpdate() throws Exception {
        // Given
        when(request.getParameter("serviceid")).thenReturn("101");
        when(request.getParameter("Service_details")).thenReturn("Service Description");
        when(request.getParameter("Service_amount")).thenReturn("500");
        when(request.getParameter("service_desc")).thenReturn("Detailed Service Description");
        when(request.getPart("Service_image")).thenReturn(part);
        when(part.getSize()).thenReturn(100L);
        when(part.getInputStream()).thenReturn(new ByteArrayInputStream(new byte[0])); // Mock file stream

        Service mockService = mock(Service.class);
        when(ss.modifyServiceDetails(any(Service.class))).thenReturn(0); // Mocking the service update to return failure

        // When
        servlet.doPost(request, response);

        // Then
        verify(ss).modifyServiceDetails(any(Service.class)); // Verify service update method is called
        verify(request, times(0)).setAttribute("message", "Service Update Sucess..!!!"); // No success message if failed
        verify(dispatcher, times(0)).forward(request, response); // No forwarding if update failed
    }
}
