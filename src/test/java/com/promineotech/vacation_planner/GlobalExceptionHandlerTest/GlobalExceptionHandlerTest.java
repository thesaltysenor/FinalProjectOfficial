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
        Object target = new Object();
        BindException bindException = new BindException(target, "target");

        MethodParameter methodParameter = new MethodParameter(Object.class.getMethod("toString"), -1);

        MethodArgumentNotValidException ex = new MethodArgumentNotValidException(methodParameter, bindException);

        // Act
        ResponseEntity<Map<String, Object>> response = errorHandler.handleMethodArgumentNotValidException(ex);

        // Assert
        assertEquals(HttpStatus.BAD_REQUEST, response.getStatusCode());
    }

    @Test
    void handleRuntimeException() {
        // Arrange
        RuntimeException ex = new RuntimeException("Test runtime exception");

        // Act
        ResponseEntity<Map<String, Object>> response = errorHandler.handleRuntimeException(ex);

        // Assert
        assertEquals(HttpStatus.INTERNAL_SERVER_ERROR, response.getStatusCode());
        assertEquals("Test runtime exception", response.getBody().get("error"));
    }
}

