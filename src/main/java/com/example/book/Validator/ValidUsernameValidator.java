package com.example.book.Validator;

import com.example.book.Validator.annotation.ValidUsername;
import com.example.book.repository.IUserRepository;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;

public class ValidUsernameValidator implements ConstraintValidator<ValidUsername, String> {
    @Autowired
    private IUserRepository userRepository;

    @Override
    public boolean isValid(String Username, ConstraintValidatorContext Context) {
        if(userRepository == null)
            return true;
        return userRepository.findByUsername(Username) ==null;
    }
}
