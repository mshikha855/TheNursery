package com.thenurserysystem.test;

import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Question;
import com.thenurserysystem.service.QuestionService;
import com.thenurserysystem.servlet.FetchAvailableQuestionDetails;

public class FetchAvailableQuestionDetailsTest {

	@InjectMocks
    private FetchAvailableQuestionDetails fetchAvailableQuestionDetails; // Don't mock this, just inject it

    @Mock
    private QuestionService questionService; // Mock the service

    @Mock
    private HttpServletRequest request; // Mock the request

    @Mock
    private HttpServletResponse response; // Mock the response

    @Mock
    private List<Question> questionList; // Mock the question list

    @Before
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testDoGet() throws ServletException, IOException {
        // Mock the service to return a list of questions
        questionList = Arrays.asList(new Question(1, "Sample Question 1"), new Question(2, "Sample Question 2"));
        when(questionService.fetchAvailableQuestionDetails()).thenReturn(questionList);

        // Call the doGet method
        fetchAvailableQuestionDetails.doGet(request, response);

        // Verify that the service method was called
        verify(questionService).fetchAvailableQuestionDetails();

        // Verify that the list is set as an attribute in the request
        verify(request).setAttribute("QuestionList", questionList);
    }

    @Test
    public void testDoPost() throws ServletException, IOException {
        // Mock the service to return a list of questions
        questionList = Arrays.asList(new Question(1, "Sample Question 1"), new Question(2, "Sample Question 2"));
        when(questionService.fetchAvailableQuestionDetails()).thenReturn(questionList);

        // Call the doPost method (which should call doGet internally)
        fetchAvailableQuestionDetails.doPost(request, response);

        // Verify that the service method was called through doGet
        verify(questionService).fetchAvailableQuestionDetails();

        // Verify that setAttribute was called in doGet
        verify(request).setAttribute("QuestionList", questionList);
    }
}
