package com.joopy.samples.domain;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

import com.joopy.samples.validation.EmployeeExist;

@XmlRootElement
public class Employee {

	private Long id;

	@NotEmpty(message = "{name.empty}")
	private String name;

	@EmployeeExist
	private Long managerId;
	
	@NotNull(message = "{provide.department}")
	@Max(value=3, message = "{department.too.big}")
	private Integer departmentId;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	public Integer getDepartmentId() {
        return departmentId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Long getManagerId() {
		return managerId;
	}

	public void setManagerId(Long managerId) {
		this.managerId = managerId;
	}

	public static class Builder {

		public Employee getEmployee() {
			return employee;
		}

		private final Employee employee = new Employee();

		public Builder withId(Long id) {
			employee.setId(id);
			return this;
		}

		public Builder withName(String name) {
			employee.setName(name);
			return this;
		}

		public Employee build() {
			return employee;
		}
	}
}