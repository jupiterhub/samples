package com.joopy.samples.dao.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Repository;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;

@Repository
public class EmployeeDaoImpl implements EmployeeDao {

	private static List<Employee> dbData = new ArrayList<Employee>();

	static {
		dbData.add(new Employee.Builder().withId(1l).withName("Lea Michele").build());
		dbData.add(new Employee.Builder().withId(2l).withName("Naya Rivera").build());
		dbData.add(new Employee.Builder().withId(3l).withName("Darren Criss").build());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dbData;
	}

	@Override
	public Employee getEmployee(Long employeeId) {
		for (Employee employee : dbData) {
			if (employee.getId() == employeeId) {
				return employee;
			}
		}
		return null;
	}
}