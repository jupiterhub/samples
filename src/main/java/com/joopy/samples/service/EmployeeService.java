package com.joopy.samples.service;

import java.util.List;

import com.joopy.samples.domain.Employee;

public interface EmployeeService {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long employeeId);

	Employee save(Employee employee);
}