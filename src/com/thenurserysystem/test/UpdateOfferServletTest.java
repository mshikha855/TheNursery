package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.Offer;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.servlet.UpdateOfferServlet;

import javax.servlet.*;
import javax.servlet.http.*;
import java.io.*;

public class UpdateOfferServletTest {

	@InjectMocks
    private UpdateOfferServlet servlet; // The servlet to test

    @Mock
    private ProductService ps; // Mocking the ProductService dependency

    @Mock
    private HttpServletRequest request; // Mocking HttpServletRequest

    @Mock
    private HttpServletResponse response; // Mocking HttpServletResponse

    private Offer offer; // Offer object to use in the test

    @Before
    public void setUp() {
        MockitoAnnotations.initMocks(this); // Initializes mocks
        offer = new Offer(); // Initialize a sample Offer object
    }

    @Test
    public void testDoPost_SuccessfulUpdate() throws Exception {
        // Given: Mocking request parameters
        when(request.getParameter("offerid")).thenReturn("101"); // Mock offer ID
        when(request.getParameter("offerdiscount")).thenReturn("20"); // Mock discount value
        when(request.getParameter("offerdetails")).thenReturn("Special Discount Offer"); // Mock offer details

        // Mocking the ProductService behavior to simulate a successful update
        when(ps.modifyOfferDetails(any(Offer.class))).thenReturn(1);

        // Mocking response behavior
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        // When: Calling the doPost method
        servlet.doPost(request, response);

        // Then: Verify that the offer was updated
        verify(ps).modifyOfferDetails(any(Offer.class)); // Check if modifyOfferDetails was called
        verify(response).sendRedirect("OfferList.jsp"); // Verify that the servlet redirects to OfferList.jsp
    }

    @Test
    public void testDoPost_FailedUpdate() throws Exception {
        // Given: Mocking request parameters
        when(request.getParameter("offerid")).thenReturn("102"); // Mock offer ID
        when(request.getParameter("offerdiscount")).thenReturn("15"); // Mock discount value
        when(request.getParameter("offerdetails")).thenReturn("Limited Time Offer"); // Mock offer details

        // Mocking the ProductService behavior to simulate a failed update
        when(ps.modifyOfferDetails(any(Offer.class))).thenReturn(0);

        // When: Calling the doPost method
        servlet.doPost(request, response);

        // Then: Verify that modifyOfferDetails was called
        verify(ps).modifyOfferDetails(any(Offer.class)); // Verify method interaction

        // Verify no redirection occurs in case of failure
        verify(response, never()).sendRedirect(anyString());
    }

}
