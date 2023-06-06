package com.example.book.Validator;

import com.example.book.entity.Category;
import com.example.book.Validator.annotation.ValidCategoryId;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class ValidCategoryIdValidator implements ConstraintValidator<ValidCategoryId, Category> {
    @Override
    public boolean isValid(Category category, ConstraintValidatorContext Context) {
        return category != null && category.getId() != null;
    }
}
