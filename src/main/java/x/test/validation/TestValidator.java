package x.test.validation;

import lombok.extern.slf4j.Slf4j;
import x.test.annotion.TestConstrain;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

@Slf4j
public class TestValidator implements ConstraintValidator<TestConstrain, Object> {
    @Override
    public void initialize(TestConstrain constraintAnnotation) {

    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        log.info("TestValidator isValid");
        return true;
    }
}
