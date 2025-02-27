package com.example.EmployeePayrollApp.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.*;
import lombok.Data;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Data
public @ToString class EmployeeDTO {

    @NotEmpty(message = "Employee name cannot be null")
    @Pattern(regexp = "^[A-Z][a-zA-Z\\s]{2,}$", message = "Employee name Invalid")
    private String name;

    @Min(value = 500 , message = "Min Wage should be more than 500")
    private long salary;

    private String profilepic;

    private List<String> departments;  // ✅ FIXED: Un-commented

    @NotBlank(message = "Gender cannot be blank")
    private String gender;

    @NotNull(message = "Start date cannot be null")
    @JsonFormat(pattern = "dd MMM yyyy")
    @PastOrPresent(message = "Start date must be in the past or present")
    private LocalDate startDate;

    @NotBlank(message = "Note cannot be blank")
    private String note;

    @NotBlank(message = "Profile picture cannot be blank")
    private String profilePic;

    @NotBlank(message = "Department cannot be blank")
    private String department;

}