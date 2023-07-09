package com.promineotech.vacation_planner.GlobalExceptionHandler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.MethodArgumentNotValidException;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// The @ControllerAdvice annotation is a specialization of @Component,
// so it's automatically picked up via component scanning.
// It is used to define @ExceptionHandler, @InitBinder, and @ModelAttribute methods
// that apply to all @RequestMapping methods across controller classes.
@ControllerAdvice
public class GlobalExceptionHandler {

    // @ExceptionHandler annotation is used to define the class of exception it will catch.
    // You can specify one or more exceptions using this annotation.
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, Object>> handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {
        // Collect all error messages from the BindingResult of the exception
        // and store them in a List of Strings.
        List<String> errors = ex.getBindingResult().getAllErrors()
                .stream()
                .map(error -> error.getDefaultMessage())
                .collect(Collectors.toList());

        // Create a map to store the response body details.
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.BAD_REQUEST);
        body.put("errors", errors);

        // Return a new ResponseEntity with the error details and HTTP status code.
        return new ResponseEntity<>(body, HttpStatus.BAD_REQUEST);
    }

    // This method handles all unhandled RuntimeExceptions across the application.
    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<Map<String, Object>> handleRuntimeException(RuntimeException ex) {

        // Create a map to store the response body details.
        Map<String, Object> body = new HashMap<>();
        body.put("status", HttpStatus.INTERNAL_SERVER_ERROR);
        body.put("error", ex.getMessage());

        // Return a new ResponseEntity with the error details and HTTP status code.
        return new ResponseEntity<>(body, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
