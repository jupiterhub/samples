package com.joopy.samples.dao.impl;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.joopy.samples.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:spring/applicationContext.xml")
@Transactional
public class EmployeeDaoJpaIT {

	@Resource(name = "employeeDaoJpa")
	private EmployeeDaoJpa employeeDao;

	@Test
	public void shouldInjectDependencies() {
		assertNotNull(this.employeeDao);
	}

	@Test
	public void shouldSaveEmployee() {
		// Given
		final Employee employee = new Employee();
		employee.setName("Jupiter");
		employee.setDepartmentId(1);

		// When
		final Employee savedEmployee = this.employeeDao.save(employee);

		// Then
		assertNotNull(savedEmployee.getId());
	}

	@Test
	public void shouldReturnAllEmployees() {
		// Given
		final Employee employee = new Employee();
		employee.setName("Jupiter1");
		employee.setDepartmentId(1);
		this.employeeDao.save(employee);
		this.employeeDao.save(employee);

		// When
		final List<Employee> allEmployees = this.employeeDao.getAllEmployees();

		// Then
		assertEquals(2, allEmployees.size());
	}
}