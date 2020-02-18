package x.test.annotion;

import x.test.validation.TestValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.FIELD})
@Constraint(validatedBy = TestValidator.class)
public @interface TestConstrain {

    String message();

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}