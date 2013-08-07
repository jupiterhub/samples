package com.joopy.samples.domain;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.joopy.samples.validation.EmployeeExist;

@Entity(name = "employee")
@XmlRootElement
public class Employee {

	@GeneratedValue(strategy = GenerationType.AUTO)
	@Id
	private Long id;

	@NotEmpty(message = "{name.empty}")
	private String name;

	@EmployeeExist
	private Long managerId;

	@NotNull(message = "{provide.department}")
	@Max(value = 3, message = "{department.too.big}")
	private Integer departmentId;

	public Long getId() {
		return this.id;
	}

	public void setId(final Long id) {
		this.id = id;
	}

	public String getName() {
		return this.name;
	}

	public void setName(final String name) {
		this.name = name;
	}

	public Integer getDepartmentId() {
		return this.departmentId;
	}

	public void setDepartmentId(final Integer departmentId) {
		this.departmentId = departmentId;
	}

	public Long getManagerId() {
		return this.managerId;
	}

	public void setManagerId(final Long managerId) {
		this.managerId = managerId;
	}

	public static class Builder {

		public Employee getEmployee() {
			return this.employee;
		}

		private final Employee employee = new Employee();

		public Builder withId(final Long id) {
			this.employee.setId(id);
			return this;
		}

		public Builder withName(final String name) {
			this.employee.setName(name);
			return this;
		}

		public Employee build() {
			return this.employee;
		}
	}
}