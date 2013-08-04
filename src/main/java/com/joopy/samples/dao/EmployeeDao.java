package com.joopy.samples.dao;

import java.util.List;

import com.joopy.samples.domain.Employee;

public interface EmployeeDao {

	List<Employee> getAllEmployees();

	Employee getEmployee(Long employeeId);
}
