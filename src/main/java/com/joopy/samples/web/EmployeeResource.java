package com.joopy.samples.web;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerRequestFilter;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.Response.Status;
import javax.ws.rs.ext.Provider;

import org.jboss.resteasy.plugins.validation.hibernate.ValidateRequest;
import org.springframework.stereotype.Component;

import com.joopy.samples.domain.Employee;
import com.joopy.samples.exception.AppException;
import com.joopy.samples.service.EmployeeService;

@Component
@Path("employees")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
@ValidateRequest
public class EmployeeResource {

	@Resource
	private Validator validator;

	@Resource
	private EmployeeService employeeService;

	@GET
	public List<Employee> getEmployees() {
		return this.employeeService.getAllEmployees();
	}

	@GET
	@Path("{employeeId}")
	public Employee getEmployee(@PathParam("employeeId") final Long employeeId) {
		return this.employeeService.getEmployee(employeeId);
	}

	@GET
	@Path("response")
	public Response response() throws URISyntaxException {
		return Response.created(new URI("1")).entity(this.employeeService.getEmployee(1l)).build();
	}

	@GET
	@Path("exception")
	public Employee throwException() {
		throw new IllegalArgumentException("Hardcoded Exception");
	}

	@GET
	@Path("exception2")
	public Employee throwException2() {
		throw new AppException();
	}

	@POST
	@Consumes({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	// TODO: find a way for @Valid annotation does to inject dependencies;
	// Need to override org.jboss.resteasy.core.ResourceMethodInvoker to use Spring Created
	// validator
	public Response save(final Employee employee) throws URISyntaxException {
		// Move the constraint to a separate class until we make the @Valid working
		final Set<ConstraintViolation<Employee>> validate = this.validator.validate(employee);
		if (validate.isEmpty()) {
			return Response.created(new URI("/employees/employeeId999"))
					.entity(this.employeeService.save(employee)).build();
		} else {
			final StringBuilder errorMessages = new StringBuilder();
			final Iterator<ConstraintViolation<Employee>> iterator = validate.iterator();
			int ctr = 0;
			while (iterator.hasNext()) {
				if (ctr > 1) {
					errorMessages.append(", ");
				}
				final ConstraintViolation<Employee> constraintValidation = iterator.next();
				errorMessages.append(constraintValidation.getMessage());
				ctr++;
			}
			return Response.status(Status.BAD_REQUEST).entity(errorMessages.toString()).build();
		}
	}

	// We can do some filtering by implementing these interface
	@Provider
	static class WebApplicationExceptionFilter implements ContainerRequestFilter,
			ContainerResponseFilter {

		@Override
		public void filter(final ContainerRequestContext context) throws IOException {
			System.out.println("WebApplicationExceptionFilter.preFilter() enter");
			// doSomeProcessing before method
			System.out.println("WebApplicationExceptionFilter.preFilter() exit");
		}

		@Override
		public void filter(final ContainerRequestContext requestContext,
				final ContainerResponseContext responseContext) throws IOException {
			System.out.println("WebApplicationExceptionFilter.postFilter() enter");
			// doSomeProcessing after method
			System.out.println("WebApplicationExceptionFilter.postFilter() exit");
		}
	}
}