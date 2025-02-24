package com.example.EmployeePayrollApp.service;

import com.example.EmployeePayrollApp.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeService {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public EmployeeService(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    // Example method for fetching all employees
    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employee"; // Adjust query as needed
        return jdbcTemplate.query(sql, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                return new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getDouble("salary")
                );
            }
        });
    }

    // Method for getting a single employee by ID
    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employee WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, new RowMapper<Employee>() {
            @Override
            public Employee mapRow(java.sql.ResultSet rs, int rowNum) throws java.sql.SQLException {
                return new Employee(
                        rs.getLong("id"),
                        rs.getString("name"),
                        rs.getString("role"),
                        rs.getDouble("salary")
                );
            }
        });
    }

    // Method for creating a new employee
    public boolean createEmployee(Employee employee) {
        String sql = "INSERT INTO employee (name, role, salary) VALUES (?, ?, ?)";
        int rowsAffected = jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary());
        return rowsAffected > 0; // Return true if the insertion was successful
    }

    // Method for updating an existing employee
    public boolean updateEmployee(Employee employee) {
        String sql = "UPDATE employee SET name = ?, role = ?, salary = ? WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary(), employee.getId());
        return rowsAffected > 0; // Return true if the update was successful
    }

    // Method for deleting an employee by ID
    public boolean deleteEmployee(Long id) {
        String sql = "DELETE FROM employee WHERE id = ?";
        int rowsAffected = jdbcTemplate.update(sql, id);
        return rowsAffected > 0; // Return true if the deletion was successful
    }
}