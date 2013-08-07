package com.joopy.samples.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;
import com.joopy.samples.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Resource(name = "employeeDaoJpa")
	private EmployeeDao employeeDao;

	@Override
	public List<Employee> getAllEmployees() {
		return this.employeeDao.getAllEmployees();
	}

	@Override
	public Employee getEmployee(final Long employeeId) {
		return this.employeeDao.getEmployee(employeeId);
	}

	@Override
	public Employee save(final Employee employee) {
		return this.employeeDao.save(employee);
	}
}