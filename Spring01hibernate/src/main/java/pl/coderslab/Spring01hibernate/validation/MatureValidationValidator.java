package pl.coderslab.Spring01hibernate.validation;

import pl.coderslab.Spring01hibernate.validation.MatureValidation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class MatureValidationValidator implements ConstraintValidator<MatureValidation, Integer> {

    @Override
    public boolean isValid(Integer integer, ConstraintValidatorContext constraintValidatorContext) {
        int nowYear = LocalDateTime.now().getYear();
        return nowYear - 18 >= integer;
    }

    @Override
    public void initialize(MatureValidation constraintAnnotation) {

    }
}
