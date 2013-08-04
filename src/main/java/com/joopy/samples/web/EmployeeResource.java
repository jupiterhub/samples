package com.joopy.samples.web;

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

import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;
import org.springframework.stereotype.Component;

import com.joopy.samples.domain.Employee;
import com.joopy.samples.service.EmployeeService;

@Path("employees")
@Component
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@ValidateRequest
// We have to explicitly specify this until we use Bean Validation 1.1 -
// https://docs.jboss.org/resteasy/docs/3.0.2.Final/userguide/html_single/index.html#d4e2419
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
	public Employee save(@Valid Employee employee) throws URISyntaxException {
		return employeeService.save(employee);
	}
}