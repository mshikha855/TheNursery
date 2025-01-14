package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.service.CartService;
import com.thenurserysystem.servlet.DeleteCartDetails;

public class DeleteCartDetailsTest {

	private DeleteCartDetails deleteCartDetailsServlet;

    @Mock
    private CartService mockCartService;

    @Mock
    private HttpServletRequest mockRequest;

    @Mock
    private HttpServletResponse mockResponse;

    @Before
    public void setUp() {
        // Initialize mocks
        MockitoAnnotations.openMocks(this);

        // Create an instance of the servlet
        deleteCartDetailsServlet = new DeleteCartDetails();

        // Inject the mocked CartService into the servlet using reflection
        try {
            java.lang.reflect.Field csField = DeleteCartDetails.class.getDeclaredField("cs");
            csField.setAccessible(true);
            csField.set(deleteCartDetailsServlet, mockCartService);
        } catch (Exception e) {
            throw new RuntimeException("Failed to inject mock CartService", e);
        }
    }

    @Test
    public void testDoGet_SuccessfulDeletion() throws ServletException, IOException {
        // Arrange
        int cartId = 123;
        when(mockRequest.getParameter("id")).thenReturn(String.valueOf(cartId));
        when(mockCartService.deleteCartDetails(cartId)).thenReturn(1); // Simulate successful deletion

        // Act
        deleteCartDetailsServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockCartService, times(1)).deleteCartDetails(cartId);
        verify(mockResponse, times(1)).sendRedirect("Cart.jsp");
    }

    @Test
    public void testDoGet_FailedDeletion() throws ServletException, IOException {
        // Arrange
        int cartId = 123;
        when(mockRequest.getParameter("id")).thenReturn(String.valueOf(cartId));
        when(mockCartService.deleteCartDetails(cartId)).thenReturn(0); // Simulate failed deletion

        // Act
        deleteCartDetailsServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockCartService, times(1)).deleteCartDetails(cartId);
        verify(mockResponse, times(1)).sendRedirect("Cart.jsp");
    }

    @Test
    public void testDoGet_MissingCartId() throws ServletException, IOException {
        // Arrange: Do not set the "id" parameter
        when(mockRequest.getParameter("id")).thenReturn(null);

        // Act
        deleteCartDetailsServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockResponse).sendError(HttpServletResponse.SC_BAD_REQUEST, "Cart ID is required");
        verify(mockCartService, never()).deleteCartDetails(anyInt());
    }

    @Test
    public void testDoGet_InvalidCartIdFormat() throws ServletException, IOException {
        // Arrange: Set an invalid "id" parameter
        when(mockRequest.getParameter("id")).thenReturn("invalid");

        // Act
        deleteCartDetailsServlet.doGet(mockRequest, mockResponse);

        // Assert
        verify(mockResponse).sendError(HttpServletResponse.SC_BAD_REQUEST, "Invalid Cart ID format");
        verify(mockCartService, never()).deleteCartDetails(anyInt());
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
    	// Arrange: Set up mock data
        int cartId = 123;
        when(mockRequest.getParameter("id")).thenReturn(String.valueOf(cartId));
        when(mockCartService.deleteCartDetails(cartId)).thenReturn(1); // Simulate successful deletion

        // Act: Call doPost, which delegates to doGet
        deleteCartDetailsServlet.doPost(mockRequest, mockResponse);

        // Assert: Verify the behavior of doGet via doPost
        verify(mockRequest, times(1)).getParameter("id");
        verify(mockCartService, times(1)).deleteCartDetails(cartId);
        verify(mockResponse, times(1)).sendRedirect("Cart.jsp");
    }

}
