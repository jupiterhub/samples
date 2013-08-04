package com.joopy.samples.service.impl;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

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
	public void shouldInvokeEmployeeDaoWhenRetrievingAllEmployees() {
		// Given / When
		employeeServiceImpl.getAllEmployees();

		// Then
		verify(employeeDao).getAllEmployees();
	}

	@Test
	public void shouldInvokeEmployeeDaoWhenRetrievingSpecificEmployee() {
		// Given / When
		employeeServiceImpl.getEmployee(5L);

		// Then
		verify(employeeDao).getEmployee(5L);
	}

	@Test
	public void shouldReturnEmployeeWhenRetrievingSpecificEmployee() {
		// Given
		Employee expectedEmployee = new Employee();
		when(employeeDao.getEmployee(anyLong())).thenReturn(expectedEmployee);

		// When
		Employee employeeRetrieved = employeeServiceImpl.getEmployee(5L);

		// Then
		assertEquals(expectedEmployee, employeeRetrieved);
	}
}