package com.thenurserysystem.test;

import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import com.thenurserysystem.bean.Area;
import com.thenurserysystem.service.TheNurseryService;
import com.thenurserysystem.servlet.FindAreaDetailsServlet;

public class FindAreaDetailsServletTest {

	@Mock
    private TheNurseryService ns;  // Mocking TheNurseryService

    @Mock
    private HttpServletRequest request;  // Mocking HttpServletRequest

    @Mock
    private HttpServletResponse response;  // Mocking HttpServletResponse

    @Mock
    private RequestDispatcher dispatcher;  // Mocking RequestDispatcher for forwarding

    private FindAreaDetailsServlet servlet; // Servlet being tested

    @Before
    public void setup() {
        MockitoAnnotations.openMocks(this);  // Manually initializing mocks
        servlet = new FindAreaDetailsServlet(); // Initialize the servlet
        servlet.ns = ns;  // Injecting mocked service into the servlet
    }
    
    @Test
    public void testDoGet_Success() throws Exception {
        // Arrange
        List<Area> mockAreaList = new ArrayList<>();
        mockAreaList.add(new Area(1, "Area1")); // Assuming Area has id and name properties.
        mockAreaList.add(new Area(2, "Area2"));

        // Mock the service to return a list of areas
        when(ns.fetchareadetails()).thenReturn(mockAreaList);
        
        // Mock the getRequestDispatcher to return the dispatcher
        when(request.getRequestDispatcher(anyString())).thenReturn(dispatcher);

        // Act
        servlet.doGet(request, response);

        // Assert
        // Verify that the correct attribute is set
        verify(request).setAttribute("areadetails", mockAreaList);
        
    }

}
