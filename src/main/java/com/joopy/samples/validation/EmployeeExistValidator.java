package com.joopy.samples.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.factory.annotation.Autowired;

import com.joopy.samples.dao.EmployeeDao;

public class EmployeeExistValidator implements
		ConstraintValidator<EmployeeExist, Long> {

	@Autowired
	private EmployeeDao employeeDao;

	@Override
	public void initialize(EmployeeExist constraintAnnotation) {
		System.out.println("£££££££££££££££££££££££££: Initialized....");
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
		// EmployeeDao is not injected even after following docs:
		// http://static.springsource.org/spring/docs/3.1.x/spring-framework-reference/html/validation.html#validation-beanvalidation-spring-constraints

		// Resteasy is overwriting what was explicitly set by Spring. Place a
		// breakpoint at LocalValidatorFactoryBean#afterPropertiesSet ==> ConfigurationImpl#buildValidatorFactory (called twice)
		System.out.println("£££££££££££££££££££££££££: EmployeeDao: "
				+ employeeDao);

		return true;
	}
}