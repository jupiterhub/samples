package com.joopy.samples.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.stereotype.Repository;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;

@Repository("employeeDaoHardcoded")
public class EmployeeDaoImpl implements EmployeeDao {

	private static final AtomicLong idCounter = new AtomicLong(5);

	private static List<Employee> dbData = new ArrayList<Employee>();

	static {
		// prepopulate data
		dbData.add(new Employee.Builder().withId(1l).withName("Lea Michele").build());
		dbData.add(new Employee.Builder().withId(2l).withName("Naya Rivera").build());
		dbData.add(new Employee.Builder().withId(3l).withName("Darren Criss").build());
	}

	@Override
	public List<Employee> getAllEmployees() {
		return dbData;
	}

	@Override
	public Employee getEmployee(final Long employeeId) {
		for (final Employee employee : dbData) {
			if (employee.getId().equals(employeeId)) {
				return employee;
			}
		}
		return null;
	}

	@Override
	public Employee save(final Employee employee) {
		employee.setId(idCounter.incrementAndGet());
		dbData.add(employee);
		return employee;
	}
}