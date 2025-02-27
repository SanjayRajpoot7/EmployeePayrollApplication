package com.example.EmployeePayrollApp.dto;

import lombok.Data;

import java.util.List;

public @Data class ResponseDTO {


    private String message;
    private Object data;

    // Constructor for successful responses
    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }

    // Constructor for error responses
    public ResponseDTO(String message, List<Object> errors) {
        this.message = message;
        this.data = errors;
    }

    // Getters and Setters
}
