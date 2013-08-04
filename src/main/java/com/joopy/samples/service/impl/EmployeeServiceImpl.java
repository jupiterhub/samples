package com.joopy.samples.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;
import com.joopy.samples.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		return employeeDao.getEmployee(employeeId);
	}

	@Override
	public Employee save(Employee employee) {
		return employeeDao.save(employee);
	}
}