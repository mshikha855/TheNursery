package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.junit.Before;
import org.junit.Test;

import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.ChangepasswordServlet;

public class ChangepasswordServletTest {
	
	//Aa testcase ma error aave 6

	private ChangepasswordServlet changePasswordServlet;
    private HttpServletRequest request;
    private HttpServletResponse response;
    private TheNurseryService ns;

    @Before
    public void setUp() throws Exception {
        changePasswordServlet = new ChangepasswordServlet();
        request = mock(HttpServletRequest.class);
        response = mock(HttpServletResponse.class);
        ns = mock(TheNurseryService.class);
        changePasswordServlet.ns = ns; // Injecting the mock service
    }

    @Test
    public void testDoPost_SuccessfulPasswordChange() throws Exception {
        // Mock the parameters sent from the request
        when(request.getParameter("userid")).thenReturn("testuser");
        when(request.getParameter("password")).thenReturn("newpassword");

        // Mock the behavior of updatepassworddetails method
        when(ns.updatepassworddetails(anyString(), anyString())).thenReturn(1);  // Simulating success

        // Create a mock PasswordConvert class
        PasswordConvert mockPasswordConvert = mock(PasswordConvert.class);
        when(mockPasswordConvert.encrypt("newpassword")).thenReturn("encryptedpassword");
        
        // Injecting the mock class
        changePasswordServlet.ns = ns;
        
        // Perform the POST request
        changePasswordServlet.doPost(request, response);

        // Verify that the updatepassworddetails method was called
        verify(ns, times(1)).updatepassworddetails(eq("testuser"), eq("encryptedpassword"));
        
        // Check if the message was set correctly
        verify(request).setAttribute(eq("msg"), eq("Password change successful!!!"));

        // Check that the dispatcher was forwarded to the correct page
        RequestDispatcher dispatcher = mock(RequestDispatcher.class);
        when(request.getRequestDispatcher("ExistingPassword.jsp")).thenReturn(dispatcher);
        verify(dispatcher).forward(request, response);
    }

    @Test
    public void testDoPost_FailedPasswordChange() throws Exception {
        // Mock the parameters sent from the request
        when(request.getParameter("userid")).thenReturn("testuser");
        when(request.getParameter("password")).thenReturn("newpassword");

        // Mock the behavior of updatepassworddetails method to simulate failure
        when(ns.updatepassworddetails(anyString(), anyString())).thenReturn(0);  // Simulating failure

        // Perform the POST request
        changePasswordServlet.doPost(request, response);

        // Verify that the updatepassworddetails method was called
        verify(ns, times(1)).updatepassworddetails(eq("testuser"), eq("encryptedpassword"));
        
        // Check if the message was set correctly for failure
        verify(request).setAttribute(eq("msg"), eq("Password change failed."));
    }

}
