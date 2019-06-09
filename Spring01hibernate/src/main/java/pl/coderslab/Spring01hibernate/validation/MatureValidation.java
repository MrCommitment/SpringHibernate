package pl.coderslab.Spring01hibernate.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = MatureValidationValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MatureValidation {
    String message() default "{matureValidation.error.message}";

    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
