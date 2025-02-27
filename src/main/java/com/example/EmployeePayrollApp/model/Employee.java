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

    public Employee(EmployeeDTO employeeDTO) {
        this.name = employeeDTO.getName();
        this.salary = employeeDTO.getSalary();
        this.gender = employeeDTO.getGender();
        this.note = employeeDTO.getNote();
        this.startDate = employeeDTO.getStartDate();
        this.profilepic = employeeDTO.getProfilepic();
        this.departments = employeeDTO.getDepartments();
    }

    // Method to update the employee details
    public void updateDetails(EmployeeDTO employeeDTO) {
        if (employeeDTO.getName() != null) {
            this.name = employeeDTO.getName();
        }
        if (employeeDTO.getSalary() > 0) {
            this.salary = employeeDTO.getSalary();
        }
        if (employeeDTO.getGender() != null) {
            this.gender = employeeDTO.getGender();
        }
        if (employeeDTO.getNote() != null) {
            this.note = employeeDTO.getNote();
        }
        if (employeeDTO.getStartDate() != null) {
            this.startDate = employeeDTO.getStartDate();
        }
        if (employeeDTO.getProfilepic() != null) {
            this.profilepic = employeeDTO.getProfilepic();
        }
        if (employeeDTO.getDepartments() != null) {
            this.departments = employeeDTO.getDepartments();
        }
    }

}