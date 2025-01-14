package com.thenurserysystem.test;

import static org.junit.Assert.*;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Product;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.servlet.BookedPlantsRatio;

public class BookedPlantsRatioTest {

	@Mock
    private ProductService mockProductService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockDispatcher;

    private BookedPlantsRatio servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Initialize the servlet
        servlet = new BookedPlantsRatio();

        // Inject the mock ProductService into the servlet using reflection
        java.lang.reflect.Field psField = BookedPlantsRatio.class.getDeclaredField("ps");
        psField.setAccessible(true);
        psField.set(servlet, mockProductService);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Arrange
        List<Product> mockProductList = new ArrayList<>();
        mockProductList.add(new Product("Plant1", 10));
        mockProductList.add(new Product("Plant2", 15));

        when(mockProductService.selectOrderProductRatio()).thenReturn(mockProductList);
        when(mockRequest.getRequestDispatcher(anyString())).thenReturn(mockDispatcher);

        // Act
        servlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockProductService).selectOrderProductRatio();
        verify(mockRequest).setAttribute("ProductRatio", mockProductList);
    }

}
