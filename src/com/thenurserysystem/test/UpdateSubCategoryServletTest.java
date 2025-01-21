package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.servlet.UpdateSubCategoryServlet;

public class UpdateSubCategoryServletTest {

	private UpdateSubCategoryServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private SubCategoryService service;

    @Before
    public void setUp() {
        // Initialize the servlet and mocks
        servlet = new UpdateSubCategoryServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        service = mock(SubCategoryService.class);

        // Inject the mocked service into the servlet
        servlet.cs = service;
    }

    @Test
    public void testDoPost_SuccessfulUpdate() throws Exception {
        // Mock request parameters
        when(request.getParameter("subcategoryid")).thenReturn("1");
        when(request.getParameter("subcategoryname")).thenReturn("Indoor Plants");
        when(request.getParameter("categoryid")).thenReturn("101");

        // Mock service behavior
        when(service.updateSubcategory(any(Category.class))).thenReturn(1);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify that the service was called
        verify(service).updateSubcategory(any(Category.class));

        // Verify that the response redirects to SubCategoryList.jsp
        verify(response).sendRedirect("SubCategoryList.jsp");
    }

    @Test
    public void testDoPost_FailedUpdate() throws Exception {
        // Mock request parameters
        when(request.getParameter("subcategoryid")).thenReturn("2");
        when(request.getParameter("subcategoryname")).thenReturn("Outdoor Plants");
        when(request.getParameter("categoryid")).thenReturn("102");

        // Mock service behavior (update fails)
        when(service.updateSubcategory(any(Category.class))).thenReturn(0);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify that the service was called
        verify(service).updateSubcategory(any(Category.class));

        // Verify that no redirect occurs on failure
        verify(response, never()).sendRedirect("SubCategoryList.jsp");
    }
	

}
