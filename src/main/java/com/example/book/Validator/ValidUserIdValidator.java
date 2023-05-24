package com.example.book.Validator;

import com.example.book.Model.Category;
import com.example.book.Model.Entity.User;
import com.example.book.Validator.annotation.ValidUserId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidUserIdValidator implements ConstraintValidator<ValidUserId, User> {
    @Override
    public boolean isValid(User user, ConstraintValidatorContext Context) {
        if(user == null)    return true;
        return user.getId() != null;
    }
}
