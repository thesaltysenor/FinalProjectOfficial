package com.promineotech.vacation_planner.GlobalExceptionHandlerTest;

import com.promineotech.vacation_planner.GlobalExceptionHandler.GlobalExceptionHandler;
import org.junit.jupiter.api.Test;
import org.springframework.core.MethodParameter;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import java.util.Map;
import static org.junit.jupiter.api.Assertions.assertEquals;


class GlobalExceptionHandlerTest {
    private final GlobalExceptionHandler errorHandler = new GlobalExceptionHandler();

    @Test
    void handleMethodArgumentNotValidException() throws NoSuchMethodException {
        // Arrange
        // - Create an Object named 'target'.
        // - Create a BindException, which is an exception that is thrown when there are binding problems.
        // - Create a MethodParameter, which represents the information of the argument in a method.
        // - Create a MethodArgumentNotValidException that will be passed to the method being tested.
        Object target = new Object();
        BindException bindException = new BindException(target, "target");

        MethodParameter methodParameter = new MethodParameter(Object.class.getMethod("toString"), -1);

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(methodParameter, bindException);

        // Act
        // Call the handleMethodArgumentNotValidException() method of the GlobalExceptionHandler and store the response.
        ResponseEntity<Map<String, Object>> response = errorHandler.handleMethodArgumentNotValidException(ex);

        // Assert
        // Check if the response status code is BAD_REQUEST (400).
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleRuntimeException() {
        // Arrange
        // - Create a RuntimeException that will be passed to the method being tested.
        RuntimeException ex = new RuntimeException("Test runtime exception");

        // Act
        // Call the handleRuntimeException() method of the GlobalExceptionHandler and store the response.
        ResponseEntity<Map<String, Object>> response = errorHandler.handleRuntimeException(ex);

        // Assert
        // Check if the response status code is INTERNAL_SERVER_ERROR (500).
        // Check if the error message in the response body is the same as the one in the exception.
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Test runtime exception", response.getBody().get("error"));
    }
}

