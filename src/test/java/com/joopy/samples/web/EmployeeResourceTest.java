package com.joopy.samples.web;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.anyLong;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.mockito.MockitoAnnotations.initMocks;

import java.util.Arrays;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;

import com.joopy.samples.domain.Employee;
import com.joopy.samples.service.EmployeeService;

public class EmployeeResourceTest {

	@Mock
	private EmployeeService employeeService;

	@InjectMocks
	private EmployeeResource employeeResource;

	@Before
	public void setup() {
		initMocks(this);
	}

	@Test
	public void shouldRetrieveAllEmployees() {
		// Given
		List<Employee> expectedEmployees = Arrays.asList(new Employee());
		when(employeeService.getAllEmployees()).thenReturn(expectedEmployees);

		// When
		List<Employee> allEmployees = employeeResource.getEmployees();

		// Then
		verify(employeeService).getAllEmployees();
		assertEquals(expectedEmployees, allEmployees);
	}

	@Test
	public void shouldRetrieveSpecificEmployee() {
		// Given
		Employee expectedEmployee = new Employee();
		when(employeeService.getEmployee(anyLong())).thenReturn(
				expectedEmployee);

		// When
		Employee employeeRetrieved = employeeResource.getEmployee(5L);

		// Then
		verify(employeeService).getEmployee(5L);
		assertEquals(expectedEmployee, employeeRetrieved);
	}
}