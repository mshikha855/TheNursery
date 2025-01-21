package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.thenurserysystem.bean.Cart;
import com.thenurserysystem.bean.CartProduct;
import com.thenurserysystem.bean.OrderDetails;
import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.CartService;
import com.thenurserysystem.service.OrderService;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.UpdateShippingAddress;

public class UpdateShippingAddressTest {


    private UpdateShippingAddress servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private CartService cartService;
    private ProductService productService;
    private OrderService orderService;

    @Before
    public void setUp() {
        // Initialize servlet and mock dependencies
        servlet = new UpdateShippingAddress();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);

        cartService = mock(CartService.class);
        productService = mock(ProductService.class);
        orderService = mock(OrderService.class);

        // Inject mocks into the servlet
        servlet.c = cartService;
        servlet.ps = productService;
        servlet.os = orderService;
    }

    @Test
    public void testDoPost_SuccessfulUpdate() throws IOException, ServletException {
        // Mock request parameters
        when(request.getParameter("areaname")).thenReturn("Downtown");
        when(request.getParameter("address")).thenReturn("123 Main Street");
        when(request.getParameter("quantity")).thenReturn("2 1");
        when(request.getParameter("userid")).thenReturn("101");
        when(request.getParameter("oderid")).thenReturn("OD12345");
        when(request.getParameter("total")).thenReturn("350.75");

        // Mock cart and product details
        List<Cart> mockCartList = new ArrayList<>();
        mockCartList.add(new Cart(1, 101, 10)); // Cart(userId, productId, quantity)

        List<Product> mockProductList = new ArrayList<>();
        mockProductList.add(new Product("Product A",100)); // Product(id, name, price)

        when(cartService.fetchCartDetails()).thenReturn(mockCartList);
        when(productService.selectProductDetails()).thenReturn(mockProductList);

        // Mock order service behavior
        when(orderService.saveOrderDetails(any(OrderDetails.class))).thenReturn(1);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify service interactions
        verify(cartService).fetchCartDetails();
        verify(productService).selectProductDetails();
        verify(orderService).saveOrderDetails(any(OrderDetails.class));

        // Verify response (no redirects are performed in this servlet)
        verify(response, never()).sendRedirect(anyString());
    }

    @Test
    public void testDoPost_FailedOrderSave() throws IOException, ServletException {
        // Mock request parameters
        when(request.getParameter("areaname")).thenReturn("Downtown");
        when(request.getParameter("address")).thenReturn("123 Main Street");
        when(request.getParameter("quantity")).thenReturn("2 1");
        when(request.getParameter("userid")).thenReturn("101");
        when(request.getParameter("oderid")).thenReturn("OD12345");
        when(request.getParameter("total")).thenReturn("350.75");

        // Mock cart and product details
        List<Cart> mockCartList = new ArrayList<>();
        mockCartList.add(new Cart(1, 101, 10)); // Cart(userId, productId, quantity)

        List<Product> mockProductList = new ArrayList<>();
        mockProductList.add(new Product("Product A", 100)); // Product(id, name, price)

        when(cartService.fetchCartDetails()).thenReturn(mockCartList);
        when(productService.selectProductDetails()).thenReturn(mockProductList);

        // Mock order service behavior (save fails)
        when(orderService.saveOrderDetails(any(OrderDetails.class))).thenReturn(0);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify service interactions
        verify(cartService).fetchCartDetails();
        verify(productService).selectProductDetails();
        verify(orderService).saveOrderDetails(any(OrderDetails.class));

        // Verify response (no redirects are performed in this servlet)
        verify(response, never()).sendRedirect(anyString());
    }

}
