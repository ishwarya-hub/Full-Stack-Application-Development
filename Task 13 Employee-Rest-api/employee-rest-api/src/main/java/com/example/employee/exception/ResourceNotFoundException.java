package com.example.employee.exception;

// Custom unchecked exception for 404 Not Found cases
// Extends RuntimeException so:
//   1. No need to declare 'throws' in method signatures
//   2. Spring automatically rolls back transactions
//   3. GlobalExceptionHandler can catch it
public class ResourceNotFoundException extends RuntimeException {

    // Constructor accepts a custom error message
    public ResourceNotFoundException(String message) {
        super(message); // Passes message to parent RuntimeException
    }
}

// =====================================================
// USAGE EXAMPLE (in EmployeeService):
// =====================================================
//
// Employee employee = repository.findById(id)
//     .orElseThrow(() ->
//         new ResourceNotFoundException("Employee not found with id: " + id));
//
// =====================================================
// RESULT: GlobalExceptionHandler returns:
// {
//   "timestamp": "2026-03-22T19:05:00",
//   "status": 404,
//   "error": "Not Found",
//   "message": "Employee not found with id: 99"
// }
// =====================================================
