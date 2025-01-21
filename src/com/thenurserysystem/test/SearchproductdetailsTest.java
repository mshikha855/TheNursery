package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.servlet.Searchproductdetails;

public class SearchproductdetailsTest {

    @InjectMocks
    private Searchproductdetails servlet;

    @Mock
    private ProductService productService;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private Product product;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        when(request.getRequestDispatcher(anyString())).thenReturn(requestDispatcher);
    }

    @Test
    public void testDoGet_SuccessfulForward() throws Exception {
        // Arrange
        String productName = "Rose";
        List<Product> productList = Arrays.asList(product);
        
        when(request.getParameter("proname")).thenReturn(productName);
        when(productService.fetchSearchProduct(productName)).thenReturn(productList);

        // Act
        servlet.doGet(request, response);

        // Assert
        verify(request).getParameter("proname");  // Verify the proname parameter is retrieved
        verify(productService).fetchSearchProduct(productName);  // Verify service method is called
        verify(request).setAttribute("ProductData", productList);  // Ensure ProductData is set in the request
        verify(requestDispatcher).forward(request, response);  // Verify forwarding to the correct JSP
    }

    @Test
    public void testDoPost_DelegatesToDoGet() throws Exception {
        // Arrange
        String productName = "Tulip";
        List<Product> productList = Arrays.asList(product);
        
        when(request.getParameter("proname")).thenReturn(productName);
        when(productService.fetchSearchProduct(productName)).thenReturn(productList);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(request).getParameter("proname");  // Verify the proname parameter is retrieved
        verify(productService).fetchSearchProduct(productName);  // Verify service method is called
        verify(request).setAttribute("ProductData", productList);  // Ensure ProductData is set in the request
        verify(requestDispatcher).forward(request, response);  // Verify forwarding to the correct JSP
    }

    @Test
    public void testDoGet_NoProductsFound() throws Exception {
        // Arrange
        String productName = "Orchid";
        List<Product> emptyList = Arrays.asList();
        
        when(request.getParameter("proname")).thenReturn(productName);
        when(productService.fetchSearchProduct(productName)).thenReturn(emptyList);

        // Act
        servlet.doGet(request, response);

        // Assert
        verify(request).getParameter("proname");  // Verify the proname parameter is retrieved
        verify(productService).fetchSearchProduct(productName);  // Verify service method is called
        verify(request).setAttribute("ProductData", emptyList);  // Ensure ProductData is set to an empty list
        verify(requestDispatcher).forward(request, response);  // Verify forwarding to the correct JSP
    }
}
