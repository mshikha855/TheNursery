package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.servlet.UpdateProductServlet;

import javax.servlet.http.*;
import javax.servlet.http.Part;

public class UpdateProductServletTest {

    @InjectMocks
    private UpdateProductServlet servlet; // The servlet to test

    @Mock
    private ProductService ps; // Mocking the ProductService dependency

    @Mock
    private HttpServletRequest request; // Mocking HttpServletRequest

    @Mock
    private HttpServletResponse response; // Mocking HttpServletResponse

    @Mock
    private Part part; // Mocking Part (file upload)

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initializes mocks
    }

    @Test
    public void testDoPost_SuccessfulUpdate() throws Exception {
        // Given: Mocking request parameters
        when(request.getParameter("productid")).thenReturn("1");
        when(request.getParameter("category")).thenReturn("101");
        when(request.getParameter("subcategory")).thenReturn("202");
        when(request.getParameter("product_name")).thenReturn("Product A");
        when(request.getParameter("product_price")).thenReturn("100");
        when(request.getParameter("product_main")).thenReturn("Low");
        when(request.getParameter("product_sunlight")).thenReturn("Full");
        when(request.getParameter("product_watering")).thenReturn("Medium");
        when(request.getParameter("product_offer")).thenReturn("1");
        when(request.getParameter("product_desc")).thenReturn("A nice product");
        when(request.getPart("product_image")).thenReturn(part);
        when(part.getSize()).thenReturn(1024L); // Simulating a file upload with a size

        // Mock ProductService method behavior
        when(ps.UpdateProductDetail(any(Product.class))).thenReturn(1); // Simulate successful update

        // When: Calling the doPost method
        servlet.doPost(request, response);

        // Then: Verify the product update method was called
        verify(ps).UpdateProductDetail(any(Product.class)); // Check that the update method was invoked

        // Verify that the servlet performs a redirect to the ProductList.jsp
        verify(response).sendRedirect("ProductList.jsp");
    }

    @Test
    public void testDoPost_FailedUpdate() throws Exception {
        // Given: Mocking request parameters for the test
        when(request.getParameter("productid")).thenReturn("1");
        when(request.getParameter("category")).thenReturn("101");
        when(request.getParameter("subcategory")).thenReturn("202");
        when(request.getParameter("product_name")).thenReturn("Product A");
        when(request.getParameter("product_price")).thenReturn("100");
        when(request.getParameter("product_main")).thenReturn("Low");
        when(request.getParameter("product_sunlight")).thenReturn("Full");
        when(request.getParameter("product_watering")).thenReturn("Medium");
        when(request.getParameter("product_offer")).thenReturn("1");
        when(request.getParameter("product_desc")).thenReturn("A nice product");
        when(request.getPart("product_image")).thenReturn(part);
        when(part.getSize()).thenReturn(1024L); // Simulating a file upload with a size

        // Mock ProductService method behavior to simulate failure
        when(ps.UpdateProductDetail(any(Product.class))).thenReturn(0); // Simulate failed update

        // When: Calling the doPost method
        servlet.doPost(request, response);

        // Then: Verify the product update method was called
        verify(ps).UpdateProductDetail(any(Product.class)); // Check that the update method was invoked

        // Verify that the servlet performs no redirect in case of failure
        verify(response, times(0)).sendRedirect("ProductList.jsp"); // No redirect in case of failure
    }

    @Test
    public void testProductDataMapping() throws Exception {
        // Given: Mocking request parameters for the test
        when(request.getParameter("productid")).thenReturn("1");
        when(request.getParameter("category")).thenReturn("101");
        when(request.getParameter("subcategory")).thenReturn("202");
        when(request.getParameter("product_name")).thenReturn("Product A");
        when(request.getParameter("product_price")).thenReturn("100");
        when(request.getParameter("product_main")).thenReturn("Low");
        when(request.getParameter("product_sunlight")).thenReturn("Full");
        when(request.getParameter("product_watering")).thenReturn("Medium");
        when(request.getParameter("product_offer")).thenReturn("1");
        when(request.getParameter("product_desc")).thenReturn("A nice product");
        when(request.getPart("product_image")).thenReturn(part);
        when(part.getSize()).thenReturn(1024L); // Simulating a file upload with a size

        // When: Calling the doPost method
        servlet.doPost(request, response);

        // Then: Verify that the product data was correctly mapped
        ArgumentCaptor<Product> captor = ArgumentCaptor.forClass(Product.class);
        verify(ps).UpdateProductDetail(captor.capture());
        Product capturedProduct = captor.getValue();

        // Assert that the captured product has the expected values
        assertEquals(1, capturedProduct.getId());
        assertEquals(101, capturedProduct.getCat_id());
        assertEquals(202, capturedProduct.getSub_catid());
        assertEquals("Product A", capturedProduct.getProduct_name());
        assertEquals(100, capturedProduct.getPrice());
        assertEquals("Low", capturedProduct.getMaintenance());
        assertEquals("Full", capturedProduct.getSunlight());
        assertEquals("Medium", capturedProduct.getWatering());
        assertEquals(1, capturedProduct.getOffer_id());
        assertEquals("A nice product", capturedProduct.getDesc());
    }
}

