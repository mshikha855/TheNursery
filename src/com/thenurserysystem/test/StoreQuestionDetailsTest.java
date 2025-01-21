package com.thenurserysystem.test;

import static org.mockito.Mockito.*;
import org.junit.Before;
import org.junit.Test;
import org.mockito.*;

import com.thenurserysystem.bean.Question;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.servlet.StoreQuestionDetails;

import javax.servlet.http.*;

public class StoreQuestionDetailsTest {

	@InjectMocks
    private StoreQuestionDetails servlet; // The servlet under test

    @Mock
    private QuestionService qs; // Mocked QuestionService

    @Mock
    private HttpServletRequest request; // Mocked HttpServletRequest

    @Mock
    private HttpServletResponse response; // Mocked HttpServletResponse

    @Mock
    private HttpSession session; // Mocked HttpSession

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this); // Initialize all mocks
    }

    @Test
    public void testDoPost_SuccessfulStore() throws Exception {
        // Arrange: Mock session attributes and request parameters
        User mockUser = new User();
        mockUser.setUserid(123); // Mocked user ID

        when(request.getSession(false)).thenReturn(session); // Mocking session retrieval
        when(session.getAttribute("loginDetails")).thenReturn(mockUser); // Mocking session user
        when(request.getParameter("message")).thenReturn("What is Java?"); // Mock question
        when(request.getParameter("time")).thenReturn("2025-01-21T12:00:00"); // Mock time
        
        // Mocking QuestionService behavior
        when(qs.saveQuestionDetails(any(Question.class))).thenReturn(1); // Simulate successful save

        // Act: Call the doPost method
        servlet.doPost(request, response);

        // Assert: Verify interactions
        verify(request).getSession(false); // Verify session is retrieved
        verify(session).getAttribute("loginDetails"); // Verify session attribute is retrieved
        verify(qs).saveQuestionDetails(any(Question.class)); // Verify saveQuestionDetails is called
        verify(response).sendRedirect("Question.jsp"); // Verify redirection to Question.jsp
    }

    @Test
    public void testDoPost_FailedStore() throws Exception {
        // Arrange: Mock session attributes and request parameters
        User mockUser = new User();
        mockUser.setUserid(123); // Mocked user ID

        when(request.getSession(false)).thenReturn(session); // Mocking session retrieval
        when(session.getAttribute("loginDetails")).thenReturn(mockUser); // Mocking session user
        when(request.getParameter("message")).thenReturn("What is Java?");
        when(request.getParameter("time")).thenReturn("2025-01-21T12:00:00");
        
        // Mocking QuestionService behavior
        when(qs.saveQuestionDetails(any(Question.class))).thenReturn(0); // Simulate failed save

        // Act: Call the doPost method
        servlet.doPost(request, response);

        // Assert: Verify interactions
        verify(request).getSession(false);
        verify(session).getAttribute("loginDetails");
        verify(qs).saveQuestionDetails(any(Question.class));
        verify(response).sendRedirect("Question.jsp"); // Verify redirection still happens
    }

    @Test
    public void testDoPost_MissingSession() throws Exception {
    	// Arrange: Simulate a missing session
        when(request.getSession(false)).thenReturn(null);

        // Act: Call the doPost method
        servlet.doPost(request, response);

        // Assert: Verify redirection to login page
        verify(request).getSession(false);
        verifyNoInteractions(qs); // Ensure no interactions with the service
        verify(response).sendRedirect("login.jsp"); // Verify redirection to login.jsp
    }

}
