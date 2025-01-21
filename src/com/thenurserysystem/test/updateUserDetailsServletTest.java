package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.never;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.junit.Before;
import org.junit.Test;

import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.updateUserDetailsServlet;

public class updateUserDetailsServletTest {

	private updateUserDetailsServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private TheNurseryService service;

    @Before
    public void setUp() {
        // Initialize the servlet and mocks
        servlet = new updateUserDetailsServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        service = mock(TheNurseryService.class);

        // Inject the mocked service into the servlet
        servlet.ns = service;
    }

    @Test
    public void testDoPost_SuccessfulUpdate() throws Exception {
        // Mock request parameters
        when(request.getParameter("userid")).thenReturn("1");
        when(request.getParameter("fname")).thenReturn("John");
        when(request.getParameter("lname")).thenReturn("Doe");
        when(request.getParameter("address")).thenReturn("123 Main St");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");
        when(request.getParameter("phoneno")).thenReturn("1234567890");
        when(request.getParameter("area")).thenReturn("12345");
        when(request.getParameter("password")).thenReturn("password123");	//Password need to check on windows machine
        when(request.getParameter("role")).thenReturn("User");

        // Mock session behavior
        when(request.getSession(false)).thenReturn(session);

        // Mock service behavior
        when(service.updateUserDetail(any(User.class))).thenReturn(1);

        // Mock request dispatcher
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("EditProfileServlet")).thenReturn(dispatcher);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify session attributes and forwarding behavior
        verify(session).setAttribute(eq("loginDetails"), any(User.class));
        verify(request).setAttribute("message", "YOUR PROFILE IS CHANGED SUCCESSFUL");
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_FailureToUpdate() throws Exception {
        // Mock request parameters
        when(request.getParameter("userid")).thenReturn("1");
        when(request.getParameter("fname")).thenReturn("John");
        when(request.getParameter("lname")).thenReturn("Doe");
        when(request.getParameter("address")).thenReturn("123 Main St");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");
        when(request.getParameter("phoneno")).thenReturn("1234567890");
        when(request.getParameter("area")).thenReturn("12345");
        when(request.getParameter("password")).thenReturn("password123");	//Password need to check on windows machine
        when(request.getParameter("role")).thenReturn("User");

        // Mock session behavior
        when(request.getSession(false)).thenReturn(session);

        // Mock service behavior (update fails)
        when(service.updateUserDetail(any(User.class))).thenReturn(0);

        // Mock response behavior
        StringWriter responseWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(responseWriter);
        when(response.getWriter()).thenReturn(printWriter);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify that no attributes or forwarding occurred
        verify(session, never()).setAttribute(eq("loginDetails"), any(User.class));
        verify(request, never()).getRequestDispatcher("EditProfileServlet");
        verify(response.getWriter()).flush();
    }

}
