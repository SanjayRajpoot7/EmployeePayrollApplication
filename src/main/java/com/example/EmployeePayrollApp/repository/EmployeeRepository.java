package com.example.EmployeePayrollApp.repository;

import com.example.EmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Integer> {
    // Custom queries can be added here if necessary, like find by name, salary, etc.
}

