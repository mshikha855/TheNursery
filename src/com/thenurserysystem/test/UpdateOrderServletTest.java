package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.servlet.UpdateOrderServlet;

import javax.servlet.http.*;

public class UpdateOrderServletTest {

	@InjectMocks
    private UpdateOrderServlet servlet; // The servlet to test

    @Mock
    private OrderService od; // Mocking the OrderService dependency

    @Mock
    private HttpServletRequest request; // Mocking HttpServletRequest

    @Mock
    private HttpServletResponse response; // Mocking HttpServletResponse

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    public void testDoGet_SuccessfulUpdate() throws Exception {
        // Given: Mocking the request parameter
        when(request.getParameter("id")).thenReturn("123"); // Mock order ID
        
        // Mocking the OrderService method behavior to simulate success
        when(od.updateOrderDetails("123")).thenReturn(1); // Simulate successful update

        // When: Calling the doGet method
        servlet.doGet(request, response);

        // Then: Verify the update method was called
        verify(od).updateOrderDetails("123"); // Verify that the updateOrderDetails method was invoked with the correct order ID
        
        // Verify that the servlet performs a redirect to the OrderList.jsp
        verify(response).sendRedirect("OrderList.jsp");
    }

    @Test
    public void testDoGet_FailedUpdate() throws Exception {
        // Given: Mocking the request parameter
        when(request.getParameter("id")).thenReturn("123"); // Mock order ID
        
        // Mocking the OrderService method behavior to simulate failure
        when(od.updateOrderDetails("123")).thenReturn(0); // Simulate failed update

        // When: Calling the doGet method
        servlet.doGet(request, response);

        // Then: Verify the update method was called
        verify(od).updateOrderDetails("123"); // Verify that the updateOrderDetails method was invoked with the correct order ID
        
        // Verify that the servlet does not perform any redirect in case of failure
        verify(response, times(0)).sendRedirect("OrderList.jsp"); // No redirect in case of failure
    }

    @Test
    public void testDoPost() throws Exception {
    	// Given: Mocking the request parameter
        when(request.getParameter("id")).thenReturn("123"); // Mock order ID
        
        // Mocking the OrderService method behavior to simulate success
        when(od.updateOrderDetails("123")).thenReturn(1); // Simulate successful update

        // When: Calling the doPost method (which delegates to doGet)
        servlet.doPost(request, response);

        // Then: Verify that the update method was invoked
        verify(od).updateOrderDetails("123"); // Verify that the updateOrderDetails method was invoked with the correct order ID
        
        // Verify that the servlet performs a redirect after the successful update
        verify(response).sendRedirect("OrderList.jsp");
    }

}
