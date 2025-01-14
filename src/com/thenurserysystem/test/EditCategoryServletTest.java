package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.service.CategoryService;
import com.thenurserysystem.servlet.EditCategoryServlet;

public class EditCategoryServletTest {

	private EditCategoryServlet editCategoryServlet;

    @Mock
    private CategoryService mockCategoryService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockDispatcher;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Initialize the servlet and inject the mock service
        editCategoryServlet = new EditCategoryServlet();
        java.lang.reflect.Field nsField = EditCategoryServlet.class.getDeclaredField("ns");
        nsField.setAccessible(true);
        nsField.set(editCategoryServlet, mockCategoryService);
    }

    @Test
    public void testDoGet_SuccessfulCategoryFetch() throws ServletException, IOException {
        // Arrange
        String categoryId = "123";
        Category mockCategory = new Category(123, "Fruits");
        
        when(mockRequest.getParameter("id")).thenReturn(categoryId);
        when(mockCategoryService.fetchCategoryDetails(categoryId)).thenReturn(mockCategory);
        when(mockRequest.getRequestDispatcher("EditCategory.jsp")).thenReturn(mockDispatcher);

        // Act
        editCategoryServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockRequest, times(1)).getParameter("id");
        verify(mockCategoryService, times(1)).fetchCategoryDetails(categoryId);
        verify(mockRequest, times(1)).setAttribute("categoryList", mockCategory);
        verify(mockDispatcher, times(1)).forward(mockRequest, mockResponse);
    }

    @Test
    public void testDoGet_InvalidCategoryId() throws ServletException, IOException {
        // Arrange
        String categoryId = null; // Simulate a missing category ID
        when(mockRequest.getParameter("id")).thenReturn(categoryId);

        // Act
        editCategoryServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockRequest, times(1)).getParameter("id");
        verify(mockCategoryService, never()).fetchCategoryDetails(anyString());
        verify(mockResponse, times(1)).sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid category ID");
    }

    @Test
    public void testDoGet_CategoryNotFound() throws ServletException, IOException {
    	// Arrange
        String categoryId = "999"; // Non-existing category ID
        when(mockRequest.getParameter("id")).thenReturn(categoryId);
        when(mockCategoryService.fetchCategoryDetails(categoryId)).thenReturn(null); // Simulate no category found

        // Act
        editCategoryServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockCategoryService, times(1)).fetchCategoryDetails(categoryId);
        verify(mockRequest, never()).setAttribute(eq("categoryList"), any());
        verify(mockResponse, times(1)).sendError(HttpServletResponse.SC_NOT_FOUND, "Category not found");
    }

}
