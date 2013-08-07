package com.joopy.samples.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;

public class EmployeeServiceImplTest {

	@Mock
	private EmployeeDao employeeDao;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void shouldReturnEmployeesWhenRetrievingAllEmployees() {
		// Given
		final ArrayList<Employee> expectedEmployees = new ArrayList<Employee>();
		when(this.employeeDao.getAllEmployees()).thenReturn(expectedEmployees);

		// When
		final List<Employee> employeesRetrieved = this.employeeServiceImpl.getAllEmployees();

		// Then
		verify(this.employeeDao).getAllEmployees();
		assertEquals(expectedEmployees, employeesRetrieved);
	}

	@Test
	public void shouldReturnEmployeeWhenRetrievingSpecificEmployees() {
		// Given
		final Employee expectedEmployee = new Employee();
		when(this.employeeDao.getEmployee(anyLong())).thenReturn(expectedEmployee);

		// When
		final Employee employeeRetrieved = this.employeeServiceImpl.getEmployee(5L);

		// Then
		verify(this.employeeDao).getEmployee(5L);
		assertEquals(expectedEmployee, employeeRetrieved);
	}

	@Test
	public void shouldReturnEmployeeWhenSaving() {
		// Given
		final Employee expectedEmployee = new Employee();
		when(this.employeeServiceImpl.save(any(Employee.class))).thenReturn(expectedEmployee);

		// When
		final Employee employeeSaved = this.employeeServiceImpl.save(expectedEmployee);

		// Then
		verify(this.employeeDao).save(expectedEmployee);
		assertEquals(expectedEmployee, employeeSaved);
	}

}