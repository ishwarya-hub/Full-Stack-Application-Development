package com.example.employee.exception;

import org.springframework.http.*;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import java.time.LocalDateTime;
import java.util.*;

// @RestControllerAdvice = Intercepts exceptions from ALL @RestController classes
// Returns JSON error responses automatically (not HTML error pages)
@RestControllerAdvice
public class GlobalExceptionHandler {

    // ============================================================
    // HANDLER 1: Employee not found → 404 Not Found
    // Triggered by: throw new ResourceNotFoundException("...")
    // ============================================================
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<?> handleResourceNotFound(ResourceNotFoundException ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.NOT_FOUND.value());   // 404
        error.put("error", "Not Found");
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
    }

    // ============================================================
    // HANDLER 2: Validation failed → 400 Bad Request
    // Triggered by: @Valid fails on @RequestBody in Controller
    // Returns field-level error messages as { "field": "message" }
    // ============================================================
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<?> handleValidationException(
            MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        // Loop through each field that failed validation
        ex.getBindingResult().getFieldErrors()
            .forEach(error ->
                errors.put(error.getField(), error.getDefaultMessage()));

        return new ResponseEntity<>(errors, HttpStatus.BAD_REQUEST); // 400
    }

    // ============================================================
    // HANDLER 3: Any other unexpected error → 500 Internal Server Error
    // Acts as a catch-all for unhandled runtime exceptions
    // ============================================================
    @ExceptionHandler(Exception.class)
    public ResponseEntity<?> handleGeneralException(Exception ex) {
        Map<String, Object> error = new LinkedHashMap<>();
        error.put("timestamp", LocalDateTime.now());
        error.put("status", HttpStatus.INTERNAL_SERVER_ERROR.value()); // 500
        error.put("error", "Internal Server Error");
        error.put("message", ex.getMessage());
        return new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
