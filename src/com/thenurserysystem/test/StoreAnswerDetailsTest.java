package com.thenurserysystem.test;

import static org.mockito.Mockito.*;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Question;
import com.thenurserysystem.bean.User;
import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.servlet.StoreAnswserDetails;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class StoreAnswerDetailsTest {

    @InjectMocks
    private StoreAnswserDetails servlet; 

    @Mock
    private HttpServletRequest request;
    
    @Mock
    private HttpServletResponse response;
    
    @Mock
    private HttpSession session;
    
    @Mock
    private QuestionService questionService;
    
    @Mock
    private User user;

    @Before
    public void setUp() {
    	// Initialize mocks before each test
        MockitoAnnotations.openMocks(this);  // Initialize mocks
        
        when(request.getSession(false)).thenReturn(session);
        when(session.getAttribute("loginDetails")).thenReturn(user);
        when(user.getUserid()).thenReturn(1);  // Assuming user ID is 1
    }

    @Test
    public void testDoPost_SuccessfulAnswerSave() throws Exception {
        // Arrange: Simulating request parameters
        when(request.getParameter("questionid")).thenReturn("1001");
        when(request.getParameter("answer")).thenReturn("This is an answer.");

        // Simulate saveAnswerDetails returning a positive value
        when(questionService.saveAnswerDetails(eq("1001"), any(Question.class))).thenReturn(1);

        // Act: Call the doPost method
        servlet.doPost(request, response);

        // Assert: Verify that the correct methods are called and the redirect happens
        verify(questionService).saveAnswerDetails(eq("1001"), any(Question.class));  // Ensure service method is called
        verify(response).sendRedirect("ReplyQuestions.jsp");  // Ensure redirection happens on success
    }

    @Test
    public void testDoPost_FailureAnswerSave() throws Exception {
        // Arrange: Simulating request parameters
        when(request.getParameter("questionid")).thenReturn("1001");
        when(request.getParameter("answer")).thenReturn("This is an answer.");

        // Simulate saveAnswerDetails returning a negative value (failure)
        when(questionService.saveAnswerDetails(eq("1001"), any(Question.class))).thenReturn(0);

        // Act: Call the doPost method
        servlet.doPost(request, response);

        // Assert: Verify that the service method was called but no redirect occurred
        verify(questionService).saveAnswerDetails(eq("1001"), any(Question.class));  // Ensure service method is called
        verify(response, never()).sendRedirect("ReplyQuestions.jsp");  // Ensure redirection does NOT happen on failure
    }

    @Test
    public void testDoPost_MissingSession() throws Exception {
        // Arrange: Simulating a session where loginDetails is null
        when(request.getSession(false)).thenReturn(null);

        // Act: Call the doPost method
        servlet.doPost(request, response);

        // Assert: Since session is null, the response should not proceed and no service call is made.
        verify(questionService, never()).saveAnswerDetails(anyString(), any(Question.class));
    }

}
