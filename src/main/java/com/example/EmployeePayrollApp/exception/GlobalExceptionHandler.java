package com.example.EmployeePayrollApp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.validation.BindingResult;
import com.example.EmployeePayrollApp.dto.ResponseDTO;

import java.util.List;
import java.util.stream.Collectors;

@ControllerAdvice
public class GlobalExceptionHandler {

    // Handle validation errors for @Valid annotations
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ResponseDTO> handleValidationExceptions(MethodArgumentNotValidException ex) {
        // Collect error messages in a simplified structure
        List<String> errorMessages = ex.getBindingResult().getAllErrors().stream()
                .map(objectError -> {
                    FieldError fieldError = (FieldError) objectError;
                    return fieldError.getField() + ": " + fieldError.getDefaultMessage();
                })
                .collect(Collectors.toList());

        // Return a user-friendly response
        ResponseDTO response = new ResponseDTO("Validation Failed", errorMessages);
        return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
    }

    // Handle other exceptions (optional for more generic errors)
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ResponseDTO> handleGenericExceptions(Exception ex) {
        ResponseDTO response = new ResponseDTO("Internal Server Error", ex.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}