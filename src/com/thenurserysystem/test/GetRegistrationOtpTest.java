package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Base64;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.GetRegistrationOtp;

public class GetRegistrationOtpTest {
	
	private HttpServletRequest request;
    private HttpServletResponse response;
    private RequestDispatcher dispatcher;
    private TheNurseryService service;
    private PasswordConvert passwordConvert;
    private GetRegistrationOtp servlet;

    @Before
    public void setUp() throws Exception {
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        dispatcher = mock(RequestDispatcher.class);
        service = mock(TheNurseryService.class);
        passwordConvert = mock(PasswordConvert.class); // Mock PasswordConvert
        servlet = new GetRegistrationOtp();

        // Inject mocks
        servlet.ns = service;
        //servlet.passwordConvert = passwordConvert; // Assume servlet has this field for PasswordConvert
    }

    @Test
    public void testDoPost_ValidOtp() throws Exception {
        // Mock request parameters
        when(request.getParameter("fname")).thenReturn("John");
        when(request.getParameter("lname")).thenReturn("Doe");
        when(request.getParameter("address")).thenReturn("123 Main St");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");
        when(request.getParameter("phoneno")).thenReturn("1234567890");
        when(request.getParameter("area")).thenReturn("12345");
        when(request.getParameter("password")).thenReturn("password123");
        when(request.getParameter("role")).thenReturn("User");
        when(request.getParameter("originalotp")).thenReturn("OwEh+86YnWmcBUblDIuFtw==");
        when(request.getParameter("otp")).thenReturn("1234");

        // Mock decryption behavior
        when(passwordConvert.decrypt("OwEh+86YnWmcBUblDIuFtw==")).thenReturn("1234");

        // Mock service behavior
        when(service.SaveUserDetails(any(User.class))).thenReturn(1);

        // Mock response behavior
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        // Execute the servlet
        servlet.doPost(request, response);

        // Verify service and dispatcher calls
        verify(passwordConvert, times(1)).decrypt("OwEh+86YnWmcBUblDIuFtw==");
        verify(service, times(1)).SaveUserDetails(any(User.class));
        verify(request, times(1)).getRequestDispatcher("Login.jsp");
        verify(dispatcher, times(1)).forward(request, response);
    }

    @Test
    public void testDoPost_InvalidOtp() throws Exception {
        // Mock request parameters
        when(request.getParameter("fname")).thenReturn("John");
        when(request.getParameter("lname")).thenReturn("Doe");
        when(request.getParameter("address")).thenReturn("123 Main St");
        when(request.getParameter("email")).thenReturn("john.doe@example.com");
        when(request.getParameter("phoneno")).thenReturn("1234567890");
        when(request.getParameter("area")).thenReturn("12345");
        when(request.getParameter("password")).thenReturn("password123");
        when(request.getParameter("role")).thenReturn("User");
        when(request.getParameter("originalotp")).thenReturn("OwEh+86YnWmcBUblDIuFtw==");
        when(request.getParameter("otp")).thenReturn("5678");

        // Mock decryption behavior
        when(passwordConvert.decrypt("OwEh+86YnWmcBUblDIuFtw==")).thenReturn("1234");

        // Mock response behavior
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        // Capture response writer
        StringWriter writer = new StringWriter();
        when(response.getWriter()).thenReturn(new PrintWriter(writer));

        // Execute the servlet
        servlet.doPost(request, response);

        // Verify dispatcher call for invalid OTP
        verify(passwordConvert, times(1)).decrypt("OwEh+86YnWmcBUblDIuFtw==");
        verify(request, times(1)).getRequestDispatcher("RegistrationOTPform.jsp");
        verify(dispatcher, times(1)).forward(request, response);
    }
}
