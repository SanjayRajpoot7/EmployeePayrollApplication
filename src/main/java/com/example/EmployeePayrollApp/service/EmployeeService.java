package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.model.Employee;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class EmployeeService {

    // In-memory storage for employee data
    private List<Employee> employees = new ArrayList<>();

    // Constructor to add sample data (optional)
    public EmployeeService() {
        employees.add(new Employee(1, "John Doe", "Software Engineer", 75000));
        employees.add(new Employee(2, "Jane Smith", "HR Manager", 80000));
        employees.add(new Employee(3, "Jitesh", "Engineer", 65000));
        employees.add(new Employee(4, "John", "Supervisor", 43000));
    }

    // Fetch all employees
    public List<Employee> getAllEmployees() {
        return employees;
    }

    // Fetch employee by ID
    public Employee getEmployeeById(int id) {
        return employees.stream()
                .filter(employee -> employee.getId() == id)
                .findFirst()
                .orElse(null); // Return null if employee not found
    }

    // Add a new employee
    public Employee createEmployee(Employee employee) {
        // Simulate an auto-incremented ID (in a real-world app, the DB would handle this)
        int newId = employees.size() + 1;
        employee.setId(newId);
        employees.add(employee);
        return employee;
    }

    // Update an employee's details
    public Employee updateEmployee(int id, Employee employee) {
        // Find the employee to update
        Employee existingEmployee = getEmployeeById(id);
        if (existingEmployee != null) {
            existingEmployee.setName(employee.getName());
            existingEmployee.setRole(employee.getRole());
            existingEmployee.setSalary(employee.getSalary());
            return existingEmployee;
        }
        return null; // Return null if employee doesn't exist
    }

    // Delete employee by ID
    public boolean deleteEmployee(int id) {
        Employee employeeToDelete = getEmployeeById(id);
        if (employeeToDelete != null) {
            employees.remove(employeeToDelete);
            return true;
        }
        return false;
    }
}