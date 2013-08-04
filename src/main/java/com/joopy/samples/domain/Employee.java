package com.joopy.samples.domain;

import javax.xml.bind.annotation.XmlRootElement;

import org.hibernate.validator.constraints.NotEmpty;

@XmlRootElement
public class Employee {

	private Long id;

	@NotEmpty
	private String name;

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

	public static class Builder {

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