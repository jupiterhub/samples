package com.joopy.samples.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ ElementType.METHOD, ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EmployeeExistValidator.class)
public @interface EmployeeExist {

	String message() default "{com.joopy.samples.validation.EmployeeExist.message}";

	Class<?>[] groups() default {};

	Class<? extends Payload>[] payload() default {};
}