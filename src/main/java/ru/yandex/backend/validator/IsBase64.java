package ru.yandex.backend.validator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = Base64Validator.class)
public @interface IsBase64 {
    String message() default "{invalid.base64}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
