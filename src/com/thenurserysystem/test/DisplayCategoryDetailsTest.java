package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import java.io.IOException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Category;
import com.thenurserysystem.service.CategoryService;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.servlet.DisplayCategoryDetails;

public class DisplayCategoryDetailsTest {

	private DisplayCategoryDetails displayCategoryDetailsServlet;

    @Mock
    private CategoryService mockCategoryService;

    @Mock
    private SubCategoryService mockSubCategoryService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockDispatcher;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Create an instance of the servlet
        displayCategoryDetailsServlet = new DisplayCategoryDetails();

        // Inject the mock services into the servlet using reflection
        Field nsField = DisplayCategoryDetails.class.getDeclaredField("ns");
        nsField.setAccessible(true);
        nsField.set(displayCategoryDetailsServlet, mockCategoryService);

        Field ns1Field = DisplayCategoryDetails.class.getDeclaredField("ns1");
        ns1Field.setAccessible(true);
        ns1Field.set(displayCategoryDetailsServlet, mockSubCategoryService);
    }

    @Test
    public void testDoGet_SuccessfulDataFetch() throws ServletException, IOException {
        // Arrange
        List<Category> mockCategories = Arrays.asList(new Category(1, "Fruits"), new Category(2, "Vegetables"));
        List<Category> mockSubCategories = Arrays.asList(new Category(1, "Citrus"), new Category(2, "Leafy Greens"));

        when(mockCategoryService.selectCategoryDetails()).thenReturn(mockCategories);
        when(mockSubCategoryService.selectSubcategory()).thenReturn(mockSubCategories);

        // Act
        displayCategoryDetailsServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockCategoryService, times(1)).selectCategoryDetails();
        verify(mockSubCategoryService, times(1)).selectSubcategory();

        verify(mockRequest, times(1)).setAttribute("CategoryData", mockCategories);
        verify(mockRequest, times(1)).setAttribute("Subcategorydata", mockSubCategories);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // Act
        displayCategoryDetailsServlet.doPost(mockRequest, mockResponse);

        // Assert
        verify(mockRequest, never()).getParameter(anyString());
        verify(mockResponse, never()).sendRedirect(anyString());
        // Ensure doPost delegates to doGet
    }


}
