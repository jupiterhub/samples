package com.joopy.samples.validation;

import javax.annotation.Resource;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import com.joopy.samples.dao.EmployeeDao;
import com.joopy.samples.domain.Employee;

public class EmployeeExistValidator implements ConstraintValidator<EmployeeExist, Long> {

	@Resource
	private EmployeeDao employeeDao;

	@Override
	public void initialize(EmployeeExist constraintAnnotation) {
		System.out.println("This only run once....");
	}

	@Override
	public boolean isValid(Long value, ConstraintValidatorContext context) {
	    for (Employee employee : employeeDao.getAllEmployees()) {
	        if (employee.getId().equals(value)) {
	            return true;
	        }
	    }
	    context.disableDefaultConstraintViolation();
	    context.buildConstraintViolationWithTemplate("Get from ResourceBundle empId is: " + value).addConstraintViolation();
	    return false;
	}
}