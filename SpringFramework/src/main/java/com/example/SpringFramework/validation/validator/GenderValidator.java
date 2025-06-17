package com.example.SpringFramework.validation.validator;

import com.example.SpringFramework.Enum.Gender;
import com.example.SpringFramework.annotation.ValidGender;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class GenderValidator implements ConstraintValidator<ValidGender, Gender> {

    @Override
    public boolean isValid(Gender gender, ConstraintValidatorContext context) {
        return gender == Gender.MALE || gender == Gender.FEMALE || gender == Gender.OTHER;
    }
}
