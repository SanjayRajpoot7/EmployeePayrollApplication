package com.example.EmployeePayrollApp.controller;

import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    // Get all employees
    @GetMapping
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getDouble("salary")
        ));
    }

    // Get employee by ID
    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Employee(
                rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getDouble("salary")
        ));
    }

    // Add new employee (using DTO)
    @PostMapping
    public String addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        String sql = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employeeDTO.getName(), "Unknown", employeeDTO.getSalary());  // Role is 'Unknown' for now
        return "Employee created successfully!";
    }

    // Update employee (using DTO)
    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody EmployeeDTO employeeDTO) {
        String sql = "UPDATE employee SET name = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employeeDTO.getName(), employeeDTO.getSalary(), id);
        return "Employee updated successfully!";
    }

    // Delete employee
    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "Employee deleted successfully!";
    }
}