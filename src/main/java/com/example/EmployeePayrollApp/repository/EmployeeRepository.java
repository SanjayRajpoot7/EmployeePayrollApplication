package com.example.EmployeePayrollApp.repository;

import com.example.EmployeePayrollApp.model.Employee;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EmployeeRepository {

    private final JdbcTemplate jdbcTemplate;

    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    public List<Employee> getAllEmployees() {
        String sql = "SELECT * FROM employees";
        return jdbcTemplate.query(sql, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setRole(rs.getString("role"));
            employee.setSalary(rs.getDouble("salary"));
            return employee;
        });
    }

    public Employee getEmployeeById(Long id) {
        String sql = "SELECT * FROM employees WHERE id = ?";
        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
            Employee employee = new Employee();
            employee.setId(rs.getLong("id"));
            employee.setName(rs.getString("name"));
            employee.setRole(rs.getString("role"));
            employee.setSalary(rs.getDouble("salary"));
            return employee;
        });
    }

    public int createEmployee(Employee employee) {
        String sql = "INSERT INTO employees (name, role, salary) VALUES (?, ?, ?)";
        return jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary());
    }

    public int updateEmployee(Employee employee) {
        String sql = "UPDATE employees SET name = ?, role = ?, salary = ? WHERE id = ?";
        return jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary(), employee.getId());
    }

    public int deleteEmployee(Long id) {
        String sql = "DELETE FROM employees WHERE id = ?";
        return jdbcTemplate.update(sql, id);
    }
}