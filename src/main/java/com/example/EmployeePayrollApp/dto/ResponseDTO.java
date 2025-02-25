package com.example.EmployeePayrollApp.dto;

import lombok.Data;

@Data // Lombok annotation to generate getters, setters, toString(), equals(), hashCode() methods
public class ResponseDTO {
    private String message;
    private Object data;

    public ResponseDTO(String message, Object data) {
        this.message = message;
        this.data = data;
    }
}
