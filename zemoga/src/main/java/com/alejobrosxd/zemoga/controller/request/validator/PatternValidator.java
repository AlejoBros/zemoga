package com.alejobrosxd.zemoga.controller.request.validator;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.util.Objects;
import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PatternValidator.PatternValidatorImplementation.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PatternValidator {

    String message() default "";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    String regexp();

    class PatternValidatorImplementation implements ConstraintValidator<PatternValidator, String> {

        private String regexp;

        @Override
        public void initialize(PatternValidator constraintAnnotation) {
            regexp = constraintAnnotation.regexp();
        }

        @Override
        public boolean isValid(String value, ConstraintValidatorContext constraintValidatorContext) {
            if (!Objects.isNull(value) && !value.isEmpty()) {
                return value.matches(regexp);
            }
            return true;
        }

    }

}
