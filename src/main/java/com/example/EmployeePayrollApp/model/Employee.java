package com.example.EmployeePayrollApp.model;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "newTable4")
@NoArgsConstructor
@AllArgsConstructor
public @Data class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private long salary;
    private String gender;
    private LocalDate startDate;
    private String note;
    private String profilepic;

    // ✅ Converts List<String> to String
    private List<String> departments;

    public Employee(EmployeeDTO employeePayrollDTO) {
        this.name = employeePayrollDTO.getName();
        this.salary = employeePayrollDTO.getSalary();
        this.gender = employeePayrollDTO.getGender();
        this.note = employeePayrollDTO.getNote();
        this.startDate = LocalDate.parse(employeePayrollDTO.getStartDate());
        this.profilepic = employeePayrollDTO.getProfilepic();
        this.departments = employeePayrollDTO.getDepartments();
    }
}