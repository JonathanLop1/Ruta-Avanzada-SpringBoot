package com.eventos.app.infrastructure.adapter.in.rest.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = StartBeforeEndValidator.class)
public @interface StartBeforeEnd {
    String message() default "La fecha de inicio debe ser anterior a la fecha de fin";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}