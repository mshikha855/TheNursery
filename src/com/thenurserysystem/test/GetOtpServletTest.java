package com.thenurserysystem.test;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.PrintWriter;
import java.io.StringWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.servlet.GetOtpServlet;

public class GetOtpServletTest {
	@Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher dispatcher;

    @Mock
    private PasswordConvert pc; // Mocking PasswordConvert

    private GetOtpServlet servlet;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this); // Initialize mocks

        // Create servlet instance
        servlet = new GetOtpServlet();

        // Inject the mocked PasswordConvert into the servlet
        servlet.pc = pc;
    }

    @Test
    public void testDoPost_SuccessfulOtpVerification() throws Exception {
        // Mocking request parameters
        when(request.getParameter("originalotp")).thenReturn("encryptedOtp");
        when(request.getParameter("otp")).thenReturn("123456");
        when(request.getParameter("userid")).thenReturn("testUser");

        // Mocking the decryption logic in PasswordConvert
        when(pc.decrypt("encryptedOtp")).thenReturn("123456");

        // Mocking the RequestDispatcher
        when(request.getRequestDispatcher("updatepassword.jsp")).thenReturn(dispatcher);

        // Calling the doPost method
        servlet.doPost(request, response);

        // Verifying that the dispatcher was forwarded to the correct page
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_FailedOtpVerification() throws Exception {
        // Mocking request parameters
        when(request.getParameter("originalotp")).thenReturn("encryptedOtp");
        when(request.getParameter("otp")).thenReturn("654321");
        when(request.getParameter("userid")).thenReturn("testUser");

        // Mocking the decryption logic in PasswordConvert
        when(pc.decrypt("encryptedOtp")).thenReturn("123456");

        // Mocking the RequestDispatcher
        when(request.getRequestDispatcher("Otpform.jsp")).thenReturn(dispatcher);

        // Calling the doPost method
        servlet.doPost(request, response);

        // Verifying that the dispatcher was forwarded to the Otpform.jsp page
        verify(dispatcher).forward(request, response);

        // Verifying that an error message was set in the request attributes
        verify(request).setAttribute("message", "Sorry!!.... This otp is Invalid or Expired");
    }

    @Test
    public void testDoGet() throws Exception {
    	// Mocking request
        when(request.getContextPath()).thenReturn("/testContext");

        // Mocking the response writer using StringWriter to capture output
        StringWriter stringWriter = new StringWriter();
        PrintWriter writer = new PrintWriter(stringWriter);
        when(response.getWriter()).thenReturn(writer);

        // Calling the doGet method
        servlet.doGet(request, response);

        // Flush the writer to ensure all data is written
        writer.flush();

        // Verifying the response content
        assertEquals("Served at: /testContext", stringWriter.toString().trim());
    }
}
