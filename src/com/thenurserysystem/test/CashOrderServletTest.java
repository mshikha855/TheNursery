package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.CashOrderServlet;

public class CashOrderServletTest {

    @Mock
    private OrderService mockOrderService;

    @Mock
    private TheNurseryService mockNurseryService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockDispatcher;

    private CashOrderServlet servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Initialize the servlet
        servlet = new CashOrderServlet();

        // Inject the mock OrderService into the servlet using reflection
        java.lang.reflect.Field osField = CashOrderServlet.class.getDeclaredField("os");
        osField.setAccessible(true);
        osField.set(servlet, mockOrderService);

        // Inject the mock TheNurseryService into the servlet using reflection
        java.lang.reflect.Field nsField = CashOrderServlet.class.getDeclaredField("ns");
        nsField.setAccessible(true);
        nsField.set(servlet, mockNurseryService);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // Arrange
        String mockOrderId = "12345";
        OrderDetails mockOrderDetails = new OrderDetails();
        mockOrderDetails.setOrderid(mockOrderId);

        when(mockRequest.getParameter("ORDER_ID")).thenReturn(mockOrderId);
        when(mockOrderService.fetchOrderDetailsData(mockOrderId)).thenReturn(mockOrderDetails);
        when(mockRequest.getRequestDispatcher("CashOnDeliveryDetails.jsp")).thenReturn(mockDispatcher);

        // Act
        servlet.doPost(mockRequest, mockResponse);

        // Assert
        verify(mockRequest).getParameter("ORDER_ID");
        verify(mockOrderService).fetchOrderDetailsData(mockOrderId);
        verify(mockRequest).setAttribute("CashOrder", mockOrderDetails);
        verify(mockDispatcher).forward(mockRequest, mockResponse);
    }
}

