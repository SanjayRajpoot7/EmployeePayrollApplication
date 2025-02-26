package com.example.EmployeePayrollApp.repository;

import com.example.EmployeePayrollApp.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}

//public class EmployeeRepository {
//
//    private final JdbcTemplate jdbcTemplate;
//
//    public EmployeeRepository(JdbcTemplate jdbcTemplate) {
//        this.jdbcTemplate = jdbcTemplate;
//    }
//
//    public List<Employee> getAllEmployees() {
//        String sql = "SELECT * FROM employee1";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Employee employee = new Employee();
//            employee.setId((int) rs.getLong("id"));
//            employee.setName(rs.getString("name"));
//            employee.setRole(rs.getString("position"));
//            employee.setSalary(rs.getDouble("salary"));
//            return employee;
//        });
//    }
//
//    public Employee getEmployeeById(int id) {
//        String sql = "SELECT * FROM employee1 WHERE id = ?";
//        return jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
//            Employee employee = new Employee();
//            employee.setId(rs.getInt("id"));
//            employee.setName(rs.getString("name"));
//            employee.setRole(rs.getString("position"));
//            employee.setSalary(rs.getDouble("salary"));
//            return employee;
//        });
//    }
//
//
//    public int createEmployee(Employee employee) {
//        String sql = "INSERT INTO employee (name, position, salary) VALUES (?, ?, ?)";
//        return jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary());
//    }
//
//    public int updateEmployee(Employee employee) {
//        String sql = "UPDATE employee SET name = ?, position = ?, salary = ? WHERE id = ?";
//        return jdbcTemplate.update(sql, employee.getName(), employee.getRole(), employee.getSalary(), employee.getId());
//    }
//
//    public int deleteEmployee(Long id) {
//        String sql = "DELETE FROM employee WHERE id = ?";
//        return jdbcTemplate.update(sql, id);
//    }
//
//    public List<Employee> findAll() {
//        String sql = "SELECT * FROM employee1";
//        return jdbcTemplate.query(sql, (rs, rowNum) -> {
//            Employee employee = new Employee();
//            employee.setId((int) rs.getLong("id"));
//            employee.setName(rs.getString("name"));
//            employee.setRole(rs.getString("position"));
//            employee.setSalary(rs.getDouble("salary"));
//            return employee;
//        });
//    }
//
//    public Optional<Employee> findById(int id) {
//        String sql = "SELECT * FROM employee1 WHERE id = ?";
//        try {
//            Employee employee = jdbcTemplate.queryForObject(sql, new Object[]{id}, (rs, rowNum) -> {
//                Employee e = new Employee();
//                e.setId((int) rs.getLong("id"));
//                e.setName(rs.getString("name"));
//                e.setRole(rs.getString("position"));
//                e.setSalary(rs.getDouble("salary"));
//                return e;
//            });
//            return Optional.ofNullable(employee);
//        } catch (Exception e) {
//            return Optional.empty();
//        }
//    }
//
//
//    public Employee save(Employee employee) {
//        if (employee.getId() == 0) {
//            // If id is 0, create a new employee
//            createEmployee(employee);
//        } else {
//            // If id is not 0, update the existing employee
//            updateEmployee(employee);
//        }
//        return employee;
//    }
//
//    public boolean existsById(int id) {
//        String sql = "SELECT COUNT(*) FROM employee1 WHERE id = ?";
//        Integer count = jdbcTemplate.queryForObject(sql, new Object[]{id}, Integer.class);
//        return count != null && count > 0;
//    }
//
//    public void deleteById(int id) {
//        String sql = "DELETE FROM employee1 WHERE id = ?";
//        jdbcTemplate.update(sql, id);
//    }
//}