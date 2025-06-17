package com.example.SpringFramework.validation.validator;

import com.example.SpringFramework.annotation.ValidBirthDate;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.time.LocalDate;

public class BirthDateValidator implements ConstraintValidator<ValidBirthDate, LocalDate> {

    @Override
    public boolean isValid(LocalDate birthDate, ConstraintValidatorContext context) {
        return !birthDate.isAfter(LocalDate.now());
    }
}
