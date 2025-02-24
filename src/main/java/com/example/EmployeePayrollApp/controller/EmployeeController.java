package com.example.EmployeePayrollApp.controller;

import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    @Autowired
    private JdbcTemplate jdbcTemplate;

    private final EmployeeService employeeService;
    @GetMapping
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee";
        return jdbcTemplate.query(sql, (rs, rowNum) -> new Employee(
                (long)rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getDouble("salary")
        ));
    }

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }




    @GetMapping("/{id}")
    public Employee getEmployeeById(@PathVariable int id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> new Employee(
                (long)rs.getInt("id"),
                rs.getString("name"),
                rs.getString("role"),
                rs.getDouble("salary")
        ));
    }

    @PostMapping
    public String addEmployee(@RequestBody Employee employee) {
        String sql = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary());
        return "Employee created successfully!";
    }


    @PutMapping("/{id}")
    public String updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        String sql = "UPDATE employee SET name = ?, role = ?, salary = ? WHERE id = ?";
        jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary(), id);
        return "Employee updated successfully!";
    }


    @DeleteMapping("/{id}")
    public String deleteEmployee(@PathVariable int id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        jdbcTemplate.update(sql, id);
        return "Employee deleted successfully!";
    }
}