package com.example.EmployeePayrollApp.controller;

import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import com.example.EmployeePayrollApp.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import lombok.extern.slf4j.Slf4j;

import java.util.List;

@RestController
@Slf4j
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/") // Handle GET requests for all employees
    public List<Employee> getAllEmployees() {
        return employeeService.getAllEmployees();
    }

    @PostMapping("/") // Handle POST requests to create a new employee
    public Employee saveEmployee(@RequestBody Employee employee) {
        return employeeService.saveEmployee(employee);
    }

    @PostMapping("/create")
    public ResponseEntity<Employee> createEmployee(@RequestBody Employee employee) {
        Employee savedEmployee = employeeService.saveEmployee(employee);
        return new ResponseEntity<>(savedEmployee, HttpStatus.CREATED);
    }





//    @Autowired
//    private EmployeeService employeeService;
//
//    // Get all employees
//    @GetMapping
//    public List<Employee> getAllEmployees() {
//        return employeeService.getAllEmployees();
//    }
//
//    // Get employee by ID
//    @GetMapping("/{id}")
//    public Employee getEmployeeById(@PathVariable int id) {
//        return employeeService.getEmployeeById(id);
//    }
//
//    // Create new employee
//    @PostMapping
//    public Employee createEmployee(@RequestBody Employee employee) {
//        return employeeService.createEmployee(employee);
//    }
//
//    // Update existing employee
//    @PutMapping("/{id}")
//    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
//        return employeeService.updateEmployee(id, employee);
//    }
//
//    // Delete employee
//    @DeleteMapping("/{id}")
//    public String deleteEmployee(@PathVariable int id) {
//        boolean isDeleted = employeeService.deleteEmployee(id);
//        return isDeleted ? "Employee deleted successfully" : "Employee not found";
//    }

    @GetMapping("/logExample")
    public String logExample() {
        // Log an informational message
        log.info("This is an info log message!");

        // Log a debug message (will only be shown if the debug level is enabled)
        log.debug("This is a debug log message!");

        // Log an error message
        log.error("This is an error log message!");

        return "Logging Example in Spring Boot";
    }
}