package com.joopy.samples.dao.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;

@Repository("employeeDaoJpa")
public class EmployeeDaoJpa implements EmployeeDao {

	@PersistenceContext
	private EntityManager entityManager;

	@Override
	public List<Employee> getAllEmployees() {
		this.entityManager.flush();
		return this.entityManager.createQuery("SELECT o FROM employee o", Employee.class)
				.getResultList();
	}

	@Override
	public Employee getEmployee(final Long employeeId) {
		return null;
	}

	@Override
	public Employee save(final Employee employee) {
		return this.entityManager.merge(employee);
	}
}