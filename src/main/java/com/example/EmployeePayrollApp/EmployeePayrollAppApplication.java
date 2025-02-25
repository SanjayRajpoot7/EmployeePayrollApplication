package com.example.EmployeePayrollApp;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;


@SpringBootApplication
public class EmployeePayrollAppApplication {

	private static final Logger log = LoggerFactory.getLogger(EmployeePayrollAppApplication.class);

	public static void main(String[] args) {
//		SpringApplication.run(EmployeePayrollAppApplication.class, args);
		ApplicationContext context = SpringApplication.run(EmployeePayrollAppApplication.class, args);
		log.info("Employee payroll app started in {} Environment", context.getEnvironment().getProperty("spring.profiles.active"));

	}

}
