package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import static org.junit.Assert.*;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Feedback;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.ProductService;
import com.thenurserysystem.servlet.Storefeedback;

public class StorefeedbackTest {

	private Storefeedback servlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private HttpSession session;

    @Mock
    private ProductService productService;

    @Mock
    private User user;

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
        servlet = new Storefeedback();
        servlet.ps = productService; // Inject the mocked ProductService
    }

    @Test
    public void testDoPost_ValidInput() throws ServletException, IOException {
        // Arrange
        when(request.getParameter("star")).thenReturn("5");
        when(request.getParameter("comment")).thenReturn("Great product!");
        when(request.getParameter("pid")).thenReturn("123");
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("loginDetails")).thenReturn(user);
        when(user.getUserid()).thenReturn(1);

        Feedback mockFeedback = new Feedback();

        doAnswer(invocation -> {
            Feedback feedback = invocation.getArgument(0);
            assertEquals(123, feedback.getPid());
            assertEquals(1, feedback.getUid());
            assertEquals(5, feedback.getStar());
            assertEquals("Great product!", feedback.getComment());
            return 1; // Simulate successful feedback save
        }).when(productService).savefeedbackdetails(any(Feedback.class));

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(productService, times(1)).savefeedbackdetails(any(Feedback.class));
    }

    @Test
    public void testDoPost_MissingSession() throws ServletException, IOException {
        // Arrange
        when(request.getSession(false)).thenReturn(null);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(productService, never()).savefeedbackdetails(any(Feedback.class));
    }

    @Test
    public void testDoPost_MissingLoginDetails() throws ServletException, IOException {
        // Arrange
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("loginDetails")).thenReturn(null);

        // Act
        servlet.doPost(request, response);

        // Assert
        verify(productService, never()).savefeedbackdetails(any(Feedback.class));
    }
}
