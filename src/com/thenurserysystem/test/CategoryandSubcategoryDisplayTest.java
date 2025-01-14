package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

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
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.service.SubCategoryService;
import com.thenurserysystem.servlet.CategoryandSubcategoryDisplay;

public class CategoryandSubcategoryDisplayTest {

    @Mock
    private CategoryService mockCategoryService;

    @Mock
    private SubCategoryService mockSubCategoryService;

    @Mock
    private ProductService mockProductService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Mock
    private RequestDispatcher mockDispatcher;

    private CategoryandSubcategoryDisplay servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);

        // Initialize the servlet
        servlet = new CategoryandSubcategoryDisplay();

        // Inject mocks into the servlet using reflection
        java.lang.reflect.Field nsField = CategoryandSubcategoryDisplay.class.getDeclaredField("ns");
        nsField.setAccessible(true);
        nsField.set(servlet, mockCategoryService);

        java.lang.reflect.Field csField = CategoryandSubcategoryDisplay.class.getDeclaredField("cs");
        csField.setAccessible(true);
        csField.set(servlet, mockSubCategoryService);

        java.lang.reflect.Field psField = CategoryandSubcategoryDisplay.class.getDeclaredField("ps");
        psField.setAccessible(true);
        psField.set(servlet, mockProductService);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Mock data for categories and subcategories
        List<Category> mockCategories = Arrays.asList(
            new Category(2, "Plants"),
            new Category(3, "Plots")
        );

        List<Category> mockSubCategories = Arrays.asList(
            new Category(1, "Indoor Plant", 2),
            new Category(2, "Outdoor Plant", 2),
            new Category(3, "Decoration Plant", 2),
            new Category(8, "Metalic Pots", 3)
        );

        when(mockCategoryService.selectCategoryDetails()).thenReturn(mockCategories);
        when(mockSubCategoryService.selectSubcategory()).thenReturn(mockSubCategories);

        // Act
        servlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockCategoryService).selectCategoryDetails();
        verify(mockSubCategoryService).selectSubcategory();

        verify(mockRequest).setAttribute("CategoryList", mockCategories);
        verify(mockRequest).setAttribute("SubCategoryList", mockSubCategories);
    }

}

