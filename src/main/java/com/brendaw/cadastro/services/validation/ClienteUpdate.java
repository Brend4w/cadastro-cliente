package com.brendaw.cadastro.services.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Constraint(validatedBy = ClienteUpdateValidator.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)

public@interface ClienteUpdate{
	String message()default"Errode validação";
	Class<?>[] groups () default {};
	Class<? extends Payload>[] payload() default{};
	}
