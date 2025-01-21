package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Generatotp;
import com.thenurserysystem.bean.PasswordConvert;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.impl.TheNurseryServiceImpl;
import com.thenurserysystem.servlet.RegistrationServlet;
import com.thenurserysystem.util.ThreadEmail;

public class RegistrationServletTest {

    private RegistrationServlet registrationServlet;

    @Mock
    private HttpServletRequest request;

    @Mock
    private HttpServletResponse response;

    @Mock
    private RequestDispatcher requestDispatcher;

    @Mock
    private PrintWriter writer;

    @Mock
    private TheNurseryServiceImpl nurseryService;

    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.openMocks(this);
        registrationServlet = new RegistrationServlet();
        registrationServlet.ns = nurseryService;
    }

    @Test
    public void testDoGet_EmailNotRegistered() throws Exception {
        // Arrange
        String email = "test@example.com";
        when(request.getParameter("email")).thenReturn(email);
        when(nurseryService.Checkemaildetails(email)).thenReturn(0);
        when(response.getWriter()).thenReturn(writer);

        // Act
        registrationServlet.doGet(request, response);

        // Assert
        verify(response).getWriter();
        verify(writer).append("false");
    }

    @Test
    public void testDoGet_EmailRegistered() throws Exception {
        // Arrange
        String email = "test@example.com";
        when(request.getParameter("email")).thenReturn(email);
        when(nurseryService.Checkemaildetails(email)).thenReturn(1);
        when(response.getWriter()).thenReturn(writer);

        // Act
        registrationServlet.doGet(request, response);

        // Assert
        verify(response).getWriter();
        verify(writer).append("true");
    }

    @Test
    public void testDoPost_SuccessfulRegistration() throws Exception {
        // Arrange
        String fname = "John";
        String lname = "Doe";
        String address = "123 Main St";
        String email = "test@example.com";
        String phoneno = "1234567890";
        String area = "560001";
        String password = "password123";
        String encryptedPassword = "encryptedPassword";
        String otp = "123456";
        String encryptedOtp = "encryptedOtp";

        // Mock request parameters
        when(request.getParameter("fname")).thenReturn(fname);
        when(request.getParameter("lname")).thenReturn(lname);
        when(request.getParameter("address")).thenReturn(address);
        when(request.getParameter("email")).thenReturn(email);
        when(request.getParameter("phoneno")).thenReturn(phoneno);
        when(request.getParameter("area")).thenReturn(area);
        when(request.getParameter("password")).thenReturn(password);

        // Mock dependencies
        PasswordConvert passwordConvert = mock(PasswordConvert.class);
        Generatotp generatotp = mock(Generatotp.class);
        ThreadEmail threadEmail = mock(ThreadEmail.class);

        when(passwordConvert.encrypt(password)).thenReturn(encryptedPassword);
        when(generatotp.random(6)).thenReturn(otp);
        when(passwordConvert.encrypt(otp)).thenReturn(encryptedOtp);
        when(request.getRequestDispatcher("RegistrationOTPform.jsp")).thenReturn(requestDispatcher);

        // Act
        registrationServlet.doPost(request, response);

        // Assert
        verify(request).setAttribute("otp", encryptedOtp);

        ArgumentCaptor<User> userCaptor = ArgumentCaptor.forClass(User.class);
        verify(request).setAttribute(eq("userdetails"), userCaptor.capture());
        User capturedUser = userCaptor.getValue();
        assert capturedUser.getFname().equals(fname);
        assert capturedUser.getLname().equals(lname);
        assert capturedUser.getEmail().equals(email);
        assert capturedUser.getContactno().equals(phoneno);
        assert capturedUser.getAddress().equals(address);
        assert capturedUser.getPincode() == Integer.parseInt(area);
        assert capturedUser.getPassword().equals(encryptedPassword);
        assert capturedUser.getRole().equals("User");

        verify(requestDispatcher).forward(request, response);
        verify(threadEmail).Send(eq(email), anyString());
    }
}
