package com.joopy.samples.web;

import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;

import javax.annotation.Resource;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import org.springframework.stereotype.Component;

import com.joopy.samples.domain.Employee;
import com.joopy.samples.service.EmployeeService;

@Component
@Path("employees")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
public class EmployeeResource {

	@Resource
	private EmployeeService employeeService;

	@GET
	public List<Employee> getEmployees() {
		return employeeService.getAllEmployees();
	}

	@GET
	@Path("{employeeId}")
	public Employee getEmployee(@PathParam("employeeId") Long employeeId) {
		return employeeService.getEmployee(employeeId);
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public Response save(@Valid Employee employee) throws URISyntaxException {
		System.out.println("@@@@@@@@@@@@@@@@@@@ ID    " + employee.getId());
		System.out.println("@@@@@@@@@@@@@@@@@@@ Name: " + employee.getName());

		return Response.created(new URI("employee/" + employee.getId()))
				.build();
	}
}