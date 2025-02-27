package com.example.EmployeePayrollApp.service;


import com.example.EmployeePayrollApp.dto.EmployeeDTO;
import com.example.EmployeePayrollApp.exception.EmployeeNotFoundException;
import com.example.EmployeePayrollApp.model.Employee;
import com.example.EmployeePayrollApp.repository.EmployeeRepository;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Data
@Service
@Slf4j
public class EmployeeService implements InterfaceEmployeePayrollService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public List<Employee> getEmployeePayrollData() {
        return List.of();
    }

    @Override
    public Employee getEmployeePayrollDataById(int empid) {
        return null;
    }

    @Override
    public Employee createEmployeePayrollData(EmployeeDTO employeeDTO) {
        log.info("Creating employee with name: {}", employeeDTO.getName());
        Employee employee = new Employee(employeeDTO);
        employeeRepository.save(employee);
        log.info("Employee created successfully with ID: {}", employee.getId());
        return employee;
    }

    @Override
    public Employee updateEmployeePayrollData(int empId, EmployeeDTO employeeDTO) {
        log.info("Updating employee with ID: {}", empId);
        Employee existingEmployee = employeeRepository.findById((long) empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        existingEmployee.updateDetails(employeeDTO);
        employeeRepository.save(existingEmployee);
        log.info("Employee updated successfully with ID: {}", empId);
        return existingEmployee;
    }

    @Override
    public void deleteEmployeePayrollData(int empId) {
        log.info("Deleting employee with ID: {}", empId);
        Employee existingEmployee = employeeRepository.findById((long) empId)
                .orElseThrow(() -> new EmployeeNotFoundException("Employee not found"));
        employeeRepository.delete(existingEmployee);
        log.info("Employee deleted successfully with ID: {}", empId);
    }
}