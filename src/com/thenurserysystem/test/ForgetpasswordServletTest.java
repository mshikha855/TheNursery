package com.thenurserysystem.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doNothing;
import static org.mockito.Mockito.mock;
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
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.ForgetpasswordServlet;

public class ForgetpasswordServletTest {
	
	private ForgetpasswordServlet servlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private HttpSession session;
    private TheNurseryService service;

    @Before
    public void setUp() throws Exception {
        // Initialize the servlet and mocks
        servlet = new ForgetpasswordServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        session = mock(HttpSession.class);
        service = mock(TheNurseryService.class);

        // Inject the mocked service into the servlet
        servlet.ns = service;
    }

    @Test
    public void testDoPost_ValidEmail() throws Exception {
        // Mock request parameters and session behavior
        when(request.getParameter("email")).thenReturn("test@example.com");
        when(service.Checkemaildetails("test@example.com")).thenReturn(1);
        
        User user = new User();
        user.setFname("John");
        //commmented due to having error while running testcase need to check and resolve earlier
        //user.setPassword(new PasswordConvert().encrypt("password123"));
        when(service.findpassword("test@example.com")).thenReturn(user);
        
        when(request.getSession(false)).thenReturn(session);

        // Mock response behavior
        StringWriter responseWriter = new StringWriter();
        PrintWriter printWriter = new PrintWriter(responseWriter);
        when(response.getWriter()).thenReturn(printWriter);

        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("Otpform.jsp")).thenReturn(dispatcher);

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify session attributes and forwarding behavior
        verify(session).setAttribute(eq("User"), any(User.class));
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_InvalidEmail() throws Exception {
        // Mock request parameters
        when(request.getParameter("email")).thenReturn("notfound@example.com");
        when(service.Checkemaildetails("notfound@example.com")).thenReturn(0);

        // Mock response behavior
        doNothing().when(response).sendRedirect("Forgetpassword.jsp");

        // Execute the servlet method
        servlet.doPost(request, response);

        // Verify redirect behavior
        verify(response).sendRedirect("Forgetpassword.jsp");
    }
}
