package com.example.EmployeePayrollApp.service;


import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.exception.EmployeeNotFoundException;
import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EmployeeService implements InterfaceEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    // Get all employees from the database
    @Override
    public List<Employee> getEmployeePayrollData() {
        return employeeRepository.findAll();
    }

    // Get employee by ID using JPA
    @Override
    public Employee getEmployeePayrollDataById(int empId) {
        return employeeRepository.findById((long) empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee Not Found with ID: " + empId));
    }

    //  Create new employee and save to MySQL
    @Override
    public Employee createEmployeePayrollData(EmployeeDTO empPayrollDTO) {
        Employee empData = new Employee(empPayrollDTO);
        return employeeRepository.save(empData); // Saves to DB
    }

    //  Update employee data in MySQL --db
    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO empPayrollDTO) {
        Employee existingEmployee = getEmployeePayrollDataById(empId);
        existingEmployee.setName(empPayrollDTO.getName());
        existingEmployee.setSalary(empPayrollDTO.getSalary());
        return employeeRepository.save(existingEmployee); // Saves updated record to DB
    }

    //  Delete employee from MySQL -- db
    @Override
    public void deleteEmployeePayrollData(int empId) {
        if (!employeeRepository.existsById((long) empId)) {
            throw new EmployeeNotFoundException("Cannot delete, Employee ID not found: " + empId);
        }
        employeeRepository.deleteById((long) empId);
    }
}