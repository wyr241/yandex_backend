package ru.yandex.backend.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class Base64Validator implements ConstraintValidator<IsBase64, String> {
    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        String regex = "^([A-Za-z0-9+/]{4})*([A-Za-z0-9+/]{3}=|[A-Za-z0-9+/]{2}==)?$";
        return value.matches(regex);
    }
}
