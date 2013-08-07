package com.joopy.samples.web;

import static junit.framework.Assert.assertNotNull;
import static org.junit.Assert.assertFalse;

import java.util.Set;

import javax.annotation.Resource;
import javax.validation.ConstraintViolation;
import javax.validation.Validator;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.joopy.samples.domain.Employee;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath*:applicationContext.xml")
public class EmployeeResourceIT {

    @Resource
    private Validator validator;
    
	@Resource
	private EmployeeResource employeeResource;
	
	@Test
	public void shouldInjectBean() {
	    // Given / When / Then
	    assertNotNull(employeeResource);
	}
	
	@Test
	public void shouldValidate() {
	    // Given / When
	    Set<ConstraintViolation<Employee>> validate = validator.validate(new Employee());
	    
	    // Then
	    assertFalse(validate.isEmpty());
	}
}